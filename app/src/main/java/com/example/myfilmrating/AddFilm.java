package com.example.myfilmrating;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class AddFilm extends AppCompatActivity {

  EditText message;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_film);
    message = findViewById(R.id.movieInputText);
    Intent test = getIntent();
    Uri uri = test.getData();
    String actionName = test.getAction();

    if (Intent.ACTION_VIEW.equals(actionName)) {
      infoFile(uri);
    }
  }

  public void openImplicitIntent(View view) {
    // Create the text message with a string
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
    sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
    if (sendIntent.resolveActivity(getPackageManager()) != null) {
      startActivity(sendIntent);
    }
  }

  public void infoFile(Uri uri) {

//    if (Intent.ACTION_VIEW.equals(test)) {
    Cursor cursor = getContentResolver().query(uri, null, null, null);
    int name = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
    int size = cursor.getColumnIndex(OpenableColumns.SIZE);
    cursor.moveToFirst();
    Log.i("Basic Info", cursor.getString(name));
    Log.i("Basic Info", Long.toString(cursor.getLong(size)));
    metadata(uri);

//    }
  }

  public void metadata(Uri returnUri) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    retriever.setDataSource(getApplicationContext(), returnUri);
    TextView titleView = (TextView) findViewById(R.id.infoMovie);
    String title = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    String artist = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
    String year = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
    int time = Integer.parseInt(
        retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
    String codec = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
    String height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
    String width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
    int duration = time / 1000;
    int hours = duration / 3600;
    int minutes = ((duration - hours * 3600) / 60);
    int seconds = duration - (hours * 3600 + minutes * 60);
    titleView.setText(String.format(Locale.ENGLISH,
                                    "Title: %s \nArtist: %s \nYear: %s \nDuration: %d:%dm \nCodec: %s \nSize: %sx%s",
                                    title,
                                    artist, year, minutes, seconds, codec, height, width));
  }
}
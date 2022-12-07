package com.example.myfilmrating.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfilmrating.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d("ESTATS", "Pause_Activity_1");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d("ESTATS", "Resume_Activity_1");
  }

  public void openProfile(View view) {
    Intent intent = new Intent(this, Profile.class);
    startActivity(intent);
  }

  public void openMyRates(View view) {
    Intent intent = new Intent(this, MyRates.class);
    startActivity(intent);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d("ESTATS", "Start_Activity_1");

  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d("ESTATS", "Stop_Activity_1");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d("ESTATS", "Destroy_Activity_1");
  }
}
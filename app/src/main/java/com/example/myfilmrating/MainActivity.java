package com.example.myfilmrating;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }


  public void openProfile(View view) {
    Intent intent = new Intent(this, Profile.class);
    startActivity(intent);
  }

  public void openMyRates(View view) {
    Intent intent = new Intent(this, MyRates.class);
    startActivity(intent);
  }

}
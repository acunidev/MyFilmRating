package com.example.myfilmrating.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import androidx.navigation.ui.NavigationUI;
import com.example.myfilmrating.R;
import com.example.myfilmrating.databinding.ActivityMyRatesBinding;

public class MyRates extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMyRatesBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMyRatesBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    NavController navController = Navigation.findNavController(this,
                                                               R.id.nav_host_fragment_content_my_rates);
    appBarConfiguration = new Builder(navController.getGraph()).build();
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    binding.fab.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), AddFilm.class);
        startActivity(intent);

      }
    });
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this,
                                                               R.id.nav_host_fragment_content_my_rates);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }
}
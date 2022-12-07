package com.example.myfilmrating.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myfilmrating.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

  private FragmentFirstBinding binding;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {

    binding = FragmentFirstBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.ExplicitIntentWeb.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intentBrowser = new Intent(Intent.ACTION_VIEW,
                                          Uri.parse("https://www.rottentomatoes.com/"));
        startActivity(intentBrowser);
      }
    });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}
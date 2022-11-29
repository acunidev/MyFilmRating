package com.example.myfilmrating;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

  SharedPreferences sharedPref;
  private EditText userName;
  private EditText email;
  private EditText nom;
  private EditText cognom;
  private EditText biografia;
  private Spinner spinner;
  private CheckBox checkBox;
  private int lastCheck;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.profile);
    initElements();
    getData();
  }

  @Override
  protected void onPause() {
    super.onPause();
    saveData();
  }


  public void saveData() {
    sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString(getString(R.string.username), userName.getText().toString());
    editor.putString(getString(R.string.email), email.getText().toString());
    editor.putString(getString(R.string.nom), nom.getText().toString());
    editor.putString(getString(R.string.cognom), cognom.getText().toString());
    editor.putString(getString(R.string.biografia), biografia.getText().toString());
    editor.putString(getString(R.string.spinGenere), (String) spinner.getSelectedItem());
    editor.putBoolean(getString(R.string.newsletter), checkBox.isChecked());
    editor.apply();
  }

  public void getData() {
    sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE);
    userName.setText(sharedPref.getString(getString(R.string.username), ""));
    email.setText(sharedPref.getString(getString(R.string.email), ""));
    nom.setText(sharedPref.getString(getString(R.string.nom), ""));
    cognom.setText(sharedPref.getString(getString(R.string.cognom), ""));
    biografia.setText(sharedPref.getString(getString(R.string.biografia), ""));

    final int lengthArrayStringSpinnerGenero = getResources().getStringArray(
        R.array.spinnerGenero).length;
    for (int index = 0; index < lengthArrayStringSpinnerGenero; index++) {
      final String valueSpinner = getResources().getStringArray(R.array.spinnerGenero)[index];
      final String selectedValueSpinner = spinner.getSelectedItem().toString();
      if (valueSpinner.equals(selectedValueSpinner)) {
        spinner.setSelection(index);
      }
    }
  }

  public void initElements() {
    userName = findViewById(R.id.txtUserName);
    email = findViewById(R.id.txtEmail);
    nom = findViewById(R.id.txtName);
    cognom = findViewById(R.id.txtCognom);
    biografia = findViewById(R.id.txtBio);
    spinner = findViewById(R.id.sniper);  // porqe no va??
    checkBox = findViewById(R.id.checkNews);

    spinner = (Spinner) (findViewById(R.id.sniper));

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                                                                         R.array.spinnerGenero,
                                                                         android.R.layout.simple_spinner_dropdown_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

  //
}



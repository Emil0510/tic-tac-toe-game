package com.emil.xogamejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableCheckedTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emil.xogamejava.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    ActivityMainMenuBinding binding;
    String player1;
    String player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }


    public void start(View view){
        if(!binding.editTextTextPerson1Name.getText().toString().equals("") && !binding.editTextTextPerson2Name.getText().toString().equals("")){
            player1 = binding.editTextTextPerson1Name.getText().toString();
            player2 = binding.editTextTextPerson2Name.getText().toString();


            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("Player 1",player1);
            intent.putExtra("Player 2",player2);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show();
        }
    }
}
package com.emil.xogamejava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.emil.xogamejava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    PlayerX playerX;
    PlayerO playerO;


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;


    boolean game;
    int  player;   //0 - O     1 - X


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();

        playerX = new PlayerX(intent.getStringExtra("Player 1"));
        playerO = new PlayerO(intent.getStringExtra("Player 2"));

        game = true;
        player = 1;
        binding.playerNameText.setText(playerX.getName());
        binding.playerText.setText("Player: X");
        binding.newGameButton.setEnabled(false);


        imageView1 = binding.imageView1;
        imageView2 = binding.imageView2;
        imageView3 = binding.imageView3;
        imageView4 = binding.imageView4;
        imageView5 = binding.imageView5;
        imageView6 = binding.imageView6;
        imageView7 = binding.imageView7;
        imageView8 = binding.imageView8;
        imageView9 = binding.imageView9;



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.back){
            Intent intent = new Intent(this,MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void imageClicked(View view){


        if(game){
            if(player==0){
                ImageView imageView = (ImageView)view;
                imageView.setImageResource(R.drawable.o);
                imageView.setEnabled(false);
                player=1;
                binding.playerNameText.setText(playerX.getName());
                binding.playerText.setText("Player: X");

                check(playerO);
                checkDraw();
            }else if(player==1){
                ImageView imageView = (ImageView)view;
                imageView.setImageResource(R.drawable.x);
                imageView.setEnabled(false);
                player=0;
                binding.playerNameText.setText(playerO.getName());
                binding.playerText.setText("Player: O");

                check(playerX);
                checkDraw();
            }

        }


    }


    public void gameOver(Player player){
        binding.newGameButton.setEnabled(true);
        binding.gameText.setText("Game Over");
        binding.gameWinText.setText("Winner: "+player.name);
        game=false;

    }
    public void gameDraft(){
        binding.newGameButton.setEnabled(true);
        binding.gameText.setText("Game Draft");
        binding.gameWinText.setText("Nobody win the game");
        game=false;
    }

    public void checkDraw(){

        if(imageView1.getDrawable()!=null && imageView2.getDrawable()!=null &&imageView3.getDrawable()!=null &&imageView4.getDrawable()!=null &&imageView5.getDrawable()!=null &&imageView6.getDrawable()!=null &&imageView7.getDrawable()!=null &&imageView8.getDrawable()!=null &&imageView9.getDrawable()!=null && game ){
            gameDraft();
        }

    }
    public void check(Player player){

        if(imageView1.getDrawable()!=null && imageView2.getDrawable()!=null && imageView3.getDrawable()!=null) {
            if ((imageView1.getDrawable().getConstantState() == imageView2.getDrawable().getConstantState()) && (imageView2.getDrawable().getConstantState() == imageView3.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView4.getDrawable()!=null && imageView5.getDrawable()!=null && imageView6.getDrawable()!=null) {
            if ((imageView4.getDrawable().getConstantState() == imageView5.getDrawable().getConstantState()) && (imageView5.getDrawable().getConstantState() == imageView6.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView7.getDrawable()!=null && imageView8.getDrawable()!=null && imageView9.getDrawable()!=null) {
            if ((imageView7.getDrawable().getConstantState() == imageView8.getDrawable().getConstantState()) && (imageView8.getDrawable().getConstantState() == imageView9.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView1.getDrawable()!=null && imageView4.getDrawable()!=null && imageView7.getDrawable()!=null) {
            if ((imageView1.getDrawable().getConstantState() == imageView4.getDrawable().getConstantState()) && (imageView4.getDrawable().getConstantState() == imageView7.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView2.getDrawable()!=null && imageView5.getDrawable()!=null && imageView8.getDrawable()!=null) {
            if ((imageView2.getDrawable().getConstantState() == imageView5.getDrawable().getConstantState()) && (imageView5.getDrawable().getConstantState() == imageView8.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView3.getDrawable()!=null && imageView6.getDrawable()!=null && imageView9.getDrawable()!=null) {
            if ((imageView3.getDrawable().getConstantState() == imageView6.getDrawable().getConstantState()) && (imageView6.getDrawable().getConstantState() == imageView9.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView1.getDrawable()!=null && imageView5.getDrawable()!=null && imageView9.getDrawable()!=null) {
            if ((imageView1.getDrawable().getConstantState() == imageView5.getDrawable().getConstantState()) && (imageView5.getDrawable().getConstantState() == imageView9.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

        if(imageView3.getDrawable()!=null && imageView5.getDrawable()!=null && imageView7.getDrawable()!=null) {
            if ((imageView3.getDrawable().getConstantState() == imageView5.getDrawable().getConstantState()) && (imageView5.getDrawable().getConstantState() == imageView7.getDrawable().getConstantState())) {
                gameOver(player);
            }
        }

    }

    public void newGame(View view){

        ImageView imageArray[] ={binding.imageView1,binding.imageView2,binding.imageView3,binding.imageView4,binding.imageView5,binding.imageView6,binding.imageView7,binding.imageView8,binding.imageView9};
        for(ImageView imageView : imageArray){
            imageView.setEnabled(true);
            imageView.setImageResource(0);
        }

        game=true;
        player = 1;
        binding.playerNameText.setText(playerX.getName());
        binding.playerText.setText("Player: X");
        binding.gameText.setText("Game Continue");
        binding.gameWinText.setText("");
        binding.newGameButton.setEnabled(false);

    }

}
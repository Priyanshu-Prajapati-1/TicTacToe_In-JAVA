package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
// import android.content.Intent;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

// import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Intent switchC;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button restartGame, btnX, btnO, switchComp, ok;
    TextView YouChoose, FriendChoose, txt, whoWon, OorX;
    String b1 , b2, b3, b4, b5, b6, b7, b8, b9, X, O;
    Dialog dialog ;
    boolean bool = false;
    int flag =0, count=0;

    @SuppressLint({"SetTextI18n", "MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation slide= AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);

        LinearLayout cv = findViewById(R.id.llout);
        cv.startAnimation(slide);

        // Intent fromFirst = getIntent();
        // String title = fromFirst.getStringExtra("title");
        // Objects.requireNonNull(getSupportActionBar()).setTitle(title);

        YouChoose = findViewById(R.id.chooseYou);
        FriendChoose = findViewById(R.id.chooseFriend);
        txt = findViewById(R.id.txtView);
        btnX = findViewById(R.id.btnX);
        btnO = findViewById(R.id.btn0);
        restartGame = findViewById(R.id.btnPlay);
        switchComp = findViewById(R.id.comp);

        switchC = new Intent(MainActivity.this, computer.class);

        init();

        restartGame.setOnClickListener(view -> reStart());


        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);

        // use for custom dialog.
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.alert_dialog_box);
        whoWon = dialog.findViewById(R.id.won);
        OorX= dialog.findViewById(R.id.sus);
        ok = dialog.findViewById(R.id.dialogBtn);


        // use to set O or X.
        btnX.setOnClickListener(view -> {
            btnX.startAnimation(anim);
            reStart();
            X = "X";
            O = "O";
            YouChoose.setText("You choose- X");
            FriendChoose.setText("Your friend- O");
        });
        // use to set O or X.
        btnO.setOnClickListener(view -> {
            btnO.startAnimation(anim);
            reStart();
            X = "O";
            O = "X";
            YouChoose.setText("You choose- O");
            FriendChoose.setText("You friend- X");
        });

        switchComp.setOnClickListener(view -> {
            switchComp.startAnimation(anim);
            startActivity(switchC);
            finish();
        });

        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
    @SuppressLint("SetTextI18n")
    public void Check(View view){
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        Animation round = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.round);

        Button btnCurrent = (Button) view;

        if (btnCurrent.getText().toString().equals("")) {

            if (flag == 0) {
                btnCurrent.setText(X);
                btnCurrent.startAnimation(anim);
                btnCurrent.startAnimation(round);
                flag = 1;
            } else {
                btnCurrent.setText(O);
                btnCurrent.startAnimation(anim);
                btnCurrent.startAnimation(round );
                flag = 0;
            }
            count++;

            checkGame();
        }
    }
    @SuppressLint("SetTextI18n")
    public void reStart(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        TextView txt = findViewById(R.id.txtView);
        txt.setText("");
        YouChoose.setText("CHOOSE-(X/O)");
        FriendChoose.setText("YOUR FRIEND-(X/O)");
        count = 0;
        bool = false;
        flag =0;
        X ="";
        O ="";
    }

    @SuppressLint("SetTextI18n")
    public void checkGame(){
        if (count > 4) {
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                dialog(b1);

            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                txt.setText("Result- " + b4 + " is Winner.");
                dialog(b4);

            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                txt.setText("Result- " + b7 + " is Winner.");
                dialog(b7);

            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                dialog(b1);

            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                txt.setText("Result- " + b2 + " is Winner.");
                dialog(b2);

            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                txt.setText("Result- " + b3 + " is Winner.");
                dialog(b3);

            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                dialog(b1);

            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                txt.setText("Result- " + b3 + " is Winner.");
                dialog(b3);

            } else if (!b1.equals("") && !b2.equals("") && !b3.equals("") &&
                    !b4.equals("") && !b5.equals("") && !b6.equals("") &&
                    !b7.equals("") && !b8.equals("") && !b9.equals(""))
            {
                txt.setText("Result- " + "!!Game Draw");
                bool = true;
                dialog("Game Draw");
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void dialog(String s) {
        // Initialize the AlertDialog within the dialog method.
//        AlertDialog.Builder result = new AlertDialog.Builder(this);
//        result.setIcon(R.mipmap.ic_launcher_round);
//        result.setTitle("Game Result.");
//        result.setMessage("Who is the winner of this game.");

        notification notify;

        Animation slide= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

        CardView cv = dialog.findViewById(R.id.cardView);
        cv.startAnimation(slide);

        if(bool){
            //result.setMessage("Game draw!");
            OorX.setText("Game");
            whoWon.setText("Draw!");
            //notify = new notification("Game", "Draw");

        }else if (YouChoose.getText().toString().equals("You choose- X") && s.equals("X")){
            //result.setMessage("You Win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You Win!");
            //notify = new notification("Winner- "+ s, "You Win!");

        }else if (YouChoose.getText().toString().equals("You choose- O") && s.equals("O")){
            //result.setMessage("You Win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You Win!");
            //notify = new notification("Winner- "+ s, "You Win!");

        }else if(FriendChoose.getText().toString().equals("Your friend- O") && s.equals("O")){
            //result.setMessage("Your friend win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("Your friend Win!");
            //notify = new notification("Winner- "+ s, "Your friend Win!");

        }else if(FriendChoose.getText().toString().equals("Your friend- X") && s.equals("X")){
            //result.setMessage("Your friend win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("Your friend Win!");
            //notify = new notification("Winner- "+ s, "Your friend Win!");

        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Game Restarted.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                reStart();
            }
        });
        dialog.show();

        // Set the message and OK button click listener
//        result.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Game Restarted.", Toast.LENGTH_SHORT).show();
//                reStart(); // You may want to add logic to restart the game here
//            }
//        });
        // Create and show the AlertDialog
//        result.show();
    }

//    public void setAnimation(View viewToAnimate , int animResId){
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), animResId);
//        viewToAnimate.startAnimation(animation);
//    }
}
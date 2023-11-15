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

import java.util.ArrayList;
// import java.util.Objects;
import java.util.Objects;
import java.util.Random;

public class computer extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    public ArrayList<Button> buttonList;
    Button restartGame, btnX, btnO , switchF,ok;
    TextView choose,txt, chooseC, whoWon, OorX;
    String b1 , b2, b3, b4, b5, b6, b7, b8, b9, X="", O="";
    boolean bol = false;
    Random random = new Random();
    int flag =0, count=0;
    boolean check=false;
    Animation anim , round;
    Dialog dialog ;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);


        Animation slide= AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        LinearLayout cv = findViewById(R.id.llout);
        cv.startAnimation(slide);


        choose = findViewById(R.id.choose);
        chooseC = findViewById(R.id.chooseC);
        txt = findViewById(R.id.txtView);
        btnX = findViewById(R.id.btnX);
        btnO = findViewById(R.id.btn0);
        restartGame = findViewById(R.id.btnPlay);
        switchF = findViewById(R.id.fri);

        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        round = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.round);

        Intent switchComp;
        switchComp = new Intent(computer.this, MainActivity.class);

        init();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.alert_dialog_box);
        ok = dialog.findViewById(R.id.dialogBtn);
        whoWon = dialog.findViewById(R.id.won);
        OorX = dialog.findViewById(R.id.sus);


        buttonList = new ArrayList<>();
        buttonList.add(btn1);
        buttonList.add(btn2);
        buttonList.add(btn3);
        buttonList.add(btn4);
        buttonList.add(btn5);
        buttonList.add(btn6);
        buttonList.add(btn7);
        buttonList.add(btn8);
        buttonList.add(btn9);

        btnX.setOnClickListener(view -> {
            btnX.startAnimation(anim);
            reStart();
            X = "X";
            O = "O";
            check = true;
            choose.setText("You choose- X");
            chooseC.setText("Computer- O");
        });
        btnO.setOnClickListener(view -> {
            btnO.startAnimation(anim);
            reStart();
            X = "X";
            O = "O";
            check=false;
            choose.setText("You choose- O");
            chooseC.setText("Computer- X");
        });

        switchF.setOnClickListener(view -> {
            switchF.startAnimation(anim);
            startActivity(switchComp);
            finish();
        });

        restartGame.setOnClickListener(view -> reStart());

        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @SuppressLint("SetTextI18n")
    public void  Check(View view){
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);

        Button btnCurrent = (Button) view;
        boolean bool;

        if (btnCurrent.getText().toString().equals("")){

            if (check){

                bool = true;
                btnCurrent.setText(X);
                btnCurrent.startAnimation(anim);
                btnCurrent.startAnimation(round);
                checkGame();
                count++;

                while (bool) {
                    int randomIndex = random.nextInt(buttonList.size());
                    Button randomButton = buttonList.get(randomIndex);
                    getChar();

                    if (b1.equals("") || b2.equals("") || b3.equals("") || b4.equals("") || b5.equals("") || b6.equals("") || b7.equals("") || b8.equals("") || b9.equals("")) {
                    }else {
                        bool = false;
                    }
                        if (randomButton.getText().toString().equals("")) {
                            randomButton.setText(O);
                            randomButton.startAnimation(anim);
                            randomButton.startAnimation(round);
                            count++;
                            bool = false;
                        }
                }
                checkGame();
            }
            else  {
                bool = true;
                btnCurrent.setText(O);
                btnCurrent.startAnimation(anim);
                btnCurrent.startAnimation(round);
                count++;

                while (bool) {
                    int randomIndex = random.nextInt(buttonList.size());
                    Button randomButton = buttonList.get(randomIndex);
                    getChar();

                    if (b1.equals("") || b2.equals("") || b3.equals("") || b4.equals("") || b5.equals("") || b6.equals("") || b7.equals("") || b8.equals("") || b9.equals("")) {
                    }else {
                        bool = false;
                    }

                    if (randomButton.getText().toString().equals("")) {
                        randomButton.setText(X);
                        randomButton.startAnimation(anim);
                        randomButton.startAnimation(round);
                        count++;
                        bool = false;
                    }
                }
                checkGame();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void reStart() {
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
        choose.setText("CHOOSE-(X/O)");
        chooseC.setText("COMPUTER-(X/O)");
        count = 0;
        flag =0;
        bol = false;
        X = "";
        O = "";
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
    public void checkGame(){
        if (count > 4) {
           getChar();

            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                animateBtn(btn1,btn2,btn3);
                dialog(b1);

            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                txt.setText("Result- " + b4 + " is Winner.");
                animateBtn(btn4, btn5, btn6);
                dialog(b4);

            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                txt.setText("Result- " + b7 + " is Winner.");
                animateBtn(btn7,btn8,btn9);
                dialog(b7);


            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                animateBtn(btn1, btn4, btn7);
                dialog(b1);


            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                txt.setText("Result- " + b2 + " is Winner.");
                animateBtn(btn2,btn5, btn2);
                dialog(b2);


            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                txt.setText("Result- " + b3 + " is Winner.");
                animateBtn(btn3, btn6, btn9);
                dialog(b3);


            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                txt.setText("Result- " + b1 + " is Winner.");
                animateBtn(btn1, btn5, btn9);
                dialog(b1);


            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                txt.setText("Result- " + b3 + " is Winner.");
                animateBtn(btn3, btn5, btn7);
                dialog(b3);


            } else if (!b1.equals("") && !b2.equals("") && !b3.equals("") &&
                    !b4.equals("") && !b5.equals("") && !b6.equals("") &&
                    !b7.equals("") && !b8.equals("") && !b9.equals(""))
            {
                txt.setText("Result- " + "!!Game Draw");
                bol = true;
                dialog("Game Draw!");
            }
        }
    }

    public void getChar(){
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();
    }

    @SuppressLint("SetTextI18n")
    public void dialog(String s) {
        // Initialize the AlertDialog within the dialog method.
//        AlertDialog.Builder result = new AlertDialog.Builder(this);
//        result.setIcon(R.mipmap.ic_launcher_round);
//        result.setTitle("Game Result.");
//        result.setMessage("Who is the winner of this game.");

        Animation slide= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

        CardView cv = dialog.findViewById(R.id.cardView);
        cv.startAnimation(slide);

        if(bol){
            OorX.setText("GAME");
            whoWon.setText("Draw!");
        }else if (chooseC.getText().toString().equals("Computer- O") && s.equals("O")){
           // result.setMessage("You lose!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You lose!");
        }else if (chooseC.getText().toString().equals("Computer- X") && s.equals("X")){
            // result.setMessage("You lose!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You lose!");
        }else if(choose.getText().toString().equals("You choose- O") && s.equals("O")) {
            // result.setMessage("You win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You win!");
        }else if(choose.getText().toString().equals("You choose- X") && s.equals("X")){
            // result.setMessage("You win!");
            OorX.setText("Winner- "+s);
            whoWon.setText("You win!");
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(computer.this, "Game Restarted.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                reStart();
            }
        });
        dialog.show();


        // Set the message and OK button click listener
//        result.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(computer.this, "Game Restarted.", Toast.LENGTH_SHORT).show();
//                reStart(); // You may want to add logic to restart the game here
//            }
//        });

        // Create and show the AlertDialog
        //result.show();
    }

    public void animateBtn(Button bt1, Button bt2, Button bt3){
        bt1.startAnimation(anim);
        bt1.startAnimation(round);
        bt2.startAnimation(anim);
        bt2.startAnimation(round);
        bt3.startAnimation(anim);
        bt3.startAnimation(round);
    }
}


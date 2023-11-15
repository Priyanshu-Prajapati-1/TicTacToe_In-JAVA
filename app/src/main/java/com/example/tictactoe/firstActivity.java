package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class firstActivity extends AppCompatActivity {

    Dialog dialog;
    Button Cancel, Ok;

    @SuppressLint({"MissingInflatedId", "SetTextI18n", "RtlHardcoded"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Objects.requireNonNull(getSupportActionBar()).hide();
        

        Button playWith,playComp;
        TextView txtMsg;
        Toast toast = new Toast(getApplicationContext());
        View viewToast = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.viewLayout));

        playWith = findViewById(R.id.playWith);
        playComp = findViewById(R.id.playComp);
        txtMsg = viewToast.findViewById(R.id.txtMsg);

        Intent iNext1, iNext2;
        String dynamicText1 = "Game start with friend";
        String dynamicText2 = "Game start with computer";

        iNext1 = new Intent(firstActivity.this, MainActivity.class);
        iNext2 = new Intent(firstActivity.this, computer.class);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide);
        LinearLayout ll = findViewById(R.id.llout);
        ll.startAnimation(animation);

        playWith.setOnClickListener(view -> {
            runOnUiThread(() -> {
                txtMsg.setText(dynamicText1);
                // This code will run on the UI thread
                toast.setView(viewToast);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
                startActivity(iNext1);
            });
        });

        playComp.setOnClickListener(view -> {

            runOnUiThread(() -> {
                txtMsg.setText(dynamicText2);
                // This code will run on the UI thread
                toast.setView(viewToast);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,100);
                toast.show();
                startActivity(iNext2);
            });
        });


    }

    public void onBackPressed(){

//        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
//        exitDialog.setTitle("Exit?");
//        exitDialog.setMessage("Are you sure want to exit?");
//        exitDialog.setIcon(R.drawable.backpress);
//
//        exitDialog.setPositiveButton("Yes" , new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                firstActivity.super.onBackPressed();
//            }
//        });
//
//        exitDialog.setNegativeButton("No" , (dialogInterface, i) -> Toast.makeText(firstActivity.this, "Welcome Back.", Toast.LENGTH_SHORT).show());
//        exitDialog.setNeutralButton("Cancel", (dialogInterface, i) -> Toast.makeText(firstActivity.this, "Operation Cancel", Toast.LENGTH_SHORT).show());

//        exitDialog.show();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_exit_dialog);

        Animation slide= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

        CardView cv = dialog.findViewById(R.id.exit);
        cv.startAnimation(slide);

        Cancel = dialog.findViewById(R.id.dialogBtnCancel);
        Ok = dialog.findViewById(R.id.dialogBtnOK);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(firstActivity.this, "Ok play.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstActivity.super.onBackPressed();
            }
        });
        dialog.show();
    }
}
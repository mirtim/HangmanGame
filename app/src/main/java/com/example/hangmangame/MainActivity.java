package com.example.hangmangame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;
    private Button btnG;
    private Button btnH;
    private Button btnI;
    private Button btnJ;
    private Button btnK;
    private Button btnL;
    private Button btnM;
    private Button btnN;
    private Button btnO;
    private Button btnP;
    private Button btnQ;
    private Button btnR;
    private Button btnS;
    private Button btnT;
    private Button btnU;
    private Button btnV;
    private Button btnW;
    private Button btnX;
    private Button btnY;
    private Button btnZ;
    private TextView ltr1;
    private TextView ltr2;
    private TextView ltr3;
    private TextView ltr4;
    private TextView ltr5;
    private Button btnGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        btnG = findViewById(R.id.btnG);
        btnH = findViewById(R.id.btnH);
        btnI = findViewById(R.id.btnI);
        btnJ = findViewById(R.id.btnJ);
        btnK = findViewById(R.id.btnK);
        btnL = findViewById(R.id.btnL);
        btnM = findViewById(R.id.btnM);
        btnN = findViewById(R.id.btnN);
        btnO = findViewById(R.id.btnO);
        btnP = findViewById(R.id.btnP);
        btnQ = findViewById(R.id.btnQ);
        btnR = findViewById(R.id.btnR);
        btnS = findViewById(R.id.btnS);
        btnT = findViewById(R.id.btnT);
        btnU = findViewById(R.id.btnU);
        btnV = findViewById(R.id.btnV);
        btnW = findViewById(R.id.btnW);
        btnX = findViewById(R.id.btnX);
        btnY = findViewById(R.id.btnY);
        btnZ = findViewById(R.id.btnZ);
        ltr1 = findViewById(R.id.ltr1);
        ltr2 = findViewById(R.id.ltr2);
        ltr3 = findViewById(R.id.ltr3);
        ltr4 = findViewById(R.id.ltr4);
        ltr5 = findViewById(R.id.ltr5);
        btnGame = findViewById(R.id.btnGame);

        final String[] words = {"apple", "phone", "chair"};              // create a list of words with 5 letters

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pick a random word from words
                // set each letter for each of 5 text views
                // update the picture(I will make the pictures!)
                // update the hind button
                // enable all buttons

                Random r = new Random();
                int randNum = r.nextInt(words.length);
                String word = words[randNum];

            }
        });


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }
}

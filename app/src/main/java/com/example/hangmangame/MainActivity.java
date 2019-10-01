/*
* This is a game of hangman
* Every time you press a button, it either adds a letter to the word if you guessed it correctly
* or it draws a new part of the Stickman body. If the whole body is drawn, you lose
* but if you guess the word completely, you win.
* There is also hint button, which can be pressed twice. The first time is gives some written clue
* to the word and the second time it removes the letters, which are not part of the word.
*/


package com.example.hangmangame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private EditText ltr1;
    private EditText ltr2;
    private EditText ltr3;
    private EditText ltr4;
    private EditText ltr5;
    private Button btnGame;
    private Button btnHint;
    private ImageView imgHang;
    final String[] words = {"apple", "phone", "chair", "house", "rival", "smile", "stove"};              // create a list of words with 5 letters
    private int correct = 0;
    private String word;
    private int numOfHints = 0;

    // A hashmap that contains hint messages for the user

    private Map<String, String> hintMessages = new HashMap<String, String>();

    // This is a hashmap that contains the letter buttons in the game. Every time a user clicks
    // a correct button, the button will be removed from the hashmap. This is to make it simple to keep
    // track of the remaining letters that may or may not be part of the solution for when a user
    // has clicked on the hint button a second time

    private Map<Character, Button> remainingButtons = new HashMap<Character, Button>();
    private int remainingBtnIterator = 0;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("correct", correct);
        outState.putString("word", word);
        // TODO save instance of buttons
        // TODO save state of an image
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            correct = savedInstanceState.getInt("correct");
            word = savedInstanceState.getString("word");
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

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
        btnHint = findViewById(R.id.btnHint);
        imgHang = findViewById(R.id.imgHang);

        // Add the hint message to each corresponding word


        hintMessages.put("apple", "These might help keep doctors away!");
        hintMessages.put("phone", "hello?");
        hintMessages.put("chair", "have a seat!");
        hintMessages.put("house", "Where do you live?");
        hintMessages.put("rival", "An opponent");
        hintMessages.put("smile", "Say cheese!");
        hintMessages.put("stove", "Be careful, it's hot!");


        // Add every button to the hashmap of buttons to begin. As a user enters a correct button,
        // it will be removed from the hashmap

       remainingButtons.put('a', btnA);
       remainingButtons.put('b', btnB);
       remainingButtons.put('c', btnC);
       remainingButtons.put('d', btnD);
       remainingButtons.put('e', btnE);
       remainingButtons.put('f', btnF);
       remainingButtons.put('g', btnG);
       remainingButtons.put('h', btnH);
       remainingButtons.put('i', btnI);
       remainingButtons.put('j', btnJ);
       remainingButtons.put('k', btnK);
       remainingButtons.put('l', btnL);
       remainingButtons.put('m', btnM);
       remainingButtons.put('n', btnN);
       remainingButtons.put('o', btnO);
       remainingButtons.put('p', btnP);
       remainingButtons.put('q', btnQ);
       remainingButtons.put('r', btnR);
       remainingButtons.put('s', btnS);
       remainingButtons.put('t', btnT);
       remainingButtons.put('u', btnU);
       remainingButtons.put('v', btnV);
       remainingButtons.put('w', btnW);
       remainingButtons.put('x', btnX);
       remainingButtons.put('y', btnY);
       remainingButtons.put('z', btnZ);


        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // pick a random word from words
                Random r = new Random();
                int randNum = r.nextInt(words.length);
                word = words[randNum];

                // update correct counter to 0
                correct = 0;

                // set each letter for each of 5 text views
                // ltr1.setText(String.valueOf(word.charAt(0)));
                ltr1.setText("");
                ltr2.setText("");
                ltr3.setText("");
                ltr4.setText("");
                ltr5.setText("");

                // update the picture
                imgHang.setImageResource(R.drawable.state1);
                imgHang.setTag(1);

                // enable all buttons
                btnA.setEnabled(true);
                btnB.setEnabled(true);
                btnC.setEnabled(true);
                btnD.setEnabled(true);
                btnE.setEnabled(true);
                btnF.setEnabled(true);
                btnG.setEnabled(true);
                btnH.setEnabled(true);
                btnI.setEnabled(true);
                btnJ.setEnabled(true);
                btnK.setEnabled(true);
                btnL.setEnabled(true);
                btnM.setEnabled(true);
                btnN.setEnabled(true);
                btnO.setEnabled(true);
                btnP.setEnabled(true);
                btnQ.setEnabled(true);
                btnR.setEnabled(true);
                btnS.setEnabled(true);
                btnT.setEnabled(true);
                btnU.setEnabled(true);
                btnV.setEnabled(true);
                btnW.setEnabled(true);
                btnX.setEnabled(true);
                btnY.setEnabled(true);
                btnZ.setEnabled(true);
                btnHint.setEnabled(true);
                numOfHints = 0;
                remainingBtnIterator = 0;
                imgHang.setVisibility(View.VISIBLE);

            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numOfHints++;

                // The first time a user asks for hint, they will lose a turn, meaning the next state will be displayed
                // Depending on the current state that the user is in, the next state will be generated

                if (numOfHints == 1) {

                    for (Map.Entry<String, String> entry : hintMessages.entrySet()) {
                        if (entry.getKey().equals(word)){
                            String toastMsg = entry.getValue();
                            Toast hintMsg = Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_LONG);
                            hintMsg.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            hintMsg.show();
                        }
                    }

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                }

                // The second time a user asks for a hint, they will lose a turn and half of the letters
                // that are not part of the word will be disabled

                if (numOfHints == 2) {
                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                    btnHint.setEnabled(false);
                    int num_of_remaining_buttons = remainingButtons.size();
                    int num_of_buttons_to_disable = num_of_remaining_buttons/2;

                    for (Map.Entry<Character, Button> entry : remainingButtons.entrySet()){
                        if (word.indexOf(entry.getKey()) == -1 && remainingBtnIterator < num_of_buttons_to_disable){
                            remainingBtnIterator++;
                            entry.getValue().setEnabled(false);
                        }

                    }

                }
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (word.indexOf(btnA.getText().toString()) == -1) {              // case if there is no such letter in the word

                        btnA.setEnabled(false);

                        if ((int) (imgHang.getTag()) == 1) {
                            imgHang.setImageResource(R.drawable.state2);
                            imgHang.setTag(2);
                        } else if ((int) (imgHang.getTag()) == 2) {
                            imgHang.setImageResource(R.drawable.state3);
                            imgHang.setTag(3);
                        } else if ((int) (imgHang.getTag()) == 3) {
                            imgHang.setImageResource(R.drawable.state4);
                            imgHang.setTag(4);
                        } else if ((int) (imgHang.getTag()) == 4) {
                            imgHang.setImageResource(R.drawable.state5);
                            imgHang.setTag(5);
                        } else if ((int) (imgHang.getTag()) == 5) {
                            imgHang.setImageResource(R.drawable.state6);
                            imgHang.setTag(6);
                        } else if ((int) (imgHang.getTag()) == 6) {
                            imgHang.setImageResource(R.drawable.state7);
                            imgHang.setTag(7);
                            btnA.setEnabled(false);
                            btnB.setEnabled(false);
                            btnC.setEnabled(false);
                            btnD.setEnabled(false);
                            btnE.setEnabled(false);
                            btnF.setEnabled(false);
                            btnG.setEnabled(false);
                            btnH.setEnabled(false);
                            btnI.setEnabled(false);
                            btnJ.setEnabled(false);
                            btnK.setEnabled(false);
                            btnL.setEnabled(false);
                            btnM.setEnabled(false);
                            btnN.setEnabled(false);
                            btnO.setEnabled(false);
                            btnP.setEnabled(false);
                            btnQ.setEnabled(false);
                            btnR.setEnabled(false);
                            btnS.setEnabled(false);
                            btnT.setEnabled(false);
                            btnU.setEnabled(false);
                            btnV.setEnabled(false);
                            btnW.setEnabled(false);
                            btnX.setEnabled(false);
                            btnY.setEnabled(false);
                            btnZ.setEnabled(false);
                            btnHint.setEnabled(false);
                            Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                            losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            losing.show();
                        }

                    } else {                                                         // case if there is such letter in the word

                        btnA.setEnabled(false);
                        remainingButtons.remove('a');
                        for (int i = 0; i < word.length(); i++) {

                            if (word.charAt(i) == 'a') {

                                correct += 1;

                                if (i == 0) {
                                    ltr1.setText("A");
                                } else if (i == 1) {
                                    ltr2.setText("A");
                                } else if (i == 2) {
                                    ltr3.setText("A");
                                } else if (i == 3) {
                                    ltr4.setText("A");
                                } else if (i == 4) {
                                    ltr5.setText("A");
                                }
                            }
                            if (correct == 5) {
                                Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                                winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                                winning.show();

                            }

                        }

                    }

                }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnB.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnB.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnB.setEnabled(false);
                    remainingButtons.remove('b');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'b') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("B");
                            } else if (i == 1) {
                                ltr2.setText("B");
                            } else if (i == 2) {
                                ltr3.setText("B");
                            } else if (i == 3) {
                                ltr4.setText("B");
                            } else if (i == 4) {
                                ltr5.setText("B");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnC.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnC.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnC.setEnabled(false);
                    remainingButtons.remove('c');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'c') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("C");
                            } else if (i == 1) {
                                ltr2.setText("C");
                            } else if (i == 2) {
                                ltr3.setText("C");
                            } else if (i == 3) {
                                ltr4.setText("C");
                            } else if (i == 4) {
                                ltr5.setText("C");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnD.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnD.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnD.setEnabled(false);
                    remainingButtons.remove('d');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'd') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("D");
                            } else if (i == 1) {
                                ltr2.setText("D");
                            } else if (i == 2) {
                                ltr3.setText("D");
                            } else if (i == 3) {
                                ltr4.setText("D");
                            } else if (i == 4) {
                                ltr5.setText("D");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnE.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnE.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnE.setEnabled(false);
                    remainingButtons.remove('e');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'e') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("E");
                            } else if (i == 1) {
                                ltr2.setText("E");
                            } else if (i == 2) {
                                ltr3.setText("E");
                            } else if (i == 3) {
                                ltr4.setText("E");
                            } else if (i == 4) {
                                ltr5.setText("E");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnF.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnF.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnF.setEnabled(false);
                    remainingButtons.remove('f');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'f') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("F");
                            } else if (i == 1) {
                                ltr2.setText("F");
                            } else if (i == 2) {
                                ltr3.setText("F");
                            } else if (i == 3) {
                                ltr4.setText("F");
                            } else if (i == 4) {
                                ltr5.setText("F");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnG.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnG.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnG.setEnabled(false);
                    remainingButtons.remove('g');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'g') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("G");
                            } else if (i == 1) {
                                ltr2.setText("G");
                            } else if (i == 2) {
                                ltr3.setText("G");
                            } else if (i == 3) {
                                ltr4.setText("G");
                            } else if (i == 4) {
                                ltr5.setText("G");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnH.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnH.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnH.setEnabled(false);
                    remainingButtons.remove('h');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'h') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("H");
                            } else if (i == 1) {
                                ltr2.setText("H");
                            } else if (i == 2) {
                                ltr3.setText("H");
                            } else if (i == 3) {
                                ltr4.setText("H");
                            } else if (i == 4) {
                                ltr5.setText("H");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnI.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnI.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnI.setEnabled(false);
                    remainingButtons.remove('i');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'i') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("I");
                            } else if (i == 1) {
                                ltr2.setText("I");
                            } else if (i == 2) {
                                ltr3.setText("I");
                            } else if (i == 3) {
                                ltr4.setText("I");
                            } else if (i == 4) {
                                ltr5.setText("I");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnJ.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnJ.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnJ.setEnabled(false);
                    remainingButtons.remove('j');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'j') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("J");
                            } else if (i == 1) {
                                ltr2.setText("J");
                            } else if (i == 2) {
                                ltr3.setText("J");
                            } else if (i == 3) {
                                ltr4.setText("J");
                            } else if (i == 4) {
                                ltr5.setText("J");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnK.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnK.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnK.setEnabled(false);
                    remainingButtons.remove('k');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'k') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("K");
                            } else if (i == 1) {
                                ltr2.setText("K");
                            } else if (i == 2) {
                                ltr3.setText("K");
                            } else if (i == 3) {
                                ltr4.setText("K");
                            } else if (i == 4) {
                                ltr5.setText("K");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnL.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnL.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnL.setEnabled(false);
                    remainingButtons.remove('l');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'l') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("L");
                            } else if (i == 1) {
                                ltr2.setText("L");
                            } else if (i == 2) {
                                ltr3.setText("L");
                            } else if (i == 3) {
                                ltr4.setText("L");
                            } else if (i == 4) {
                                ltr5.setText("L");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnM.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnM.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnM.setEnabled(false);
                    remainingButtons.remove('m');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'm') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("M");
                            } else if (i == 1) {
                                ltr2.setText("M");
                            } else if (i == 2) {
                                ltr3.setText("M");
                            } else if (i == 3) {
                                ltr4.setText("M");
                            } else if (i == 4) {
                                ltr5.setText("M");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnN.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnN.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnN.setEnabled(false);
                    remainingButtons.remove('n');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'n') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("N");
                            } else if (i == 1) {
                                ltr2.setText("N");
                            } else if (i == 2) {
                                ltr3.setText("N");
                            } else if (i == 3) {
                                ltr4.setText("N");
                            } else if (i == 4) {
                                ltr5.setText("N");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnO.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnO.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnO.setEnabled(false);
                    remainingButtons.remove('o');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'o') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("O");
                            } else if (i == 1) {
                                ltr2.setText("O");
                            } else if (i == 2) {
                                ltr3.setText("O");
                            } else if (i == 3) {
                                ltr4.setText("O");
                            } else if (i == 4) {
                                ltr5.setText("O");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnP.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnP.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnP.setEnabled(false);
                    remainingButtons.remove('p');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'p') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("P");
                            } else if (i == 1) {
                                ltr2.setText("P");
                            } else if (i == 2) {
                                ltr3.setText("P");
                            } else if (i == 3) {
                                ltr4.setText("P");
                            } else if (i == 4) {
                                ltr5.setText("P");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnQ.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnQ.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnQ.setEnabled(false);
                    remainingButtons.remove('q');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'q') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("Q");
                            } else if (i == 1) {
                                ltr2.setText("Q");
                            } else if (i == 2) {
                                ltr3.setText("Q");
                            } else if (i == 3) {
                                ltr4.setText("Q");
                            } else if (i == 4) {
                                ltr5.setText("Q");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnR.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnR.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnR.setEnabled(false);
                    remainingButtons.remove('r');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'r') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("R");
                            } else if (i == 1) {
                                ltr2.setText("R");
                            } else if (i == 2) {
                                ltr3.setText("R");
                            } else if (i == 3) {
                                ltr4.setText("R");
                            } else if (i == 4) {
                                ltr5.setText("R");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnS.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnS.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnS.setEnabled(false);
                    remainingButtons.remove('s');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 's') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("S");
                            } else if (i == 1) {
                                ltr2.setText("S");
                            } else if (i == 2) {
                                ltr3.setText("S");
                            } else if (i == 3) {
                                ltr4.setText("S");
                            } else if (i == 4) {
                                ltr5.setText("S");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnT.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnT.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnT.setEnabled(false);
                    remainingButtons.remove('t');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 't') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("T");
                            } else if (i == 1) {
                                ltr2.setText("T");
                            } else if (i == 2) {
                                ltr3.setText("T");
                            } else if (i == 3) {
                                ltr4.setText("T");
                            } else if (i == 4) {
                                ltr5.setText("T");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnU.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnU.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnU.setEnabled(false);
                    remainingButtons.remove('u');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'u') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("U");
                            } else if (i == 1) {
                                ltr2.setText("U");
                            } else if (i == 2) {
                                ltr3.setText("U");
                            } else if (i == 3) {
                                ltr4.setText("U");
                            } else if (i == 4) {
                                ltr5.setText("U");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnV.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnV.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnV.setEnabled(false);
                    remainingButtons.remove('v');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'v') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("V");
                            } else if (i == 1) {
                                ltr2.setText("V");
                            } else if (i == 2) {
                                ltr3.setText("V");
                            } else if (i == 3) {
                                ltr4.setText("V");
                            } else if (i == 4) {
                                ltr5.setText("V");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnW.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnW.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnW.setEnabled(false);
                    remainingButtons.remove('w');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'w') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("W");
                            } else if (i == 1) {
                                ltr2.setText("W");
                            } else if (i == 2) {
                                ltr3.setText("W");
                            } else if (i == 3) {
                                ltr4.setText("W");
                            } else if (i == 4) {
                                ltr5.setText("W");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnX.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnX.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnX.setEnabled(false);
                    remainingButtons.remove('x');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'x') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("X");
                            } else if (i == 1) {
                                ltr2.setText("X");
                            } else if (i == 2) {
                                ltr3.setText("X");
                            } else if (i == 3) {
                                ltr4.setText("X");
                            } else if (i == 4) {
                                ltr5.setText("X");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnY.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnY.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnY.setEnabled(false);
                    remainingButtons.remove('y');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'y') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("Y");
                            } else if (i == 1) {
                                ltr2.setText("Y");
                            } else if (i == 2) {
                                ltr3.setText("Y");
                            } else if (i == 3) {
                                ltr4.setText("Y");
                            } else if (i == 4) {
                                ltr5.setText("Y");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (word.indexOf(btnZ.getText().toString()) == -1) {              // case if there is no such letter in the word

                    btnZ.setEnabled(false);

                    if ((int) (imgHang.getTag()) == 1) {
                        imgHang.setImageResource(R.drawable.state2);
                        imgHang.setTag(2);
                    } else if ((int) (imgHang.getTag()) == 2) {
                        imgHang.setImageResource(R.drawable.state3);
                        imgHang.setTag(3);
                    } else if ((int) (imgHang.getTag()) == 3) {
                        imgHang.setImageResource(R.drawable.state4);
                        imgHang.setTag(4);
                    } else if ((int) (imgHang.getTag()) == 4) {
                        imgHang.setImageResource(R.drawable.state5);
                        imgHang.setTag(5);
                    } else if ((int) (imgHang.getTag()) == 5) {
                        imgHang.setImageResource(R.drawable.state6);
                        imgHang.setTag(6);
                    } else if ((int) (imgHang.getTag()) == 6) {
                        imgHang.setImageResource(R.drawable.state7);
                        imgHang.setTag(7);
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        btnE.setEnabled(false);
                        btnF.setEnabled(false);
                        btnG.setEnabled(false);
                        btnH.setEnabled(false);
                        btnI.setEnabled(false);
                        btnJ.setEnabled(false);
                        btnK.setEnabled(false);
                        btnL.setEnabled(false);
                        btnM.setEnabled(false);
                        btnN.setEnabled(false);
                        btnO.setEnabled(false);
                        btnP.setEnabled(false);
                        btnQ.setEnabled(false);
                        btnR.setEnabled(false);
                        btnS.setEnabled(false);
                        btnT.setEnabled(false);
                        btnU.setEnabled(false);
                        btnV.setEnabled(false);
                        btnW.setEnabled(false);
                        btnX.setEnabled(false);
                        btnY.setEnabled(false);
                        btnZ.setEnabled(false);
                        btnHint.setEnabled(false);
                        Toast losing = Toast.makeText(getApplicationContext(), "Sorry, You lost! Press NEW GAME to try again.", Toast.LENGTH_LONG);
                        losing.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        losing.show();
                    }

                } else {                                                         // case if there is such letter in the word

                    btnZ.setEnabled(false);
                    remainingButtons.remove('z');
                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == 'z') {

                            correct += 1;

                            if (i == 0) {
                                ltr1.setText("Z");
                            } else if (i == 1) {
                                ltr2.setText("Z");
                            } else if (i == 2) {
                                ltr3.setText("Z");
                            } else if (i == 3) {
                                ltr4.setText("Z");
                            } else if (i == 4) {
                                ltr5.setText("Z");
                            }
                        }
                        if (correct == 5) {
                            Toast winning = Toast.makeText(getApplicationContext(), "Great Job! You won! Press NEW GAME if you want to play again.", Toast.LENGTH_LONG);
                            winning.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                            winning.show();

                        }

                    }

                }

            }
        });

    }

}

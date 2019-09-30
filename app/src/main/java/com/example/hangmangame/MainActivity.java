package com.example.hangmangame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

                // update the hint button
                // TODO!

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
                imgHang.setVisibility(View.VISIBLE);

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

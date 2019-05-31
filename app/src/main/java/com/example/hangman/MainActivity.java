package com.example.hangman;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineButtons();
        runGame();
    }

    public void defineButtons(){
        findViewById(R.id.A_button).setOnClickListener(buttonListener);
        findViewById(R.id.B_button).setOnClickListener(buttonListener);
        findViewById(R.id.C_button).setOnClickListener(buttonListener);
        findViewById(R.id.D_button).setOnClickListener(buttonListener);
        findViewById(R.id.E_button).setOnClickListener(buttonListener);
        findViewById(R.id.F_button).setOnClickListener(buttonListener);
        findViewById(R.id.G_button).setOnClickListener(buttonListener);
        findViewById(R.id.H_button).setOnClickListener(buttonListener);
        findViewById(R.id.I_button).setOnClickListener(buttonListener);
        findViewById(R.id.J_button).setOnClickListener(buttonListener);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener(){
        @Override
        public void onClick (View view){ //Switch handles multiple buttons for onClickListener
            switch (view.getId()){
                case R.id.A_button:
                    guessLetter('A');
                    break;
                case R.id.B_button:
                    guessLetter('B');
                    break;
                case R.id.C_button:
                    guessLetter('C');
                    break;
                case R.id.D_button:
                    guessLetter('D');
                    break;
                case R.id.E_button:
                    guessLetter('E');
                    break;
                case R.id.F_button:
                    guessLetter('F');
                    break;
                case R.id.G_button:
                    guessLetter('G');
                    break;
                case R.id.H_button:
                    guessLetter('H');
                    break;
                case R.id.I_button:
                    guessLetter('I');
                    break;
                case R.id.J_button:
                    guessLetter('J');
                    break;
            }
            view.setClickable(false);
            view.setBackgroundColor(Color.GRAY);
        }
    };

    private void guessLetter(Character letter){
        /*for (int i=0; i<wordArray.length; i++) {
            if(letter == wordArray[i]){
                guessArray[i] = letter;
            }
        }*/
    }

    private void runGame(){
        TextView guessDisplay = (TextView) findViewById(R.id.guessDisplay);
        String answerWord = "cab";
        int wordLength =  stringToCharArray(answerWord).length;
        char[] wordArray = stringToCharArray(answerWord); //Char array to compare answers to
        char[] guessArray = new char[wordLength]; //Char Array to display on screen
        for(int i=0; i<wordLength; i++){
            guessArray[i] = '_';       //Fills char array with underlines
        }


        guessDisplay.setText(guessArrayToString(guessArray)); //Displays current guessArray to App.

    }

    public char[] stringToCharArray(String inputString) {
        char[] stringToCharArray = inputString.toCharArray();
        for (char output : stringToCharArray) {
            System.out.println(output);
        }
        return stringToCharArray;
    }

    public String guessArrayToString(char[] guessArray) { //Converts guessArray to String with added spaces.
        String guessString = "";

        for (int i=0; i<guessArray.length; i++) {
            guessString += guessArray[i];
            if(i != guessArray.length-1){
                guessString += " ";
            }
        }
        return guessString;
    }
}

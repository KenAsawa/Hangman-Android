package com.example.hangman;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String answerWord;
    String guessWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runGame();
        defineButtons();
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

    public void guessLetter(Character letter){
        char[] guessWordArray = guessWord.toCharArray();
        for (int i=0; i<answerWord.length(); i++) {
            if(letter == answerWord.charAt(i)){
                guessWordArray[i] = letter;
            }
        }
        guessWord = new String(guessWordArray);
        TextView guessDisplay = (TextView)findViewById(R.id.guessDisplay);
        guessDisplay.setText(displayGuessWord());   // Re-displays guess word on the screen.
    }

    private void runGame(){
        TextView guessDisplay = (TextView)findViewById(R.id.guessDisplay);
        setAnswerWord();
        guessDisplay.setText(displayGuessWord()); //Displays current guessWord to the screen.
    }

    public void setAnswerWord() {
        answerWord = "cab"; //TODO: On play selects random word from the wordlist
        answerWord = answerWord.toUpperCase();
        guessWord = "";
        for(int i=0; i<answerWord.length(); i++){
            guessWord += '_';       //Fills guessWord with underlines equal to size of answerWord
        }
    }

    public String displayGuessWord() { //Converts guessWord to String with added spaces.
        String newGuessString = "";
        for (int i=0; i<guessWord.length(); i++) {
            newGuessString += guessWord.charAt(i);
            if(i != guessWord.length()-1){
                newGuessString += " ";
            }
        }
        return newGuessString;
    }
}

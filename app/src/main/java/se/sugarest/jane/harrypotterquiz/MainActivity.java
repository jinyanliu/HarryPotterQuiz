package se.sugarest.jane.harrypotterquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int answerOne = 0;
    int answerTwo = 0;
    int answerThree = 0;
    int answerFour = 0;
    int answerFive = 0;
    int answerSix = 0;
    int answerSeven = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = (EditText) findViewById(R.id.user_input_number);
        editTextName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        EditText editTextQuestionSix = (EditText) findViewById(R.id.user_name);
        editTextQuestionSix.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }

    /**
     * This method is called to hide keyboard.
     */
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * This method is called to get user name.
     */
    public String getUserName() {
        // Find user name
        EditText editText = (EditText) findViewById(R.id.user_name);
        return editText.getText().toString();
    }

    /**
     * This method is called to get the answer of Question 6.
     */
    public String getNumberOfHorcruxes() {
        // Find user input number of Question 6
        EditText editText = (EditText) findViewById(R.id.user_input_number);
        return editText.getText().toString();
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submit(View view) {

        int score = 0;

        String userName = getUserName();

        // Figure out if the user checked Name Rose of Question 7
        CheckBox nameRose = (CheckBox) findViewById(R.id.name_rose);
        //boolean hasNameRose = nameRose.isChecked();

        // Figure out if the user checked Name Hugo of Question 7
        CheckBox nameHugo = (CheckBox) findViewById(R.id.name_hugo);
        //boolean hasNameHugo = nameHugo.isChecked();

        // Figure out if the user checked Name Bilius of Question 7
        CheckBox nameBilius = (CheckBox) findViewById(R.id.name_bilius);
        //boolean hasNameBilius = nameBilius.isChecked();

        // Figure out if the user checked Name Albus of Question 7
        CheckBox nameAlbus = (CheckBox) findViewById(R.id.name_albus);
        //boolean hasNameAlbus = nameAlbus.isChecked();

        //Check if both NameRose and NameHugo are only checked of Question 7, user can get 1 score.
        if (nameRose.isChecked() && nameHugo.isChecked() && !nameBilius.isChecked() && !nameAlbus.isChecked()) {
            answerSeven = 1;
        } else {
            answerSeven = 0;
        }

//        if (hasNameRose) {
//            if (hasNameHugo) {
//                answerSeven = 1;
//            } else {
//                answerSeven = 0;
//            }
//        } else {
//            answerSeven = 0;
//        }
//
//        if (hasNameBilius) {
//            answerSeven = 0;
//        }
//
//        if (hasNameAlbus) {
//            answerSeven = 0;
//        }

        //Only if the user typed "6" of Question 6, user can get 1 score.
        if (getNumberOfHorcruxes().equals("6")) {
            answerSix = 1;
        } else {
            answerSix = 0;
        }

        //Calculate final score.
        score = answerOne + answerTwo + answerThree + answerFour + answerFive + answerSix + answerSeven;

        //Make the text for Toast.
        String scoreText = userName;
        scoreText += "! You got " + score + " of 7 right answers!";

        //Make a Toast message to display final score for the user.
        Toast.makeText(this, scoreText, Toast.LENGTH_SHORT).show();

        View anotherview = this.getCurrentFocus();
        if (anotherview != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(anotherview.getWindowToken(), 0);
        }
    }

    /**
     * Get Score From Question One.
     */
    public void onRadioButtonClickedQuestionOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.mcgonagall:
                if (checked)
                    answerOne = 0;
                break;
            case R.id.quirrell:
                if (checked)
                    answerOne = 0;
                break;
            case R.id.snape:
                if (checked) ;
                answerOne = 1;
                break;
            case R.id.sprout:
                if (checked)
                    answerOne = 0;
                break;
        }
    }

    /**
     * Get Score From Question Two.
     */
    public void onRadioButtonClickedQuestionTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.hedies:
                if (checked)
                    answerTwo = 0;
                break;
            case R.id.heisfired:
                if (checked)
                    answerTwo = 0;
                break;
            case R.id.heloseshismemory:
                if (checked) ;
                answerTwo = 1;
                break;
            case R.id.herunsaway:
                if (checked)
                    answerTwo = 0;
                break;
        }
    }

    /**
     * Get Score From Question Three.
     */
    public void onRadioButtonClickedQuestionThree(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.professorkettleburn:
                if (checked)
                    answerThree = 1;
                break;
            case R.id.professorhagrid:
                if (checked)
                    answerThree = 0;
                break;
            case R.id.professorlupin:
                if (checked) ;
                answerThree = 0;
                break;
            case R.id.professorsnape:
                if (checked)
                    answerThree = 0;
                break;
        }
    }

    /**
     * Get Score From Question Four.
     */
    public void onRadioButtonClickedQuestionFour(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.bulgaria:
                if (checked)
                    answerFour = 0;
                break;
            case R.id.ireland:
                if (checked)
                    answerFour = 1;
                break;
            case R.id.brazil:
                if (checked) ;
                answerFour = 0;
                break;
            case R.id.america:
                if (checked)
                    answerFour = 0;
                break;
        }
    }

    /**
     * Get Score From Question Five.
     */
    public void onRadioButtonClickedQuestionFive(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.bellatrix:
                if (checked)
                    answerFive = 0;
                break;
            case R.id.atimeturner:
                if (checked)
                    answerFive = 0;
                break;
            case R.id.dolohov:
                if (checked) ;
                answerFive = 0;
                break;
            case R.id.abrain:
                if (checked)
                    answerFive = 1;
                break;
        }
    }
}

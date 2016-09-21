package se.sugarest.jane.harrypotterquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        // Figure out if the user checked Name Rose of Question 7
        CheckBox nameRose = (CheckBox) findViewById(R.id.name_rose);
        boolean hasNameRose = nameRose.isChecked();

        // Figure out if the user checked Name Hugo of Question 7
        CheckBox nameHugo = (CheckBox) findViewById(R.id.name_hugo);
        boolean hasNameHugo = nameHugo.isChecked();

        //Only if both NameRose and NameHugo are checked of Question 7, user can get 1 score.
        if (hasNameRose) {
            if (hasNameHugo) {
                score += 1;
            }
        }

        //Only if the user typed "6" of Question 6, user can get 1 score.
        if (getNumberOfHorcruxes().equals("6")) {
            score += 1;
        }

        Toast.makeText(this, createScoreText(score), Toast.LENGTH_SHORT).show();
    }

    /**
     * Create Final ScoreText Message.
     *
     * @param score is the final score of the user
     */
    private String createScoreText(int score) {

        String userName = getUserName();

        String scoreText = userName;
        scoreText += "! You got " + score + " of 7 right answers!";
        return scoreText;
    }

    /**
     * Get Answer From Question One.
     */
    public void onRadioButtonClickedQuestionOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.mcgonagall:
                if (checked)
                    break;
            case R.id.quirrell:
                if (checked)
                    break;
            case R.id.snape:
                if (checked) ;
                score += 1;
                break;
            case R.id.sprout:
                if (checked)
                    break;
        }
    }

    /**
     * Get Answer From Question Two.
     */
    public void onRadioButtonClickedQuestionTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.hedies:
                if (checked)
                    break;
            case R.id.heisfired:
                if (checked)
                    break;
            case R.id.heloseshismemory:
                if (checked) ;
                score += 1;
                break;
            case R.id.herunsaway:
                if (checked)
                    break;
        }
    }


    /**
     * Get Answer From Question Three.
     */
    public void onRadioButtonClickedQuestionThree(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.professorkettleburn:
                if (checked)
                    score += 1;
                break;
            case R.id.professorhagrid:
                if (checked)
                    break;
            case R.id.professorlupin:
                if (checked) ;
                break;
            case R.id.professorsnape:
                if (checked)
                    break;
        }
    }

    /**
     * Get Answer From Question Four.
     */
    public void onRadioButtonClickedQuestionFour(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.bulgaria:
                if (checked)
                    break;
            case R.id.ireland:
                if (checked)
                    score += 1;
                break;
            case R.id.brazil:
                if (checked) ;
                break;
            case R.id.america:
                if (checked)
                    break;
        }
    }

    /**
     * Get Answer From Question Five.
     */
    public void onRadioButtonClickedQuestionFive(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.bellatrix:
                if (checked)
                    break;
            case R.id.atimeturner:
                if (checked)
                    break;
            case R.id.dolohov:
                if (checked) ;
                break;
            case R.id.abrain:
                if (checked)
                    score += 1;
                break;
        }
    }
}

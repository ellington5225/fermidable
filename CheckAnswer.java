package com.example.fermihome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheckAnswer extends AppCompatActivity {

    int catpageID;
    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_answer);
        /**
        Intent checkAnswer = getIntent();

        int userAnswer1 = checkAnswer.getIntExtra("USER_ANSWER_1", 0);
        int userAnswer2 = checkAnswer.getIntExtra("USER_ANSWER_2", 0);
        int userAnswer3 = checkAnswer.getIntExtra("USER_ANSWER_3", 0);
        int userAnswer4 = checkAnswer.getIntExtra("USER_ANSWER_4", 0);
        int userAnswer5 = checkAnswer.getIntExtra("USER_ANSWER_5", 0);

        int realAnswer1 = checkAnswer.getIntExtra("REAL_ANSWER_1", 0);
        int realAnswer2 = checkAnswer.getIntExtra("REAL_ANSWER_2", 0);
        int realAnswer3 = checkAnswer.getIntExtra("REAL_ANSWER_3", 0);
        int realAnswer4 = checkAnswer.getIntExtra("REAL_ANSWER_4", 0);
        int realAnswer5 = checkAnswer.getIntExtra("REAL_ANSWER_5", 0);

        final TextView finalscore = (TextView) findViewById(R.id.finalscorevalue);

        if (userAnswer1 == realAnswer1){
            totalScore += 20;
        } else if (Math.abs(userAnswer1 - realAnswer1) == 1){
            totalScore +=15;
        } else if (Math.abs(userAnswer1 - realAnswer1) == 2){
            totalScore +=10;
        }

        if (userAnswer2 == realAnswer2){
            totalScore += 20;
        } else if (Math.abs(userAnswer2 - realAnswer2) == 1){
            totalScore +=15;
        } else if (Math.abs(userAnswer2 - realAnswer2) == 2){
            totalScore +=10;
        }

        if (userAnswer3 == realAnswer3){
            totalScore += 20;
        } else if (Math.abs(userAnswer3 - realAnswer3) == 1){
            totalScore +=15;
        } else if (Math.abs(userAnswer3 - realAnswer3) == 2){
            totalScore +=10;
        }

        if (userAnswer4 == realAnswer4){
            totalScore += 20;
        } else if (Math.abs(userAnswer4 - realAnswer4) == 1){
            totalScore +=15;
        } else if (Math.abs(userAnswer4 - realAnswer4) == 2){
            totalScore +=10;
        }

        if (userAnswer5 == realAnswer5){
            totalScore += 20;
        } else if (Math.abs(userAnswer5 - realAnswer5) == 1){
            totalScore +=15;
        } else if (Math.abs(userAnswer5 - realAnswer5) == 2){
            totalScore +=10;
        }
*/
        /**
        catpageID = checkAnswer.getIntExtra("CATPAGE_ID", 0);
         */
/**
        final TextView seeFinalScore = (TextView) findViewById(R.id.finalscorevalue);
        final int finalScore = totalScore;
        seeFinalScore.setText(finalScore);
 */
    }

    //get name of activity that you're coming from and put that in below instead of CatOnePage

    /**
    public void sameCategory (View view){

        Intent newQuestion = new Intent(this, CatOnePage.class);
        startActivity(newQuestion);
    }

    public void diffCategory (View view){
        Intent newCategory = new Intent(this, ChooseCategory.class);
        startActivity(newCategory);
    }
     */
}

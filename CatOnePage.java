package com.example.fermihome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class CatOnePage extends AppCompatActivity {

    //finalQs = questions within category
    //availableQs = all questions to choose from
    ArrayList<String> availableQs = new ArrayList<String>();
    ArrayList<Integer> allAnswers = new ArrayList<Integer>();

    //choose random integers
    ArrayList<Integer> availableInts = new ArrayList<Integer>();
    ArrayList<Integer> chosenInts = new ArrayList<Integer>();

    //choose questions and answers based on integers
    ArrayList<String> chosenQs = new ArrayList<String>();
    ArrayList<Integer> realAnswers = new ArrayList<Integer>();


    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_one_page);
/**
        availableQs = new ArrayList<String>();
        chosenQs = new ArrayList<String>();

        allAnswers = new ArrayList<Integer>();
        realAnswers = new ArrayList<Integer>();

        chosenInts = new ArrayList<Integer>();
        availableInts = new ArrayList<Integer>();

        mDatabase = FirebaseDatabase.getInstance().getReference("/Environment");

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String str = dataSnapshot.child("Q").getValue(String.class);
                availableQs.add(str);

                Integer i = dataSnapshot.child("A").getValue(Integer.class);
                allAnswers.add(i);
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    */


        //sample questions in two categories
        Question q1 = new Question (1, 1, "What is 1+1?", 2);
        Question q2 = new Question (2, 1, "What is 2+2?", 4);
        Question q3 = new Question (3, 1, "What is 3+3?", 6);
        Question q4 = new Question (4 ,1,"How many states are in the US?", 50);
        Question q5 = new Question (5, 1, "How many continents are there?", 7);
        Question q6 = new Question (6, 1, "When was the Declaration signed?", 1776);

        //make these arrays for real?
        availableQs = new ArrayList<String>();
        chosenQs = new ArrayList<String>();

        availableInts = new ArrayList<Integer>();
        chosenInts = new ArrayList<Integer>();

        allAnswers = new ArrayList<Integer>();
        realAnswers = new ArrayList<Integer>();


        //add all questions to available Qs (is there an easier/faster way to do this?)
        availableQs.add(q1.getQuestion());
        availableQs.add(q2.getQuestion());
        availableQs.add(q3.getQuestion());
        availableQs.add(q4.getQuestion());
        availableQs.add(q5.getQuestion());
        availableQs.add(q6.getQuestion());

        allAnswers.add(q1.getAnswer());
        allAnswers.add(q2.getAnswer());
        allAnswers.add(q3.getAnswer());
        allAnswers.add(q4.getAnswer());
        allAnswers.add(q5.getAnswer());
        allAnswers.add(q6.getAnswer());

        int randInt;

        for (int length = 0; length < availableQs.size(); length++){
            availableInts.add(length);
        }

        for (int k = 0; k < 5; k++){
            randInt = (int) (Math.random()*(availableInts.size()));
            chosenQs.add(availableQs.get(randInt));
            realAnswers.add(allAnswers.get(randInt));

            availableInts.remove(randInt);
            availableQs.remove(availableQs.get(randInt));
        }

        /**
        //choose 5 distinct integers
        for (int k = 0; k < 5; k++){
            randInt = (int) (Math.random()*availableQs.size());
            while (chosenInts.contains(randInt)){
                randInt = (int) (Math.random()*availableQs.size());
            }
            chosenInts.add(randInt);
        }
         */
/**
        //add questions to chosenQs and answers to realAnswers
        for (int j = 0; j < 5; j++){
            int chosenIndex = chosenInts.get(j);
            chosenQs.add(availableQs.get(chosenInts.get(j)));
            realAnswers.add(allAnswers.get(chosenInts.get(j)));
        }
 */


        //at this point we have a list of chosen questions (chosenQs)
        //and a list of their corresponding correct answers (realAnswers)


        final String question1 = chosenQs.get(0);
        final String question2 = chosenQs.get(1);
        final String question3 = chosenQs.get(2);
        final String question4 = chosenQs.get(3);
        final String question5 = chosenQs.get(4);

        final TextView showq1 = (TextView) findViewById(R.id.questiontext1);
        final TextView showq2 = (TextView) findViewById(R.id.questiontext2);
        final TextView showq3 = (TextView) findViewById(R.id.questiontext3);
        final TextView showq4 = (TextView) findViewById(R.id.questiontext4);
        final TextView showq5 = (TextView) findViewById(R.id.questiontext5);

        showq1.setText(question1);
        showq2.setText(question2);
        showq3.setText(question3);
        showq4.setText(question4);
        showq5.setText(question5);

        /**
        //add all questions with categoryID 1 to finalQs (only get questions from 1 category)
        for (int i = 0 ; i < availableQs.size(); i++){
            if (availableQs.get(i).getCategoryID() == 1){
                finalQs.add(availableQs.get(i));
            }
        }
         */

    }

    public void submitClick(View view){
        Intent submitAnswer = new Intent(this, CheckAnswer2.class);

        //pass user's answer to checkAnswer
        EditText userAnswer1 = findViewById(R.id.useranswer1);
        EditText userAnswer2 = findViewById(R.id.useranswer2);
        EditText userAnswer3 = findViewById(R.id.useranswer3);
        EditText userAnswer4 = findViewById(R.id.useranswer4);
        EditText userAnswer5 = findViewById(R.id.useranswer5);

        int userAnsMes1 = Integer.parseInt(userAnswer1.getText().toString());
        int userAnsMes2 = Integer.parseInt(userAnswer2.getText().toString());
        int userAnsMes3 = Integer.parseInt(userAnswer3.getText().toString());
        int userAnsMes4 = Integer.parseInt(userAnswer4.getText().toString());
        int userAnsMes5 = Integer.parseInt(userAnswer5.getText().toString());

        submitAnswer.putExtra("USER_ANSWER_1", userAnsMes1);
        submitAnswer.putExtra("USER_ANSWER_2", userAnsMes2);
        submitAnswer.putExtra("USER_ANSWER_3", userAnsMes3);
        submitAnswer.putExtra("USER_ANSWER_4", userAnsMes4);
        submitAnswer.putExtra("USER_ANSWER_5", userAnsMes5);

        //also pass real answer to checkAnswer
        submitAnswer.putExtra("REAL_ANSWER_1", realAnswers.get(0));
        submitAnswer.putExtra("REAL_ANSWER_2", realAnswers.get(1));
        submitAnswer.putExtra("REAL_ANSWER_3", realAnswers.get(2));
        submitAnswer.putExtra("REAL_ANSWER_4", realAnswers.get(3));
        submitAnswer.putExtra("REAL_ANSWER_5", realAnswers.get(4));

        /**
        //also pass the category page you're coming from
        submitAnswer.putExtra("CATPAGE_ID", 1);
         */

        startActivity(submitAnswer);
    }
}
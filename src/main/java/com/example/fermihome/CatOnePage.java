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
import com.google.firebase.database.ValueEventListener;

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

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Update();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    void Update(){

        int randInt;

        for (int length = 0; length < availableQs.size(); length++){
            availableInts.add(length);
        }

        for (int k = 0; k < 5; k++){
            randInt = (int) (Math.random()*(availableInts.size()));
            chosenQs.add(availableQs.get(randInt));
            realAnswers.add(allAnswers.get(randInt));

            availableInts.remove(randInt);
            availableQs.remove(randInt);
            allAnswers.remove(randInt);
        }



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

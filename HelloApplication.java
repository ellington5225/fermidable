/**package com.example.fermihome;

import android.app.Application;

import java.util.ArrayList;

public class HelloApplication extends Application {

    private ArrayList<Question> availableQs = new ArrayList<Question>();

    //sample questions in two categories
    Question q1 = new Question (1, 1, "What is 1+1?", 2);
    Question q2 = new Question (2, 1, "What is 2+2?", 4);
    Question q3 = new Question (3, 1, "What is 3+3?", 6);
    Question q4 = new Question (4 ,2 ,"How many states are in the US?", 50);
    Question q5 = new Question (5, 2, "How many continents are there?", 7);
    Question q6 = new Question (6, 2, "When was the Declaration signed?", 1776);

    availableQs = new ArrayList<Question>();

    //add all questions to available Qs (is there an easier/faster way to do this?)
    availableQs.add(q1);
    availableQs.add(q2);
    availableQs.add(q3);
    availableQs.add(q4);
    availableQs.add(q5);
    availableQs.add(q6);

    /**
    //finalQs = questions within category
    //availableQs = all questions to choose from
    ArrayList<Question> finalQs = new ArrayList<Question>();
    ArrayList<Question> availableQs = new ArrayList<Question>();

    //check if questions have already been chosen
    ArrayList<Integer> chosenQs = new ArrayList<Integer>();

    //sample questions in two categories
    Question q1 = new Question (1, 1, "What is 1+1?", 2);
    Question q2 = new Question (2, 1, "What is 2+2?", 4);
    Question q3 = new Question (3, 1, "What is 3+3?", 6);
    Question q4 = new Question (4 ,2 ,"How many states are in the US?", 50);
    Question q5 = new Question (5, 2, "How many continents are there?", 7);
    Question q6 = new Question (6, 2, "When was the Declaration signed?", 1776);


    //make these arrays for real?
    finalQs = new ArrayList<Question>();
    availableQs = new ArrayList<Question>();
    chosenQs = new ArrayList<Integer>();


    //add all questions to available Qs (is there an easier/faster way to do this?)
        availableQs.add(q1);
        availableQs.add(q2);
        availableQs.add(q3);
        availableQs.add(q4);
        availableQs.add(q5);
        availableQs.add(q6);


    private int globalVariable=1;

    public int getGlobalVariable() {
        return globalVariable;
    }

}
*/
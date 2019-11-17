package com.example.fermihome;

public class Question{
    private int questionID;
    private int categoryID;
    private String questionText;
    private int answer;
    private int score;

    public Question (int questionID, int categoryID, String questionText, int answer){
        this.questionID = questionID;
        this.categoryID = categoryID;
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestion(){
        return questionText;
    }

    public int getQuestionID(){
        return questionID;
    }

    public int getCategoryID(){
        return categoryID;
    }

    public int getAnswer(){
        return answer;
    }

    public int getScore(){
        return score;
    }
}
package com.example.fermihome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }

    public void catOneClick (View v){
        Intent goToCatOne = new Intent(this, CatOnePage.class);
        startActivity(goToCatOne);
    }
}

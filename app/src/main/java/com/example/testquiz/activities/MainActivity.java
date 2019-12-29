package com.example.testquiz.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testquiz.R;
import com.example.testquiz.models.Question;

public class MainActivity extends AppCompatActivity {

    public Button btnAdd, btnAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    //SIMPLES BOTONES QUE MANDAN A OTRA ACTIVITY
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddQuestionActivity.class);
                startActivity(intent);
            }
        });

        btnAns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, QuestionsList.class);
                startActivity(intent);
            }
        });


    }


    public void init(){
        btnAdd = findViewById(R.id.btnAddQuestion);
        btnAns = findViewById(R.id.btnAnsw);
    }
}

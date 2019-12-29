package com.example.testquiz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.testquiz.R;
import com.example.testquiz.adapters.MyAdapter;
import com.example.testquiz.models.Question;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddQuestionActivity extends AppCompatActivity {


    public Realm realm;
    public EditText eTxtAddQuestion;
    public RadioButton rbTrue, rbFalse;
    public Button btnAddQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        init();

        realm = Realm.getDefaultInstance();

        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = eTxtAddQuestion.getText().toString();
                createNewQuestion(question);
            }
        });

    }


    public void createNewQuestion(String question){
        if(question.length() > 0){
            if(rbTrue.isChecked()){
                upQuestionToRealm(question, true);
                Toast.makeText(getApplicationContext(), "Pregunta añadida/Marcaste True", Toast.LENGTH_LONG).show();
            } else if(rbFalse.isChecked()){
                upQuestionToRealm(question, false);
                Toast.makeText(getApplicationContext(), "Pregunta añadida/ Marcaste False", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "marca una opcion", Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(getApplicationContext(), "Haz una pregunta", Toast.LENGTH_SHORT).show();
        }
    }


    public void upQuestionToRealm(String question, boolean answer){
        realm.beginTransaction();
        Question questionObject = new Question(question, answer);
        realm.copyToRealm(questionObject);
        realm.commitTransaction();
    }


    private void init(){
        eTxtAddQuestion = findViewById(R.id.editTextQuestion);
        rbTrue = findViewById(R.id.radioButtonTrue);
        rbFalse = findViewById(R.id.radioButtonFalse);
        btnAddQuestion = findViewById(R.id.buttonAddQuestionToRealm);
    }




}

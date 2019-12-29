package com.example.testquiz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testquiz.R;
import com.example.testquiz.adapters.MyAdapter;
import com.example.testquiz.models.Question;

import io.realm.Realm;
import io.realm.RealmResults;

public class QuestionsList extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Realm realm;
    //Esta variable almacena la queries
    private RealmResults<Question> questionRealmResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);

        realm = Realm.getDefaultInstance();
        //QUERY
        questionRealmResults = realm.where(Question.class).findAll();

        init();

        mAdapter = new MyAdapter(R.layout.item_list, questionRealmResults);
        //Detalles para el recycler
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setAdapter(mAdapter);

    }


    public void init(){
        mRecyclerview = findViewById(R.id.recyclerView);
    }

}

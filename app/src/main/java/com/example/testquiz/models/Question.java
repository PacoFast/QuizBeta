package com.example.testquiz.models;

import com.example.testquiz.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Question extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String question;

    private boolean questionValue;

    public Question(){}

    public Question(String question, boolean questionValue){
        //Falta agregar el autoincrement
        this.id = MyApplication.questionId.incrementAndGet();
        this.question = question;
        this.questionValue = questionValue;
    }

    public int getId() {
        return id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(boolean questionValue) {
        this.questionValue = questionValue;
    }
}

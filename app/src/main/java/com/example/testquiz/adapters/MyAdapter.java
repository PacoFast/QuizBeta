package com.example.testquiz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testquiz.R;
import com.example.testquiz.models.Question;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderData> {
    //REFERENCIA DE NUESTRO LAYOUT CUSTOM
    private int layout;
    //LISTA DE DATOS QUE RECIBIRA NUESTRO ADAPTER
    private List<Question> questions;

    public MyAdapter(int layout, List<Question> question) {
        this.layout = layout;
        this.questions = question;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //INFLAMOS LA VISTA CON EL LAYOUT QUE NOS LLEGA EN EL CONSTRUCTOR
        View view = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        ViewHolderData viewHolderData = new ViewHolderData(view);
        //LE MANDAMOS A NUESTRA CLASE VIEWHOLDERDATA LA VISTA QUE OBTENEMOS
        return viewHolderData;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        holder.bindData(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolderData extends RecyclerView.ViewHolder {

        public TextView txtViewQuestion, txtViewResult;
    //RECUPERAMOS LAS REFERENCIAS QUE NOS MANDARON CON ESTE CONSTRUCTOR QUE OBTIENE EL OBJETO
        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            txtViewQuestion = itemView.findViewById(R.id.textViewQuestionMade);
            txtViewResult = itemView.findViewById(R.id.textViewAnswerMade);
        }

        public void bindData(final Question question){
            //VOLCAMOS LOS DATOS
           txtViewQuestion.setText(question.getQuestion());
           txtViewResult.setText(""+question.isQuestionValue());
        }

    }
}

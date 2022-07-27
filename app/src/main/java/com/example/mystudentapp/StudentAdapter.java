package com.example.mystudentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    private List<Student> mListStudent;

    public StudentAdapter(List<Student> mListStudent) {
        this.mListStudent = mListStudent;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = mListStudent.get(position);
        if (student == null){
            return;
        }
    }

    @Override
    public int getItemCount() {
        if (mListStudent != null){
            return mListStudent.size();
        }
        return 0;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvAge;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
        }
    }
}

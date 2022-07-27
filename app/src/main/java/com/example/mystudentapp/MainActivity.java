package com.example.mystudentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvStudent;
    private Button btnAdd;

    private StudentAdapter studentAdapter;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvStudent = findViewById(R.id.rcv_student);
        btnAdd = findViewById(R.id.btn_add);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvStudent.setLayoutManager(linearLayoutManager);

        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        studentViewModel.getListStudentLiveData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentAdapter = new StudentAdapter(students);
                rcvStudent.setAdapter(studentAdapter);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAddStudent();
            }
        });
    }

    private void clickAddStudent() {
        int index=1;
        Student student = new Student("Tuan Anh"+index,24 + index);
        studentViewModel.addStudent(student);
        index++;
    }
}
package com.example.mystudentapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private MutableLiveData<List<Student>> mListStudentLiveData;
    private List<Student> mListStudent;

    public StudentViewModel(){
        mListStudentLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mListStudent = new ArrayList<>();
        mListStudent.add(new Student("AnhNT257",24));

        mListStudentLiveData.setValue(mListStudent);
    }

    public MutableLiveData<List<Student>> getListStudentLiveData() {
        return mListStudentLiveData;
    }
    public void addStudent(Student student){
        mListStudent.add(student);
        mListStudentLiveData.setValue(mListStudent);
    }
}

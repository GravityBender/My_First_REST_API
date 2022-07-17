package com.practise.controller;

import com.practise.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Garvit", "Verma"));
        theStudents.add(new Student("Anurag", "Singh"));
        theStudents.add(new Student("Arpit", "Tripathi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
//        List<Student> theStudents = new ArrayList<>();
//
//        theStudents.add(new Student("Garvit", "Verma"));
//        theStudents.add(new Student("Anurag", "Singh"));
//        theStudents.add(new Student("Arpit", "Tripathi"));

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }

}

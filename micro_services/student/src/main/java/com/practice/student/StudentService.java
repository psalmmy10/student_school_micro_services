package com.practice.student;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;

    public void saveStudents(Student student){
        studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId){
        return studentRepo.findAllBySchoolId(schoolId);
    }

}

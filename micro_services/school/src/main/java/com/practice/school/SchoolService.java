package com.practice.school;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.school.client.StudentClient;

import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class SchoolService {

//     private final SchoolRepository schoolRepo;
//     private final StudentClient studentClient;

//     public SchoolService(StudentClient studentClient) {
//         this.schoolRepo = null;
//         this.studentClient = studentClient;
//     }

//     public void saveSchool(School school){
//         schoolRepo.save(school);
//     }

//     public List<School> findAllSchools(){
//         return schoolRepo.findAll();
//     }

//     public FullResponse findSchoolsWithStudents(Integer schoolId){

//         var school = schoolRepo.findById(schoolId)
//             .orElse(School.builder()
//             .name("NOT_FOUND")
//             .email("NOT_FOUND")
//             .build()
//         );

//         var students = studentClient.findAllStudentsBySchool(schoolId);

//         return FullResponse.builder()
//                 .name(school.getName())
//                 .email(school.getEmail())
//                 .students(students)
//                 .build();
//     }

// }


@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepo;
    private final StudentClient studentClient;

    public void saveSchool(School school){
        schoolRepo.save(school);
    }

    public List<School> findAllSchools(){
        return schoolRepo.findAll();
    }

    public FullResponse findSchoolsWithStudents(Integer schoolId){

        var school = schoolRepo.findById(schoolId)
            .orElse(School.builder()
                .name("NOT_FOUND")
                .email("NOT_FOUND")
                .build()
            );

        var students = studentClient.findAllStudentsBySchool(schoolId);

        return FullResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
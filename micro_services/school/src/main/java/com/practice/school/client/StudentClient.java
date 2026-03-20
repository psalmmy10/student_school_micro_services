package com.practice.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.school.Student;

// @FeignClient(name = "student-service", url = "${application.config.student-url}")
// public interface StudentClient {

//     @GetMapping("/schools/{schoolId}")
//     List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId);
// }
// @FeignClient(name = "student-service", url = "${application.config.student-url}")
// public interface StudentClient {

//     @GetMapping("schools/{schoolId}")
//     List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);
// }


@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("api/v1/students/schools/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);
}

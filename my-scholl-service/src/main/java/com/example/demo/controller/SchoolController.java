package com.example.demo.controller;
import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.service.SchoolStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SchoolController {
    private SchoolStudentService schoolStudentService;

    @GetMapping("/schools/{schoolId}")
    public ResponseEntity<Iterable<Student>> getStudentBySchoolID(@PathVariable("schoolId") Integer schoolId)
    {
        Optional<School> school=schoolStudentService.findBySchoolId(schoolId);

        return ResponseEntity.ok().body(school.get().getStudents());
    }

    public SchoolController(SchoolStudentService schoolStudentService) {
        this.schoolStudentService = schoolStudentService;
    }
    @RequestMapping(value = "/schools", method = RequestMethod.POST,consumes = { "application/JSON"})
    public ResponseEntity<School> createSchool(@RequestBody School school)
    {

        return new ResponseEntity<>(schoolStudentService.createSchool(school), HttpStatus.CREATED);
    }
}

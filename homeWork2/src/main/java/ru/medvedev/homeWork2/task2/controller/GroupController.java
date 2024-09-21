package ru.medvedev.homeWork2.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medvedev.homeWork2.task2.Student;
import ru.medvedev.homeWork2.task2.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final StudentRepository studentRepository;


    @Autowired
    public GroupController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/{groupName}/students")
    public List<Student> getGroupStudents(@PathVariable String groupName) {
        return studentRepository.getGroupStudents(groupName);
    }

}


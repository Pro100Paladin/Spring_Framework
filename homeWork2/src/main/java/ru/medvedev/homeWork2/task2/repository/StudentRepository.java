package ru.medvedev.homeWork2.task2.repository;

import org.springframework.stereotype.Repository;
import ru.medvedev.homeWork2.task2.Student;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
public class StudentRepository {

    private final List<Student> students;


    private StudentRepository(List<Student> students) {
        this.students = students;
        students.add(new Student("Evgeniy", "Testing"));
        students.add(new Student("Dmitry", "Developer"));
        students.add(new Student("Alexander", "Developer"));
        students.add(new Student("Katharine", "Analytics"));
        students.add(new Student("Olga", "Analytics"));
        students.add(new Student("Konstantin", "Testing"));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public List<Student> getByName(String name) {
        return students.stream()
                .filter(it -> it.getName().startsWith(name))
                .collect(Collectors.toList());
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getGroupStudents(String groupName) {
        return students.stream()
                .filter(it -> it.getGroupName().equals(groupName))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        long newId = students.stream()
                .reduce((first, second) -> second)
                .map(Student::getId)
                .get();
        student.setId(++newId);
        students.add(student);
    }

    public Student deleteStudent(long id){
        Student deleteStudent = getById(id);
        students.remove(deleteStudent);
        return deleteStudent;
    }


}

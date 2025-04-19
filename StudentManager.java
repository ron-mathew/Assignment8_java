package service;

import model.Student;
import exception.*;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) throws DuplicatePRNException, InvalidStudentException {
        if (student.getPrn() == null || student.getPrn().isEmpty()) {
            throw new InvalidStudentException("PRN cannot be empty.");
        }
        for (Student s : students) {
            if (s.getPrn().equals(student.getPrn())) {
                throw new DuplicatePRNException("PRN already exists.");
            }
        }
        students.add(student);
    }

    // Display all students
    public List<Student> getAllStudents() throws StudentNotFoundException {
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No student data available.");
        }
        return students;
    }

    // Search by PRN
    public Student searchByPRN(String prn) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getPrn().equalsIgnoreCase(prn)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    // Search by Name
    public List<Student> searchByName(String name) throws StudentNotFoundException {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            throw new StudentNotFoundException("No students found with name: " + name);
        }
        return result;
    }

    // Search by position
    public Student searchByPosition(int index) throws InvalidPositionException {
        if (index < 0 || index >= students.size()) {
            throw new InvalidPositionException("Invalid index: " + index);
        }
        return students.get(index);
    }

    // Update student
    public void updateStudent(String prn, String name, String dob, float marks) throws StudentNotFoundException {
        Student s = searchByPRN(prn);
        s.setName(name);
        s.setDob(dob);
        s.setMarks(marks);
    }

    // Delete student
    public void deleteStudent(String prn) throws StudentNotFoundException {
        Student s = searchByPRN(prn);
        students.remove(s);
    }
}

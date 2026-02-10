package question2_student_registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Sample students list (in-memory storage)
    private List<Student> students = new ArrayList<>();

    // Constructor - Initialize with 5 sample students
    public StudentController() {
        students.add(new Student(1L, "John", "Doe", "john.doe@example.com", "Computer Science", 3.8));
        students.add(new Student(2L, "Jane", "Smith", "jane.smith@example.com", "Computer Science", 3.9));
        students.add(new Student(3L, "Mike", "Johnson", "mike.j@example.com", "Business Administration", 3.2));
        students.add(new Student(4L, "Sarah", "Williams", "sarah.w@example.com", "Engineering", 3.6));
        students.add(new Student(5L, "David", "Brown", "david.b@example.com", "Computer Science", 3.4));
    }

    // GET /api/students - Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET /api/students/{studentId} - Get student by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET /api/students/major/{major} - Get all students by major
    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/students/filter?gpa={minGpa} - Filter students by minimum GPA
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByGpa(@RequestParam Double gpa) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGpa() >= gpa) {
                result.add(student);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // POST /api/students - Register new student
    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // PUT /api/students/{studentId} - Update student information
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getStudentId().equals(studentId)) {
                updatedStudent.setStudentId(studentId);
                students.set(i, updatedStudent);
                return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
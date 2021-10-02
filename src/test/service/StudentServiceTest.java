package test.service;

import entity.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;
import service.StudentService;
import service.StudentServiceImpl;

public class StudentServiceTest {

    public static void main(String[] args) {
        testEditStudent();
    }

    public static void testShowStudents() {

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        studentRepository.data[0] = new Student("Ahmad Saipuddin");
        studentRepository.data[1] = new Student("Hilmi Subardjo");
        studentRepository.data[2] = new Student("Fahrul Ubaidah");

        StudentService studentService = new StudentServiceImpl(studentRepository);
        studentService.showStudents();

    }

    public static void testAddStudent() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        studentService.addStudent("Ahmad");
        studentService.addStudent("Udin");
        studentService.addStudent("Saipeul");

        for (int i = 0; i < 20; i++) {
            studentService.addStudent("Ahmad " + i);
        }

        studentService.showStudents();
    }

    public static void testRemoveStudent() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        studentService.addStudent("Ahmad");
        studentService.addStudent("Udin");
        studentService.addStudent("Saipeul");
        studentService.showStudents();

        studentService.removeStudent(4);
        studentService.removeStudent(12);
        studentService.removeStudent(2);
        studentService.showStudents();
    }

    public static void testShowStudentWithNumber() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        studentService.addStudent("Ahmad");
        studentService.addStudent("Udin");
        studentService.addStudent("Saipeul");

        studentService.showStudentWithNumber(11);
    }

    public static void testEditStudent() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        studentService.addStudent("Ahmad");
        studentService.addStudent("Udin");
        studentService.addStudent("Saipeul");

        studentService.editStudent("name", 1, "Ucup");
        studentService.editStudent("npm", 1, "19670067");
        studentService.editStudent("address", 1, "Kupang");
        studentService.showStudentWithNumber(1);
    }
}

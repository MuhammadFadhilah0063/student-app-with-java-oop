package test.view;

import repository.StudentRepository;
import repository.StudentRepositoryImpl;
import service.StudentService;
import service.StudentServiceImpl;
import view.StudentView;

public class StudentViewTest {
    public static void main(String[] args) {

        testEditStudentWithNumber();

    }

    public static void testShowStudents() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        service.addStudent("Udin");
        service.addStudent("Ucup");
        service.addStudent("Undul");

        view.showStudents();

    }

    public static void testAddStudent() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        view.addStudent();
        service.showStudents();
        view.addStudent();
        service.showStudents();

    }

    public static void testRemoveStudent() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        service.addStudent("Udin");
        service.addStudent("Ucup");
        service.addStudent("Undul");

        view.removeStudent();

    }

    public static void testEditStudent() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        service.addStudent("Udin");

        view.detailStudent();

    }

    public static void testShowStudentWithNumber() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        service.addStudent("Udin");

        view.detailStudentWIthNumber(1);

    }

    public static void testEditStudentWithNumber() {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentService service = new StudentServiceImpl(repository);
        StudentView view = new StudentView(service);

        service.addStudent("Udin");

        view.editStudentWIthNumber("Address", 1);

    }

}

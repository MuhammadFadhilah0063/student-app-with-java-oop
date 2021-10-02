import repository.StudentRepository;
import repository.StudentRepositoryImpl;
import service.StudentService;
import service.StudentServiceImpl;
import view.StudentView;

public class StudentApp {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);
        StudentView studentView = new StudentView(studentService);

        studentView.showStudents();

    }
}

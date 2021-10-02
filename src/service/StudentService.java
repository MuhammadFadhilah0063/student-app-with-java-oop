package service;

public interface StudentService {

    void showStudents();

    void showStudentWithNumber(Integer number);

    void addStudent(String name);

    void removeStudent(Integer number);

    void editStudent(String info, Integer number, String value);

    boolean hasDetailStudent(Integer number);

}

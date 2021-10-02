package repository;

import entity.Student;

public interface StudentRepository {

    Student[] getAll();

    Student getStudent(Integer number);

    void add(Student student);

    boolean remove(Integer number);

    boolean edit(String info, Integer number, String value);

    boolean isValidNumber(Integer number);

}

package service;

import entity.Student;
import repository.StudentRepository;

public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * To show all students
     */
    @Override
    public void showStudents() {
        Student[] data = studentRepository.getAll();

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null) {
                System.out.println((i + 1) + ". " + data[i].getName());
            }

        }
    }

    /**
     * To display student data details by number
     * @param number
     */
    @Override
    public void showStudentWithNumber(Integer number) {
        Student student = studentRepository.getStudent(number);

        if (student != null) {
            System.out.println("Number  : " + number);
            System.out.println("Name    : " + student.getName());
            System.out.println("NPM     : " + student.getNpm());
            System.out.println("Address : " + student.getAddress());
        } else {
            System.out.println("Student with number " + number + " is not available");
        }

    }

    /**
     * To display input add student
     * @param name
     */
    @Override
    public void addStudent(String name) {

        Student student = new Student(name);
        studentRepository.add(student);
        System.out.println("successfully added student : " + name);

    }

    /**
     * To display input remove student
     * @param number
     */
    @Override
    public void removeStudent(Integer number) {
        var success = studentRepository.remove(number);
        if (success) {
            System.out.println("Successfully deleting student : " + number);
        } else {
            System.out.println("Not Successfully deleting student : " + number);
        }
    }

    /**
     * To edit student data
     * @param info
     * @param number
     * @param value
     */
    @Override
    public void editStudent(String info, Integer number, String value) {
        var success = studentRepository.edit(info,number,value);
        if (success) {
            System.out.println("Successfully Editing " + info + " Student : " + number);
        } else {
            System.out.println("Not Successfully Editing " + info + " Student : " + number);
        }
    }

    /**
     * To check if there is a student data detail
     * @param number
     * @return
     */
    public boolean hasDetailStudent(Integer number) {
        if (studentRepository.isValidNumber(number)) {
            return true;
        } else {
            return false;
        }
    }

}

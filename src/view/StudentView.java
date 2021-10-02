package view;

import service.StudentService;
import util.InputUtil;

public class StudentView {

    StudentService studentService;

    public StudentView(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * View to show all students
     */
    public void showStudents() {

        while (true) {
            System.out.println("~~~~~~~~~~~Student~~~~~~~~~~~");
            studentService.showStudents();

            System.out.println("~~~~~~~~~~~~Menu~~~~~~~~~~~~~");
            System.out.println("1. add");
            System.out.println("2. remove");
            System.out.println("3. detail");
            System.out.println("x. exit");

            System.out.println("~~~~~~~~~~~~Input~~~~~~~~~~~~");
            var input = InputUtil.input("Input");

            if (input.equals("1")) {
                addStudent();
            } else if (input.equals("2")) {
                removeStudent();
            } else if (input.equals("3")) {
               detailStudent();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("\n>>>>> Invalid input : " + input + " <<<<<\n");
            }
        }


    }

    /**
     * View to show input add student
     */
    public void addStudent() {
        System.out.println("~~~~~~~~~Add Student~~~~~~~~~");
        var input = InputUtil.input("Name (x for cancel)");

        if (input.equals("x")) {
            // cancel
        } else {
            studentService.addStudent(input);
        }
    }

    /**
     * View to show input remove student
     */
    public void removeStudent() {
        System.out.println("~~~~~~~Remove Student~~~~~~~~");
        studentService.showStudents();

        System.out.println("~~~~~~~~~~~~Input~~~~~~~~~~~~");
        var input = InputUtil.input("Number (x for cancel)");

        if (input.equals("x")) {
            // cancel
        } else {
            studentService.removeStudent(Integer.valueOf(input));
        }
    }

    /**
     * View to show input detail student
     */
    public void detailStudent() {
        System.out.println("~~~~~~~Detail Student~~~~~~~~");
        studentService.showStudents();

        System.out.println("~~~~~~~~~~~~Input~~~~~~~~~~~~");
        var input = InputUtil.input("Number (x for cancel)");

        if (input.equals("x")) {
            // cancel
        } else {
            if (studentService.hasDetailStudent(Integer.valueOf(input))) {
                detailStudentWIthNumber(Integer.valueOf(input));
            } else {
                System.out.println("\n>>>>> Invalid input : " + input + " <<<<<\n");
            }
        }
    }

    /**
     * View to display student data details by number
     * @param number
     */
    public void detailStudentWIthNumber(Integer number) {
        System.out.println("~~~~~~~Detail Student~~~~~~~~");
        studentService.showStudentWithNumber(number);

        System.out.println("~~~~~~~~~~~~Menu~~~~~~~~~~~~~");
        System.out.println("1. edit name");
        System.out.println("2. edit npm");
        System.out.println("3. edit address");
        System.out.println("x. cancel");

        System.out.println("~~~~~~~~~~~~Input~~~~~~~~~~~~");
        var input = InputUtil.input("Input");

        if (input.equals("1")) {
            editStudentWIthNumber("Name", number);
        } else if (input.equals("2")) {
            editStudentWIthNumber("NPM", number);
        } else if (input.equals("3")) {
            editStudentWIthNumber("Address", number);
        } else if (input.equals("x")) {
            // cancel
        } else {
            System.out.println("\n>>>>> Invalid input : " + input + " <<<<<\n");
            detailStudentWIthNumber(number);
        }
    }

    /**
     * View to show input edit student data
     * @param info
     * @param number
     */
    public void editStudentWIthNumber(String info, Integer number) {
        System.out.println("~~~~~~~Edit " + info + " Student~~~~~~~~");
        var input = InputUtil.input(info + " (x for cancel)");

        if (input.equals("x")) {
            detailStudentWIthNumber(number);
        } else {
            studentService.editStudent(info, number, input);
            detailStudentWIthNumber(number);
        }
    }

}

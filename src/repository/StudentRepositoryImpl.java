package repository;

import entity.Student;

public class StudentRepositoryImpl implements StudentRepository{

    public Student[] data = new Student[10];

    /**
     * Retrieve all student data
     * @return data
     */
    @Override
    public Student[] getAll() {
        return data;
    }

    /**
     * Take student data by number
     * @param number
     * @return data
     */
    @Override
    public Student getStudent(Integer number) {
        if ((number - 1) >= data.length) {
            return null;
        } else if (data[number - 1] == null) {
            return null;
        } else {
            return data[number - 1];
        }
    }

    /**
     * Checking if data array is full?
     * @return isFull (true or false)
     */
    public boolean isFull() {

        boolean isFull = true;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                isFull = false;
            }
        }
        return isFull;

    }

    /**
     * Resize (2x) data array if full
     */
    public void resizeIfFull() {

        if (isFull()) {
            var temp = data;

            data = new Student[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

    }

    /**
     * Add student
     * @param student
     */
    @Override
    public void add(Student student) {

        resizeIfFull();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = student;
                break;
            }
        }
        
    }

    /**
     * Remove student
     * @param number
     */
    @Override
    public boolean remove(Integer number) {

        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }

            return true;
        }

    }

    /**
     * Edit data from students
     * @param info
     * @param number
     * @param value
     * @return true or false
     */
    @Override
    public boolean edit(String info, Integer number, String value) {

        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            if (info == "Name") {
                data[number - 1].setName(value);
            } else if (info == "NPM") {
                data[number - 1].setNpm(value);
            } else if (info == "Address") {
                data[number - 1].setAddress(value);
            }
            return true;
        }

    }

    /**
     * Check if there is student data with number
     * @param number
     * @return true or false
     */
    public boolean isValidNumber(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            return true;
        }
    }

}

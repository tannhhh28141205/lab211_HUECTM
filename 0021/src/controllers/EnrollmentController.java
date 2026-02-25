package controllers;

import models.Enrollment;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class EnrollmentController {

    public void mockData(List<Enrollment> listStudent) {
        listStudent.add(new Enrollment(1, "Vu Trong Phu", 1, 1,6));
        listStudent.add(new Enrollment(1, "Vu Trong Phu", 2, 1,7));
        listStudent.add(new Enrollment(1, "Vu Trong Phu", 2, 2,3));
        listStudent.add(new Enrollment(2, "Nguyen Van A", 1, 3,10));
        listStudent.add(new Enrollment(3, "Nguyen Van A", 4, 1,3));
        listStudent.add(new Enrollment(1, "Vu Trong Phu", 3, 1,3));
    }

    //Create
    public void inputEnrollment(List<Enrollment> listStudent, Enrollment student) {

        if (findEnrollmentIndex(listStudent, student) != -1) {
            throw new IllegalArgumentException("Invalid, that infomation is duplicated");
        }
        listStudent.add(student);

    }

    public void isValidStudent(List<Enrollment> listStudent, Enrollment student) {
        //tranverse element start to end
        for (Enrollment temp : listStudent) {
            //compare in 1 id
            if (temp.getId() == student.getId()) {

                //only 1 id have 1 name
                if (!temp.getName().equalsIgnoreCase(student.getName())) {
                    throw new IllegalArgumentException("Invalid, Id only only exist with one name");
                }

            }
        }
    }

    /**
     * find student in list by object student
     *
     * @param listStudent
     * @param student
     * @return index of student in list and otherwise is -1
     */
    private int findEnrollmentIndex(List<Enrollment> listStudent, Enrollment student) {
        for (int i = 0; i < listStudent.size(); i++) {
            //compare in 1 id
            if (listStudent.get(i).getId() == student.getId()) {
                //check duplicate of student
                if (listStudent.get(i).getCourseName() == student.getCourseName() && listStudent.get(i).getSemeter() == student.getSemeter()
                        && listStudent.get(i).getName().equalsIgnoreCase(student.getName())) {
                    return i;
                }

            }
        }
        return -1;
    }

    //Find and Sort
    public List<Enrollment> findListStudentByKey(List<Enrollment> listStudent, String key) {
        //check list student have element or yet
        if (listStudent.isEmpty()) {
            throw new IllegalArgumentException("That list student is empty!");
        }

        List<Enrollment> listS = new ArrayList<>();
        for (Enrollment t : listStudent) {
            //test each student have any characters same key
            if (t.getName().toLowerCase().contains(key.toLowerCase())) {
                listS.add(t);
            }
        }
        sortList(listS);

        return listS;
    }

    private void sortList(List<Enrollment> listStudent) {
        Collections.sort(listStudent, (Enrollment o1, Enrollment o2) -> o1.getName().compareTo(o2.getName()));
    }

    /**
     * update student with id
     *
     * @param listStudent
     * @param idFound
     * @param toUpdate
     */
    //Update
    public void updateListStudent(List<Enrollment> listStudent, Enrollment toUpdate, Enrollment studentFound) {
        if (listStudent.isEmpty()) {
            throw new IllegalArgumentException("Invalid, the list student is empty");
        }
        int index = findEnrollmentIndex(listStudent, studentFound);
        if (index == -1) {
            throw new IllegalArgumentException("Not found student");
        }
        Enrollment newStudent = listStudent.get(index);

        newStudent.setName(toUpdate.getName());
        newStudent.setCourseName(toUpdate.getCourseName());
        newStudent.setSemeter(toUpdate.getSemeter());

        updateNameByID(listStudent, toUpdate.getName(), newStudent.getId());

    }

    private void updateNameByID(List<Enrollment> listStudent, String name, int id) {

        for (Enrollment t : listStudent) {
            //check all student have that id matches
            if (t.getId() == id) {
                t.setName(name);
            }
        }
    }

    /**
     * delete student follow with user
     *
     * @param listStudent
     * @param studentFound
     */
    //Delete
    public void deleteStudent(List<Enrollment> listStudent, Enrollment studentFound) {
        if (listStudent.isEmpty()) {
            throw new IllegalArgumentException("Invalid, not found student with that ID ");
        }

        listStudent.remove(studentFound);

    }

    /**
     * find a student by that id
     *
     * @param listStudent
     * @param id
     * @return list information of student
     */
    public List<Enrollment> findStudentById(List<Enrollment> listStudent, int id) {
        List<Enrollment> listRes = new ArrayList<>();
        for (Enrollment t : listStudent) {
            if (t.getId() == id) {
                listRes.add(t);
            }
        }
        return listRes;
    }

}

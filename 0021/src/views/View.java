package views;

import controllers.ReportController;
import controllers.EnrollmentController;
import models.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import models.Report;

public class View {

    public void run() {
        EnrollmentController controller = new EnrollmentController();
        ReportController reportController = new ReportController();
        List<Enrollment> listStudent = new ArrayList<>();
        controller.mockData(listStudent);
        while (true) {
            //Show menu
            showMenu();
            //Ask user select option
            int option = utilities.InputValidation.inputInteger("Enter option: ", 1, 9);

            switch (option) {
                //Create
                case 1:
                    inputStudentView(listStudent, controller);
                    break;
                //Find and Sort
                case 2:
                    findListStudentView(listStudent, controller);
                    break;
                //Update or Delete
                case 3:
                    String choice = utilities.InputValidation.inputString("Do you want Update or Delete(u/d):?", "Please enter u or d",
                            utilities.InputValidation.REGEX_DELETE_UPDATE);
                    if (choice.equalsIgnoreCase("u")) {
                        updateView(listStudent, controller);
                        break;
                    }
                    deleteView(listStudent, controller);
                    break;
                //Report
                case 4:
                    displayReportView(listStudent, reportController);
                    break;
                //Exit
                case 5:
                    System.exit(0);

                case 9:
                    deleteAllEnrollmentById(listStudent);
                    break;
            }

        }

    }

    private void deleteAllEnrollmentById(List<Enrollment> list) {
        int id = inputId();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }

    private void showMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit\n"
                + "9.                    Delete All");
    }

    private <T> T inputWithRetry(Supplier<T> t) {
        //run when data return 
        while (true) {
            try {

                return t.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputStudentView(List<Enrollment> listStudent, EnrollmentController controller) {
        System.out.println("--------Create Student-----------");
        String choice = "y";
        //check list have X0 student 
        if (listStudent.size() % 10 == 0) {
            System.out.println("Do you want to add student more: ");
            System.out.println("Yes or No ?(y/n): ");

            choice = utilities.InputValidation.inputString("Yes or No ?(y/n): ", "Enter choice (y or n) valid!",
                    utilities.InputValidation.REGEX_ADD);
        }
        if (choice.equalsIgnoreCase("n")) {
            return;
        }
        try {
            Enrollment student = new Enrollment();

            int id = inputId();
            student.setId(id);

            String name = inputName();
            student.setName(name);
            //check valid
            controller.isValidStudent(listStudent, student);

            inputWithRetry(() -> {
                int semester = inputSemester();
                student.setSemeter(semester);
                return null;
            });

            inputWithRetry(() -> {
                int course = inputCourse();
                student.setCourseName(course);
                return null;
            });
            
            student.setScore(5.5);

            controller.inputEnrollment(listStudent, student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void findListStudentView(List<Enrollment> listStudent, EnrollmentController controller) {
        System.out.println("-----------Find and Sort---------------");
        String key = utilities.InputValidation.inputString("Enter key: ", "", "");
        try {
            List<Enrollment> listTemp = controller.findListStudentByKey(listStudent, key);
            displayStudentById(listTemp);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteView(List<Enrollment> listStudent, EnrollmentController controller) {
        System.out.println("------Delete-------");
        int id = utilities.InputValidation.inputInteger("Enter id: ", 1, 1000);
        List<Enrollment> listStudentTemp = controller.findStudentById(listStudent, id);

        displayStudentById(listStudentTemp);

        int index = utilities.InputValidation.inputInteger("Enter number want to delete:", 1, listStudentTemp.size());
        Enrollment studentFound = listStudentTemp.get(index - 1);
        try {
            controller.deleteStudent(listStudent, studentFound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateView(List<Enrollment> listStudent, EnrollmentController controller) {
        System.out.println("-----------Update---------");

        int id = utilities.InputValidation.inputInteger("Enter id: ", 1, 1000);
        List<Enrollment> listStudentTemp = controller.findStudentById(listStudent, id);
        if (listStudentTemp.isEmpty()) {
            System.out.println("Not found any student with ID");
            return;
        }
        displayStudentById(listStudentTemp);
        int index = utilities.InputValidation.inputInteger("Enter id want to update:", 0, listStudentTemp.size() - 1);

        Enrollment studentFound = listStudentTemp.get(index);

        Enrollment toUpdate = new Enrollment();
        toUpdate.setId(studentFound.getId());

        String name = inputName();
        toUpdate.setName(name);

        inputWithRetry(() -> {
            int semester = inputSemester();
            toUpdate.setSemeter(semester);
            return null;
        });

        inputWithRetry(() -> {
            int course = inputCourse();
            toUpdate.setCourseName(course);
            return null;
        });

        try {
            controller.updateListStudent(listStudent, toUpdate, studentFound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void displayReportView(List<Enrollment> listStudent, ReportController reportController) {
        System.out.println("---------Report----------");
        List<Report> listReport = reportController.createListReport(listStudent);
        System.out.printf("%-4s %-15s %-10s %-10s\n","ID","Name","Course","TotalCourse");
        for (Report temp : listReport) {
            System.out.println(temp);
        }

    }

    //Input property function
    private int inputId() {
        return utilities.InputValidation.inputInteger("Enter ID: ", 1, 10000);
    }

    private String inputName() {
        return utilities.InputValidation.inputString("Enter Name: ", "Wrong", "");
    }

    private int inputSemester() {
        return utilities.InputValidation.inputInteger("Enter semester: ", 1, 100);
    }

    private int inputCourse() {
        System.out.print("1.  Java\n2. .Net\n3. C\\C++\n");
        return utilities.InputValidation.inputInteger("Enter courser name:", 1, 3);
    }

    private boolean checkOption(String msg, String error, String regex, String trueValue) {
        String res = utilities.InputValidation.inputString(msg, error, regex);
        return res.equalsIgnoreCase(trueValue);

    }

    private void displayStudentById(List<Enrollment> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("That list not have any student");
            return;
        }
        System.out.println("-------------Display------------");
        System.out.printf("%-7s %-10s %-13s %-13s %-10s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(i+1 + "       " + listStudent.get(i));
        }
        
    }

    
    
    public static void main(String[] args) {
        EnrollmentController controller = new EnrollmentController();
        ReportController reportController = new ReportController();
        List<Enrollment> listStudent = new ArrayList<>();
        controller.mockData(listStudent);
        View view = new View();
        view.displayReportView(listStudent, reportController);
    }

}

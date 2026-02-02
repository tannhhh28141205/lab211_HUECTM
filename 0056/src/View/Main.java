package View;

import Controller.Manage;
import Model.HistorySalary;
import Model.Worker;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Worker> listWorker = new ArrayList<>();
        List<HistorySalary> listHistory = new ArrayList<>();
        View_Worker view = new View_Worker();
        Manage manage = new Manage();
        loadSampleData(listWorker);
        
        while (true) {
            //Show menu to user
            view.showMenu();
            //Ask user select option
            int option = view.inputMenuChoice();
            switch (option) {
                //Option  1: Add worker
                case 1:
                    view.addWorker(listWorker, manage);
                    break;
                //Option 2: Up salary
                case 2:
                    view.updateSalary(listWorker, listHistory, manage, option);
                    break;
                //Option 3: Down salary
                case 3:
                    view.updateSalary(listWorker, listHistory, manage, option);
                    break;
                //Option 4: Display the list of adjusted salary workers
                case 4:
                    view.displayAllSalaryHistory(listHistory);
                    break;
                //Option 5: Exit system
                case 5:
                    System.exit(0);
            }

        }

    }
    
    private  static void loadSampleData(List<Worker> listWorker) {
    listWorker.add(new Worker("W01", "Nam", 18, 5000, "HN"));
    listWorker.add(new Worker("W02", "An", 30, 6000, "HCM"));
    listWorker.add(new Worker("W03", "Binh", 28, 5500, "DN"));
}

}

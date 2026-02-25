package View;

import Controller.EbankController;
import Model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<Account> listAccount = new ArrayList<>();
        EbankController controller = new EbankController();
        View_Ebank view = new View_Ebank();

        while (true) {

            // Show menu
            //Ask user enter option
            int option = view.inputOption();

            switch (option) {
                //Login with Vietnamese
                case 1:
                    view.login(new Locale("vi"), listAccount, controller);
                    break;
                //login with English
                case 2:
                    view.login(new Locale("en"), listAccount, controller);
                    break;
                //Exit program
                case 3:
                    System.exit(0);
            }

        }

    }

}

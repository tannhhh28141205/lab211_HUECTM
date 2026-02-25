package View;

import Controller.EbankController;
import Model.Account;
import Utility.InputValidation;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View_Ebank {

    public void showMenu() {
        System.out.println("-------Login Program-------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }

    public void login(Locale locale, List<Account> listAccount, EbankController controller) {
        ResourceBundle bundle = ResourceBundle.getBundle("Resourses/message", locale);
        try {
            String username = Utility.InputValidation.inputString(bundle.getString("msgAccount"), bundle.getString("msgAccountError"), Utility.InputValidation.REGEX_ACCOUNT);
            String password = Utility.InputValidation.inputString(bundle.getString("msgPassword"), bundle.getString("msgPasswordError"), Utility.InputValidation.REGEX_PASSWORD);
            String captcha = Utility.CaptchaUtil.genarateCaptcha();
            System.out.println(bundle.getString("msgCaptcha") + captcha);
            String captchaInput = Utility.InputValidation.inputString(bundle.getString("msgCaptchaInput"), bundle.getString("msgCaptchaError"), "");
            controller.loginFunction(locale, listAccount, username, password, captcha, captchaInput);
            System.out.println(bundle.getString("messageLoginSuccess"));
        } catch (IllegalArgumentException e) {
            String key = e.getMessage();
            System.out.println(bundle.getString(key));
        }
    }

    public int inputOption() {
        return Utility.InputValidation.inputInteger("Enter option: ", 1, 3);
    }
}

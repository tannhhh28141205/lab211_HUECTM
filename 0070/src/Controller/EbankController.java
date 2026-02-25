package Controller;

import Model.Account;
import java.util.List;
import java.util.Locale;


public class EbankController {



    public  void loginFunction(Locale locale, List<Account> listAccount,
            String username, 
            String password
            , String captcha
            , String captchaInput) {
        
        
        if(!Utility.CaptchaUtil.validateCaptcha(captcha, captchaInput)){
            throw new IllegalArgumentException(("msgCaptchaError"));
        }
        
        if(!checkExistAccount(listAccount,username, password)){
            throw new IllegalArgumentException(("messageLoginFail"));
        }

    }

    private boolean checkExistAccount(List<Account> listAccount,  String username, 
            String password) {
        boolean isExist = false;
        for (Account temp : listAccount) {
            if (temp.getAccount().equals(username)
                    && temp.getPassword().equals(password)) {
                isExist = true;
            }
        }
        return isExist;
    }



   

}

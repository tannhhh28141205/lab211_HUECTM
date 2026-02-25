

package Utility;

import java.util.Random;

public class CaptchaUtil {

    
        public   static String genarateCaptcha() {
        char[] listCharacter = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'Q', 'W', 'E', 'R', 'T',
            'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z',
            'X', 'C', 'V', 'B', 'N', 'M'};
        Random rd = new Random();
        String captcha = "";
        for (int i = 0; i < 6; i++) {
            captcha += listCharacter[rd.nextInt(listCharacter.length)];
        }
        return captcha;
    }
    
    public static boolean validateCaptcha(String captcha, String input){
        return captcha.contains(input);
    }
}

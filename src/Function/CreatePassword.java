/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.Random;

/**
 *
 * @author Shado
 */
public class CreatePassword {

    public static String randomPassword(int size) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str2 = "0123456789";

        // These are the valid charecters use to random.
        String strValid = str + str1 + str2;

        Random random = new Random();
        String mystring = "";
        for (int i = 0; i < size; i++) {
            int randnum = random.nextInt(strValid.length());
            mystring = mystring + strValid.charAt(randnum);
        }
        return mystring;
    }
}

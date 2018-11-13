/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.Account;

/**
 *
 * @author Shado
 */
public class SetEmailContent {

    public String emailContent(Account acc, String password, String fromEmail) {
        String text = "Dear " + acc.getFullName() + ","
                + "\n\nThank you for register system. You can log in using new password:"
                + "\n\nUsername : " + acc.getUsername()
                + "\nPassword  : " + password
                + "\n\nBest regards,"
                + "\nDOManagement Team"
                + "\nEmail: " + fromEmail;
        return text;
    }

}

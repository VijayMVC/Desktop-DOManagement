/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author SunCho
 */
public class EmailInfo {
    private int id;
    private String email;
    private String password;
    private String rule;
    private String note;

    public EmailInfo() {
    }

    public EmailInfo(String email, String password, String rule, String note) {
        this.email = email;
        this.password = password;
        this.rule = rule;
        this.note = note;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "EmailInfo{" + "id=" + id + ", email=" + email + ", password=" + password + ", rule=" + rule + ", note=" + note + '}';
    }

}

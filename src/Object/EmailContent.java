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
public class EmailContent {
    private int id;
    private int emailId;
    private String subject;
    private String content;
    private String note;

    public EmailContent() {
    }

    public EmailContent(int emailId, String subject, String content, String note) {
        this.emailId = emailId;
        this.subject = subject;
        this.content = content;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "EmailContent{" + "id=" + id + ", subject=" + subject + ", content=" + content + ", note=" + note + '}';
    }

}

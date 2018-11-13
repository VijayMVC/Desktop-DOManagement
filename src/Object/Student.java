//
package Object;

import java.sql.Date;

public class Student {
    private int id;
    private int roomId;
    private String rollNumber;
    private String fullName;
    private String email;
    private String mobile;
    private String address;
    private boolean gender;
    private Date startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }   

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", roomId=" + roomId + ", rollNumber=" + rollNumber + ", fullName=" + fullName + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", gender=" + gender + ", startDate=" + startDate + '}';
    } 

}

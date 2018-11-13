/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Model.StudentModel;
import Object.StudentJoinRoom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class StudentController {
    
    public void displayListStudents(JTable table, List<StudentJoinRoom> list){
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int stt = 0;
        for (StudentJoinRoom sjr : list) {
            stt++;
            String date = sjr.getStartDate().toString();
            String[] temp = date.split("-");
            date = temp[2] + "/" + temp[1] + "/" + temp[0];
            
            Object[] rowData = {" " + stt, " " + sjr.getRoomNumber(), " " + date + " " + new StudentModel().getSemester(date), " " + sjr.getFullName(),
                                " " + sjr.getEmail(), " " + sjr.getRollNumber(), " " + sjr.getMobile(), sjr.isGender() == true ? " Male" : " Female"};
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
    
    public ArrayList<StudentJoinRoom> listSeachStudent(int type, String text, List<StudentJoinRoom> list){
        ArrayList<StudentJoinRoom> listSearchStudents = new ArrayList();
        
        listSearchStudents.clear();
        for(StudentJoinRoom sjr : list){
            if(sjr.getFullName().toLowerCase().contains(text.toLowerCase()) && type == 0){
                listSearchStudents.add(sjr);
            }
            if(sjr.getRoomNumber().toLowerCase().contains(text.toLowerCase()) && type == 1){
                listSearchStudents.add(sjr);
            }
            if(sjr.getRollNumber().toLowerCase().contains(text.toLowerCase()) && type == 2){
                listSearchStudents.add(sjr);
            }
            if(sjr.getMobile().toLowerCase().contains(text.toLowerCase()) && type == 3){
                listSearchStudents.add(sjr);
            }
        } 
        return listSearchStudents;
    }
}

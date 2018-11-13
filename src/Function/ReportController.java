/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Model.RoomModel;
import Model.StudentModel;
import Object.Room;
import Object.Student;
import Object.TransferRoom;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class ReportController {
    RoomModel rm = new RoomModel();
    StudentModel sm = new StudentModel();
    
    public void displayListReport(JTable table, List<TransferRoom> list){
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int stt = 0;
        for (TransferRoom tr : list) {
            Student s = sm.getStudentsById(tr.getStudentId());
            Room r1 = rm.getRoomById(tr.getRoomId());
            Room r2 = rm.getRoomById(s.getRoomId());
            stt++;
            String roomTo = "none";
            if(tr.isStatus() == false){
                roomTo = r1.getRoomNumber();
            }
            
            Object[] rowData = {" " + stt, " " + tr.getId(), " " + s.getFullName(), " " + s.getEmail(), " " + s.getMobile(),
                " Room transfer", " " + r2.getRoomNumber(), " " + roomTo, tr.isStatus()==false ? " Pending" : " Approved"};
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
}

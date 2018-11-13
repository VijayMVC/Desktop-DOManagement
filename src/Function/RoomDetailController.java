/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.Student;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class RoomDetailController {
    public void displayListMember(JTable table, List<Student> list){
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int stt = 0;
        for (Student student : list) {
            stt++;
            Object[] rowData = {" " + stt, " " + student.getFullName(), " " + student.getRollNumber(),
                " " + student.getEmail(), " " + student.getMobile(), " " + student.getAddress()};
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.EmailInfo;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class EmailInfoController {
    public void displayListEmail(JTable table, List<EmailInfo> list){
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int stt = 0;
        for (EmailInfo ei : list) {
            stt++;
            
            Object[] rowData = {" " + stt, " " + ei.getEmail(), " " + ei.getRule()};
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
}

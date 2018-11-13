/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.Account;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class AccountController {   
    
    public void displayListAccounts(JTable table, List<Account> list){
 
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        Object[] rowData = new Object[8];
        
        int stt = 0;
        for (Account acc : list) {
            stt++;
            rowData[0] = " " + stt;
            rowData[1] = " " + acc.getFullName();
            rowData[2] = " " + acc.getMobile();
            rowData[3] = " " + acc.getUsername();
            rowData[4] = " " + acc.getEmail();
            rowData[5] = " " + acc.getType();
            
            String date = acc.getCreated().toString();
            String[] temp = date.split("-");
            date = temp[2] + "/" + temp[1] + "/" + temp[0];
            rowData[6] = " " + date;
            
            switch (acc.getStatus()) {
                case 1:
                    rowData[7] = " Active";
                    break;
                case 2:
                    rowData[7] = " Pending";
                    break;
                default:
                    rowData[7] = " Deactivate";
                    break;
            }
                       
            //Object[] rowData = {" " + stt, " " + acc.getFullName(), " " + acc.getMobile(),
            //                    " " + acc.getUsername(), " " + acc.getEmail(), " " + acc.getType(),
            //                    acc.getStatus() == 1 ? " Active" : acc.getStatus() == 2 ? " Pending" : " Deactivate"};
            
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
    
    public ArrayList<Account> listSeachAccount(int type, String text, List<Account> list){
        ArrayList<Account> listSearchAccounts = new ArrayList();
        
        listSearchAccounts.clear();
        for(Account acc : list){
            if(acc.getFullName().toLowerCase().contains(text.toLowerCase()) && type == 0){
                listSearchAccounts.add(acc);
            }
            if(acc.getMobile().toLowerCase().contains(text.toLowerCase()) && type == 1){
                listSearchAccounts.add(acc);
            }
            if(acc.getUsername().toLowerCase().contains(text.toLowerCase()) && type == 2){
                listSearchAccounts.add(acc);
            }
        }
        return listSearchAccounts;
    }
}

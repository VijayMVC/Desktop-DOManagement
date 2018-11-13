/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.Room;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SunCho
 */
public class RoomController {
    public void displayListRoom(JTable table, List<Room> list){
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int stt = 0;
        for (Room room : list) {
            stt++;
            int totalElectricity = room.getElectricityNumberThisSemester() - room.getElectricityNumberLastSemester();
            int totalWater = room.getWaterNumberThisSemester() - room.getWaterNumberLastSemester();
            Object[] rowData = {" " + stt, " " + room.getId(), " " + room.getRoomNumber(), " " + room.getNumberStudent(),
                " " + room.getFreeSlot(), " " + totalElectricity, " " + totalWater, room.getType() == 0 ? " Female" : " Male",
                room.getStatus() == 1 ? " Active" : room.getStatus() == 2 ? " Maintenance" : " Deactivate", room.isPaystatus() == true ? " Done" : " Not yet"};
            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }       
    }
    
    public ArrayList<Room> listSeachRoom(int st, List<Room> list){
        ArrayList<Room> listSearchRoom = new ArrayList();
        for (Room room : list) {
            if(room.getStatus() == st){
                listSearchRoom.add(room);
            }
        }       
        return listSearchRoom;
    }
}

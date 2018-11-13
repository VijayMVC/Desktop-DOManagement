/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Object.Room;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author AnhDT
 */
public class ExportToExcel {
    private static int no = 0;
    
    public static void ExportToExcelListRoom(List<Room> list, String url) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Room");// creating a blank sheet
            initCreate(sheet.createRow(0));
            int rownum = 1;
            for (Room r : list) {
                Row row = sheet.createRow(rownum++);
                createList(r, row);
            }
            FileOutputStream out = new FileOutputStream(new File(url+".xlsx")); // file name with path
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void initCreate(Row row){
        Cell cell = row.createCell(0);
        cell.setCellValue("No");

        cell = row.createCell(1);
        cell.setCellValue("Room");
        
        cell = row.createCell(2);
        cell.setCellValue("Total students");
        
        cell = row.createCell(3);
        cell.setCellValue("Free slot");
        
        cell = row.createCell(4);
        cell.setCellValue("Number of Electricity");
        
        cell = row.createCell(5);
        cell.setCellValue("Number of Water");
        
        cell = row.createCell(6);
        cell.setCellValue("Room status");
        
        cell = row.createCell(7);
        cell.setCellValue("Payment status");
    }

    private static void createList(Room r, Row row) // creating cells for each row
    {
        no++;
        int totalElectricity = r.getElectricityNumberThisSemester() - r.getElectricityNumberLastSemester();
        int totalWater = r.getWaterNumberThisSemester() - r.getWaterNumberLastSemester();
        
        Cell cell = row.createCell(0);
        cell.setCellValue(no);

        cell = row.createCell(1);
        cell.setCellValue(r.getRoomNumber());
        
        cell = row.createCell(2);
        cell.setCellValue(r.getNumberStudent());
        
        cell = row.createCell(3);
        cell.setCellValue(r.getFreeSlot());
        
        cell = row.createCell(4);
        cell.setCellValue(totalElectricity);
        
        cell = row.createCell(5);
        cell.setCellValue(totalWater);
        
        cell = row.createCell(6);
        cell.setCellValue(r.getStatus() == 1 ? "Active" : r.getStatus() == 2 ? "Maintenance" : "Deactivate");
        
        cell = row.createCell(7);
        cell.setCellValue(r.isPaystatus() == true ? "Done" : "Not yet");
    }
}


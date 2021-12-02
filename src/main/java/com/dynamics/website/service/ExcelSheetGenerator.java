package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
public class ExcelSheetGenerator
{

    public void generateCodingEventSheet(List<CodingUser> users) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("CODEARENA2021");

        XSSFRow row;
        int a=2;

        Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();

        sheetData.put("1", new Object[]{"Id", "Name", "College", "USN", "Year", "Branch", "Email", "Contact", "Hackerrank Id", "ImageDriveLink", "TimeStamp"});

        for(CodingUser user : users) {
            sheetData.put(Integer.toString(a), new Object[]{
                    user.getCoding_id(),
                    user.getFirstName()+" "+user.getLastName(),
                    user.getCollege(),
                    user.getUsn(),
                    user.getYear(),
                    user.getBranch(),
                    user.getEmail(),
                    user.getContact(),
                    user.getHack_id(),
                    user.getIdUrl(),
                    user.getDate()
            });
            a++;
        }

        Set<String> keyId = sheetData.keySet();

        int rowId = 0;

        for(String key : keyId) {
            row = sheet.createRow(rowId++);
            Object[] objects = sheetData.get(key);

            int cellId = 0;

            for(Object object : objects) {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(String.valueOf(object));
            }
        }

        FileOutputStream outputStream = new FileOutputStream(new File("F:\\REST_Frameworks\\DynamicsWebsiteOfficial\\src\\main\\resources\\sheets\\codearena.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }
}
package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.model.User;
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

        sheetData.put("1", new Object[]{"Id", "Name", "College", "USN", "Year", "Branch", "Email", "Contact", "Hackerrank Id", "Address", "City/State", "Pincode", "TimeStamp"});

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
                    user.getPresentAddress(),
                    user.getCityState(),
                    user.getPincode(),
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

    public void generateRecruitmentSheet(List<User> users) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("RECRUITMENTS_2022");

        XSSFRow row;
        int a=2;

        Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();

        sheetData.put("1", new Object[]{"Id", "Name", "USN", "Year", "Branch", "Email", "Contact", "Github ID", "LinkedIn ID", "File Url"});

        for(User user : users) {
            sheetData.put(Integer.toString(a), new Object[]{
                    user.getUser_id(),
                    user.getFirstName()+" "+user.getLastName(),
                    user.getUsn(),
                    user.getYear(),
                    user.getBranch(),
                    user.getEmail(),
                    user.getContact(),
                    user.getGithub(),
                    user.getLinkedin(),
                    user.getFileUrl()
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

        FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/sheets/recruitment_2022.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }
}

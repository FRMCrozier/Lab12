package com.example.lab_11;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.example.lab_11.ExcelSave.createSheetHeader;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования сохранения в xls
 */
class ExcelSaveTest { //NOPMD - suppressed AtLeastOneConstructor - this is testing class

    /**
     * timeout save excel prepare
     */
    @Test
    void saveToFile() throws IOException { //NOPMD - suppressed CommentDefaultAccessModifier
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Sheet1"); //NOPMD - suppressed LocalVariableCouldBeFinal - final sheet name
        DBClass.connectDB();
        DBClass.loadDT();
        List<Wow> list = DBClass.getData(); //NOPMD - suppressed LocalVariableCouldBeFinal - could be like that
        int rowNum = 0;
        HSSFRow hssfRow = hssfSheet.createRow(rowNum); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        hssfRow.createCell((short) 0).setCellValue("WowID"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 1).setCellValue("Movie"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 2).setCellValue("movieYear"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 3).setCellValue("ReleaseDate"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 4).setCellValue("Director"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 5).setCellValue("MovieCharacter"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 6).setCellValue("MovieDuration"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 7).setCellValue("TimestampM"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 8).setCellValue("FullLine"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 9).setCellValue("CurrentWow"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 10).setCellValue("TotalWow"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 11).setCellValue("Poster"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 12).setCellValue("Video"); //NOPMD - suppressed LawOfDemeter - needed in this case
        hssfRow.createCell((short) 13).setCellValue("Audio"); //NOPMD - suppressed LawOfDemeter - needed in this case
        for (Wow w : list) { //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
            createSheetHeader(hssfSheet, rowNum++, w);
        }
        try {
            hssfWorkbook.write(Files.newOutputStream(Paths.get("Wow.xls")) );
        }
        catch (IOException e) {
            System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
        }
        hssfWorkbook.close();
        DBClass.exit();

    }

    /**
     * timeout save excel
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(1000),
                this::saveToFile
        );
    }
}
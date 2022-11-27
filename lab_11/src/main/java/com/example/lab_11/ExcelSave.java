package com.example.lab_11;

import javafx.scene.control.Alert;
import lombok.experimental.UtilityClass;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Класс сохранения таблицы в формате эксель
 */
@UtilityClass
public class ExcelSave {
    /**
     * название страницы в экселе
     */
    private static final String SHEET_NAME = "Sheet1";


    /**
     * метод для заполнения HSSFSheet данными из List
     */
    static void createSheetHeader(HSSFSheet sheet, int rowNum, Wow wow) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final

        Row row = sheet.createRow(rowNum); //NOPMD - suppressed LocalVariableCouldBeFinal - could be like that
        row.createCell((short) 0).setCellValue(wow.getWowID()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 1).setCellValue(wow.getMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 2).setCellValue(wow.getYear()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 3).setCellValue(Date.valueOf(wow.getReleaseDate())); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 4).setCellValue(wow.getDirector()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 5).setCellValue(wow.getCharacter()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 5).setCellValue(Time.valueOf(wow.getMovieDuration())); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 7).setCellValue(Time.valueOf(wow.getTimestamp())); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 8).setCellValue(wow.getFullLine()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 9).setCellValue(wow.getCurrentWowInMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 10).setCellValue(wow.getTotalWowsInMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 11).setCellValue(wow.getPoster()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 12).setCellValue(wow.getVideo()); //NOPMD - suppressed LawOfDemeter - needed in this case
        row.createCell((short) 13).setCellValue(wow.getAudio()); //NOPMD - suppressed LawOfDemeter - needed in this case
    }


    /**
     * метод сохранения данных в файл
     */
    public static void saveToFile(String filename) throws IOException { //NOPMD - suppressed MethodArgumentCouldBeFinal - this value is customized
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
        HSSFSheet hssfSheet = hssfWorkbook.createSheet(SHEET_NAME); //NOPMD - suppressed LocalVariableCouldBeFinal - final sheet name
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
            hssfWorkbook.write(Files.newOutputStream(Paths.get(filename)) );
        }
        catch (IOException e) {
            MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
        }
        hssfWorkbook.close();
        DBClass.exit();
        MBox.messageBox(Alert.AlertType.INFORMATION, null, "TABLE SAVED TO EXCEL FILE");
    }
}
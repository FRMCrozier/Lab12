package com.example.lab_11;


import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Класс для вызова методов сохранения
 */
@UtilityClass
public class SaveClass {

    /**
     * сохранение в формате xlsx
     */
    public static void saveToExcel() throws IOException {
        ExcelSave.saveToFile("Wow.xls");
    }


    /**
     * сохранение в формате json
     */
    public static void saveToJson() throws IOException, SQLException {
        JsonSave.saveToFile("Wow.json");
    }

    /**
     * сохранение в формате txt
     */
    public static void saveToTxt() throws IOException, SQLException {
        TxtSave.saveToFile("Wow.txt");
    }


}
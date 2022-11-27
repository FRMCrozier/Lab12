package com.example.lab_11;

import com.alibaba.fastjson.JSON;
import javafx.scene.control.Alert;
import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс сохранения в формате джейсон
 */
@UtilityClass
public class JsonSave {

    /**
     * метод сохранения в файл JSON
     */
    public static void saveToFile(String filename) throws IOException { //NOPMD - suppressed MethodArgumentCouldBeFinal - this value is customized
        DBClass.connectDB();
        DBClass.loadDT();
        List<Wow> list = DBClass.getData(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        FileWriter outStream = new FileWriter(filename); //NOPMD - suppressed AvoidFileStream - the correct way to use
        BufferedWriter bw = new BufferedWriter(outStream); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
        try {
            bw.write(JSON.toJSONString(list));
        } catch (IOException e) {
            MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
        }
        bw.close();
        outStream.close();
        DBClass.exit();
        MBox.messageBox(Alert.AlertType.INFORMATION, null, "TABLE SAVED TO JSON FILE");

    }
}
package com.example.lab_11;

import javafx.scene.control.Alert;
import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс сохраненич в текстовом формате
 */
@UtilityClass
public class TxtSave {

    /**
     * метод сохранения в файл TXT
     */
    public static void saveToFile(String filename) throws IOException { //NOPMD - suppressed MethodArgumentCouldBeFinal - this value is customized
        DBClass.connectDB();
        DBClass.loadDT();
        List<Wow> list = DBClass.getData(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        FileWriter fileWriter = new FileWriter(filename); //NOPMD - suppressed AvoidFileStream - the correct way to use
        BufferedWriter bw = new BufferedWriter(fileWriter); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
        for (Wow w : list) { //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
            try {
                bw.write(String.valueOf(w.getWowID()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getMovie()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getYear()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getReleaseDate()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getDirector()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getCharacter()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getMovieDuration()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getTimestamp()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getFullLine()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getCurrentWowInMovie()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getTotalWowsInMovie()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getPoster()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getVideo()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(w.getAudio()));
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
            }
        }
        bw.close();
        fileWriter.close();
        DBClass.exit();
        MBox.messageBox(Alert.AlertType.INFORMATION, null, "TABLE SAVED TO TXT FILE");
    }

}
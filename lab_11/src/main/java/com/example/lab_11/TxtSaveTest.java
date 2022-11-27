package com.example.lab_11;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования сохранения в txt
 */
class TxtSaveTest { //NOPMD - suppressed AtLeastOneConstructor - this is testing class

    /**
     * timeout save txt prepare
     */
    @Test
    void saveToFile() throws IOException { //NOPMD - suppressed CommentDefaultAccessModifier
        DBClass.connectDB();
        DBClass.loadDT();
        List<Wow> list = DBClass.getData(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        FileWriter fileWriter = new FileWriter("Wow.txt"); //NOPMD - suppressed AvoidFileStream - the correct way to use
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
                System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
            }
        }
        bw.close();
        fileWriter.close();
        DBClass.exit();

    }

    /**
     * timeout save txt
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(1000),
                this::saveToFile
        );
    }
}
package com.example.lab_11;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования сохранения в джейсон
 */
class JsonSaveTest {  //NOPMD - suppressed AtLeastOneConstructor - this is testing class

    /**
     * timeout save json prepare
     */
    @Test
    void saveToFile() throws IOException { //NOPMD - suppressed CommentDefaultAccessModifier
        List<Wow> list = DBClass.getData(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        FileWriter outStream = new FileWriter("Wow.json"); //NOPMD - suppressed AvoidFileStream - the correct way to use
        BufferedWriter bw = new BufferedWriter(outStream); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
        try {
            bw.write(JSON.toJSONString(list));
        } catch (IOException e) {
            System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
        }
        bw.close();
        outStream.close();
        DBClass.exit();
    }

    /**
     * timeout save json
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(200),
                this::saveToFile
        );
    }

}
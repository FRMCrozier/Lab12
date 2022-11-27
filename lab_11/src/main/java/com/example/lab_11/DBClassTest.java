package com.example.lab_11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования для класса базы данных
 */
class DBClassTest { //NOPMD - suppressed AtLeastOneConstructor - not needed

    /**
     * переменная подключения
     */
    private static Connection con;

    /**
     * вспомагательный метод
     */
    Properties getProperties() { //NOPMD - suppressed CommentDefaultAccessModifier
        Properties properties = new Properties(); //NOPMD - suppressed LocalVariableCouldBeFinal - could be like that
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        return properties;
    }

    /**
     * timeout connect db prepare
     */
    @Test
    void connectDB() { //NOPMD - suppressed CommentDefaultAccessModifier
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage()); //NOPMD - suppressed AvoidDuplicateLiterals - this string is a message so it dublicates
        }

        try {
            String url = "jdbc:mysql://" + "localhost:3306/test"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
            con = getConnection(url, getProperties());
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
        }

    }

    /**
     * timeout connect db
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(1000),
                this::connectDB
        );
    }

    /**
     * Тестирование ошибок
     */
    @Test
    void shouldThrowException() { //NOPMD - suppressed JUnitTestContainsTooManyAsserts - needed here
        Throwable exception = assertThrows(IOException.class, () -> { //NOPMD - suppressed DataflowAnomalyAnalysis - not anomaly
            throw new IOException ("IOException");
        });
        assertEquals("IOException", exception.getMessage()); //NOPMD - suppressed LawOfDemeter - needed here
    }

    /**
     * timeout exit db prepare
     */
    @Test
    void exit() { //NOPMD - suppressed CommentDefaultAccessModifier
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
            }
        }
    }

    /**
     * timeout exit db
     */
    @Test
    public void whenAssertingTimeoutThenNotExceededToExit() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(100),
                this::exit
        );
    }

    @Test
    void getData() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setData() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void downloadDB() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void loadDT() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void find() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void clearTable() { //NOPMD - suppressed CommentDefaultAccessModifier
    }
}
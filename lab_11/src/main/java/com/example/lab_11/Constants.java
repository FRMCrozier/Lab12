package com.example.lab_11;

/**
 * Константы строки подключения
 */
public class Constants {
    /**
     * строка сервера
     */
    static final String SERVER = "localhost:3306"; //NOPMD - suppressed CommentDefaultAccessModifier - not needed
    /**
     * строка названия базы данны
     */
    static final String DATABASE = "test"; //NOPMD - suppressed CommentDefaultAccessModifier - not needed
    /**
     * строка ссылки подключения
     */
    static final String URL = "jdbc:mysql://" + SERVER + "/" + DATABASE; //NOPMD - suppressed CommentDefaultAccessModifier - not needed
}

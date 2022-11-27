package com.example.lab_11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Objects;

/**
 * Класс приложения
 */
public class WowApp extends Application { //NOPMD - suppressed AtLeastOneConstructor - not needed
    /**
     * Старт
     */
    @Override
    public void start(Stage stage) throws IOException { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final (standard method)
        FXMLLoader fxmlLoader = new FXMLLoader(WowApp.class.getResource("view.fxml")); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        Scene scene = new Scene(fxmlLoader.load(), 1165, 720); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        stage.setTitle("WOWS!");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("images/owen.bmp")).toExternalForm())); //NOPMD - suppressed LawOfDemeter - needed in this case
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Запуск
     */
    public static void main(String[] args) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final (standard method)
        launch();
    }
}
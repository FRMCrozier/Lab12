package com.example.lab_11;

import javafx.scene.control.Alert;
import lombok.experimental.UtilityClass;

/**
 * Вспомогательный класс
 * Для вывода сообщений
 */
@UtilityClass
public class MBox { //NOPMD - suppressed ShortClassName - okay name
    /**
     * метод вывода сообщений
     */
    public static void messageBox(Alert.AlertType type, String info, String message) { //NOPMD - suppressed MethodArgumentCouldBeFinal - these values are customized
        Alert alert = new Alert(type); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        alert.setTitle(alert.getAlertType().toString()); //NOPMD - suppressed LawOfDemeter - needed in this case
        alert.setHeaderText(info);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
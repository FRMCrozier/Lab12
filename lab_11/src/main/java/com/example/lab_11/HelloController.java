package com.example.lab_11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * контроллер
 */
public class HelloController implements Initializable { //NOPMD - suppressed AtLeastOneConstructor - not needed
    @FXML
    public TableView<Wow> tableWows; //NOPMD - suppressed BeanMembersShouldSerialize - normal
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    public TextField textFind; //NOPMD - suppressed BeanMembersShouldSerialize - normal
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, Integer> WowID; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> Movie; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, Integer> movieYear; //NOPMD - suppressed BeanMembersShouldSerialize - normal
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> ReleaseDate; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> Director; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> MovieCharacter; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> MovieDuration; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> TimestampM; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> FullLine; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, Integer> CurrentWow; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, Integer> TotalWow; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> Poster; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> Video; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML //NOPMD - suppressed DefaultPackage - package needed
    TableColumn<Wow, String> Audio; //NOPMD - suppressed FieldNamingConventions - could be
    @FXML
    private ChoiceBox<String> chooseFormat; //NOPMD - suppressed BeanMembersShouldSerialize - normal
    @FXML
    private ChoiceBox<String> chooseAction; //NOPMD - suppressed BeanMembersShouldSerialize - normal

    /**
     * Вспомогательный метод
     * для загрузки значений из БД в таблицу
     */
    public void loadNew() {
        WowID.setCellValueFactory(new PropertyValueFactory<>("WowID")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        Movie.setCellValueFactory(new PropertyValueFactory<>("Movie")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        movieYear.setCellValueFactory(new PropertyValueFactory<>("Year")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        ReleaseDate.setCellValueFactory(new PropertyValueFactory<>("ReleaseDate")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        Director.setCellValueFactory(new PropertyValueFactory<>("Director")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        MovieCharacter.setCellValueFactory(new PropertyValueFactory<>("Character")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        MovieDuration.setCellValueFactory(new PropertyValueFactory<>("MovieDuration")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        TimestampM.setCellValueFactory(new PropertyValueFactory<>("Timestamp")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        FullLine.setCellValueFactory(new PropertyValueFactory<>("FullLine")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        CurrentWow.setCellValueFactory(new PropertyValueFactory<>("currentWowInMovie")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        TotalWow.setCellValueFactory(new PropertyValueFactory<>("totalWowsInMovie")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        Poster.setCellValueFactory(new PropertyValueFactory<>("Poster")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        Video.setCellValueFactory(new PropertyValueFactory<>("Video")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        Audio.setCellValueFactory(new PropertyValueFactory<>("Audio")); //NOPMD - suppressed AvoidDuplicateLiterals - needed
    }


    /**
     * Очистка таблицы
     */
    public void clearTable() {
        DBClass.clearTable();
        tableWows.setItems(DBClass.getData());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //NOPMD - suppressed MethodArgumentCouldBeFinal - could not be final in this case
        chooseFormat.getItems().addAll(".xls", ".json", ".txt"); //NOPMD - suppressed LawOfDemeter - needed in this case
        chooseFormat.setOnAction(this::getFormat);
        chooseAction.getItems().addAll("Connect to DB", "Download Data", "Load Data", "Exit"); //NOPMD - suppressed LawOfDemeter - needed in this case
        chooseAction.setOnAction(this::getAction);
    }

    /**
     * Выбор действия с БД
     */
    public void getAction(ActionEvent event) { //NOPMD - suppressed LinguisticNaming - normal name

        String myact = chooseAction.getValue(); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        switch (myact) {
            case ("Connect to DB"): //NOPMD - suppressed UselessParentheses - needed in this case
                DBClass.connectDB();
                break;

            case ("Download Data"): //NOPMD - suppressed UselessParentheses - needed in this case
                try {
                    DBClass.downloadDB();
                } catch (IOException e) {
                    MBox.messageBox(Alert.AlertType.WARNING, null, "Error!"); //NOPMD - suppressed AvoidDuplicateLiterals - this message needed
                }
                break;

            case ("Load Data"): //NOPMD - suppressed UselessParentheses - needed in this case
                DBClass.loadDT();
                tableWows.setItems(DBClass.getData());
                loadNew();
                break;

            case ("Exit"): //NOPMD - suppressed UselessParentheses - needed in this case
                DBClass.exit();
                break;

            default:
                break;

        }
    }

    /**
     * Выбор формата файла,
     * в который сохранится таблица
     */
    public void getFormat(ActionEvent event) { //NOPMD - suppressed LinguisticNaming - normal name

        String myformat = chooseFormat.getValue(); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        switch (myformat) {
            case (".xls"): //NOPMD - suppressed UselessParentheses - needed in this case
                try {
                    SaveClass.saveToExcel();
                } catch (Exception e) { //NOPMD - suppressed AvoidCatchingGenericException - could be in this case
                    MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
                }
                break;

            case (".json"): //NOPMD - suppressed UselessParentheses - needed in this case
                try {
                    SaveClass.saveToJson();
                } catch (Exception e) { //NOPMD - suppressed AvoidCatchingGenericException - could be in this case
                    MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
                }
                break;

            case (".txt"): //NOPMD - suppressed UselessParentheses - needed in this case
                try {
                    SaveClass.saveToTxt();
                } catch (Exception e) { //NOPMD - suppressed AvoidCatchingGenericException - could be in this case
                    MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
                }
                break;

            default:
                break;
        }
    }

    /**
     * Поиск по значению
     */
    public void find() {
        String title = textFind.getText().trim(); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        DBClass.find(title);
        tableWows.setItems(DBClass.getData());
        loadNew();
    }
}
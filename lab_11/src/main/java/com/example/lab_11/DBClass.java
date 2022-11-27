package com.example.lab_11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

/**
 * Класс методов работы с базой данных
 */
@UtilityClass
public class DBClass {  //NOPMD - suppressed AtLeastOneConstructor - not needed

    /**
     * строка подключения
     */
    private static final String CONNECT = "localhost:3306/test";
    /**
     * переменная подключения
     */
    private static Connection con;
    /**
     * список полученных данных
     */
    private static ObservableList<Wow> data;

    /**
     * получение списка
     */
    public static ObservableList<Wow> getData() {
        return data;
    }

    /**
     * запись в список
     */
    public static void setData(ObservableList<Wow> dlist) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        data = dlist;
    }

    /**
     * Вспомогательный метод, хранящий настройки,
     * необходимые для подключения к бд
     */
    static Properties getProperties() { //NOPMD - suppressed CommentDefaultAccessModifier - not needed
        Properties properties = new Properties(); //NOPMD - suppressed LocalVariableCouldBeFinal - could be like that
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        return properties;
    }

    /**
     * Подключение к БД
     */
    public static void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage()); //NOPMD - suppressed AvoidDuplicateLiterals - this string is a message so it dublicates
        }

        try {
            String url = "jdbc:mysql://" + CONNECT; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
            con = getConnection(url, getProperties());
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
        }
    }

    /**
     * Загрузка апи в БД
     */
    public static void downloadDB() throws IOException {
        try {
            con = getConnection(Constants.URL, getProperties());
            Statement st = con.createStatement(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            ResultSet rs = st.executeQuery("use test;"); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            PreparedStatement st1 = con.prepareStatement("insert into wows( Movie, MovieYear, ReleaseDate, Director, MovieCharacter, MovieDuration, TimestampM, FullLine, CurrentWow, TotalWow, Poster, Video, Audio) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            for (Wow wow : Wows.download()) { //NOPMD - suppressed LocalVariableCouldBeFinal - could be like that
                st1.setString(1, wow.getMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setInt(2, wow.getYear()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setDate(3, Date.valueOf(wow.getReleaseDate())); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(4, wow.getDirector()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(5, wow.getCharacter()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setTime(6, Time.valueOf(wow.getMovieDuration())); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setTime(7, Time.valueOf(wow.getTimestamp())); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(8, wow.getFullLine()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setInt(9, wow.getCurrentWowInMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setInt(10, wow.getTotalWowsInMovie()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(11, wow.getPoster()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(12, wow.getVideo()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.setString(13, wow.getAudio()); //NOPMD - suppressed LawOfDemeter - needed in this case
                st1.executeUpdate(); //NOPMD - suppressed LawOfDemeter - needed in this case
            }
            st1.close(); //NOPMD - suppressed LawOfDemeter - close the resource
            rs.close(); //NOPMD - suppressed LawOfDemeter - close the resource
            st.close(); //NOPMD - suppressed LawOfDemeter - close the resource
            MBox.messageBox(Alert.AlertType.INFORMATION, null, "Wows are loaded to DB");

        } catch (SQLException e) {
            MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
        }
    }

    /**
     * Разрыв соединения
     */
    public static void exit() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
            }
        }
    }

    /**
     * Загрузка данных в таблицу
     */
    public static void loadDT() {
        try {
            con = getConnection(Constants.URL, DBClass.getProperties());
            Statement statement = con.createStatement(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            ResultSet resultSet; //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            resultSet = statement.executeQuery("select * from wows;"); //NOPMD - suppressed LawOfDemeter - needed in this case
            data = FXCollections.observableArrayList();
            while (resultSet.next()) { //NOPMD - suppressed LawOfDemeter - needed in this case
                data.add(new Wow(resultSet.getInt("WowID"), resultSet.getString("Movie"), resultSet.getInt("movieYear"), resultSet.getDate("ReleaseDate").toLocalDate(), resultSet.getString("Director"), resultSet.getString("MovieCharacter"), resultSet.getTime("MovieDuration").toLocalTime(), resultSet.getTime("TimestampM").toLocalTime(), resultSet.getString("FullLine"), //NOPMD - suppressed LawOfDemeter - needed in this case
                        resultSet.getInt("CurrentWow"), resultSet.getInt("TotalWow"), resultSet.getString("Poster"), resultSet.getString("Video"), resultSet.getString("Audio"))); //NOPMD - suppressed LawOfDemeter - needed in this case
            }
            setData(data);
            //tableWows.setItems(data);
            resultSet.close(); //NOPMD - suppressed LawOfDemeter - close resource
            statement.close(); //NOPMD - suppressed LawOfDemeter - close resource
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //NOPMD - suppressed SystemPrintln - for test
        }
    }

    /**
     * метод поиска
     **/
    public void find(String name) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final

        try {
            con = getConnection(Constants.URL, DBClass.getProperties());

            String query = "SELECT * FROM wows WHERE Movie like '%" + name + "%';"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
            Statement s = con.createStatement(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method //NOPMD - suppressed LocalVariableCouldBeFinal - not final
            ResultSet rs = s.executeQuery(query); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            data = FXCollections.observableArrayList();
            while (rs.next()) { //NOPMD - suppressed LawOfDemeter - needed in this case
                data.add(new Wow(rs.getInt("WowID"), rs.getString("Movie"), rs.getInt("movieYear"), rs.getDate("ReleaseDate").toLocalDate(), rs.getString("Director"), rs.getString("MovieCharacter"), rs.getTime("MovieDuration").toLocalTime(), rs.getTime("TimestampM").toLocalTime(), rs.getString("FullLine"), //NOPMD - suppressed LawOfDemeter - needed in this case
                        rs.getInt("CurrentWow"), rs.getInt("TotalWow"), rs.getString("Poster"), rs.getString("Video"), rs.getString("Audio"))); //NOPMD - suppressed LawOfDemeter - needed in this case
            }
            setData(data);
            rs.close(); //NOPMD - suppressed LawOfDemeter - close method
            s.close(); //NOPMD - suppressed LawOfDemeter - close method

        } catch (SQLException se) {
            MBox.messageBox(Alert.AlertType.WARNING, null, "Error! Disconnect!");
        }
    }

    /**
     * Очистка таблицы
     */
    public static void clearTable() {
        try {
            con = getConnection(Constants.URL, DBClass.getProperties());
            String query = "TRUNCATE TABLE wows;"; //NOPMD - suppressed LocalVariableCouldBeFinal - once used
            Statement stm = con.createStatement(); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            stm.execute(query); //NOPMD - suppressed LawOfDemeter - needed in this case
            loadDT();
            stm.close(); //NOPMD - suppressed LawOfDemeter - close resource
            MBox.messageBox(Alert.AlertType.INFORMATION, null, "Table is clear!");

        } catch (SQLException e) {
            MBox.messageBox(Alert.AlertType.WARNING, null, "Error!");
        }
    }
}

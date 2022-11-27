package com.example.lab_11;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "movie",
        "year",
        "release_date",
        "director",
        "character",
        "movie_duration",
        "timestamp",
        "full_line",
        "current_wow_in_movie",
        "total_wows_in_movie",
        "poster",
        "video",
        "audio"
})

/**
 * Класс объекта апи
 */
public class Wow implements Serializable { //NOPMD - suppressed DataClass - dataclass
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *  final для значения разницы годов
     */
    private static final int YEAR_PAST = 52;

    /**
     *  название фильма
     */
    @JsonProperty("movie")
    private String movie;

    /**
     *  год выхода фильма
     */
    @JsonProperty("year")
    private Integer year;

    /**
     * дата релиза
     */

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    /**
    * режиссёр фильма
    */
    @JsonProperty("director")
    private String director;

    /**
    * персонаж фильма
    */
    @JsonProperty("character")
    private String movieCharacter; //NOPMD - suppressed BeanMembersShouldSerialize - normal

    /**
    * длительность фильма
    */
    @JsonProperty("movie_duration")
    private LocalTime movieDuration;

    /**
    * штамп времени
    */
    @JsonProperty("timestamp")
    private LocalTime timestamp;

    /**
    * полная строка цитаты
    */
    @JsonProperty("full_line")
    private String fullLine;

    /**
    * номер по счету
    */
    @JsonProperty("current_wow_in_movie")
    private Integer currentWowInMovie;

    /**
    * всего сказано
    */
    @JsonProperty("total_wows_in_movie")
    private Integer totalWowsInMovie;

    /**
    * ссылка на постер
    */
    @JsonProperty("poster")
    private String poster;

    /**
    * ссылки на видео
    */
    @JsonProperty("video")
    private String video;

    /**
    * ссылка на аудио
    */
    @JsonProperty("audio")
    private String audio;

    /**
    * номер в списке
    */
    private int WowID; //NOPMD - suppressed FieldNamingConventions - could be

    /**
     * Конструктор класса
     */
    public Wow() { //NOPMD - suppressed UncommentedEmptyConstructor - comment added
    }

    /**
     * Конструктор класса с параметрами
     */
    public Wow(int idWow, String movie, int year, LocalDate releaseDate, String director, String character, LocalTime duration, //NOPMD - suppressed ExcessiveParameterList - could be like that
               LocalTime timestamp, String fullLine, int current, int total, String poster, String video, String audio) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        WowID = idWow;
        this.movie = movie.strip();
        this.year = year > LocalDate.now().getYear() || year < 1970 ? LocalDate.now().getYear(): year;
        this.releaseDate = releaseDate.compareTo(LocalDate.now()) > 0 || LocalDate.now().compareTo(releaseDate) > YEAR_PAST ? LocalDate.now(): releaseDate;
        this.director = director.strip();
        this.movieCharacter = character.strip();
        this.movieDuration = duration;
        this.timestamp = timestamp;
        this.fullLine = fullLine.strip();
        this.currentWowInMovie = current <= 0 ? 1: current;
        this.totalWowsInMovie = total <= 0 || total < current && current > 0 ? current: total;
        this.poster = poster.strip();
        this.video = video.strip();
        this.audio = audio.strip();
    }

    public int getWowID() {
        return WowID;
    }

    @SuppressWarnings("unused") //NOPMD - suppressed AvoidDuplicateLiterals - this one unused methods error
    public void setWowID(int wowID) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        WowID = wowID;
    }

    public String getMovie() {
        return movie;
    }

    @SuppressWarnings("unused")
    public void setMovie(String movie) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.movie = movie.strip();
    }

    public Integer getYear() {
        return year;
    }

    @SuppressWarnings("unused")
    public void setYear(Integer year) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.year = year > LocalDate.now().getYear() || year < 1970 ? LocalDate.now().getYear(): year; //NOPMD - suppressed LawOfDemeter - could be like that
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @SuppressWarnings("unused")
    public void setReleaseDate(String releaseDate) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final

        LocalDate releaseDateD = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        this.releaseDate = LocalDate.now().compareTo(releaseDateD) < 0 || LocalDate.now().compareTo(releaseDateD) > YEAR_PAST ? LocalDate.now(): releaseDateD;  //NOPMD - suppressed LawOfDemeter - could be like that

    }

    public String getDirector() {
        return director;
    }

    @SuppressWarnings("unused")
    public void setDirector(String director) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.director = director.strip();
    }

    /**
     * получение персонажа
     */
    public String getCharacter() {
        return movieCharacter;
    }

    /**
     * установление персонажа
     */
    @SuppressWarnings("unused")
    public void setCharacter(String character) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.movieCharacter = character.strip();
    }

    public LocalTime getMovieDuration() {
        return movieDuration;
    }

    @SuppressWarnings("unused")
    public void setMovieDuration(String movieDuration) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final

        this.movieDuration = LocalTime.parse(movieDuration, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    @SuppressWarnings("unused")
    public void setTimestamp(String timestamp) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final

        this.timestamp = LocalTime.parse(timestamp, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getFullLine() {
        return fullLine;
    }

    @SuppressWarnings("unused")
    public void setFullLine(String fullLine) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.fullLine = fullLine.strip();
    }

    public Integer getCurrentWowInMovie() {
        return currentWowInMovie;
    }

    @SuppressWarnings("unused")
    public void setCurrentWowInMovie(Integer currentWowInMovie) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.currentWowInMovie = currentWowInMovie <= 0 ? 1: currentWowInMovie;
    }

    public Integer getTotalWowsInMovie() {
        return totalWowsInMovie;
    }

    @SuppressWarnings("unused")
    public void setTotalWowsInMovie(Integer totalWowsInMovie) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.totalWowsInMovie = totalWowsInMovie <= 0  || totalWowsInMovie < this.getCurrentWowInMovie() ? this.getCurrentWowInMovie(): totalWowsInMovie;
    }

    public String getPoster() {
        return poster;
    }

    @SuppressWarnings("unused")
    public void setPoster(String poster) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.poster = poster.strip();
    }

    public String getVideo() {
        return video;
    }

    @SuppressWarnings("unused")
    public void setVideo(Video video) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        List<String> list = Stream.of(video).map(Video::toString).toList(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        String[] videoArray = list.toArray(new String[0]); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        this.video = Arrays.toString(videoArray).strip();  //NOPMD - suppressed LawOfDemeter - could be like that
    }

    public String getAudio() {
        return audio;
    }

    @SuppressWarnings("unused")
    public void setAudio(String audio) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.audio = audio.strip();
    }
}
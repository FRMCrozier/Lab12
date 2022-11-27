package com.example.lab_11;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "1080p",
        "720p",
        "480p",
        "360p"
})

/**
 * Класс для получения объекта видео
 */
public class Video { //NOPMD - suppressed DataClass - dataclass
    private String _1080p; //NOPMD - suppressed FieldNamingConventions - normal
    private String _720p; //NOPMD - suppressed FieldNamingConventions - normal
    private String _480p; //NOPMD - suppressed FieldNamingConventions - normal
    private String _360p; //NOPMD - suppressed FieldNamingConventions - normal

    /**
     * Конструктор
     */
    public Video() {} //NOPMD - suppressed UncommentedEmptyConstructor - comment added
    public String get1080p() {
        return _1080p;
    }

    public void set1080p(String v1080p) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this._1080p = v1080p;
    }


    public String get720p() {
        return _720p;
    }

    public void set720p(String v720p) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this._720p = v720p;
    }


    public String get480p() {
        return _480p;
    }

    public void set480p(String v480p) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this._480p = v480p;
    }


    public String get360p() {
        return _360p;
    }

    public void set360p(String v360p) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this._360p = v360p;
    }

    @Override
    public String toString() {
        return
                "1080p = '" + _1080p + "\n" +
                        "720p = '" + _720p + '\n' +
                        "480p = '" + _480p + '\n' +
                        "360p = '" + _360p;
    }
}

package com.example.lab_11;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс списка полученных объектов
 */
public class Wows implements Serializable { //NOPMD - suppressed ShortClassName - okay name

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Список объектов
     */
    private List<Wow> wowses; //NOPMD - suppressed BeanMembersShouldSerialize - normal

    /**
     * Ссылка загрузки
     */
    private static final String URL = "https://owen-wilson-wow-api.onrender.com/wows/random?results=10";

    /**
     * Конструктор класса
     */
    public Wows() {
        this.wowses = new ArrayList<>();
    }

    /**
     * Получение списка
     */
    public List<Wow> getWows() {
        return wowses;
    }
    /**
     * Выгрузка значений в список
     */
    public void setResults(List<Wow> wows) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        this.wowses = wows;
    }

    /**
     * Добавление объекта в список
     */
    @SuppressWarnings("unused")
    public void add(Wow currency) { //NOPMD - suppressed MethodArgumentCouldBeFinal - not final
        wowses.add(currency);
    }


    /**
     * Получение списка массивов обьектов
     */
    public static ArrayList<Wow> download() throws IOException { //NOPMD - suppressed LooseCoupling - needed arraylist here
        Wows wows = JGetter.loadByURL(URL); //NOPMD - suppressed LocalVariableCouldBeFinal - final URL
        List<Wow> wows1 = wows.getWows(); //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        return new ArrayList<>(wows1);
    }

}

package com.example.lab_11;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования методов класса Wow
 */
class WowTest { //NOPMD - suppressed AtLeastOneConstructor - not needed this is testing class

    /**
     * Тестовое создание объекта
     * и проверка на корректный ввод
     * при добавлении через конструктор
     */
    @Test
    public void createObject() //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public //NOPMD - suppressed JUnitTestContainsTooManyAsserts - needed
    {
        Wow wow = new Wow(1, " Hall Pass ", 2031, LocalDate.of(2031, Month.NOVEMBER, 19), "  Woody Allen", " Gil Pender ", LocalTime.of(1, 33,57),  LocalTime.of(0, 48, 24), "Wow. No wonder she wanted to lead.", 0, -1,"https://images.ctfassets.net/bs8ntwkklfua/2ZcfSCe2dlfoVzYMr4b9nK/d566e5ad044dee56645f3bffc7200d64/Midnight_in_Paris_Poster.jpg", //NOPMD - suppressed LocalVariableCouldBeFinal - not final
                """
                        [1080p = 'https://videos.ctfassets.net/bs8ntwkklfua/3KJZ435sr6Y5k00AnZdOJ2/2aadc7fbc687b38c3f1536a9efc16cdb/Cars_3_Wow_10_1080p.mp4
                        720p = 'https://videos.ctfassets.net/bs8ntwkklfua/5vQtn6ny9J79PNG16jsJMR/1b4804366cfb9206d70472ab9b7f37e6/Cars_3_Wow_10_720p.mp4
                        480p = 'https://videos.ctfassets.net/bs8ntwkklfua/6kIDoftFyBJOgvCBe5Jr5k/51be6dcd0a40aff052a4215258f6f2cb/Cars_3_Wow_10_480p.mp4
                        360p = 'https://videos.ctfassets.net/bs8ntwkklfua/923BnYGWVuiPpWeM7e6wv/db39600a6bd7c6a807e95d397d129dd4/Cars_3_Wow_10_360p.mp4]""", "https://assets.ctfassets.net/bs8ntwkklfua/4pMtMRK3uSK6KNodFS7p2v/7f688b6bc487958d59e7fae635d98df1/Midnight_in_Paris_Wow_2.mp3" );
        assertNotEquals(2, wow.getWowID());
        assertEquals("Hall Pass", wow.getMovie()); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        assertTrue(LocalDate.now().getYear() >= wow.getYear()); //NOPMD - suppressed LawOfDemeter - different methods
        assertEquals(0, LocalDate.now().compareTo(wow.getReleaseDate())); //NOPMD - suppressed LawOfDemeter - could be like that
        assertEquals("Woody Allen", wow.getDirector()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        assertEquals("Gil Pender", wow.getCharacter()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        assertTrue(wow.getCurrentWowInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        assertTrue(wow.getTotalWowsInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message

        Wow wow2 = new Wow(1, "Hall Pass", 1950, LocalDate.of(1054, Month.NOVEMBER, 19), "Woody Allen", "Gil Pender", LocalTime.of(1, 33,57),  LocalTime.of(0, 48, 24), "Wow. No wonder she wanted to lead.", 5, 1,"https://images.ctfassets.net/bs8ntwkklfua/2ZcfSCe2dlfoVzYMr4b9nK/d566e5ad044dee56645f3bffc7200d64/Midnight_in_Paris_Poster.jpg", //NOPMD - suppressed LocalVariableCouldBeFinal - not final
                """
                        [1080p = 'https://videos.ctfassets.net/bs8ntwkklfua/3KJZ435sr6Y5k00AnZdOJ2/2aadc7fbc687b38c3f1536a9efc16cdb/Cars_3_Wow_10_1080p.mp4
                        720p = 'https://videos.ctfassets.net/bs8ntwkklfua/5vQtn6ny9J79PNG16jsJMR/1b4804366cfb9206d70472ab9b7f37e6/Cars_3_Wow_10_720p.mp4
                        480p = 'https://videos.ctfassets.net/bs8ntwkklfua/6kIDoftFyBJOgvCBe5Jr5k/51be6dcd0a40aff052a4215258f6f2cb/Cars_3_Wow_10_480p.mp4
                        360p = 'https://videos.ctfassets.net/bs8ntwkklfua/923BnYGWVuiPpWeM7e6wv/db39600a6bd7c6a807e95d397d129dd4/Cars_3_Wow_10_360p.mp4]""", "https://assets.ctfassets.net/bs8ntwkklfua/4pMtMRK3uSK6KNodFS7p2v/7f688b6bc487958d59e7fae635d98df1/Midnight_in_Paris_Wow_2.mp3" );
        assertTrue(wow2.getYear()>= 1970); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        assertTrue(LocalDate.now().compareTo(wow2.getReleaseDate()) <= 52); //NOPMD - suppressed LawOfDemeter - could be like that //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        assertTrue(wow2.getCurrentWowInMovie() <= wow2.getTotalWowsInMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message

    }

    /**
     * createObject Timeout
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofSeconds(2),
                this::createObject
        );
    }

    @Test
    void getWowID() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setWowID() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getMovie() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода названия
     * при добавлении через сеттер
     */
    @Test
    void setMovie() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setMovie("Hall Pass");
        assertEquals("Hall Pass", wow.getMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie(" Hall Pass");
        assertEquals("Hall Pass", wow.getMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("Hall Pass ");
        assertEquals("Hall Pass", wow.getMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("  Hall Pass  ");
        assertEquals("Hall Pass", wow.getMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getYear() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода года
     * (не больше текущего)
     * при добавлении через сеттер
     */
    @Test
    void setYearinFuture() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setYear(2031);
        assertTrue(LocalDate.now().getYear() >= wow.getYear()); //NOPMD - suppressed LawOfDemeter - different methods
    }

    /**
     * Проверка павильности ввода года
     * (не ранее 1970)
     * при добавлении через сеттер
     */
    @Test
    void setYearinPast() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setYear(1960);
        assertTrue(wow.getYear()>= 1970); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getReleaseDate() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода даты релиза
     * (не познее текущей)
     * при добавлении через сеттер
     */
    @Test
    void setReleaseDateinFuture() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();   //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setReleaseDate("2031-11-19");
        assertEquals(0, LocalDate.now().compareTo(wow.getReleaseDate())); //NOPMD - suppressed LawOfDemeter - could be like that
    }

    /**
     * Проверка павильности ввода даты релиза
     * (не ранее 1970)
     * при добавлении через сеттер
     */
    @Test
    void setReleaseDateinPast() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setReleaseDate("1031-11-19");
        assertTrue(LocalDate.now().compareTo(wow.getReleaseDate()) <= 52); //NOPMD - suppressed LawOfDemeter - could be like that
    }

    @Test
    void getDirector() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода режиссёра
     * при добавлении через сеттер
     */
    @Test
    void setDirector() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setDirector("Brian Fee"); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        assertEquals("Brian Fee", wow.getDirector()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie(" Brian Fee");
        assertEquals("Brian Fee", wow.getDirector()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("Brian Fee ");
        assertEquals("Brian Fee", wow.getDirector()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("  Brian Fee  ");
        assertEquals("Brian Fee", wow.getDirector()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getCharacter() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода персонажа
     * при добавлении через сеттер
     */
    @Test
    void setCharacter() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setCharacter("Lighting McQueen"); //NOPMD - suppressed AvoidDuplicateLiterals - needed
        assertEquals("Lighting McQueen", wow.getCharacter()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie(" Lighting McQueen");
        assertEquals("Lighting McQueen", wow.getCharacter()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("Lighting McQueen ");
        assertEquals("Lighting McQueen", wow.getCharacter()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setMovie("  Lighting McQueen  ");
        assertEquals("Lighting McQueen", wow.getCharacter()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getMovieDuration() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setMovieDuration() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getTimestamp() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setTimestamp() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getFullLine() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setFullLine() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getCurrentWowInMovie() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода номера вов
     * (не 0 и не отрицательное)
     * при добавлении через сеттер
     */
    @Test
    void currentWowNotNullOrNegative() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setCurrentWowInMovie(0);
        assertTrue(wow.getCurrentWowInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setCurrentWowInMovie(-1);
        assertTrue(wow.getCurrentWowInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getTotalWowsInMovie() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * Проверка павильности ввода кол-ва вов
     * (не 0 и не отрицательное)
     * при добавлении через сеттер
     */
    @Test
    void totalWowsNotNullOrNegative() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setTotalWowsInMovie(0);
        assertTrue(wow.getTotalWowsInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
        wow.setTotalWowsInMovie(-1);
        assertTrue(wow.getTotalWowsInMovie() > 0); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    /**
     * Проверка павильности ввода кол-ва вов
     * (не больше текущего вов)
     * при добавлении через сеттер
     */
    @Test
    void totalWowsMoreThanCurrent() { //NOPMD - suppressed CommentDefaultAccessModifier
        Wow wow = new Wow();  //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        wow.setCurrentWowInMovie(7);
        wow.setTotalWowsInMovie(3);
        assertTrue(wow.getCurrentWowInMovie() <= wow.getTotalWowsInMovie()); //NOPMD - suppressed JUnitAssertionsShouldIncludeMessage - no message
    }

    @Test
    void getPoster() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setPoster() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getVideo() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setVideo() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void getAudio() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setAudio() { //NOPMD - suppressed CommentDefaultAccessModifier
    }
}
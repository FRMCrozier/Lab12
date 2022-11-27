package com.example.lab_11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Класс тестирования методов класса Wows
 */
class WowsTest { //NOPMD - suppressed AtLeastOneConstructor - not needed this is testing class

    @Test
    void getWows() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void setResults() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    @Test
    void add() { //NOPMD - suppressed CommentDefaultAccessModifier
    }

    /**
     * timeout downloads prepare
     */
    @Test
    void download() throws IOException { //NOPMD - suppressed UncommentedEmptyMethodBody
        Wows wows = JGetter.loadByURL( "https://owen-wilson-wow-api.onrender.com/wows/random?results=10"); //NOPMD - suppressed LocalVariableCouldBeFinal - only for test
        List<Wow> wows1 = wows.getWows(); //NOPMD - suppressed DataflowAnomalyAnalysis - only for test //NOPMD - suppressed LawOfDemeter - only for test
    }

    /**
     * timeout downloads
     */
    @Test
    public void whenAssertingTimeoutThenNotExceeded() { //NOPMD - suppressed JUnit5TestShouldBePackagePrivate - this method should be public
        assertTimeout(
                ofMillis(2000),
                this::download
        );
    }
}
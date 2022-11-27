package com.example.lab_11;

import org.junit.jupiter.api.Test;

/**
 * Класс тестирования методов контроллера
 */
class HelloControllerTest { //NOPMD - suppressed AtLeastOneConstructor - not needed


    /**
     * Тестирование метода поиска по названию
     */
    @Test
    void find() {  //NOPMD - suppressed CommentDefaultAccessModifier - commented
        String title1 = "Cars"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        String title2 = " Cars"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        String title3 = "Cars  "; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        String title4 = "cars"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        String title5 = "CARS"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        String title6 = "Car"; //NOPMD - suppressed LocalVariableCouldBeFinal - not final
        DBClass.find(title1);
        DBClass.find(title2);
        DBClass.find(title3);
        DBClass.find(title4);
        DBClass.find(title5);
        DBClass.find(title6);
    }
}
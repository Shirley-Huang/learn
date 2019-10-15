package com.dandan.other.reflect.impl;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dandan On 九月 02 2019
 */
@Getter
@Setter
@ToString
public class Book {

    private final static String TAG = "BookTag";
    private String name;
    private String author;

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    private String declaredMethod(int index){
        String string = null;
        switch (index){
            case 0:
                string = "i am declaredMethod 0!";
                break;
            case 1:
                string = "i am declaredMethod 1!";
                break;
            default:
                string = "i am declaredMethod 0!";
                break;
        }
        return string;
    }

}

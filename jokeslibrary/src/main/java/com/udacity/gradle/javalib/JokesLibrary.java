package com.udacity.gradle.javalib;

import java.util.ArrayList;

public class JokesLibrary {
    public String tellAJoke(){
        ArrayList<String> jokeList = new ArrayList<String>();
        jokeList.add("If you had 4 apples and 5 oranges in one hand and 6 apples and 7 oranges in the other, what would you have? Very large hands");
        jokeList.add("What has 6 wheels and flies? A garbage truck.");
        jokeList.add("Math is made of 50 percent formulas, 50 percent proofs and 50 percent imagination.");
        jokeList.add("How do you make 7 even? Take away the s!");
        jokeList.add("Why is a math book always unhappy? A: Because it always has lots of problems.");
        return jokeList.get((int)(Math.random()*jokeList.size()));
    }
}

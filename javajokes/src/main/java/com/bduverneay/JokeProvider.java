package com.bduverneay;

import java.util.Random;

public class JokeProvider {

    private static String[] jokeArray = {
        "Q: What do you call a Fish without an eye? A: A 'Fsh'!",
                "Q: Why does it take 1 million sperm to fertilize one egg? A: They won't stop to ask directions."
    };

    public String getJoke() {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((jokeArray.length));

        return jokeArray[randomNum];
    }
}

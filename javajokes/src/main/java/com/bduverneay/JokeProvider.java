package com.bduverneay;

import java.util.Random;

public class JokeProvider {

    public String getJoke() {
        // Get a random joke from the string array
        Random rand = new Random();
        int randomNum = rand.nextInt((jokeArray.length));
        return jokeArray[randomNum];
    }
    private static String[] jokeArray = {
            "A guy walks into a bar and asks for 1.014 root beers.\n\n" +
                    "The bartender says, \"I\'ll have to charge you extra, that's a root beer float\".\n\n" +
                    "So the guy says, \"In that case, better make it a double.\"",
            "There are 10 kinds of people in this world: Those who understand binary, those who don't",
            "An SEO expert walks into a bar, pub, public house, inn, restaurant, club.",
            "Why is it that women find C to be more attractive than Java?\n\n" +
                    "Because C doesn’t treat them like objects.",
            "In Canadian hexadecimal, why is 6 afraid of 7?\n\n" +
                    "Because 7 8 9 A?",
            "Why aren’t octal jokes funny?\n\n" +
                    "Because 7 10 11.",
            "Why do Java programmers wear glasses?\n\n" +
                    "Because they don’t C#!",
            "Why did the programmer quit his job?\n\n" +
                    "Because he didn’t get arrays.",
            "What do you call it when a programmer throws up at IHOP?\n\n" +
                    "A stack overflow.",
            "What do you get if you divide the circumference of a jack-o-lantern by its diameter?\n\n" +
                "Pumpkin Pi",
            "Why couldn't the angle get a loan? \n\n" +
                    "His parents wouldn't Cosine",
            "Why is beer never served at a math party?\n\n" +
                    "Because you can't drink and derive.",
            "Why didn't the number 4 get into the nightclub?\n\n" +
                    "Because he is 2 square",
            "Why did the obtuse angle go to the beach?\n\n" +
                    "Because it was over 90 degrees",
            "What do you call a man who spent all summer at the beach? \n\n" +
                    "A Tangent",
            "How do you know the moon is going broke?\n\n" +
                    "It's down to it's last quarter",
            "Why can't you trust atoms?\n\n" +
                    "They make up everything",
            "A neutron walks into a bar, and asks the bartender \"How much for a drink?\"\n\n" +
                    "For you, no charge",
            "What does a subatomic duck say?\n\n" +
                    "Quark",
            "What do you call an educated tube?\n\n"+
                    "A graduated cylinder",
            "What do you call a Divinely Shaped Wave?\n\n" +
                    "A Sine from God",
            "Do you know any good jokes about Sodium?\n\n" +
                    "Na",
            "Tell me a joke about Potassium.\n\n" +
                    "K",
    };
}

package com.bduverneay;

import java.util.Random;

public class JokeProvider {

    public Joke getJoke() {
        // Get a random joke from the string array
        Random rand = new Random();
        int randomNum = rand.nextInt((jokeArray.length));
        return jokeArray[randomNum];
    }
    private static Joke[] jokeArray =  {
        new Joke("A guy walks into a bar and asks for 1.014 root beers.\n\n" +
                "The bartender says, \"I\'ll have to charge you extra, that's a root beer float\"",
                "So the guy says, \"In that case, better make it a double.\""),
        new Joke("There are 10 kinds of people in this world." ,
                "Those who understand binary, those who don't"),
        new Joke("An SEO expert walks into a bar, pub, public house, inn, restaurant, club." ,
                ""),
        new Joke("Why is it that women find C to be more attractive than Java?" ,
                "Because C doesn’t treat them like objects."),
        new Joke("In Canadian hexadecimal, why is 6 afraid of 7?" ,
            "Because 7 8 9 A?"),
        new Joke("Why aren’t octal jokes funny?",
                "Because 7 10 11."),
        new Joke("Why do Java programmers wear glasses?",
                "Because they don’t C#!"),
        new Joke("Why did the programmer quit his job?",
                "Because he didn’t get arrays."),
        new Joke("What do you call it when a programmer throws up at IHOP?",
                "A stack overflow."),
        new Joke("What do you get if you divide the circumference of a jack-o-lantern by its diameter?",
                "Pumpkin Pi"),
        new Joke("Why couldn't the angle get a loan?",
                "His parents wouldn't Cosine"),
        new Joke("Why is beer never served at a math party?",
            "Because you can't drink and derive."),
        new Joke("Why didn't the number 4 get into the nightclub?",
                "Because he is 2 square"),
        new Joke("Why did the obtuse angle go to the beach?",
                "Because it was over 90 degrees"),
        new Joke("What do you call a man who spent all summer at the beach?",
                "A Tangent"),
        new Joke("How do you know the moon is going broke?",
                "It's down to it's last quarter"),
        new Joke("Why can't you trust atoms?",
                "They make up everything"),
        new Joke("A neutron walks into a bar, and asks the bartender \"How much for a drink?\"",
                "For you, no charge"),
        new Joke("What does a subatomic duck say?" ,
                "Quark"),
        new Joke("What do you call an educated tube?" ,
                "A graduated cylinder"),
        new Joke("What do you call a Divinely Shaped Wave?" ,
                "A Sine from God"),
        new Joke("Do you know any good jokes about Sodium?" ,
                "Na"),
        new Joke("Tell me a joke about Potassium." ,
                "K"),
    };
}

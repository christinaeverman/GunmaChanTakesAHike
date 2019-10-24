package asu.gunma.MiniGames.Controllers;

import java.util.ArrayList;
import java.util.Iterator;

import asu.gunma.DbContainers.VocabWord;
import asu.gunma.MiniGames.Models.WordScrambleGame;
import asu.gunma.MiniGames.Views.WordScrambleGameView;

public class WordScrambleGameController
{
    private WordScrambleGame model;
    private WordScrambleGameView view;

    public WordScrambleGameController(WordScrambleGame model, WordScrambleGameView view)
    {
        this.model = model;
        this.view = view;
    }

    public void increaseScore()
    {
        model.setScore(model.getScore()+ 1);
    }

    // scramble each word in the vocab list
    public void scramble()
    {
        // We only need the string containing the English spelling of each vocab word, not the VocabWord object
        ArrayList<VocabWord> scrambledVocabWordList = new ArrayList<VocabWord>(model.getActiveVocabList());
        ArrayList<String> scrambledList = new ArrayList<String>();

        // add English spelling of all words to ArrayList
        for (VocabWord itr : scrambledVocabWordList)
        {
            scrambledList.add(itr.getEngSpelling());
        }

        // iterate through vocab list
        for (int i = 0; i < scrambledList.size(); i++)
        {
            ArrayList<Character> charList = new ArrayList<Character>();

            // add all letters of a single word to the ArrayList
            for (char letter : scrambledList.get(i).toCharArray())
            {
                // check for space
                if (letter != ' ')
                {
                    // add letter to ArrayList of chars
                    charList.add(letter);
                }
            }

            StringBuilder scrambledWord = new StringBuilder();
            int index = 0;

            // add letters at random to the string to create a scrambled word
            while (charList.size() != 0)
            {
                int random = (int)(Math.random() * charList.size());

                // keep the space where it is if the vocab consists of more than 1 word
                if (scrambledList.get(i).charAt(index) == ' ')
                {
                    scrambledWord.append(' ');
                }
                else
                {
                    scrambledWord.append(charList.remove(random));
                }

                index++;
            }

            String scrambledWordString = scrambledWord.toString();
            scrambledList.set(i, scrambledWordString);
        }

        // set the model's scrambledList to the list of scrambled words
        model.setScrambledList(scrambledList);

        // prints the full list of scrambled words for debugging purposes
        /*
        for (String itr : model.getScrambledList())
        {
            System.out.println(itr);
        }
        */
    }
}

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

    // scramble each word in the vocab list
    public void scramble()
    {
        // change to ArrayList of Strings
        ArrayList<VocabWord> scrambledWordList = new ArrayList<VocabWord>(model.getActiveVocabList());

        // iterate through vocab list
        for (VocabWord itr : scrambledWordList)
        {
            ArrayList<Character> charList = new ArrayList<Character>();

            for (char letter : itr.getEngSpelling().toCharArray())
            {
                charList.add(letter);
            }

            StringBuilder scrambledWord = new StringBuilder(itr.getEngSpelling());

            while (charList.size() != 0)
            {
                int random = (int)Math.random() * charList.size();
                scrambledWord.append(charList.remove(random));
            }
        }

        model.setScrambledWordList(scrambledWordList);

        for (VocabWord itr : model.getScrambledWordList())
        {
            System.out.println(itr.toString());
        }
    }
}

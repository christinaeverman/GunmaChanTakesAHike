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

            for (char letter : scrambledList.get(i).toCharArray())
            {
                charList.add(letter);
            }

            StringBuilder scrambledWord = new StringBuilder();

            while (charList.size() != 0)
            {
                int random = (int)(Math.random() * charList.size());

                scrambledWord.append(charList.remove(random));
            }
            String scrambledWordString = scrambledWord.toString();
            System.out.println(scrambledWordString);
            scrambledList.set(i, scrambledWordString);
            //scrambledList.add(scrambledWord);
        }

        model.setScrambledList(scrambledList);

        for (String itr : model.getScrambledList())
        {
            //System.out.println(itr);
        }
    }
}

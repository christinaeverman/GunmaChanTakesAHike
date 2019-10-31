package asu.gunma.MiniGames.Models;

import java.util.ArrayList;
import java.util.List;

import asu.gunma.DbContainers.VocabWord;

public class WordScrambleGameModel
{
    private int score = 0;
    private String displayWord;
    private List<VocabWord> dbListWords;
    private ArrayList<VocabWord> activeVocabList; // list of words that may be included in the mini-game
    private ArrayList<String> scrambledList; // list of individual words in their scrambled form

    public WordScrambleGameModel (int score, ArrayList<VocabWord> activeVocabList)
    {
        if (score != 0)
            this.score = score;
        else
            score = 0;

        this.activeVocabList = activeVocabList;
        this.scramble();
    }

    // get methods
    public int getScore()
    {
        return score;
    }

    public ArrayList<VocabWord> getActiveVocabList()
    {
        return activeVocabList;
    }

    public ArrayList<String> getScrambledList()
    {
        return scrambledList;
    }

    public VocabWord getCurrentVocabWord(int index)
    {
        VocabWord currentWord = activeVocabList.get(index);
        return currentWord;
    }

    public String getCurrentScrambledWord(int index)
    {
        String currentScrambledWord = scrambledList.get(index);
        return currentScrambledWord;
    }

    // set methods
    public void setScore(int score)
    {
        this.score = score;
    }

    public void setActiveVocabList(ArrayList<VocabWord> activeVocabList)
    {
        this.activeVocabList = new ArrayList<VocabWord>(activeVocabList);
    }

    public void setScrambledList(ArrayList<String> scrambledList)
    {
        this.scrambledList = new ArrayList<String>(scrambledList);
    }

    // other methods
    public int increaseScore()
    {
        score += score;
        return score;
    }

    // scramble each word in the vocab list
    private void scramble()
    {
        // We only need the string containing the English spelling of each vocab word, not the VocabWord object
        ArrayList<VocabWord> scrambledVocabWordList = new ArrayList<VocabWord>(activeVocabList);
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
        this.scrambledList = scrambledList;

        // prints the full list of scrambled words for debugging purposes
        for (String itr : scrambledList)
        {
            System.out.println(itr);
        }

    }
}

package asu.gunma.MiniGames.Controllers;

import java.util.ArrayList;

import asu.gunma.DbContainers.VocabWord;
import asu.gunma.MiniGames.Models.WordScrambleGameModel;
import asu.gunma.MiniGames.Views.WordScrambleGameView;

public class WordScrambleGameController
{
    private WordScrambleGameModel model;
    private WordScrambleGameView view;

    public WordScrambleGameController(WordScrambleGameModel model)
    {
        this.model = model;
    }

    public int getScore()
    {
        return model.getScore();
    }

    public ArrayList<VocabWord> getActiveVocabList()
    {
        return model.getActiveVocabList();
    }

    public ArrayList<String> getScrambledList()
    {
        return model.getScrambledList();
    }

    public VocabWord getCurrentVocabWord(int index)
    {
        VocabWord currentWord = model.getActiveVocabList().get(index);
        return currentWord;
    }

    public String getCurrentScrambledWord(int index)
    {
        String currentScrambledWord = model.getScrambledList().get(index);
        return currentScrambledWord;
    }

    // set methods
    public void setScore(int score)
    {
        model.setScore(score);
    }

    public void setActiveVocabList(ArrayList<VocabWord> activeVocabList)
    {
        model.setActiveVocabList(activeVocabList);
    }

    public void setScrambledList(ArrayList<String> scrambledList)
    {
        model.setScrambledList(scrambledList);
    }

    // other methods
    public int increaseScore()
    {
        int increasedScore = model.increaseScore();
        return increasedScore;
    }
}

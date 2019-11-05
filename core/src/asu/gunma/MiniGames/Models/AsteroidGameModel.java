package asu.gunma.MiniGames.Models;

import java.util.ArrayList;

import asu.gunma.DbContainers.VocabWord;

public class AsteroidGameModel
{
    private int level; // current level that the player is on (levels 1 - 5)
    private int score = 0;
    private ArrayList<VocabWord> activeVocabList; // list of words that may be included in the mini-game

    public AsteroidGameModel(int level, int score, ArrayList<VocabWord> activeVocabList)
    {
        if (level >= 1 && level <= 5)
            this.level = level;
        else
            level = 1;

        if (score >= 0)
            this.score = score;
        else
            score = 0;

        if (activeVocabList != null)
            this.activeVocabList = activeVocabList;
        else
            activeVocabList = new ArrayList<VocabWord>();
    }

    // get methods
    public int getScore()
    {
        return score;
    }

    public int getLevel()
    {
        return level;
    }

    public ArrayList<VocabWord> getActiveVocabList()
    {
        return activeVocabList;
    }

    // set methods
    public void setScore(int score)
    {
        this.score = score;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setActiveVocabList(ArrayList<VocabWord> activeVocabList)
    {
        this.activeVocabList = activeVocabList;
    }
}

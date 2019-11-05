package asu.gunma.MiniGames.Models;

import java.util.ArrayList;

import asu.gunma.DbContainers.VocabWord;

public class AsteroidGameModel
{
    private int level; // current level that the player is on (levels 1 - 5)
    private int score = 0;
    private ArrayList<VocabWord> activeVocabList; // list of words that may be included in the mini-game
    private ArrayList<Asteroid> asteroidList;

    public AsteroidGameModel(int level, int score, ArrayList<VocabWord> activeVocabList, ArrayList<Asteroid> asteroidList)
    {
        setLevel(level);

        if (score >= 0)
            this.score = score;
        else
            this.score = 0;

        if (activeVocabList != null)
            this.activeVocabList = activeVocabList;
        else
            this.activeVocabList = new ArrayList<VocabWord>();

        // the number of asteroids sent towards the player is equal to the level number
        if (asteroidList.size() == level)
            this.asteroidList = asteroidList;
        else
            this.asteroidList = new ArrayList<Asteroid>();
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

    public ArrayList<Asteroid> getAsteroidList()
    {
        return asteroidList;
    }

    // set methods
    public void setScore(int score)
    {
        this.score = score;
    }

    public void setLevel(int level)
    {
        if (level >= 1 && level <= 5)
            this.level = level;
        else
            level = 1;
    }

    public void setActiveVocabList(ArrayList<VocabWord> activeVocabList)
    {
        this.activeVocabList = activeVocabList;
    }

    public void setAsteroidList(ArrayList<Asteroid> asteroidList)
    {
        this.asteroidList = asteroidList;
    }
}
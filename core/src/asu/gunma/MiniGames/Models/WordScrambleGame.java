package asu.gunma.MiniGames.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
import java.util.List;

import asu.gunma.DatabaseInterface.DbInterface;
import asu.gunma.DbContainers.VocabWord;
import asu.gunma.speech.ActionResolver;

public class WordScrambleGame implements Screen
{
    DbInterface dbCallback;
    private Game game;
    private Music gameMusic;
    public static float masterVolume = 5;
    public ActionResolver speechGDX;
    private Screen previousScreen;

    // Game logic variables
    private int score = 0;
    private String displayWord;
    private List<VocabWord> dbListWords;
    private ArrayList<VocabWord> activeVocabList; // list of words that may be included in the mini-game
    private ArrayList<String> scrambledList; // list of individual words in their scrambled form
    protected int numWords; // number of words to be included in the mini-game (maybe 10-20 words per mini-game?)

    private boolean isGameOver;

    public WordScrambleGame(Game game, ActionResolver speechGDX, Music music, DbInterface dbCallback, Screen previous, ArrayList<VocabWord> activeList, Preferences prefs)
    {
        this.game = game;
        this.speechGDX = speechGDX;
        this.gameMusic = music;
        this.dbCallback = dbCallback;
        this.previousScreen = previous;
        this.activeVocabList = activeList;
    }

    public int getScore()
    {
        return score;
    }

    public int numWords()
    {
        return numWords;
    }

    public ArrayList<VocabWord> getActiveVocabList()
    {
        return activeVocabList;
    }

    public ArrayList<String> getScrambledList()
    {
        return scrambledList;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setNumWords(int numWords)
    {
        this.numWords = numWords;
    }

    public void setScrambledList(ArrayList<String> scrambledList)
    {
        this.scrambledList = new ArrayList<String>(scrambledList);
    }

    @Override
    public void show()
    {
        // Insert word scramble mini-game UI here
    }

    @Override
    public void render(float delta)
    {

    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}

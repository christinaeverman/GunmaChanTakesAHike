package asu.gunma.MiniGames.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;
import java.util.List;

import asu.gunma.DatabaseInterface.DbInterface;
import asu.gunma.DbContainers.VocabWord;
import asu.gunma.speech.ActionResolver;

public class AsteroidGame implements Screen
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
    public ArrayList<VocabWord> activeVocabList; // list of words that may be included in the mini-game
    public String scrambledWord; // the scrambled version of the current word
    protected int numWords; // number of words to be included in the mini-game (maybe 10-20 words per mini-game?)

    private boolean isGameOver;

    public AsteroidGame(Game game, ActionResolver speechGDX, Music music, DbInterface dbCallback, Screen previous, ArrayList<VocabWord> activeList, Preferences prefs)
    {

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

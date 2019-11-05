package asu.gunma.MiniGames.Views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;

import asu.gunma.DatabaseInterface.DbInterface;
import asu.gunma.DbContainers.VocabWord;
import asu.gunma.speech.ActionResolver;

// Use this class for the front-end of the asteroid mini-game
// You'll want to use the AsteroidGameController class
public class AsteroidGameView implements Screen
{
    private Game game;
    private Music gameMusic;
    public static float masterVolume = 5;
    public ActionResolver speechGDX;
    private Screen previousScreen;

    public AsteroidGameView(Game game, ActionResolver speechGDX, Music music, Screen previous, Preferences prefs)
    {
        this.game = game;
        this.speechGDX = speechGDX;
        this.gameMusic = music;

        this.previousScreen = previous;
    }

    // Override Screen class methods
    @Override
    public void show()
    {

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

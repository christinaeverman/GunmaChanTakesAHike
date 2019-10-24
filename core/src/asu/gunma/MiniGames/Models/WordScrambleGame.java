package asu.gunma.MiniGames.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;

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
    protected int numWords; // number of words to be included in the mini-game (maybe not needed)

    boolean isPaused = false;

    // UI variables
    SpriteBatch batch;
    Stage stage;
    private GlyphLayout displayWordLayout;
    private BitmapFont font;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

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

    public void setScrambledList(ArrayList<String> scrambledList)
    {
        this.scrambledList = new ArrayList<String>(scrambledList);
    }

    // Override Screen class methods
    @Override
    public void show()
    {
        Gdx.gl.glClearColor(1, .8f, 1, 1);
        stage = new Stage();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        /*
        final String FONT_PATH = "irohamaru-mikami-Regular.ttf";
        generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        //font for vocab word
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.characters = displayWord;
        parameter.size = 70;
        parameter.color = Color.BLACK;
        font = new BitmapFont();
        font = generator.generateFont(parameter);
        */
    }

    @Override
    public void render(float delta)
    {
        batch.begin();
        //font.draw(batch, displayWordLayout, 300, 350);

        batch.end();
        stage.act(delta); // optional to pass delta value
        stage.draw();
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
        //font.dispose();
        batch.dispose();
        stage.dispose();
    }
}

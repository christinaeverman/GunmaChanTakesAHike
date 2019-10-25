package asu.gunma.MiniGames.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;
import java.util.List;

import asu.gunma.DatabaseInterface.DbInterface;
import asu.gunma.DbContainers.VocabWord;
import asu.gunma.speech.ActionResolver;
import asu.gunma.ui.screen.menu.MainMenuScreen;

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
    private Stage stage;

    private TextButton buttonTutorial;

    private SpriteBatch batch;
    private Texture texture;

    private BitmapFont font;
    private BitmapFont font2;

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter2;
    public Preferences prefs;

    private TextButton speakButton;

    private int listCounter = 0;
    private GlyphLayout displayWordLayout;
    private int targetWidth = 400;

    public WordScrambleGame(Game game, ActionResolver speechGDX, Music music, DbInterface dbCallback, Screen previous, ArrayList<VocabWord> activeList, Preferences prefs)
    {
        this.game = game;
        this.speechGDX = speechGDX;
        this.gameMusic = music;
        this.dbCallback = dbCallback;
        this.previousScreen = previous;
        this.activeVocabList = activeList;

        this.prefs = prefs;
        //font file
        final String FONT_PATH = "irohamaru-mikami-Regular.ttf";

        generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
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
        Gdx.gl.glClearColor(.8f, 1, 1, 1);
        stage = new Stage();

        batch = new SpriteBatch();
        //texture = new Texture("title_gunma.png");

        Gdx.input.setInputProcessor(stage);

        dbListWords = dbCallback.getDbVocab();
        displayWord = dbListWords.get(listCounter).getEngSpelling();
        parameter.characters = displayWord;
        parameter.size = 70;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
        parameter2.size = 30;
        parameter2.color = Color.BLACK;
        font2 = generator.generateFont(parameter2);

        displayWordLayout = new GlyphLayout();
        displayWordLayout.setText(font, displayWord, Color.BLACK, targetWidth, Align.center, true);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = font2;
        textButtonStyle.fontColor = Color.BLACK;

        buttonTutorial = new TextButton("Play", textButtonStyle);
        speakButton = new TextButton("Speak", textButtonStyle);
        speakButton.setPosition(100 , Gdx.graphics.getHeight() - 550);

        //speakButton.pad(20);

        speakButton.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                try
                {
                    speechGDX.listenOnce();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        });
        stage.addActor(speakButton);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        batch.begin();
        font.draw(batch, displayWordLayout, 300, 350);
        //batch.draw(texture, Gdx.graphics.getWidth()/2 - texture.getWidth()/4 + 400, Gdx.graphics.getHeight()/4 - texture.getHeight()/2 + 400, texture.getWidth()/2, texture.getHeight()/2);
        batch.end();
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
        //batch.dispose();
        //stage.dispose();
    }
}

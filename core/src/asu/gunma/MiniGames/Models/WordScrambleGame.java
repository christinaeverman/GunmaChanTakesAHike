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
    private Table table;

    private TextButton buttonTutorial;

    private SpriteBatch batch;
    private Texture texture;

    private BitmapFont font;
    private Label heading;

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter2;
    public Preferences prefs;

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

        //font for vocab word
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        //font for other words
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
        //Gdx.gl.glClearColor(1, .8f, 1, 1);
        //stage = new Stage();
        //batch = new SpriteBatch();
        //Gdx.input.setInputProcessor(stage);
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

        Gdx.gl.glClearColor(.8f, 1, 1, 1);
        stage = new Stage();

        batch = new SpriteBatch();
        texture = new Texture("title_gunma.png");

        Gdx.input.setInputProcessor(stage);

        // Defining the regions of sprite image we're going to create
        //atlas = new TextureAtlas("ui/button.pack"); // ???
        //skin = new Skin(atlas);

        table = new Table();
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        parameter.size = 30;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        //textButtonStyle.up = skin.getDrawable("button.up");
        //textButtonStyle.down = skin.getDrawable("button.down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = font;

        // IMPORTANT: needs localization support
        buttonTutorial = new TextButton("Play", textButtonStyle);

        Label.LabelStyle headingStyle = new Label.LabelStyle(font, Color.BLACK);
        //

        heading = new Label("Gunma-chan Takes a Hike", headingStyle);
        heading.setFontScale(2);
        //

        // Actually, should probably custom class this process
        buttonTutorial.pad(20);

            /*
                If you want to test functions with UI instead of with console,
                add it into one of these Listeners. Each of them correspond to
                one of the buttons on the screen in top-down order.
             */
        buttonTutorial.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Going from TitleScreen to MainMenuScreen");
                game.setScreen(new MainMenuScreen(game, speechGDX, gameMusic, dbCallback, activeVocabList, prefs));
            }
        });

        table.add(heading);
        table.row();
        table.add(buttonTutorial);
        table.row();

        // Remove this later
        //table.debug();

        stage.addActor(table);

    }

    @Override
    public void render(float delta)
    {
        //batch.begin();
        //font.draw(batch, displayWordLayout, 300, 350);

        //batch.end();
        //stage.act(delta); // optional to pass delta value
        //stage.draw();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta); // optional to pass delta value
        stage.draw();

        // SpriteBatch is resource intensive, try to use it for only brief moments
        batch.begin();
        batch.draw(texture, Gdx.graphics.getWidth()/2 - texture.getWidth()/4 + 400, Gdx.graphics.getHeight()/4 - texture.getHeight()/2 + 400, texture.getWidth()/2, texture.getHeight()/2);
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

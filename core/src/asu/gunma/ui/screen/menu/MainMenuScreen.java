package asu.gunma.ui.screen.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import asu.gunma.DatabaseInterface.DbInterface;
import asu.gunma.DbContainers.VocabWord;
import asu.gunma.speech.ActionResolver;
import asu.gunma.ui.screen.game.FlashcardScreen;
import asu.gunma.ui.screen.game.GameScreen;
import asu.gunma.ui.util.AssetManagement.GameAssets;
import asu.gunma.ui.util.AssetManagement.MyResources;

public class MainMenuScreen implements Screen {

    private Game game;
    public ActionResolver speechGDX;
    public DbInterface dbCallback;
    public Music gameMusic;
    public static float masterVolume = 5;
    public ArrayList<VocabWord> activeVList = new ArrayList<>();
    private GameAssets gameAssets;

    // Using these are unnecessary but will make our lives easier.
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;

    private int testInt = 0;

    /*
        We will need 5 different buttons for this menu:
          1. Video Tutorials
          2. Flashcards
          3. Game #1
          4. Game #2
          5. Game #3
        This is based on the Project Proposal, I'd like to change this
        before the final release.
     */
    private TextButton buttonTutorial, buttonFlashcard, buttonGameFirst, buttonOptionMenu;

    private SpriteBatch batch;
    private Texture texture;

    private BitmapFont font;
    private Label heading;

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter2;
    Preferences prefs;

    public MainMenuScreen(Game game, ActionResolver speechGDX, Music music, DbInterface dbCallback, ArrayList<VocabWord> activeList, Preferences prefs, GameAssets gameAssets) {
        this.game = game;
        this.prefs = prefs;
        this.speechGDX = speechGDX;
        this.gameMusic = music;
        this.dbCallback = dbCallback;
        this.activeVList = activeList;
        this.gameAssets = gameAssets;
    }

    @Override
    public void show() {
        //font file
        final String FONT_PATH = "rounded-mgenplus-1c-medium.ttf";

        font = gameAssets.getFont();

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

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        //textButtonStyle.up = skin.getDrawable("button.up");
        //textButtonStyle.down = skin.getDrawable("button.down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = font;

        // IMPORTANT: needs localization support
        buttonTutorial = new TextButton(gameAssets.getResourceBundle().getString("VideoTutorials"), textButtonStyle);
        buttonFlashcard = new TextButton(gameAssets.getResourceBundle().getString("Flashcards"), textButtonStyle);
        buttonGameFirst = new TextButton(gameAssets.getResourceBundle().getString("Game1"), textButtonStyle);
        buttonOptionMenu = new TextButton(gameAssets.getResourceBundle().getString("OptionsMenu"), textButtonStyle);


        Label.LabelStyle headingStyle = new Label.LabelStyle(font, Color.BLACK);
        //


        heading = new Label(gameAssets.getResourceBundle().getString("SelectType"), headingStyle);
        heading.setFontScale(2);
        //

        // Actually, should probably custom class this process
        buttonTutorial.pad(20);
        buttonFlashcard.pad(20);
        buttonGameFirst.pad(20);
        buttonOptionMenu.pad(20);


            /*
                If you want to test functions with UI instead of with console,
                add it into one of these Listeners. Each of them correspond to
                one of the buttons on the screen in top-down order.
             */
        buttonTutorial.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                testInt++;
                System.out.println(testInt);
            }
        });
        buttonFlashcard.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameMusic.pause();
                gameMusic.dispose();
                //play flashcard music
                //gameMusic = new Music
                game.setScreen(new FlashcardScreen(game, speechGDX, gameMusic, dbCallback, game.getScreen(), activeVList, prefs, gameAssets));
            }
        });
        buttonGameFirst.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameMusic.pause();
                gameMusic.dispose();
                //play GameFirst music
                // gameMusic = new Music
                game.setScreen(new GameScreen(game, speechGDX, gameMusic, dbCallback, game.getScreen(), activeVList, prefs,gameAssets));

            }
        });
        buttonOptionMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //testing sign in method when option menu is selected
                gameMusic.pause();
                gameMusic.dispose();
                //play OptionMenu music
                //gameMusic = new Music
                game.setScreen(new OptionMenu(game, speechGDX, gameMusic, dbCallback, game.getScreen(),  activeVList, prefs, gameAssets));
            }
        });


        table.add(heading);
        table.row();
        table.add(buttonTutorial);
        table.row();
        table.add(buttonFlashcard);
        table.row();
        table.add(buttonGameFirst);
        table.row();
        table.add(buttonOptionMenu);
        table.row();

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // SpriteBatch is resource intensive, try to use it for only brief moments
        batch.begin();
        batch.draw(texture, Gdx.graphics.getWidth()/2 - texture.getWidth()/4 + 400, Gdx.graphics.getHeight()/4 - texture.getHeight()/2 + 400, texture.getWidth()/2, texture.getHeight()/2);
        batch.end();

        stage.act(delta); // optional to pass delta value
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        gameMusic.pause();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        font.dispose();
        texture.dispose();
        batch.dispose();
        stage.dispose();
    }

}


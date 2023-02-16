package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Box2DTutorial;

public class PreferencesScreen implements Screen {
    private Box2DTutorial parent; // a field to store our orchestrator
    private Stage stage;
    // our new fields
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;
    public final static int PREFERENCES = 1;

    // our constructor with a Box2DTutorial argument


    public PreferencesScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;     // setting the argument to our field.
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

    }
    @Override
    public void show() {
        // Creating the buttons
        Skin skin = new Skin(Gdx.files.internal("skin/skin/glassy-ui.json"));
        TextButton newGame = new TextButton("New Game", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);
        titleLabel = new Label( "Preferences", skin );
        volumeMusicLabel = new Label( null, skin );
        volumeSoundLabel = new Label( null, skin );
        musicOnOffLabel = new Label( null, skin );
        soundOnOffLabel = new Label( null, skin );

        // TODO Auto-generated method stub
        // create stage and set it as input processor

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        table.add(titleLabel);
        table.row();
        table.add(volumeMusicLabel);
//        table.add(volumeMusicSlider);
        table.row();
        table.add(musicOnOffLabel);
//        table.add(musicCheckbox);
        table.row();
        table.add(volumeSoundLabel);
//        table.add(soundMusicSlider);
        table.row();
        table.add(soundOnOffLabel);
//        table.add(soundEffectsCheckbox);
        table.row();
//        table.add(backButton);
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }
}
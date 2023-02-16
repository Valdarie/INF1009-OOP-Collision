package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Box2DTutorial;

public class LoadingScreen implements Screen {
    private Stage stage;
    private Box2DTutorial parent; // a field to store our orchestrator

    // our constructor with a Box2DTutorial argument
    public LoadingScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;     // setting the argument to our field.

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        parent.changeScreen(Box2DTutorial.MENU);
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
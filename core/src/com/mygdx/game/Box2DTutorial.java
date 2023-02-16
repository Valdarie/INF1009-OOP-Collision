package com.mygdx.game;

import com.badlogic.gdx.Game;

public class Box2DTutorial extends Game {

    private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    public final static int MENU = 0;
    public final static int PREFERENCES = 1;
    public final static int APPLICATION = 2;
    public final static int ENDGAME = 3;

    private AppPreferences preferences;

    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this); // added (this)
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new MainScreen(this); //added (this)
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);  // added (this)
                this.setScreen(endScreen);
                break;
        }
    }
    @Override
    public void create () {
        // The word “this” is a special word in Java used to represent the current object.
        // As were in the Box2DTutorial class it will reference Box2DTutorial objects.
        loadingScreen = new LoadingScreen(this);
        menuScreen = new MenuScreen(this);
        setScreen(loadingScreen);
        setScreen(menuScreen);
    }

    @Override
    public void render(){
        super.render();
    }

}
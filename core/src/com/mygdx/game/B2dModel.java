package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.classitem.objectType;
import com.mygdx.game.classitem.createFloor;
import com.mygdx.game.classitem.createMovingObject;
import com.mygdx.game.classitem.createObject;

public class B2dModel {
    public World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private createFloor floor;
    private createObject target;
    private createMovingObject player;
    BodyFactory bodyFactory;
    public B2dModel(){
        world = new World(new Vector2(0,-5.0f), true);
       // Updates constructor to add contact listener
        world.setContactListener(new CollisionManager(this));
        //Using enum
        objectType.FLOORTYPE.typeOfObject(world);
        objectType.TARGETTYPE.typeOfObject(world);
        objectType.PLAYERTYPE.typeOfObject(world);
        // get our body factory singleton and store it in bodyFactory. Also make sures our bodyfactory is running
        BodyFactory bodyFactory = BodyFactory.getInstance(world);

        // add a new ball at position 4, 1
        bodyFactory.makeCirclePolyBody(0, 1, 5, BodyFactory.DEFAULT, BodyDef.BodyType.DynamicBody,false);
        // add a new stone at position -4,1
        bodyFactory.makeCirclePolyBody(-4, 1, 2, BodyFactory.DEFAULT, BodyDef.BodyType.KinematicBody,false);
    }

    // our game logic here
    public void logicStep(float delta){

        world.step(delta , 3, 3);
    }
}
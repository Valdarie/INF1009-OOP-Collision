package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class B2dModel {
    public World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private createFloor floor;
    private createObject target;
    private createMovingObject player;
    BodyFactory bodyFactory;
    public B2dModel(){
        world = new World(new Vector2(0,-10f), true);
        world.setContactListener(new B2dContactListener(this));
        floor = new createFloor(world);
        target = new createObject(world);
        player = new createMovingObject(world);
        // get our body factory singleton and store it in bodyFactory. Also make sures our bodyfactory is running
        BodyFactory bodyFactory = BodyFactory.getInstance(world);

        // add a new steel ball at position 4, 1
        bodyFactory.makeCirclePolyBody(0, 1, 5, BodyFactory.STEEL, BodyDef.BodyType.DynamicBody,false);

    }

    // our game logic here
    public void logicStep(float delta){

        world.step(delta , 3, 3);
    }
}
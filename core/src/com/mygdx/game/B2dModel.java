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
    private Body floor;
    private Body target;
    private Body player;
    BodyFactory bodyFactory;
    public B2dModel(){
        world = new World(new Vector2(0,-10f), true);
        world.setContactListener(new B2dContactListener(this));
        createFloor();
        createObject();
        createMovingObject();
        // get our body factory singleton and store it in bodyFactory. Also make sures our bodyfactory is running
        BodyFactory bodyFactory = BodyFactory.getInstance(world);

        // add a new steel ball at position 4, 1
        bodyFactory.makeCirclePolyBody(0, 1, 5, BodyFactory.STEEL, BodyDef.BodyType.DynamicBody,false);

    }

    private void createFloor() {

        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, -10);

        // add it to the world
        floor = world.createBody(bodyDef);
        floor.setUserData("FloorBody");


        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50, 1);

        // create the physical object in our body)
        // without this our body would just be data in the world
        floor.createFixture(shape, 0.0f);
        floor.setUserData("FloorFix");

        // we no longer use the shape object here so dispose of it.
        shape.dispose();
    }

    private void createObject(){

        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);


        // add it to the world
        target = world.createBody(bodyDef);
        target.setUserData("TargetBody");

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1.2f,1.2f);

        // set the properties of the object ( shape, weight, restitution(bouncyness)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        // create the physical object in our body)
        // without this our body would just be data in the world
        target.createFixture(shape, 0.0f);
        target.setUserData("TargetFix");

        // we no longer use the shape object here so dispose of it.
        shape.dispose();
    }

    private void createMovingObject(){

        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0,-12);


        // add it to the world
        player = world.createBody(bodyDef);
        player.setUserData("PlayerBody");

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1,1);

        // set the properties of the object ( shape, weight, restitution(bouncyness)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        // create the physical object in our body)
        // without this our body would just be data in the world
        player.createFixture(shape, 0.0f);
        player.setUserData("PlayerFix");

        // we no longer use the shape object here so dispose of it.
        shape.dispose();

        player.setLinearVelocity(0, 0.75f);
    }

    // our game logic here
    public void logicStep(float delta){

        world.step(delta , 3, 3);
    }
}
package com.mygdx.game.classitem;

import com.badlogic.gdx.physics.box2d.*;

public class createMovingObject {
    public static void createPlayerObject(World world)
    {
        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0,-12);


        // add it to the world
        Body player = world.createBody(bodyDef);
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

}


package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.*;

public class createObject {
    private Body target;

    public createObject(World world){
        {

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
    }
}

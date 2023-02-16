package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class createFloor{
    private Body floor;
    public createFloor(World world) {
        //create new body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, -10);

        floor = world.createBody(bodyDef);
        floor.setUserData("FloorBody");

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50, 1);

        floor.createFixture(shape,0.0f);
        floor.setUserData("FloorFix");

        shape.dispose();

    }
    public Body getBody(){
        return floor;
    }
}

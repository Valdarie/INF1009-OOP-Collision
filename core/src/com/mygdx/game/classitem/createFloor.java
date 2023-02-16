package com.mygdx.game.classitem;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class createFloor{

    public static void createBasicFloor(World world){
            //create new body definition
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(0, -10);

            Body floor = world.createBody(bodyDef);
            floor.setUserData("FloorBody");

            PolygonShape shape = new PolygonShape();
            shape.setAsBox(50, 1);

            floor.createFixture(shape,0.0f);
            floor.setUserData("FloorFix");

            shape.dispose();

        }

}

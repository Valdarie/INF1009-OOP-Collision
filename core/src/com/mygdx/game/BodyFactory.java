// Place to create all the bodies and their properties

// Creates new objects to be used (body)
package com.mygdx.game;

// Constructor that takes a Box2D world
import com.badlogic.gdx.physics.box2d.*;

public class BodyFactory {

    private World world;
    private static BodyFactory thisInstance;
    public static final int STEEL = 0;

    // Private because making a singleton class. AKA only 1 BodyFactory object
    // will ever be created as dont need more than 1. instead of creating new ones,
    // we will just use the one already created.
    private BodyFactory(World world) {
        this.world = world;
    }

    public static BodyFactory getInstance(World world) {
        if (thisInstance == null) {
            thisInstance = new BodyFactory(world);
        }
        return thisInstance;
    }

    static public FixtureDef makeFixture(int material, Shape shape) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        switch (material) {
            case 0:
                fixtureDef.density = 1f;
                fixtureDef.friction = 0.3f;
                fixtureDef.restitution = 0.1f;
                break;
            default:
                fixtureDef.density = 7f;
                fixtureDef.restitution = 0.3f;
        }
        return fixtureDef;
    }

    public Body makeCirclePolyBody(float posx, float posy, float radius, int material, BodyDef.BodyType bodyType){
        return makeCirclePolyBody( posx,  posy,  radius,  material,  bodyType,  false);
    }

    public Body makeCirclePolyBody(float posx, float posy, float radius, int material, BodyDef.BodyType bodyType, boolean fixedRotation){
        // create a definition
        BodyDef boxBodyDef = new BodyDef();
        //boxBodyDef.type = bodyType;
        boxBodyDef.position.x = posx;
        boxBodyDef.position.y = posy;
        boxBodyDef.fixedRotation = fixedRotation;

        //create the body to attach said definition
        Body boxBody = world.createBody(boxBodyDef);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(radius /2);
        boxBody.createFixture(makeFixture(material,circleShape));
        circleShape.dispose();
        return boxBody;
    }

    public Body makeBoxPolyBody(float posx, float posy, float width, float height,int material, BodyDef.BodyType bodyType){
        return makeBoxPolyBody(posx, posy, width, height, material, bodyType, false);
    }

    public Body makeBoxPolyBody(float posx, float posy, float width, float height, int material, BodyDef.BodyType bodyType, boolean fixedRotation){
        // create a definition
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = bodyType;
        boxBodyDef.position.x = posx;
        boxBodyDef.position.y = posy;
        boxBodyDef.fixedRotation = fixedRotation;

        //create the body to attach said definition
        Body boxBody = world.createBody(boxBodyDef);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width/2, height/2);
        boxBody.createFixture(makeFixture(material,poly));
        poly.dispose();

        return boxBody;
    }

}
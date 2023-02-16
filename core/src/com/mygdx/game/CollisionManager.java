package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CollisionManager implements ContactListener {

    private B2dModel parent;
    private BehaviourManager behaviourManager;

    public CollisionManager(B2dModel parent)
    {
        this.parent = parent;

    }

    public CollisionManager(BehaviourManager behaviourManager) {
        this.behaviourManager = behaviourManager;
    }

    @Override
    public void beginContact(Contact contact) {
        //BeginContact so we know when something starts colliding
//            System.out.println("Contact");
        // Get the fixtures involved in the collision
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        // Get the user data from both fixtures
        // Check to see if one of the fixtures belongs to a specific body type (e.g. PlayerFix)
        // Check if one of the fixtures belongs to a specific body type (e.g. the player)


//            System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
        if(fa.getBody().getUserData() != null && fb.getBody().getUserData() != null) {
            String userDataA = (String)fa.getBody().getUserData();
            String userDataB = (String)fb.getBody().getUserData();

            if (userDataA.equals("PlayerFix") && userDataB.equals("TargetFix")
                    || userDataA.equals("TargetFix") && userDataB.equals("PlayerFix")){
                // Create an instance of BehaviourManager class
                //behaviourManager.onPlayerCollision();
                System.out.println("Player collided with target");

            }


        }

        // Update world.setContactListener(new B2dContactListener(this)); to logic's constructor (b2dModel)
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

}

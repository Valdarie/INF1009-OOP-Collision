package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class CollisionManager implements ContactListener {

	// Instance code start *************************************
    private static CollisionManager instance;

    // Retrieve singleton from anywhere
    public static CollisionManager getInstance() {
        if (instance == null) 
            instance = new CollisionManager();        
        return instance;
    }
    // Instance code end *************************************
    
    private B2dModel parent;
    private BehaviourManager behaviourManager;

    
    public CollisionManager() {
    	//init behaviour manager
    	behaviourManager = BehaviourManager.getInstance();
    }
    
    public CollisionManager(B2dModel parent)
    {
        this.parent = parent;
    }

//    public CollisionManager(BehaviourManager behaviourManager) {
//        this.behaviourManager = behaviourManager;
//    }

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

            //behaviourManager.onPlayerCollision();
        System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
        if(fa.getBody().getType() == BodyDef.BodyType.StaticBody){
            this.shootUpInAir(fa, fb);
        } else if(fb.getBody().getType() == BodyDef.BodyType.StaticBody){
            this.shootUpInAir(fb, fa);
        }else{
            // neither a nor b are static so do nothing
        }

        if(fa.getBody().getUserData() != null && fb.getBody().getUserData() != null) {
            String userDataA = (String)fa.getBody().getUserData();
            String userDataB = (String)fb.getBody().getUserData();

            if (userDataA.equals("PlayerFix") && userDataB.equals("TargetFix")
                    || userDataA.equals("TargetFix") && userDataB.equals("PlayerFix")){
                // Create an instance of BehaviourManager OnPlayerCollision Method
                //behaviourManager.onPlayerCollision();
                System.out.println("Player collided with target");
                // Figure out what type of collision is happening:
                System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
            }



        }


        // Update world.setContactListener(new B2dContactListener(this)); to logic's constructor (b2dModel)
    }

    private void shootUpInAir(Fixture staticFixture, Fixture otherFixture) {
        System.out.println("Adding Force Shoot Up In Air");
        otherFixture.getBody().applyForceToCenter(new Vector2(-0,-200), true);
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

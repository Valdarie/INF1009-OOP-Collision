package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class BehaviourManager {
	
	// Instance code start *************************************
    private static BehaviourManager instance;

    // Retrieve singleton from anywhere
    public static BehaviourManager getInstance() {
        if (instance == null) 
            instance = new BehaviourManager();        
        return instance;
    }
    // Instance code end *************************************
    
    public BehaviourManager() {
    	//nothing for now
    }
    
    
    public void onPlayerCollision(){
        System.out.println("Player collided with target");
        /*
        private void shootUpInAir(Fixture staticFixture, Fixture otherFixture){
            System.out.println("Adding Force");

            //Check if body connected to fixturea (fa) is a Static Body)
            // If it is, we get body connected to fixtureb and apply the ApplyForceToCenter method to make it go up
            //Box2D will ignore bodies that havent move.
            if(fa.getBody().getType() == BodyDef.BodyType.StaticBody){
                System.out.println("Force Added");
                fb.getBody().applyForceToCenter(new Vector2(0,-10000), true);
            }

        }

         */
    }
}

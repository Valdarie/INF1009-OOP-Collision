package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

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

    }
}

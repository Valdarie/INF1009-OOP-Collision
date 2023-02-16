package com.mygdx.game.classitem;

import com.badlogic.gdx.physics.box2d.World;

public enum objectType {
    FLOORTYPE {
        @Override
        public void typeOfObject(World world) {
            createFloor.createBasicFloor(world);
        }
    },
    PLAYERTYPE{
        @Override
        public void typeOfObject(World world){
            createMovingObject.createPlayerObject(world);
        }
    },
    TARGETTYPE{
        @Override
        public void typeOfObject(World world){
            createObject.createTarget(world);
        }

    };
    public abstract void typeOfObject(World world);
}

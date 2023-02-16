package com.mygdx.game.classitem;

import com.badlogic.gdx.physics.box2d.World;

public enum objectType {
    FLOORTYPE {
        @Override
        public void typeOfObject(World world) {
            createFloor.createBasicFloor(world);
        }
        @Override
        public String getFixName(){
            return "FloorFix";
        }
    },
    PLAYERTYPE{
        @Override
        public void typeOfObject(World world){
            createMovingObject.createPlayerObject(world);
        }

        @Override
        public String getFixName(){
            return "PlayerFix";
        }
    },
    TARGETTYPE{
        @Override
        public void typeOfObject(World world){
            createObject.createTarget(world);
        }

        @Override
        public String getFixName(){
            return "TargetFix";
        }
    };
    public abstract void typeOfObject(World world);
    public abstract String getFixName();
}

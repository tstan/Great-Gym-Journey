import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUpIntro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUpIntro extends Street
{

    /**
     * Constructor for objects of class PowerUpIntro.
     * Need I explain how a world spawns?
     * ALL CODED BY SPENCER
     */
    public PowerUpIntro(boolean haungs)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        removeObject(runner);
        runner.spawned = false;
        super.haungs = haungs;
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            super.bkgMusic.stop();
            Greenfoot.delay(10);
            LevelOne one = new LevelOne(haungs, 0, 1);
            Greenfoot.setWorld(one);
        }
    }
}

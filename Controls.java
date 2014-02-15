import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends Street
{
    /**
     * Constructor for objects of class Controls;
     * These are pretty much all the same as Introdutions 1.
     * ALL CODED BY SPENcEr
     */
    public Controls(boolean haungs)
    {
        removeObject(runner);
        runner.spawned = false;
        super.haungs = haungs;
    }	

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            super.bkgMusic.stop();
            Greenfoot.delay(10);
            PowerUpIntro power = new PowerUpIntro(haungs);
            Greenfoot.setWorld(power);
        }
    }
}

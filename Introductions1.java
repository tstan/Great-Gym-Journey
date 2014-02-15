import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Introductions1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introductions1 extends Street
{
    /**
     * Constructor for objects of class Introductions1.
     * CODED BY SPENCER
     */
    public Introductions1(boolean haungs)
    {
        removeObject(runner);       //Since Introductions is a Street subclass, the runner must be removed.
        runner.spawned = false;     //Make sure the runner does not spawn any health bar.
        super.haungs = haungs;      //Carry over the boolean haungs
    }   

    /**
     * CODED BY SPENCER, THEO, FRANKLIN
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))        //If the player presses the spacebar, execute the following.
        {
            super.bkgMusic.stop();
            Greenfoot.delay(10);
            Controls control = new Controls(haungs);        //Go to the Controls Screen.
            Greenfoot.setWorld(control);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RockDust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockDust extends SmoothMover
{
    int scaleVar;
    GreenfootImage dust;
    int w;
    /**
     * CODED BY SPENCER
     */
    public RockDust()
    {
        dust = getImage();
        dust.setTransparency(175);
        scaleVar = 1;
        w = 0;
    }

    public void act() 
    {
        makeDust(20);
    }   

    /**
     * Makes a dusty tail for the rock:
     * This code should use bigger parameter for width/height to SHOW POWAAAAAAA:
     * Since the image is a square, one parameter should suffice.
     * CODED BY SPENCER
     */
    public void makeDust(int width)
    {
        w += 1;
        width -= w;
        if(width <= 2)
        {
            getWorld().removeObject(this);
        }
        else
        {
            dust.scale(width, width);
        }
    }
}

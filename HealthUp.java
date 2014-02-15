import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthUp extends PowerUps
{
    /**
     * CODED BY JACOB
     */
    public HealthUp()
    {
        GreenfootImage img = getImage();
        img.scale(16, 30);
        setImage(img);
    }

    public void act() 
    {
        super.scroll();
        super.act();
    }    
}

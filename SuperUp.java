import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperUp extends PowerUps
{
    /**
     * CODED BY FRANKLIN: Unfinished PowerUp
     */
    public SuperUp()
    {
        GreenfootImage img = getImage();
        img.scale(22, 22);
        setImage(img);
    }

    public void act() 
    {
        super.scroll();
        super.act();
    }    
}

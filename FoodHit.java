import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FoodHit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoodHit extends Actor
{
    GreenfootImage img;
    int w;
    int h;
    /**
     * CODED BY SPENCER
     */
    public FoodHit()
    {
        img = getImage();
        w = img.getWidth();
        h = img.getHeight();
    }

    /**
     * CODED BY SPENCER
     */
    public void act() 
    {
        if(w >= 2)
        {
            img.scale(w--,h--);
        }
        else
        {
            getWorld().removeObject(this);
        }
        setImage(img);
    }    

}

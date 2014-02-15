import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PizzaParlor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurgerShack extends Enemies
{
    int delay = 100;
    /**
     * CODED BY SPENCER
     */
    public BurgerShack(){
        GreenfootImage BS = getImage();
        BS.scale(90,90);
    }
    
    public void act()
    {
        shoot();
        delay++;
        super.act();
    }
    
    /**
     * CODED BY JARED
     */
    public void shoot(){
        if(delay>200){
            burgers();
            delay = 0;
        }
    }
    
    /**
     * CODED BY JARED
     */
    private void burgers(){
        Burger b = new Burger(getRotation());
        getWorld().addObject(b, getX(), getY());
    }
}

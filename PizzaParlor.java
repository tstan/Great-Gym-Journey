import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PizzaParlor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PizzaParlor extends Enemies
{
    int delay = 100;
    /**
     * CODED BY JARED
     */
    public PizzaParlor(){
        GreenfootImage PP = getImage();
        PP.scale(110,90);
    }

    public void act()
    {
        super.act();
        shoot();
        delay++;
    }

    public void shoot(){
        if(delay>200){
            pizzas();
            delay = 0;
        }
    }
    
    /**
     * CODED BY JARED
     */
    private void pizzas(){
        if(canRemove == true)
        {
            Pizza p = new Pizza(getRotation() );
            getWorld().addObject(p, getX(), getY());
        }
    }
}

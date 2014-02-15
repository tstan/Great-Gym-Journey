import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FriesCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceCreamCannon extends Enemies
{
    Street s;
    int half;
    int ypos;
    int xpos;
    int move = 1;
    boolean shotCream = false;
    boolean topScreen;
    boolean oriented;
    /**
     * ALL CODED BY SPENCER
     */
    public IceCreamCannon()
    {
        oriented = false;
        turn(90);
    }

    /**
     * Act - do whatever the FriesCannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ypos = getY();
        xpos = getX();
        inAndOut();
        if(shotCream != true)
        {
            spawnIceCream();
            shotCream = true;
        }
    }    

    /**
     * CODED BY SPENCEr
     */
    public void checkPos()
    {
        half = (getWorld().getHeight()/2);
        if(oriented != true)
        {
            if(ypos > half)
            {
                topScreen = false;
            }
            else if (ypos < half)
            {
                topScreen = true;
                turn(180);
            }
            oriented = true;
        }
    }

    /**
     * CODED BY SPENCER CHANG
     */
    public void inAndOut()
    {
        if(shotCream != true)
        {
            for(int i = 0; i < 15; i++){
                xpos += move;
                setLocation(xpos, ypos);
            }
        }
        else if (shotCream == true)
        {
            xpos -= move;
            setLocation(xpos, ypos);
        }
        if(xpos <= -30)
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * CODED BY SPENCEr
     */
    public void spawnIceCream()
    {
        s = (Street) getWorld();
        IceCream ice1 = new IceCream(0);
        IceCream ice2 = new IceCream(-1);
        IceCream ice3 = new IceCream(1);
        s.addObject(ice1, getX(), getY());
        s.addObject(ice2, getX(), getY());
        s.addObject(ice3, getX(), getY());
    }
}

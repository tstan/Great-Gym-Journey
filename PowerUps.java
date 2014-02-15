import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Actor
{
    Street s;
    int move = Greenfoot.getRandomNumber(3);
    /**
     * CODED BY JARED
     */
    public void act() 
    {
        s = (Street) getWorld();
    }        

    /**
     * CODED BY JARED
     */
    public void scroll(){
        //reference the street world
        Street street = (Street) getWorld();
        //get the x location of the runner
        int rx = street.XLocation();
        int scrollSpeed = street.scrollSpeed;
        //if the runner is in the right 1/3 of the screen...
        if(rx>getWorld().getWidth()-street.scrollLoc){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                int xpos = this.getX();

                if(xpos <= -10){
                    getWorld().removeObject(this);
                }
                else{
                    xpos = xpos - scrollSpeed;
                    if(street.fightboss != true){
                        setLocation(xpos, getY());
                    }
                }
            }
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Jared Speck
 * 
 */
public class Road extends Actor
{
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scroll();
    }    

    public void scroll(){ //Jared Speck
        //references street world
        Street street = (Street) getWorld();
        //gets x/y location of the runner
        int rx = street.XLocation();
        int ry = street.YLocation();
        int scrollSpeed = street.scrollSpeed;
        //if the runner is on the right 1/3 of the screen
        if(rx>getWorld().getWidth()-street.scrollLoc || street.cutscene == true){
            if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))|| street.cutscene == true){
                int xpos = getX();
                if(xpos <= -5){
                    getWorld().removeObject(this);
                }
                else{
                    xpos = xpos-scrollSpeed;
                    setLocation(xpos, getY());
                }
            }
        }
    }
}

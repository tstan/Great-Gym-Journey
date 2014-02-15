import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Jared Speck
 * 
 */
public class Food extends SmoothMover
{
    public boolean isAimed = false;
    Street street;
    public Food(){
        Street steet = (Street) getWorld();
    }

    public void act() 
    {
        //Fun Snapple Fact: Did you know mosquitos are attracted to people who just ate bananas?

        //Might be useful to know that in the future.....don't eat bananas at night.
    }    

    public void move(){
        //references street world
        Street street = (Street) getWorld();

        //gets x/y location of the runner
        int rx = street.XLocation();
        int ry = street.YLocation();
        int scrollSpeed = street.scrollSpeed;

        //if the runner is on the right 1/3 of the screen

        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && rx>getWorld().getWidth()-street.scrollLoc){
            scrollSpeed = street.scrollSpeed-1;
            move(3);
            if(street.fightboss != true){
                setLocation(getX() - scrollSpeed, getY());
            }
        }
        else{
            move(3);
        }
    }

    public void aim(){
        if(isAimed==false){
            street = (Street) getWorld();
            int rx = street.XLocation();
            int ry = street.YLocation();
            turnTowards(rx, ry);
            isAimed = true;
        }
    }
}
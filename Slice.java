import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Jared Speck
 * 
 */
public class Slice extends Food
{
    Street street;
    public Slice(){
        getImage().scale(20,20);
    }

    public void act() 
    {
        move();
    }    

    public void move(){
        street = (Street) getWorld();
        int rx = street.XLocation();
        int scrollSpeed = street.scrollSpeed;

        if(getX() <= 5 || getX() >= getWorld().getWidth()-5 || getY() <= 5 || getY() >= getWorld().getHeight() - 5){
            getWorld().removeObject(this);
        }
        else if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && rx>getWorld().getWidth()-street.scrollLoc){
            scrollSpeed = street.scrollSpeed-1;
            move(2);
            if(street.fightboss != true){
                setLocation(getX() - scrollSpeed, getY());
            }
        }
        else{
            move(2);
        }
    }
}

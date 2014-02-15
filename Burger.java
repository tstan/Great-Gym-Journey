import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Theodore Tan
 * 
 */
public class Burger extends Food
{
    public boolean isAimed = false;
    Street street;
    public Burger(int rotation) {
        // Scale Image
        GreenfootImage burger = getImage();
        burger.scale(25,25);
        setImage(burger);
    }

    public void act() 
    {
        super.aim();
        move(); //should set to player x, y
        if (!selfDestruct()){
        }
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
            move(2);
            if(street.fightboss != true){
                setLocation(getX() - scrollSpeed, getY());
            }
        }
        else{
            move(2);
        }
    }

    /**
     * Coded by Theo
     */
    private boolean selfDestruct() {
        int cX = getX();
        int cY = getY();

        if( cX <= 0 || cX >= getWorld().getWidth()) {
            getWorld().removeObject(this);
            return true;
        } else if( cY <= 0 || cY >= getWorld().getHeight()) {
            getWorld().removeObject(this);
            return true;
        } 

        return false;
    }
}


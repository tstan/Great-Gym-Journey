import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang
 * 
 */
public class Taco extends Food
{
    public Taco(int rotation){
        GreenfootImage taco = getImage();
        taco.scale(20,10);
        setImage(taco);
        setRotation(rotation);
    }

    public void act() 
    {
        super.aim();
        super.move();
        if(!selfDestruct()){
        }
    }    

    /**
     * Coded by: Theodore Tan
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

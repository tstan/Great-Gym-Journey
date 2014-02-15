import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang
 * Artwork by: Jacob Rickman
 * 
 */
public class EnemyHP extends HitPoints
{
    private String[] enemyHealth=
        {"Full Health.png", "Health -10.png", "Health -20.png", "Health -30.png"};
    GreenfootImage image7;
    public void act() 
    {
        scroll();
    }

    /**
     * Scroll the Enemies if the player is in the RIGHT 1/3 of the screen.
     */
    public void scroll(){
        Street street = (Street) getWorld();
        int rx = street.XLocation();
        int scrollSpeed = street.scrollSpeed;
        if(rx>getWorld().getWidth()-street.scrollLoc){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                int xpos = getX();
                if(xpos <= -10){
                    getWorld().removeObject(this);
                }
                else{
                    xpos = xpos-scrollSpeed;
                    setLocation(xpos, getY());
                }
            }
        }
    }

    /**
     * Will decrease health bar in respect to the portions set in method newWidth below,
     * The integer Portions displays how much the health bar will decrease
     * from each enemy/runner hit.
     */
    public void decHealth(int nHits)
    {
        if( nHits == 3)
        {
            getWorld().removeObject(this);
        }
        image7 = new GreenfootImage(enemyHealth[nHits]);
        setImage(image7);
    }
}

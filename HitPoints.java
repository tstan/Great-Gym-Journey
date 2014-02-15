import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang
 * Artwork by: Jacob Rickman
 * 
 */
public class HitPoints extends Actor
{
    public String[] healthBar =
        { "Full Health.png","Health -1.png","Health -2.png","Health -3.png","Health -4.png","Health -5.png","Health -6.png","Health -7.png",
            "Health -8.png","Health -9.png","Health -10.png","Health -11.png","Health -12.png","Health -13.png","Health -14.png","Health -15.png",
            "Health -16.png","Health -17.png","Health -18.png","Health -19.png","Health -20.png","Health -21.png","Health -22.png","Health -23.png",
            "Health -24.png","Health -25.png","Health -26.png","Health -27.png","Health -28.png","Health -29.png","Health -30.png"};
    private String[] runnerHealth = 
        { "Full Health.png","Health -3.png","Health -6.png","Health -9.png","Health -12.png","Health -15.png","Health -18.png",
            "Health -21.png","Health -24.png","Health -27.png","Health -29.png","Health -30.png"};
    GreenfootImage image1;
    GreenfootImage image7;
    private static int width;
    int newWidth;
    public int nHits;
    Street street;
    /**
     * Dimensions of health bar are 64x16, Goes for all health bars so far.
     */
    public HitPoints() 
    {
        street = (Street) getWorld();
        image1 = new GreenfootImage("Full Health.png");
        setImage(image1);
    }

    /**
     * Will decrease health bar in respect to the portions set in method newWidth below,
     * The integer Portions displays how much the health bar will decrease
     * from each enemy/runner hit.
     */
    public void decHealth(int nHits)
    {
        image7 = new GreenfootImage(runnerHealth[nHits]);
        setImage(image7);
    }
}
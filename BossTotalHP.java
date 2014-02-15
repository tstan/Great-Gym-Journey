import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Jacob Rickman
 * 
 */
public class BossTotalHP extends HitPoints
{
    int i;
    int a;
    /**
     * Act - do whatever the BossTotalHP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BossTotalHP()
    {       
        GreenfootImage img = getImage();
        img.scale(350, 50);
        setImage(img);
    }

    public void act() 
    {
        GreenfootImage img = getImage();
        img.scale(350, 50);
        setImage(img);
    }   

    public int getHeight()
    {
        GreenfootImage img = getImage();
        i = img.getHeight();
        return i;
    }

    public int getWidth()
    {
        GreenfootImage img = getImage();
        a = img.getWidth();
        return a;
    }

    /**
     * Will decrease health bar in respect to the portions set in method newWidth below,
     * The integer Portions displays how much the health bar will decrease
     * from each enemy/runner hit.
     * COded by: Spencer Chang
     */
    public void decHealth(int nHits)
    {
        image7 = new GreenfootImage(healthBar[nHits]);
        setImage(image7);
    }
}

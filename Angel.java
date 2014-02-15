import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Jacob Rickman
 * 
 * Angel animation on the gameover screen
 * 
 */
public class Angel extends Actor
{
    /**
     * Act - do whatever the Angel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int xpos;
    private int ypos;
    public Angel()
    {
        GreenfootImage img = getImage();
        img.scale(380,240);
        setImage(img);
    }
    
    public void act() 
    {
        xpos = getX();
        ypos = getY() - 1;
        setLocation(xpos, ypos);
        
    }    
}

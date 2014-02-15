import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Angel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FitAngel extends Actor
{
    private int xpos;
    private int ypos;
    private int i;
    GreenfootImage win1 = new GreenfootImage("Winscreen.png");
    GreenfootImage win2 = new GreenfootImage("Winscreen2.png");
    /**
     * CODED ALL BY JACOB.
     */
    public FitAngel()
    {
        GreenfootImage img = getImage();
        img.scale(320,360);
        setImage(img);
        setImage(win1);
    }

    public void act() 
    {
        i++;
        if( i >= 12)
        {
            i= 0;
            if( getImage() == win1)
            {
                win2.scale(160, 180);
                setImage(win2);
                setLocation(491, 251);
            }
            else if( getImage() == win2)
            {
                win1.scale(160, 180);
                setImage(win1);
                setLocation(491, 241);
            }
        }
    }    
}

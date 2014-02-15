import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang
 * 
 * Arrows that point to the bosses weaknesses
 * 
 */
public class Pointer extends Actor
{
    int trans;
    GreenfootImage img;
    public Pointer(){
        trans = 250;
        img = getImage();
        img.scale(40,50);
        img.setTransparency(trans);
    }

    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int xpos = getX();
        xpos += 1;
        setLocation(xpos, getY());
        if(trans >10){
            trans -= 1;
            img.setTransparency(trans);
        }
        else if(trans <= 10){
            getWorld().removeObject(this);
        }
    }    
}

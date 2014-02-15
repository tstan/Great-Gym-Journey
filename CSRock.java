import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CODED BY JOSEPH
 */
public class CSRock extends CutScene
{
    Street street;
    /**
     * Act - do whatever the CSRock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage CSR = getImage();
        CSR.scale(20,20);
        movement();
    }    

    public void movement() {
        if(getX() <= 700) {
            setLocation(getX() + 2, getY());
        }
    }
}

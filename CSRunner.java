import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CODED BY JOSEPH
 */
public class CSRunner extends CutScene
{
    int ypos;
    /**
     * Act - do whatever the CSRunner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ypos = getY();
        movement();
        action();
    } 

    public void movement() {
        if (ypos >= 250) {
            setLocation(getX(), ypos-2);
        }
    }

    public void action() {
        GreenfootImage walk1 = new GreenfootImage("Guy Walking 1.png");
        GreenfootImage walk2 = new GreenfootImage("Guy Walking 2.png");
        GreenfootImage walk3 = new GreenfootImage("Guy Walking 3.png");
        walk1.scale(33,39);
        walk2.scale(33,39);
        walk3.scale(33,39);
        if (ypos > 250) {
            if (ypos % 3 == 0) {
                setImage(walk1);
            }
            if (ypos % 7 == 1){
                setImage(walk2);
            }
            if (ypos % 10 == 2){
                setImage(walk3);
            }
        }
        else{
            setImage(walk1);
        }
    }

}

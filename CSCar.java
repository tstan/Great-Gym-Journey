import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CODED BY JOSEPH
 */
public class CSCar extends CutScene
{
    private GreenfootSound carCrash = new GreenfootSound("sounds/car-brake-crash-01.mp3");;
    public CSRunner csrunner;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }

    public boolean yPos() {
        if (getY() >= 480){
            return true;
        }
        else{
            return false;
        }
    }

    public void movement() {
        csrunner = new CSRunner();
        if (getX() <= 300) {
            setLocation(getX()+2, getY());
        }
        if (getX() >= 300 && getY() < 500) {
            carCrash.play();
            setLocation(getX()+1, getY() + 2);
            turn(7);
        }
    }
}

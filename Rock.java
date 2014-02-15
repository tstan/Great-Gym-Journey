import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends SmoothMover
{
    private GreenfootSound rockThrow;
    int hPoints;
    int nHits;
    int i;
    boolean inWorld;
    Street street;
    HitPoints health;
    int scale;
    /**
     * CODED BY SPENCER
     */
    public Rock(int rotation) {
        // Scale Image
        GreenfootImage rock = getImage();
        scale = 20;
        rock.scale(scale, scale);
        setImage(rock);
        setRotation(rotation);
    }

    /**
     * CODED BY SPENCER
     */
    private void collision() {
        Enemies e = (Enemies) getOneIntersectingObject(Enemies.class);
        if( e != null ) {
            Greenfoot.playSound("bHit.wav");
            Street s = (Street) getWorld();
            if(e.canHit() != true)
            {
                s.removeObject(this);
                return;
            }
            e.health();
            s.removeObject(this);
        }
    }

    /**
     * CODED BY SPENCER & JOSEPH
     */
    public void act() 
    {
        i += 1;
        move(3);
        if(startMinimize() == true){
            minimize();
        }
        else if( !selfDestruct()) {
            collision();
        }
    }    

    /**
     * CODED BY THEO
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
        if(i%5 ==0)
        {
            street = (Street) getWorld();
            RockDust rdust = new RockDust();
            street.spawnRockDust(rdust, getX(), getY());
        }
        return false;
    }

    /**
     * CODED BY JOSEPH
     */
    public void minimize() {
        GreenfootImage rock = getImage();
        if (getX() <= getWorld().getWidth() || getY()>=5) {
            if (scale >=2) {
                scale -= 1;
                rock.scale(scale, scale);
                this.setImage(rock);
                if (scale == 2){
                    getWorld().removeObject(this);
                }
            }
        }
    }

    /**
     * CODED BY JOSEPH
     */
    public boolean startMinimize(){
        if (getX() >= 0 && getX() <= getWorld().getWidth() && getX() % 50 == 0){
            return true;
        }
        else {
            return false;
        }
    }

}

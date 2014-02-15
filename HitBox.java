import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitBox extends Enemies
{   
    boolean justHit;
    int timer = 73;
    boolean spawnPoint;
    Pointer point;
    /**
     * ALL HITBOXES CODED BY JACOB
     */
    public HitBox(){
        spawnPoint = true;
        point = new Pointer();
    }

    /**
     * CODED BY JACOB
     */
    public void act() 
    {
        if(spawnPoint == true){
            Street s = (Street) getWorld();
            s.spawnPointer(point, getX(), getY()-50);
            spawnPoint = false;
        }
    }  

    /**
     * CODED BY SPENCER, JARED
     */
    public void gotHit(GreenfootImage img){
        if(justHit == true){
            timer--;
            if((4+timer)%8 == 0){
                img.setTransparency(200);
            }
            else if(timer%8 == 0){
                img.setTransparency(2);
            }
            if(timer < 1){
                img.setTransparency(2);
                timer = 73;
                justHit = false;
            }
        }
    }
}

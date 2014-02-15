import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Actor
{
    int hPoints;
    int nHits;
    private int xpos;
    boolean inWorld;
    boolean canHit;
    boolean canRemove;
    Street street;
    HitPoints health;
    public Enemies()
    {
        hPoints = 3;
        nHits = 0;
        street = (Street) getWorld();
        inWorld = true;
    }

    public void act() 
    {
        noDoubles();
        xpos = getX();
        if(inWorld == true)
        {
            street = (Street) getWorld();
            health = new EnemyHP();
            street.spawnHitPoints(getX(),getY(),health);
            canHit = true;
            inWorld = false;
        }
        scroll();
    }    

    /**
     * CODED BY SPENCER
     */
    public boolean canHit()
    {
        return canHit;
    }

    /**
     * CODED BY JARED
     */
    public void scroll(){
        //reference the street world
        Street street = (Street) getWorld();

        //get the x/y location of the runner
        int rx = street.XLocation();
        int scrollSpeed = street.scrollSpeed;

        //if the runner is in the right 1/3 of the screen...
        if(rx>getWorld().getWidth()-street.scrollLoc){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                if(xpos <= -10){
                    getWorld().removeObject(this);
                    canRemove = false;
                }
                else{
                    xpos = xpos - scrollSpeed;
                    setLocation(xpos, getY());
                    canRemove = true;
                }
            }
        }
    }

    /**
     * Will decrease health and call health function from street.
     * CODED BY SPENCER, THEO, JARED
     */
    public void health()
    {
        hPoints -= 1;
        nHits += 1;
        health.decHealth(nHits);
        street = (Street) getWorld();
        if(hPoints <= 0 && nHits >= 3)
        {
            spawnPower();
            street.addScore(100);
            Greenfoot.playSound("bExplosion.wav");
            getWorld().removeObject(health);
            Explosion explode = new Explosion();
            street.spawnExplosion(explode,getX(),getY());
            getWorld().removeObject(this);
        }
    }
    
    /**
     * CODED BY SPENCER & JACOB
     */
    public void spawnPower(){
        if(Greenfoot.getRandomNumber(1000) <= 500 && inWorld == false)
            {
                int rand = Greenfoot.getRandomNumber(100);
                if(rand <= 33)
                {
                    SpeedUp su = new SpeedUp();
                    street.spawnSpeedUp(su, getX(), getY());
                }
                else if((rand>33 && rand <= 66) && inWorld == false)
                {
                    AttackUp attack = new AttackUp();
                    street.spawnAttackUp(attack, getX(), getY());
                }
                else if( ( 1 <= street.getHits() || street.getHits() <= 3) && Greenfoot.getRandomNumber(200) <= 50 && inWorld == false)
                {
                    HealthUp hu = new HealthUp();
                    street.spawnHealthUp(hu, getX(), getY());
                }
                else if( ( 4 <= street.getHits() || street.getHits() <= 5) && Greenfoot.getRandomNumber(100) <= 50 && inWorld == false)
                {
                    HealthUp hu = new HealthUp();
                    street.spawnHealthUp(hu, getX(), getY());
                }
            }
    }

    /**
     * CODED BY SPENCER
     */
    public void noDoubles()
    {
        if(xpos > -11 && canRemove != false)
        {
            Enemies colliding = (Enemies) getOneIntersectingObject(Enemies.class);
            if(colliding != null && colliding.inWorld == true)
            {
                getWorld().removeObject(colliding);
                inWorld = false;
            }
        }
    }
}
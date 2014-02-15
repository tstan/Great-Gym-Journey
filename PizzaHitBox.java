import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PizzaHitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PizzaHitBox extends HitBox
{
    int delay = 100;
    int hPoints;
    int nHits;
    BossBattle bworld;
    GreenfootImage img;
    /**
     * CODED BY JACOB.
     */
    public PizzaHitBox()
    {
        img = getImage();
        img.scale(30, 30);
        img.setTransparency(2);
        setImage(img);
    }

    /**
     * CODED BY JACOB
     */
    public void act() 
    {
        super.act();
        super.gotHit(img);
        move();
        shoot();
        delay++;
        if( inWorld == true)
        {
            BossBattle bworld = (BossBattle) getWorld();
            health = new BossHP();
            ///bworld.spawnHitPoints( getX(), getY(), health);
            canHit = true;
            inWorld = false;
        }
    }

    public void move(){
        bworld = (BossBattle) getWorld();
        setLocation(bworld.bossX()-5,bworld.bossY()+30);
    }

    /**
     * CODED BY JACOB
     */
    public void shoot()
    {
        if(delay > 150)
        {
            pizza();
            delay = 0;
        }
    }

    public void pizza()
    {
        Pizza bp = new Pizza(2);
        getWorld().addObject(bp, getX(), getY());
    }  

    /**
     * CODED BY JARED, SPENCER, THEO...
     */
    public void health()
    {
        hPoints -= 1;
        nHits += 1;
        health.decHealth(nHits);
        street = (Street) getWorld();
        BossBattle bWorld = (BossBattle) getWorld();
        justHit = true;
        timer = 73;
        if(hPoints <= 0 && nHits >= 10)
        {
            bWorld.hBoxes -= 1;
            super.spawnPower();
            street.addScore(100);
            Greenfoot.playSound("bExplosion.wav");
            getWorld().removeObject(health);
            Explosion explode = new Explosion();
            street.spawnExplosion(explode,getX(),getY());
            getWorld().removeObject(this);
        }
    }

    public int getHits()
    {
        return nHits;
    }
}

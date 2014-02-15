import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceCreamHitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceCreamHitBox extends HitBox
{
    int delay = 100;
    BossBattle bworld;
    GreenfootImage img;
    /**
     * MOST CODED BY JACOB
     */
    public IceCreamHitBox()
    {
        img = getImage();
        img.scale(35, 35);
        img.setTransparency(2);
        setImage(img);
        inWorld = true;
    }

    public void act() 
    {
        super.act();
        super.gotHit(img);
        move();
        shoot();
        delay++;
        if( inWorld == true)
        {
            bworld = (BossBattle) getWorld();
            health = new BossHP();
            //bworld.spawnHitPoints( getX(), getY(), health);
            canHit = true;
            inWorld = false;
        }
    }

    public void move(){
        bworld = (BossBattle) getWorld();
        setLocation(bworld.bossX()+96,bworld.bossY()+33);
    }

    /**
     * CODED BY SPENCER for original ice cream cannon
     */
    public void shoot()
    {
        if(delay > 150)
        {
            icecream();
            delay = 0;
        }
    }

    /**
     * CODED BY SPENCER: added increased variety.
     */
    public void icecream()
    {
        IceCream ic = new IceCream(Greenfoot.getRandomNumber(2)+2);
        IceCream ic2 = new IceCream(Greenfoot.getRandomNumber(2)+2);
        IceCream ic3 = new IceCream(Greenfoot.getRandomNumber(2)+2);
        getWorld().addObject(ic, getX(), getY());
        getWorld().addObject(ic2, getX()+10, getY());
        getWorld().addObject(ic3, getX()-10, getY());
    }

    public int getHits()
    {
        return nHits;
    }

    /**
     * CODED BY SPENCER, JARED, THEO in many enemy places for explosion effects.
     */
    public void health()
    {
        hPoints -= 1;
        nHits += 1;
        health.decHealth(nHits);
        street = (Street) getWorld();
        BossBattle bWorld = (BossBattle) getWorld();
        timer = 73;
        justHit = true;
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

}

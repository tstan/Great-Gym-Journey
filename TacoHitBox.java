import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TacoHitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TacoHitBox extends HitBox
{
    int delay = 0;
    int burst = 5;
    BossBattle bworld;
    GreenfootImage img;
    /**
     * CODED BY JACOB
     */
    public TacoHitBox()
    {
        img = getImage();
        img.scale(35, 35);
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
        if( inWorld == true)
        {
            BossBattle bworld = (BossBattle) getWorld();
            health = new BossHP();
            canHit = true;
            inWorld = false;
        }
    }   

    public void move(){
        bworld = (BossBattle) getWorld();
        setLocation(bworld.bossX()-95,bworld.bossY()+33);
    }

    /**
     * CODED BY SPENCER for original Taco Shop Shooting.
     */
    public void shoot(){
        if(burst > 100)
        {
            delay++;        //delay increments
            if(delay==1){
                tacos();        //Spawns first taco of burst.
            }
            else if(delay == 15){
                tacos();        //Spawns second taco of burst.
            }
            else if(delay == 25){
                tacos();        //Spawns third taco of burst.
                delay = 0;
                burst = 0;
            }
        }
        else{
            burst ++;           //Increments burst delay.
        }
    }

    public void tacos()
    {
        Taco bt = new Taco(2);
        getWorld().addObject(bt, getX(), getY());
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
}

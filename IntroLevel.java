import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel extends Street
{
    /**
     * THIS CLASS IS NO LONGER USED:
     * HOWEVER, IT MAY BE USED IN THE FUTURE.
     * CODED BY SPENCEr, jARED
     */
    public IntroLevel(boolean haungs, int score){
        super.score = score;
        super.haungs = haungs;
        prepare();
    }

    public void prepare(){
        super.spawnWall(0);
    }

    public void act(){
        super.wall = true;
        fightboss = false;
        scrolling();
        if(distance.getScore() < 45){
            Sidewalks();
            RoadStripe();
        }
        EnemySpawn();
        speedCheck();
    }

    //method for getting the X-location of the runner for use in other classes
    public int XLocation(){
        return runner.getX();
    }

    //method for getting the Y-location of the runner for use in other classes
    public int YLocation(){
        return runner.getY();
    }

    public void EnemySpawn()
    {
        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && XLocation()>getWidth()-scrollLoc){
            if(distance.getScore() == 7)
            {
                addObject(new BurgerShack(), getWidth(), getHeight()/2);
            }
            if(distance.getScore() == 20)
            {
                bkgMusic.stop();
                super.wall = false;
                Introductions1 intro1 = new Introductions1(haungs);
                Greenfoot.setWorld(intro1);
            }
            addDistance();
        }
    }

}   
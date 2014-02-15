import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CODED BY SPENCER W/SCROLLING DONE BY JARED
 */
public class Gym extends Actor
{
    GreenfootImage img;
    int i;
    int trans;
    int score;
    /**
     * CODED BY SPENCER
     */
    public Gym(int score)
    {
        this.score = score;
        i = 0;
        trans = 0;
        img = getImage();
        img.scale(img.getWidth()+20, img.getHeight()+20);
        img.setTransparency(trans);
    }

    /**
     * CODED BY SPENCER
     */
    public void act() 
    {
        if(trans < 250){
            i++;
            if(i%5 == 0)
            {
                trans += 3;
                img.setTransparency(trans);
            }
        }
        else if(trans >= 250)
        {
            move();
        }
        winGame();
    }    

    public void winGame()
    {
        Actor runner = getOneIntersectingObject(Runner.class);
        Street s = (Street) getWorld();
        if(runner != null)
        {
            s.bkgMusic.stop();
            s.fightboss = true;
            s.halfScore = false;
            WinScreen win = new WinScreen(score);
            Greenfoot.setWorld(win);
        }
    }

    /**
     * CODED BY JARED
     */
    public void move()
    {
        if(getX() > 650)
        {
            //reference the street world
            Street street = (Street) getWorld();
            //get the x location of the runner
            int rx = street.XLocation();
            int scrollSpeed = street.scrollSpeed;
            //if the runner is in the right 1/3 of the screen...
            if(rx>getWorld().getWidth()-street.scrollLoc-300){
                if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                    int xpos = this.getX();
                    if(xpos <= -10){
                        getWorld().removeObject(this);
                    }
                    else{
                        xpos = xpos - scrollSpeed;
                        setLocation(xpos, getY());
                    }
                }
            }
        }
    }
}

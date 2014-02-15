import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    GreenfootImage img = getImage();
    int trans;
    boolean opacity;
    private static GreenfootImage[] images;    
    private final static int IMAGE_COUNT = 12;       //Used for setting different images to show the explosion.
    private int imageNo = 0;
    private int increment = 1;                      //Changes the image of the explosion for each increment.
    int sizes = 3;

    /**
     * Spencer/Franklin
     */
    public Explosion()
    {
        initializeImages();
        sizes = this.sizes;
        setImage ( images[0] );
        trans = 10;
        img.setTransparency(18);
        turn(180);
        img.scale(150,150);
        opacity = true;
    }

    /**
     * Franklin:
     */
    public void initializeImages()
    {
        if ( images == null )
        {
            GreenfootImage baseImage = new GreenfootImage("Explosion2.png");
            images = new GreenfootImage[IMAGE_COUNT];
            for ( int i = 0; i < IMAGE_COUNT; i++ )
            {
                int size = (i+1) * ((baseImage.getWidth() / IMAGE_COUNT)) * (sizes);
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }

    /**
     * Franklin:
     */
    public void act() 
    {
        move();
        explode();
        setImage(images[imageNo]);
        imageNo += increment;
        if (imageNo >= IMAGE_COUNT)
        {
            increment = -increment;
            imageNo += increment;
        }

        if ( imageNo < 0 )
        {
            getWorld().removeObject(this);
        }
    } 

    /**
     * Spencer: Originally had the explosion start off strong and fade away.
     */
    private void explode()
    {
        int changeTrans = 8;
        int thresHold = 256 - changeTrans;
        if(trans > 0 && trans < thresHold && opacity == true)
        {
            trans += changeTrans;
        }
        else if(trans >= thresHold || opacity == false && trans>10)
        {
            trans -= changeTrans;
            opacity = false;
        }
        else if(trans <= 10)
        {
            trans = trans;
            getWorld().removeObject(this);
        }
        img.setTransparency(trans);
    }

    /**
     * Jared: Scrolling method for the explosions, so they move in-game.
     */
    public void move(){
        //references street world
        Street street = (Street) getWorld();
        //gets x/y location of the runner
        int rx = street.XLocation();
        int ry = street.YLocation();
        int scrollSpeed = street.scrollSpeed;
        //if the runner is on the right 1/3 of the screen
        if(rx>getWorld().getWidth()-street.scrollLoc)
        {
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
            {
                int xpos = getX();
                if(xpos <= -10){
                    getWorld().removeObject(this);
                }
                else{
                    xpos -= scrollSpeed;
                    if(street.fightboss != true){
                        setLocation(xpos, getY());
                    }
                }
            }
        }
    }
}

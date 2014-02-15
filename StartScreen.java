import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private GreenfootSound bkgMusic = new GreenfootSound("sounds/JauntyGumption.mp3"); //Music for StartScreen
    boolean haungs; //Used to find out if Haungs mode is wanted or not.
    public IRunner irunner; //Place holder for fake runner.
    public IFood ifood;     //Food switched on screen.
    public ISign isign;     //Sign flashes on screen.
    /**
     * Constructor for objects of class StartScreen;
     * Whole class by Franklin Chang
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 500, 1); 
        bkgMusic.setVolume(50);
        irunner = new IRunner();
        addObject(irunner, 152, 350);
        ifood = new IFood();
        addObject(ifood, 820, 348);
        isign = new ISign();
        addObject(isign, 490, 110);
    }

    /**
     * Original code by THEO, EDITED BY FRANKLIN
     */
    public void act()
    {   
        if (Greenfoot.isKeyDown("right")) //Chooses the regular/story mode of the game.
        {
            bkgMusic.stop();
            haungs = false;
            CutScene1 cutS = new CutScene1(haungs);
            Greenfoot.setWorld(cutS);
        }
        if (Greenfoot.isKeyDown("up"))  //Chooses the regular/story mode WITH haungs mode on.
        {
            haungs = true;
            bkgMusic.stop();
            CutScene1 cutS = new CutScene1(haungs);
            Greenfoot.setWorld(cutS);
        }
        if(Greenfoot.isKeyDown("left")) //Chooses endless/arcade mode to see how far the player can make it in the game.
        {
            haungs = false;
            bkgMusic.stop();
            Street street = new Street(haungs, 0, true);
            Greenfoot.setWorld(street);
        }
        if(Greenfoot.isKeyDown("down")) //For testing purposes to set development team right into the game's atmosphere.
        {
            haungs = true;
            bkgMusic.stop();
            LevelOne one = new LevelOne(haungs, 0, 1);
            Greenfoot.setWorld(one);
        }
    }

    /**
     * CODED BY FRANKLIN
     */
    public void started(){
        bkgMusic.playLoop();
    }

    /**
     * CODED BY FRANKLIN
     */
    public void stopped(){
        bkgMusic.stop();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends Street
{
    Board board;
    ScoreBoard sb;
    int score;
    int level;
    boolean haungs;
    /**
     * Constructor for objects of class GameOverScreen.
     * CODED BY SPENCER, JARED
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        score = 500;
        removeObject(runner);
        sb = new ScoreBoard(200,35,200,score,"Final Score: ");
        addObject(sb, 480, 400);
        Angel angel = new Angel();
        addObject( angel, 491, 241);
    }

    public GameOverScreen(int score, int level){
        super.score = score;
        this.level = level;
        super.bkgMusic.stop();
        removeObject(runner);
        sb = new ScoreBoard(200,35,200,score,"Final Score: ");
        addObject(sb, 480, 400);
        Angel angel = new Angel();
        addObject( angel, 491, 241);
    }

    public void act()
    {
        haungs = false;
        reStart();
    }

    /**
     * CODED/EDITED BY SPENCER, JARED, JACOB
     */
    public void reStart()
    {
        if(Greenfoot.isKeyDown("t")) //We don't really have an Introduction level, so this is useless :/
        {
            IntroLevel t = new IntroLevel(haungs, 0);
            Greenfoot.setWorld(t);
        }
        if(Greenfoot.isKeyDown("q")) //Sends players back to the level they were at with score equaling 0.
        {
            score = 0;
            braveNewWorld();
        }
    }

    /**
     * When this method is called, the level the player was on is created and set before them.
     * CODED BY JARED
     */
    public void braveNewWorld(){
        if(level <= 1){         
            LevelOne s = new LevelOne(score, level);
            Greenfoot.setWorld(s);
        }
        else if(level == 2){
            LevelTwo s = new LevelTwo(score, level);
            Greenfoot.setWorld(s);
        }
        else if(level == 3){
            LevelThree s = new LevelThree(score, level);
            Greenfoot.setWorld(s);
        }
    }
}

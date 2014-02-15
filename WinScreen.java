import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends Street
{
    ScoreBoard sb;
    /**
     * Constructor for objects of class WinScreen.
     * CODED BY JACOB
     */
    public WinScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        sb = new ScoreBoard(200,35,200,score, "Final Score: ");     //New scoreboard made for the winning screen.
        addObject(sb, 486, 407);
        removeObject(runner);
        FitAngel angel = new FitAngel();        //Creates object for winning screen. it's cool!
        addObject( angel, 491, 241);
    }

    public WinScreen(){
        int score = 9001;
        sb = new ScoreBoard(200,35,200,score, "Final Score: ");
        addObject(sb, 486, 407);
        removeObject(runner);
        FitAngel angel = new FitAngel();
        addObject( angel, 491, 241);
    }

    public void act()
    {
        super.bkgMusic.stop();
        if(Greenfoot.isKeyDown("q"))    //Pressing 'q' will take the player back into the StartScreen.
        {
            StartScreen ss = new StartScreen();
            Greenfoot.setWorld(ss);
        }
    }
}

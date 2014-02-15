import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeechBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeechBubble extends Actor
{
    private String[] speechBubble = {"SpeechBubble.png", "SpeechBubble1.png",
            "SpeechBubble2.png"};
    public boolean spoken = false;
    public boolean oneSpawn = true;
    GreenfootImage img;

    /**
     * CODED BY SPENCEr
     */
    public SpeechBubble(int level){
        img = new GreenfootImage(speechBubble[level]);
        img.scale(300,165);
        setImage(img);
    }

    public SpeechBubble(){
    }

    /**
     * CODED BY SPENCER
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("space")){
            getWorld().removeObject(this);
        }
    }    

    public boolean spoken(){
        return spoken;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CODED BY SPENCER
 */
public class Boss extends Actor
{
    int end;
    int i;
    int burst;
    int level;
    int move = 1;
    int xpos;
    int ypos;
    boolean bubble = false;
    boolean spoken = false;
    SpeechBubble speech;
    BossBattle bworld;
    /**
     * CODED BY JARED
     */
    public Boss(int level){
        this.level = level;
    }

    /**
     * CODED BY SPENCER
     */
    public void act() 
    {
        xpos = getX();
        ypos = getY();
        move();
        die();
        if(i == 75){
            spawnBurgers();
            i = 0;
        }
    }    

    /**
     * CODED BY SPENCER
     */
    public void die()
    {
        bworld = (BossBattle) getWorld();
        end = bworld.overallHits();
        if(bworld.hBoxes < 1)
        { 
            speech = new SpeechBubble(level-1);
            if(bubble != true){
                bworld.spawnSpeech(speech, getX()+215, getY());
                bubble = true;
                Greenfoot.delay(50);
            }
            if(Greenfoot.isKeyDown("space") || spoken == true){
                getWorld().removeObject(speech);
                spoken = true;
                bossFight();
                if(getY() <= -100 || level >= 3){
                    bworld.bossEndGame(level);
                }
            }
        }
    }

    private void spawnBurgers()
    {
        getWorld().addObject(new Burger(getRotation()), getX(), getY());
    }

    /**
     * CODED BY SPENCER
     */
    public void move()
    {
        if(bubble != true){
            i++;
            xpos += move;
            if(xpos == getWorld().getWidth()-250){
                move = -1;
            }
            else if(xpos == getWorld().getWidth()-750){
                move = 1;
            }
            setLocation(xpos, getY());
        }
    }

    /**
     * CODED BY SPENCER
     */
    public void bossFight(){
        ypos -= 5;
        setLocation(xpos, ypos);
    }
}

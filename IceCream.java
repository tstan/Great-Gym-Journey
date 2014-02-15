import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang
 * 
 */
public class IceCream extends Food
{
    GreenfootImage img;
    Street street;
    int ypos;
    int xpos;
    int move = 2;
    int yMove;
    int half;
    int turn;
    boolean oriented;
    boolean smoked;
    int go = 0;
    /**
     * Act - do whatever the IceCream wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public IceCream(int yMove)
    {
        this.yMove = yMove;
        oriented = false;
        img = getImage();
        img.scale(15, 30);
        setImage(img);
        turn = 0;
    }

    public void act() 
    {
        ypos = getY();
        xpos = getX();
        selfDestruct();
    }

    public void move()
    {
        street = (Street) getWorld();
        //         if(street.canScroll == true){
        //             xpos = xpos + move - street.scrollSpeed - 1;
        //         }
        //         else{
        if(go ==0){
            if(street.fightboss != false){
                move = Greenfoot.getRandomNumber(9)-4;
            }
            go = 1;
        }
        xpos = xpos + move;
        //         }
        ypos = ypos + yMove;
        setLocation(xpos, ypos);
    }

    public void selfDestruct()
    {
        //         if(ypos <= 0 || ypos >= getWorld().getHeight() + 10)
        if(xpos >= getWorld().getWidth() + 10 || xpos <= -30)
        {
            getWorld().removeObject(this);
        }
        else if(ypos >= getWorld().getHeight()+10 || ypos <= -10)
        {
            getWorld().removeObject(this);
        }
        else
        {
            move();
            turnMove();
            if(smoked != true)
            {
                Street world = (Street) getWorld();
                RockDust smoke = new RockDust();
                world.spawnRockDust(smoke, xpos+20,ypos-5);
                world.spawnRockDust(smoke, xpos+30,ypos+5);
                world.spawnRockDust(smoke, xpos+27,ypos-10);
                smoked = true;
            }
        }
    }

    public void turnMove()
    {
        turn += 1;
        if(turn%3 == 0)
        {
            turn(45);
        }
    }
}

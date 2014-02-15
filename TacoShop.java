import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TacoShop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TacoShop extends Enemies
{
    int delay = 0;          //Delay between shots of a burst.
    int burst = 5;          //Delay between sets of bursts.
    /**
     * CODED BY SPENCER
     */
    public void act() 
    {
        super.act();        //Calling the super class method 'act()' will make the tacoshop scroll and get hit by rocks like the rest.
        shoot();            //Calls the shoot() method
    }    

    /**
     * Shoot() shoots the tacos in a burst of three shots each time that burst reaches 101.
     * CODED BY SPENCEr
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

    /**
     * tacos() is the tacospawn calling method:
     * It orients the taco so our group can have the "move(int)" ability.
     * If we changed the x position, it would be difficult to get the food to move in a straight line after
     * going towards the player's avatar.
     * CODED BY JARED
     */
    private void tacos(){
        if(canRemove == true){
            Taco t = new Taco(getRotation() );
            getWorld().addObject(t, getX()+(Greenfoot.getRandomNumber(10)-5), getY()+25);
        }
    }
}

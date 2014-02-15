
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Spencer Chang & Jared Speck
 * 
 */
public class IntroWall extends Road
{
    private boolean canShoot;
    /**
     * Act - do whatever the IntroWall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public IntroWall(int level, boolean canShoot){
        if(level == 1){
            LevelOne s = (LevelOne) getWorld();
        }
        else if(level == 2){
            LevelTwo s = (LevelTwo) getWorld();
        }
        else if(level == 3){
            LevelThree s = (LevelThree) getWorld();
        }
        this.canShoot = canShoot;
    }
    
    public void act() 
    {
        getImage().scale(20, getImage().getHeight());
        scroll();
        collision();
    }    

    public void collision()
    {
        Actor rock = getOneIntersectingObject(Rock.class);
        Actor food = getOneIntersectingObject(Food.class);
        Actor enemy = getOneIntersectingObject(Enemies.class);
        if( getX() <= 0){
            getWorld().removeObject(this);
        }
        else if(rock != null && canShoot == true){
            getWorld().removeObject(rock);
            getWorld().removeObject(this);
        }
        else if(rock != null && canShoot != true){
            getWorld().removeObject(rock);
        }
        else if( food != null & canShoot != true){
            getWorld().removeObject(food);
        }
        else if(food != null && canShoot == true){
            getWorld().removeObject(food);
        }
        else if(enemy != null){
            getWorld().removeObject(this);
        }
    }
}

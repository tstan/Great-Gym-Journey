import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackUp extends PowerUps
{
    /**
     * CODED BY JACOB
     */
    public AttackUp()
    {
        GreenfootImage attack = getImage();
        attack.scale(25,30);
        setImage(attack);
    }
    
    public void act() 
    {
        super.scroll();
        super.act();
    }    
}

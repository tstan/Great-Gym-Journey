import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * CODED BY SPENCER
 */
public class Board extends Actor
{
    GreenfootImage board;
    GreenfootImage sb;
    String label;
    GameOverScreen gameover;
    Street s;
    /**
     * CODED BY SPENCER: Board is not used anymore, but it originally was used to say,
     * "'Space' to fire" or something like that.
     */
    public Board()
    {
        gameover = new GameOverScreen();
        s = new Street();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("q") && getWorld() == gameover)
        {
            Greenfoot.setWorld(s);
        }
    }

    public Board(int boardWidth, int boardHeight, int boardTransparency, String label) 
    {
        makeBoard(boardWidth, boardHeight, boardTransparency, label);
    }    

    public void makeBoard(int boardWidth, int boardHeight, int boardTransparency, String label)
    {
        board = new GreenfootImage(boardWidth, boardHeight);
        board.setColor(Color.green);
        board.setTransparency(boardTransparency);
        board.fillRect(0,0,boardWidth,boardHeight);
        this.setImage(board);
        update(label);
    }

    public void update(String label)
    {
        sb = new GreenfootImage(board);
        sb.drawImage(new GreenfootImage(label, 24, Color.WHITE, new Color(0,0,0,0)),15,7);
        this.setImage(sb);
    }
}

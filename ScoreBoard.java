import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private GreenfootImage sb;
    private GreenfootImage board;
    private String label = "Score: ";
    Street street;
    int boardWidth;
    int boardHeight;
    int boardTransparency;
    int score = 0;
    /**
     * CODED BY SPENCER AND JARED
     */
    public ScoreBoard(int boardWidth, int boardHeight, int boardTransparency, int score, String label)
    {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.boardTransparency = boardTransparency;
        this.score = score;
        this.label = label;
    }

    public ScoreBoard()
    {
        makeBoard();
    }

    public void act() 
    {
        makeBoard();
        street = (Street) getWorld();
        if(street.halfScore != false)
        {
            addScore(street.score);
            street.halfScore = false;
        }
    }    

    public int getScore()
    {
        return score;
    }

    public void addScore(int pts)
    {
        score += pts;
        update();
    }

    public void makeBoard()
    {
        board = new GreenfootImage(boardWidth, boardHeight);
        board.setColor(Color.green);
        board.setTransparency(boardTransparency);
        board.fillRect(0,0,boardWidth, boardHeight);
        this.setImage(board);
        update();
    }

    public void update()
    {
        sb = new GreenfootImage(board);
        sb.drawImage(new GreenfootImage(label + score, 24, Color.WHITE, new Color(0,0,0,0)),15,5);
        setImage(sb);
    }
}

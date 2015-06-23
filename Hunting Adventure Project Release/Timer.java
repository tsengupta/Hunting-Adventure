import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The timer is used to countdown the number of seconds the player has.
 * 
 * Trisha S. 
 * Project Release, 5/1/2015
 */
public class Timer extends Actor
{
    public static int NANOSECONDS_PER_SECOND = 1000000000;
    private long startTime;
    private int label;
    private GreenfootImage background;
    private static final Color transparent = new Color (0,0,0,0);
    
    /**
     * Timer - starts the timer and shows it starting at 90 seconds.
     */
    public Timer()
    {
        startTime = Long.MIN_VALUE;
        this.label = label;
        background = getImage();
        update(90);
    }
    /**
     * reset
     */
    public void reset() {
        startTime = System.nanoTime();
    }
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update(timeSpent());
        
        if (timeSpent() <= 0){
            getWorld().addObject( new Lose(), 300, 200);
            Greenfoot.stop();
        }
    }    
    /**
     * timeSpent - shows the amount of time that has spent by using the NANOSECONDS_PER_SECOND and subtracting 90 so it countsdown
     */
    public int timeSpent()
    {
        if (startTime == Long.MIN_VALUE) {
            reset();
        }
        return (int)( 90 - (System.nanoTime()-startTime) 
            / NANOSECONDS_PER_SECOND);
    }
    /**
     * update - changes the number each time it goes down
     */
    public void update(int timeSpent)
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage label = new GreenfootImage("Time: " + timeSpent, 22, Color.BLACK, transparent);
        image.drawImage(label, (image.getWidth()-label.getWidth())/2, 
                        (image.getHeight()-label.getHeight())/2);
        setImage(image);
    }
}

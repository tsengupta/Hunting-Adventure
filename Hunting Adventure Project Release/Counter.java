import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The counter is used so the player can keep track of their score.
 * 
 * @Trisha S.
 * @Project Release, 5/1/2015
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;

    /**
     * Counter - create a new counter, initialised to 0.
     */
    public Counter()
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        updateImage();
    } 
    /**
     * act - the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
        if (value >= 125){
            getWorld().addObject( new Win(), 300, 200);
            Greenfoot.stop();  
        }
    }
    /**
     * add - add a new score to the current counter value.
     */
    public void add(int score)
    {
        target += score;
    }
    /**
     * getValue - return the current counter value.
     */
    public int getValue()
    {
        return value;
    }
    /**
     * setValue - set a new counter value.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Score: " + value, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
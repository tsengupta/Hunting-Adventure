import greenfoot.*;
import java.awt.Color;
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * The Field is the setting of the Hunting Game.
 * 
 * @Mir(Field), Trisha S. (Animals: canAddBear, canAddBird, canAddRabbit), Antonio (New Cursor)
 * @Project Release, 5/1/2015
 */
public class Field extends World
{
    private int birdCounter = 0;
    private int rabbitCounter = 0;
    private Timer timer;
    Counter counter = new Counter();
    JPanel Pan = WorldHandler.getInstance().getWorldCanvas();  
    Cursor NewCursor;
    /**
    * Constructor for objects of class field.
    * 
    */
   public Field()
   {    
       // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
       super(600, 400, 1, false);
    
       addObject( new Start(), 300, 200 );
    
       Counter counter = new Counter();
       addObject(counter, 58, 26);
        
       Timer timer = new Timer();
       addObject(timer, 550, 26);
        
       addObject( new Tree(), 337, 319 );
       addObject( new Tree(), 275, 88 );
       addObject( new Tree(), 525, 50 ); 
       addObject( new Tree(), 70, 350 );
       addObject( new Tree(), 38, 49 );
        
       addObject( new Brush(), 547, 343 );
       addObject( new Brush(), 153, 220 );
       addObject( new Brush(), 441, 171 );
        
        
       addObject( new Crosshair(counter), 300, 200 );
        
       setPaintOrder(Start.class, Lose.class, Win.class, Crosshair.class, Counter.class, Timer.class, Tree.class, Brush.class, Bear.class, Bird.class, Rabbit.class);
      
       /*
       * These are used to make the mouse transparent/disappear.
        */
       Toolkit Tk = Toolkit.getDefaultToolkit();
       Point CursorPoint= new Point(0,0);
       NewCursor = Tk.createCustomCursor(new GreenfootImage(5,5).getAwtImage(), CursorPoint, "Somehow");  
    }  
   public void act()
   { 
       Pan.setCursor(NewCursor);
       Started();
      
       /**
       * This if-statement for the Bird is used to randomly spawn Bird at a certain location in random intervals
       */
       if (Greenfoot.getRandomNumber(100) < 15){
            if (canAddBird()) {
            addObject(new Bird(), Greenfoot.getRandomNumber(601), Greenfoot.getRandomNumber(401));
            birdCounter = Greenfoot.getRandomNumber (5);
            }   
       }  
       /**
       * This if-statement for the Rabbit is used to randomly spawn Rabbit at a certain location in random intervals
       */
       if (Greenfoot.getRandomNumber(100) < 20){
            if (canAddRabbit()) {
            addObject(new Rabbit(), Greenfoot.getRandomNumber(601), Greenfoot.getRandomNumber(401));
            rabbitCounter = Greenfoot.getRandomNumber (6);
           }   
       }
       /**
       * This if-statement for the Bear is used to randomly spawn Bear at a certain location in random intervals
       */
       if (Greenfoot.getRandomNumber(300) < 1){
            if (canAddBear()) {
            addObject(new Bear(), Greenfoot.getRandomNumber(601), Greenfoot.getRandomNumber(401));
           }
       }
   }
   public Counter getCounter()
   { 
       return counter;
    }
    /**
   * started - removes the Start screen once the player hits "Run"
   */
   public void Started()
   {
       if (!getObjects(Start.class).isEmpty()){
            removeObjects(getObjects(Start.class));
       }
   } 
    /**
    * canAddBird - limits the amount of Birds on screen
    */
   public boolean canAddBird(){
       return getObjects (Bird.class).size() < 4;
   }
    /**
    * canAddRabbit - limits the amount of Rabbits on screen
    */
   public boolean canAddRabbit(){
       return getObjects(Rabbit.class).size() < 5;
   }
    /**
    * canAddBear - limits the amount of Bears on screen
    */
   public boolean canAddBear(){
       return getObjects(Bear.class).size() < 1;
    }
}

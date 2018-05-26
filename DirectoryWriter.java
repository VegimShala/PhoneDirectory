package phonedirectory;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Vegim Shala
 */
public class DirectoryWriter extends JPanel 
{
   private final int width = 600;   //main frame width
   private final int height = 250;  //main frame height
   
   private String sentence = "";    //the sentence to be displayed
   
   private String name;         //contact's name
   private String number;       //contact's number
   private String address;      //contact's address
   private String key;          //contact's database key
   
   private int count;     //determines the new frames' locations
   private int w;         //determines what to show on the main frame
   
   private JButton button;     //The button that deletes the contact
   
   /** Constructor BullsEyeWriter constructs the panel and frames it.*/
   public DirectoryWriter()
   {
      JFrame frame = new JFrame();
      frame.setSize(width,height);
      frame.setVisible(true);
      frame.setTitle("MAIN FRAME");
      frame.getContentPane().add(this);
      frame.setLocation(width,0);
   }
   /** paintComponent shows changes
    * @param g - the graphics pen that does the drawing */
   public void paintComponent(Graphics g)
   {
      g.setColor(Color.WHITE);
      g.fillRect(0,0,width,height);
      
      g.setColor(Color.BLACK);  
      g.drawString(sentence,50,50);
      if(w==1)
      {g.drawString("Name:     " + name,50,70);
      g.drawString("Number:   " + number,50,90);
      g.drawString("Address:  " + address,50,110); 
      g.drawString("Key:      " + key,50,130);}
   }
   /**showFound creates a new frame in which shows found contacts 
    * the parameters na , nu, a , k , s , initialize the fields values
    * @param b - determines whether to show the button   */
   public void showFound(String na, String nu, String a, String k, String s,boolean b)
   {
      Frames obj = new Frames(count,na,nu,a,k,s);
      if(b) button = obj.showButton();
      count++;
   }
   /**show repaints the main frame, and shows each change of the database 
    * the parameters na , nu, a , k , s , initialize the fields values
    * @param i - determines whether to show the contact's information   */
   public void show(String na, String nu, String a, String k, String s,int i)
   {
      w=i;
      name = na; number = nu; address = a; key = k; sentence = s;
      this.repaint();
   }
   /**getButton returns the delete button */
   public JButton getButton()
   {
      return button;
   }
   
   public void print(String name, String number, String address, String key)
   {
      System.out.print(name + ": " + number + ", " + address + ", " + key);
      System.out.println();
   }
}

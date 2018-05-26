package phonedirectory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Vegim Shala
 */
public class Frames extends JPanel 
{
    private String name;          //contact's name
   private String number;        //contact's number
   private String address;       //contact's address
   private String key;           //contact's database key
   private String sentence;      //the sentence to be displayed
   
   private int width = 300;      //frames' width
   private int height = 250;     //frames' height
   
   private JButton button;       //The button that deletes the contact
   
   /**Constructor Frames creates the frame and sets it location
    * @param i - the integer in base of which sets the location
    * @param fn - initializes field name
    * @param a - initializes field address
    * @param k - initializes field key
    * @param s - initializes sentence field  */
   public Frames(int i,String fn, String pn, String a, String k, String s)
   {
      name=fn; number = pn; address = a; key = k; sentence = s;
      JFrame frame = new JFrame(i+"");
      if(i>=18) i = i%18;
      frame.setSize(width,height);
      frame.setVisible(true);
      frame.getContentPane().add(this);
      int j = i%6;
      if(i>=0 && i<6) frame.setLocation(j*width,height);
      else if(i>=6 && i<12) frame.setLocation(j*width,2*height);
      else if(i>=12 && i<18) frame.setLocation(j*width,3*height);
   }
   /**showButton shows the delete button and checks if it is clicked */
   public JButton showButton()
   {
      button = new JButton("DELETE");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            button.setText("This contact has been deleted");
         }
         });
      this.add(button);
      return button;
   }
   /** paintComponent shows changes
    * @param g - the graphics pen that does the drawing */
   public void paintComponent(Graphics g)
   {
      g.setColor(Color.WHITE);
      g.fillRect(0,0,width,height);
      g.setColor(Color.BLACK);
      g.drawString(sentence,50,50);
      g.drawString("Name:     " + name,50,70);
      g.drawString("Number:   " + number,50,90);
      g.drawString("Address:  " + address,50,110);
      g.drawString("Key:      " + key,50,130);
   }
}

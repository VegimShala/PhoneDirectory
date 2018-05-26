package phonedirectory;
import javax.swing.*;
/**
 *
 * @author Vegim Shala
 */
public class DirectoryReader 
{
    /**chooseOption determines what the user wants to do
    * return - the answer of the user  */
   public int chooseOption()
   {
      String[] options = {"Find","Insert","Delete","Show All"};
      int k = JOptionPane.showOptionDialog(null, "Choose one of the options below?", "Phone Directory",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,null);
      return k;
   }
   /**confirm shows a yes or no dialog, in order to continue further in the application
    * @param s - the sentence to be displayed to the user 
    * return - the answer of the user   */
   public boolean confirm(String s)
   {
      boolean answer = false;
      int k = JOptionPane.showConfirmDialog(null,s,"PHONE DIRECTORY?",JOptionPane.YES_NO_OPTION);
      if(k==0) answer = true;
      return answer;
   }
   /**dialog shows a dialog for the user, and asks him to give information on it
    * @param k - the sentence to be displayed to the user
    * return - the user's answer   */
   public String dialog(String k)
   {      
      String s = JOptionPane.showInputDialog(k);
      if(s==null) { if(confirm("Are you sure you want to exit the application")) {System.exit(0);} 
                    else { s="~"; } }
      else if(s.trim().equals("")){JOptionPane.showMessageDialog(null,"Please type something to proceed"); s = dialog(k); }
      else { s = s.trim(); s = s.toUpperCase(); }
      return s;
   }

}

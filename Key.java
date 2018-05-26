package phonedirectory;
/**
 * @author VegimShala
 */
public class Key 
{
   private String operator;   //phone operator
   private int number;        //identifier
   /**Constructor Key initializes the Key fields
    * @param letters - operator
    * @param num - number  */
   public Key(String letters, int num)
   { operator = letters;
     number = num;
   } 
   /**The following are getter methods that return the fields' values
     * @return  */
   public String getOperator() { return operator; }
   
   public int getNumber() { return number; }
}

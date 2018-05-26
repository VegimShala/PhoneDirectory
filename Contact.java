package phonedirectory;

/**
 *
 * @author Vegim Shala
 */
public class Contact 
{
   private Key key;             //unique string for each contact
   private String fullName;     //the contact's full name
   private String phoneNumber;  //the contact's phone number
   private String address;      //the contact's address
   
   /**Constructor Contact initializes the Contacts field variable
    * @param name - the fullName
    * @param number - the phoneNumber
    * @param place - the address
    * @param id - the key */
   public Contact(String name, String number, String place, Key id)
   {
      fullName = name;
      phoneNumber = number;
      address = place;
      key = id;
   }
   /**equals checks if a contact is in the database
    * @param s - Contact's name, phone number or key
    *  return - whether it is   */
   public boolean equals(String s)
   {
      boolean equals = false;
      if(s.equals(fullName) || s.equals(phoneNumber) || s.equals(getKeyString()))
      {
         equals = true;
      }
      return equals;
   }
   /**The following are getter methods who return the fields' values */
   public String getName() { return fullName; }
   
   public String getNumber() { return phoneNumber; }
   
   public String getAddress() { return address; }
   
   public String getKeyString()
   {
      return (key.getOperator() + key.getNumber());
   }
}

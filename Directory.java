package phonedirectory;
/**
 * @author Vegim Shala
 */
public class Directory 
{
   private Contact[] base;       //the Database in which the Contacts are saved
   private int[] index;          // locations of specified contacts in the Database
   private int notFound = -1;    //in case a contact is not found 
   private int k = 0;            //remember the last found contact's index as a starting point for the next one
   
   /**Constructor Directory initializes the database
    * @param howMany - the size of the database */
   public Directory(int howMany)
   {
      if(howMany>0)
      {base = new Contact[howMany];}
      else {base = new Contact[1];}
   }
   
   /**findOcurrences is a helper method that detects whether a specified contact 
      is in the database, and also counts the ocurrences of that contact in the database.
    * @param s - Contact's name, phone number or key 
    *  return - number of ocurrences   */
   public int findOcurrences(String s)
   {
      int i = 0; int count = notFound;
      while(i<base.length)
      {
         if(base[i]!=null && base[i].equals(s)) { count++; }
         i++;
      }
      return count-notFound;
   }
   /**findLocations is a method that finds the indices of the specified contact 
      and stores them into the index array.
    * @param s - Contact's name, phone number or key
    *  return - the indices   */
   public int[] findLocations(String s)
   {
      index = new int[findOcurrences(s)];
      for(int i = 0; i<index.length ; i++)
      {
         boolean checking = true;
         while(checking && k<base.length)
         {
            if(base[k]!=null && base[k].equals(s))
            {
               checking = false;
               index[i] = k;
            }
            k++; 
         }
         if(i==index.length-1) k=0;
      }
      return index;
   }
   /**findContacts finds the contacts using the two previous methods
    * @param s - Contact's name, phone number or key
    *  return - the contacts   */
   public Contact[] findContacts(String s)
   {
      index = findLocations(s);
      Contact[] contacts = null;
      if(findOcurrences(s)!=notFound)
      {
         contacts = new Contact[findOcurrences(s)];
      }
      for(int i = 0; i<contacts.length; i++)
      {
         contacts[i]=base[index[i]];
      }
      return contacts;
   }
   /**insert adds a new contact on the directory 
    * @param r - the contact to be added 
    * returns whether the contact is inserted - a boolean  */
   public boolean insert(Contact c)
   {
      boolean inserted = false;
      if(same(c)==false)
      {
         boolean searching = true;
         int i = 0;
         while(searching && i<base.length)
         {
            if(base[i]==null) searching = false;
            else i++;
         }
         if(!searching) base[i]=c;
         else
         {
            Contact[] extendedBase = new Contact[base.length*2];
            for(int j = 0; j<base.length; j++)
            {
               extendedBase[j]=base[j];
            }
            extendedBase[base.length] = c;
            base = extendedBase;
         }
         inserted = true;
      }
      return inserted;
   }
   /**delete removes a contact from the directory based on its key
    * @param r - the contact to be deleted 
    *  return - whether the contact is deleted - a boolean  */
   public boolean delete(Contact c)
   {
      boolean deleted = false;
      int index = findLocations(c.getKeyString())[0];
      if(index!=notFound)
      {
         base[index] = null;
         deleted = true;
      }
      return deleted;
   }
   /** same detects if a contact is already in the database
    * @param c - the Contact to be checked 
    *  return - whether the contact is in the database  */
   public boolean same(Contact c)
   {
      boolean answer = false;
      for(int i = 0; i<base.length ; i++)
      {
         if(base[i]!=null)
         {
            if(base[i].getName().equals(c.getName()) && base[i].getNumber().equals(c.getNumber()))
            {
               answer = true;
            }
         }
      }
      return answer;
   }
   
   public Contact[] getBase()
   {
      return base;
   }

}

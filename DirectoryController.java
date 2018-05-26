package phonedirectory;

/**
 *
 * @author Vegim Shala
 */
public class DirectoryController 
{
    private Directory base;
   private DirectoryWriter writer;     
   private DirectoryReader reader;
   
   private int keyNr;  //the key identifier
   
   public DirectoryController(Directory b,DirectoryWriter w, DirectoryReader r)
   {
      base = b;
      writer = w;
      reader = r;
   }
   /**control manages the entire application's control flow*/
   public void control()
   {
      int a = reader.chooseOption();
      switch(a)
      {
         case 0:
         {
            String s = reader.dialog("Type one of the person's: \nFull Name, or\nPhone Number or\nKey");
            Contact[] r = base.findContacts(s);
            String l = "The contact you have been searching for is:";
          for (Contact r1 : r) {
              writer.showFound(r1.getName(), r1.getNumber(), r1.getAddress(), r1.getKeyString(), l, false);
          }
            String h = "There were " + r.length + " results";
            if(r.length==0) h="No results found";
            writer.show(null,null,null,null,h,0);
            break;
         }
         case 1:
         {
            String name = reader.dialog("Type the full name of the person you want to add");
            if(name.equals("~")) this.control();
            String number = reader.dialog("Type the phone number of the person you want to add");
            if(number.equals("~")) this.control();
            String address = reader.dialog("Type the address of the person you want to add");
            if(address.equals("~")) this.control();
            String keyString = reader.dialog("Type the number operator of the person you want to add");
            if(keyString.equals("~")) this.control();
            Key key = new Key(keyString,keyNr++);
            Contact contact = new Contact(name,number,address,key);
            String sentence = "The contact with the following data has been successfully added";
            if(base.insert(contact)==false) sentence = "The contact with te following data is already in the directory";
            writer.show(name,number,address,keyString,sentence,1);
            break;
         }
         
         case 2:
         {
            String s = reader.dialog("Type one of the person's: \nFull Name, or\nPhone Number or\nKey");
            int index = base.findOcurrences(s);
            String z = "There are "+index+" contacts that match your search";
            String x = "Do you want to delete this contact?";
            String c = "If YES press Yes, and press the Delete button to continue\n Otherwise press No";
            if(index>0)
            {
               Contact[] r = base.findContacts(s);
               for(int i = 0; i<r.length ; i++)
               {
                  writer.showFound(r[i].getName(),r[i].getNumber(),r[i].getAddress(),r[i].getKeyString(),i+".",true);
                  if(reader.confirm(z+"\n"+x+"\n"+c+"\nWARNING: You have 3 seconds to press the delete button before continuing"))
                  {
                     try {Thread.sleep(3000); }
                     catch(InterruptedException e) {}
                     if(writer.getButton().getText().equals("DELETE")) {writer.getButton().setText("This contact is not deleted");}
                  }
                  else { writer.getButton().setText("This contact is not deleted"); }
                  if(writer.getButton().getText().equals("This contact has been deleted")) 
                  {
                     if(base.delete(r[i])) 
                     writer.show(r[i].getName(),r[i].getNumber(),r[i].getAddress(),r[i].getKeyString(),"This contact has been deleted",1);
                     index--;
                  }
                  z="There are " + (r.length-i-1) + " more results";
               }
               writer.show(null,null,null,null,r.length-index + " of the found contacts were deleted",0);
            
            }
            else {writer.show(null,null,null,null,"No contacts found!",0);}

            break;
         }
         case 3: 
         {
            Contact[] c = base.getBase(); 
            boolean is = false;
          for (Contact c1 : c) {
              if (c1 != null) {
                  writer.print(c1.getName(), c1.getNumber(), c1.getAddress(), c1.getKeyString());
                  is = true;
              }
          }
            if(!is) writer.show(null,null,null,null,"THERE ARE NO CONTACTS IN THE DIRECTORY FOR THE MOMENT",0);
            break;
         }
      }
      
      if(reader.confirm("Continue?")) 
      {
         this.control();
      }
      else{ System.exit(0); }
   }
}
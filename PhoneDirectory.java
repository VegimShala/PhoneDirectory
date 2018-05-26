/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

/**
 *
 * @author vegim
 */
public class PhoneDirectory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Directory base = new Directory(100);
      DirectoryWriter writer = new DirectoryWriter();
      DirectoryReader reader = new DirectoryReader();
      DirectoryController controller = new DirectoryController(base,writer,reader);
      controller.control();
    }
    
}

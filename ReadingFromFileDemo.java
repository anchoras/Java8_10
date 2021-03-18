/*
    demo shows basics of reading from file using byte stream
*/

import java.io.*;

class ReadingFromFileDemo {
    public static void main(String args[]) {
        int i;
        FileInputStream fin = null;

        System.out.println(args.length);
        if (args.length != 1) {
            System.out.println("Error. Check file name input");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if(i != -1)
                    System.out.print((char) i);
            } while(i != -1);
        }
        catch (FileNotFoundException exc) {
            System.out.println("File was not found");
            return;
        }
        catch (IOException exc) {
            System.out.println("Error. Input-Output exception");
        }
        finally {
            try {
                if (fin != null)
                    fin.close();
                else
                    System.out.println("There is no opened file");
            }
            catch (IOException exc) {
                System.out.println("Error. Error while closing file");
            }
        }
    }
}
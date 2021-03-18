/*
    demo shows basics of writing to file using byte stream
*/

import java.io.*;

class WriteToFileDemo {
    public static void main(String args[]) {
        int i;
        boolean appendFile = true;

        if(args.length !=2) {
            System.out.println("Using (in command line input): WriteToFileDemo FileFrom_name FileTo_name");
            return;
        }

        try(FileInputStream fin = new FileInputStream(args[0]); FileOutputStream fout = new FileOutputStream(args[1], appendFile)) {
            do {
                i = fin.read();
                if(i != -1)
                    fout.write(i);
            } while(i != -1);
        }
        catch(IOException exc) {
            System.out.println("Error. Input-output error");
            System.out.println(exc);
        }
    }
}
/*
    demo shows basics of writing to file using byte stream
*/

import java.io.*;

class WriteToFileDemo {
    public static void main(String args[]) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;
        boolean appendFile = true;

        if(args.length !=2) {
            System.out.println("Next time input into arguments of command line: FileFrom FileTo");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1], appendFile);

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
        finally {
            if(fin != null) {
                try {
                    fin.close();
                }
                catch(IOException exc) {
                    System.out.println("Error. Input file closing error");
                }
            }
            if(fout != null) {
                try {
                    fout.close();
                }
                catch(IOException exc) {
                    System.out.println("Error. Output file closing error");
                }
            }
        }
    }
}
package com.company;
import java.io.*;

public class Main {
   // private static final String FILENAME = "C:\\Users\\lekhuwane.n.sharlot\\Desktop\\password and count account.txt";

    public static void main(String[] args) {
        final String Filename=("C:\\Users\\lekhuwane.n.sharlot\\Desktop\\newfileCreatedw.txt");
        CreatFile( Filename);
        writeFile(Filename);
        ReadFile(Filename);
        appendfile(Filename);
    }
    public static void appendfile(String filename)
    {
        try{
            File file =new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //This will add a new line to the file content
            pw.println("");
            /* Below three statements would add three
             * mentioned Strings to the file in new lines.
             */
            pw.println("This is first line");
            pw.println("This is the second line");
            pw.println("This is third line");
            pw.close();
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }


public static void ReadFile(String filename)
{

    BufferedReader br = null;
    FileReader fr = null;

    try {
        //br = new BufferedReader(new FileReader(FILENAME));
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {

        try {
            if (br != null)
                br.close();
            if (fr != null)
                fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
    public static void writeFile(String filename)
    {
        BufferedWriter bw = null;
        try {
            String mycontent = "This String would be written" +
                    " to the specified File";
            //Specify the file name and path here
            //File file = new File("C:/myfile.txt");
            File file=new File(filename);

            /* This logic will make sure that the file
             * gets created if it is not present at the
             * specified location*/
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }


    public static void CreatFile(String Filename)
    {
        try {
           // File file = new File("C:\\Users\\lekhuwane.n.sharlot\\Desktop\\newfileCreated.txt");
            File file=new File(Filename);
            /*If file gets created then the createNewFile()
             * method would return true or if the file is
             * already present it would return false
             */
            boolean fvar = file.createNewFile();
            if (fvar){
                System.out.println("File has been created successfully");
            }
            else{
                System.out.println("File already present at the specified location");
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
    }
}
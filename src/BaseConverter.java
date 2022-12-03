import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.Math.*;

/**
 *
 * converts base 2 to 16 numbers to a new number
 * @version 11/16/2022
 *  @author me
 *  */

public class BaseConverter {
    private final String DIGITS = "0123456789ABCDEF";
    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num the original number
     * @param fromBase the original from base
     * @return a base-10 int of num base fromBase
     */
    public int strToInt(String num, String fromBase) {
        // "FF" "16"
        int value = 0, exp=0;
        for(int i = num.length()- 1; i>=0;  i--) {
        value+=DIGITS.indexOf(num.charAt(i))* Math.pow(Integer.parseInt(fromBase), exp);
         exp++;
        }
        return value;
    }
    /**
     * Convert a int num in toBase to base-10 string.
     * @param num the original number
     * @param toBase the original to base
     * @return a base 10 string string
     */
    public String intToStr(int num, int toBase){
            String toNum = new String();
            int index =-1;
            while(num>0) {
                index = num % toBase;
                toNum = DIGITS.charAt(num % toBase) + toNum;
                num /= toBase;
            }
        return (toNum.equals("")) ? "0" : toNum;
    }


    /**
     * Reads in the contents of a datafile  and calls the strToInt and intToStr method converts the base.
     */
    public void inputConvertPrintWrite()    {
        Scanner in = null; //new Scanner(System.in);
        PrintWriter out = null;
        try{
            in= new Scanner(new File("datafiles/values30.dat"));
            out= new PrintWriter(new File("datafiles/converted.dat"));
            String [] line;
            String output;
            while(in.hasNext()){
                    line=in.nextLine().split("\t");
                    //System.out.println(line[0]);    // String num
                    //System.out.println(line[1]);    // String fromBase
                    //System.out.println(line[2]);    // String toBase
                    if (Integer.parseInt(line[1])<2 || Integer.parseInt(line[1])>16) {
                        System.out.println("Invalid input base "+ line[1]);
                    }
                    else if (Integer.parseInt(line[2])<2 || Integer.parseInt(line[2])>16) {
                        System.out.println("Invalid output base" + line[2]);
                    }
                    else {
                        output= intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2]));
                        out.println(line[0] +"\t" +line[1] +"\t" + output + "\t" + line[2]);
                        System.out.println(line[0] + " base " + line[1] + " = " +output + " base " + line[2]);
                    }
                }
            if(out != null)
                out.close();
            if(in != null );
                in.close();
            System.out.println("The revolution will not be televised.");
        }
        catch(Exception e) {
            System.out.println("Something bad happened. Details here: "+ e.toString());
        }
    }




    /**
     * main method for class base converter
     * @param args
     */
        public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        bc.inputConvertPrintWrite();
    }
}

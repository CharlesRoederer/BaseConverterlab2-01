import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.Math.*;

/**
 * Javadoc me
 */
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
        int value = 0, decimalBase;
        for(int i = num.length()- 1; i>=0;  i--) {

        }
        return value;
    }
    /**
     * Javadoc me
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase){
            String toNum = new String();
            if(num==0){
                return "0";
            }
                while(num>0)
                toNum+=DIGITS.indexOf(num%toBase);
                num-=toBase;
        return toNum;
    }


    /**
     * Javadoc me
     */
    public void inputConvertPrintWrite()    {
        Scanner in = new Scanner(System.in);
        PrintWriter out = null;
        try{
            in= new Scanner(new File("dataffiles/values10.dat"));
            out= new PrintWriter(new File("hello.txt"));
            while(in.hasNext()){
                out.println(in.nextLine());
            }
            if(out != null)
                out.close();
            if(in != null );
                in.close();
        }
        catch(Exception e) {
            System.out.println("Something bad happend. Detains here: "+ e.toString());
        }
    }




    /**
     * Javadoc me
     * @param args
     */
        public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        bc.inputConvertPrintWrite();
    }
}

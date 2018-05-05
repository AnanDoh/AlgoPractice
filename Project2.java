import java.io.*;
import java.util.*;

public class Project2 {

   public static String input1;
   public static String input2;
   public static String input3;    
   public static int d;
   public static int e;
   public static int f;
   public static int lenStr1;
   public static int lenStr2;
   public static int lenStr3;
    
    
    public static void main(String[] args) {
        Project2 project = new Project2();
        project.readfile();
        project.LCSL();
        project.LCS();
        System.out.println(LCS());
        
    }
    //reading file and saving each line to input
    public void readfile(){
      try {

            File f = new File("input2.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            input1 = readLine = b.readLine();
          //  System.out.println(input1);
            input2 = readLine = b.readLine();
           // System.out.println(input2);
            input3 = readLine = b.readLine();
           // System.out.println(input3);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    //lengths 
    public void LCSL(){
    
       d = input1.length()+1;
       lenStr1 = input1.length();
       //System.out.println(d);
       e = input2.length()+1;
       lenStr2 = input2.length();
      // System.out.println(e);
       f = input3.length()+1;
       lenStr3 = input3.length();
       //System.out.println(f);
    }    
    
    //create the 3d array
    //if ur in the first row for any of them(x,y,or z) fill that with zeros
    //if ur characters matches check its diagnols
    //and if they dont check its ones next to it
    public static int LCS(){  
        int LCS[][][] = new int[d][e][f];
        for(int x=0; x<=lenStr1; x++)
        {
            for(int y=0; y<=lenStr2; y++)
            {
                for(int z=0; z<=lenStr3; z++)
                {
                    if(x==0|| y==0|| z==0){
                        LCS[x][y][z] = 0;
                    }
                    else if(input1.charAt(x-1) == input2.charAt(y-1) && input1.charAt(x-1) ==
                            input3.charAt(z-1)){
                        LCS[x][y][z]= LCS[x-1][y-1][z-1]+1;
                    }
                    else{
                        int max;
                        max = Math.max(LCS[x-1][y][z], LCS[x][y-1][z]);
                        LCS[x][y][z]= Math.max(max,LCS[x][y][z-1]);
                    }
                }
            }
        }
        return LCS[d-1][e-1][f-1];
    }    
 
}

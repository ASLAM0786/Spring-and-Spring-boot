import java.util.*;
import java.io.*;
class SampleJava {
    public static int sum(int a, int b, int c = 0){
      return a+b+c;
    }
   public static void main(String[] arg){
      System.out.println("Hi");
      System.err.println(sum(1,2));
   }
}
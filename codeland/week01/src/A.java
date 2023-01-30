
/*
   A Moroccan Otaku was Fascinated by Anime and Japanese culture and he wanted to play a popular Japanese game called ÅtCoder,
   so he has decided to learn Japanese.
   When counting pencils in Japanese, the counter word "本" follows the number. The pronunciation of this word varies depending on the number.
   Specifically, the pronunciation of "本" in the phrase "N 本" for a positive integer N not exceeding 999 is as follows:

   "hon" when the digit in the one's place of N is 2, 4, 5, 7, or 9;

   "pon" when the digit in the one's place of N is 0, 1, 6 or 8;

   "bon" when the digit in the one's place of N is 3.

   Given N, print the pronunciation of "本" in the phrase "N 本".
   Input
   Input is given from Standard Input in the following format: N . N is a positive integer not exceeding 999.

   Output

   Print the answer.
   Examples

   16
   pon

   183
   bon
    */
import java.util.Scanner;
public class A {
    public static Scanner scanner = new Scanner(System.in);
    public static final String HON = "24579";
    public static final String PON = "0168";
    public static final String BON = "3";
    public static void main(String[] args) {
        int n = scanner.nextInt();
        String number = String.valueOf(n);
        char digitInTheOnesPlace = number.charAt(number.length() - 1);

       if(HON.contains(String.valueOf(digitInTheOnesPlace))){
           System.out.println("hon");
       }else if(PON.contains(String.valueOf(digitInTheOnesPlace))){
           System.out.println("pon");
       }else if(BON.contains(String.valueOf(digitInTheOnesPlace))){
           System.out.println("bon");
       }

       scanner.close();
    }
}

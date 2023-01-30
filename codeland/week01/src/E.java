
/*
    Kenza started her journey as a programmer, her first task was to write a simple program that would
    take a string as an input. The program should do the following: It should delete all the vowels in
    the string It should insert a "." before each consonant It should change all the uppercase consonants
    to their lowercase versions. Vowels are the letters "A", "O", "Y", "E", "U", "I" and the rest are
    consonants. The program's input is exactly one string, it should return the output as a single string,
    resulting after the program's processing the initial string.

    Help Kenza to complete this simple task.
    Input
    The first line represents input string of Petya's program. This string only consists of uppercase
    and lowercase Latin letters and its length is from 1 to 100, inclusive.

    Output
    Print the resulting string. It is guaranteed that this string is not empty.

    Examples

    Input
        tour
    Output
        .t.r

    Input
        Codeforces
    Output
        .c.d.f.r.c.s

    Input
        aBAcAba
    Output
        .b.c.b

 */
import java.util.Scanner;

public class E {
    public static Scanner scanner = new Scanner(System.in);
    public static String VOYELLES = "aeyuio";

    public static void main(String[] args){
        String input = scanner.nextLine();
        input = input.toLowerCase();
        String output = "";

        for(int i = 0; i < input.length(); ++i){
            //il s agit d une constante
            if(! VOYELLES.contains(String.valueOf(input.charAt(i)))){
                output += "." + input.charAt(i);
            }
        }

        System.out.println(output);

        scanner.close();
    }
}

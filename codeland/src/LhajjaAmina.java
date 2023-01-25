
/*
    Lhajja Amina talked so much, the whole town knew her secrets before she did. She finally found peace
    in our codeland where we delete unimportant characters. We have a string S consisting of lowercase
    English letters (what lhajja says). If the length of S is at most K, print S without change.
    If the length of S exceeds K, extract the first K characters in S, append ... to the end of them,
    and print the result.

    Input
    Input is given from Standard Input in the following format:
    K
    S

    Output
    Print a string as stated in Problem Statement.

    Examples
    Input
    7
    nikoandsolstice

    Output
    nikoand...

    Input
    40
    ferelibenterhominesidquodvoluntcredunt

    Output
    ferelibenterhominesidquodvoluntcredunt

 */

import java.util.Scanner;
public class LhajjaAmina {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        if(s.length() <= k){
            System.out.println(s);
        }else{
            System.out.println(s.substring(0, k)  + "...");
        }

        scanner.close();
    }
}

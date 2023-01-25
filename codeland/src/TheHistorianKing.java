
/*
    Once upon a time, there was a kingdom that was known for its love of history and its desire to
    understand the passage of time. The King of this kingdom was fascinated by the concept of centuries
    and he decided to find out the best way to determine in which century a specific year (N) belonged.

    What is century?
    A century is a period of 100 years. For example, the 1-st century consists of the years 1 through 100,
    the 2-nd century consists of the years 101 through 200, and so on.

    In what century is the year N ?

    Constraints :
    1≤N≤3000

    Input
    Input is given from Standard Input in the following format:
    N

    Output
    Print the answer as an integer.

    Examples
    Input
    2023

    Output
    21

    Input
    200

    Output
    2

    Note
    The year 200 is in the 2-nd century.
 */
import java.util.Scanner;
public class TheHistorianKing {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int annee = scanner.nextInt();

        //find the ceintury
        if(annee % 100 == 0){
            System.out.println(annee / 100);
        }else{
            System.out.println((annee / 100) + 1);
        }
        scanner.close();
    }
}

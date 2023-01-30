
/*
    In our CodeLand, there is a unique programming language called IEEE++. This language is known for
    its complexity and peculiarities.
    The language only has one variable, called I. There are two operations that can be performed on this
    variable: Operation ++ increases the value of variable I by 1. Operation −− decreases the value of
    variable Iby 1. A statement in language IEEE++ is a combination of exactly one operation and one
    variable y. The statement is written without spaces, that is, it can only contain characters "+", "-",
    "I". Executing a statement means applying the operation it contains.
    A programme in IEEE++ is a sequence of statements, each of which needs to be executed.
    Executing a programme means executing all the statements it contains.
    You are given a programme in the IEEE++ language. The initial value of Iis 0. Execute the programme
    and find its final value (the value of the variable when this programme is executed).

    Input
    The first line contains a single integer n (1≤n≤150)
    — the number of statements in the programme.
    Next n lines contain a statement each. Each statement contains exactly one operation (++ or −−) and
    exactly one variable i (denoted as letter «I»). Thus, there are no empty statements.
    The operation and the variable can be written in any order.

    Output
    Print a single integer — the final value of i.

    Examples
    Input
    1
    ++I

    Output
    1

    Input
    2
    --I
    I++

    Output
    0

 */
import java.util.Scanner;

public class D {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int lines = Integer.parseInt(scanner.nextLine());
        int somme = 0;
        String line = "";
        for(int i = 0; i < lines; ++i){
            line = scanner.nextLine();
            if(line.contains("++")){
                somme++;
            }else if(line.contains("--")){
                somme--;
            }
        }

        System.out.println(somme);

        scanner.close();
    }
}

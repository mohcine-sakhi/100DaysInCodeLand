/*
    Once upon a time, in a kingdom far, far away, there was a wise and just king who ruled over his people
    with fairness and compassion.
    One day, the king realized that his kingdom had become so prosperous that the people had grown
    complacent and lazy.
    He knew that he had to come up with a new challenge to test the mettle of his subjects. So, he
    summoned his most trusted advisors and asked them to devise a task that would be both challenging and
    rewarding.
    The advisors came up with an idea to create a sorted array of integers and to ask the people to find
    if there exists any pair of elements (A[i],A[j]) such that their sum is equal to X.
    The king was pleased with this idea and immediately ordered that the task be made available to all his
    subjects.
    And so, the people of the kingdom set to work, determined to prove their worth to their beloved king.
    Your task is to help peaople to solve this problem.

    Input
    The first line contains one integer n, the size of array A.
    The second line contains numbers a1,a2,…,an (−109≤a1≤a2≤...≤an≤109), separated by spaces — elements
    of array A.
    The third line contains the target number X.

    Output
    Print "YES" (without the quotes), if there exists any pair of elements (A[i],A[j]) that their sum is
    equal to X. Otherwise, print "NO" (without the quotes).

    Example
    Input
    7
    2 3 5 8 9 10 11
    17

    Output
    YES
 */

import java.util.Arrays;
import java.util.Scanner;

public class I {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[] numbers = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int x = Integer.parseInt(scanner.nextLine().trim());

        boolean isFound = false;
        /*
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(numbers[i] + numbers[j]);
                if ( numbers[i] + numbers[j] == x){
                    isFound = true;
                    break;
                }
            }
            //le 1 break ne permet que de quitter la boucle interne
            if(isFound){
                break;
            }
        }
        */

        //on exploite que le tableau est trie et on fait la somme des elements a l extremite
        // s il est grand on decremente s il petit on incremente juqu a tomber sur les 2 bons elements
        //ou bien les bornes vont s inverser au cas ou pas d elements qui satisfont la condition
        int borneInf = 0;
        int borneSup = n - 1;

        while(!isFound && borneInf < borneSup){
            if( numbers[borneInf] + numbers[borneSup] == x){
                isFound = true;
            }else if( numbers[borneInf] + numbers[borneSup] > x){
                borneSup--;
            }else {
                borneInf++;
            }
        }

        if (isFound) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}

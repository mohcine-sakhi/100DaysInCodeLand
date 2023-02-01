/*
    Ehaaaaaab loves number theory, but for some reason he hates the number x. Given an array A, find the
    length of its longest sub array such that the sum of its elements isn't divisible by x, or determine
    that such sub array doesn't exist.
    An array A is a sub array of an array B if A can be obtained from B by deletion of several (possibly,
    zero or all) elements from the beginning and several (possibly, zero or all) elements from the end.

    Input
    The first line contains an integer t (1≤t≤5) — the number of test cases you need to solve. The
    description of the test cases follows.
    The first line of each test case contains 2 integers n and x (1≤n≤105, 1≤x≤104) — the number of
    elements in the array and the number that Ehab hates.
    The second line contains n space-separated integers a1, a2, …, an (0≤ai≤104) — the elements of the
    array A.

    Output
    For each testcase, print the length of the longest sub array whose sum isn't divisible by x. If there's
    no such sub array, print −1.

    Examples
    Input
    3
    3 3
    1 2 3
    3 4
    1 2 3
    2 2
    0 6

    Output
    2
    3
    -1

    Note

    In the first test case, the subarray [2,3] has sum of elements 5, which isn't divisible by 3.
    In the second test case, the sum of elements of the whole array is 6, which isn't divisible by 4.
    In the third test case, all subarrays have an even sum, so the answer is −1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    public static final int NOT_FOUND = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine().trim());

        int[] infos;
        int[] numbers;

        for(int i = 0; i < cases; ++i){
            infos = intArray(reader.readLine().trim());
            int taille = infos[0];
            int x = infos[1];
            int length = 0;

            numbers = intArray(reader.readLine().trim());

            int sum = Arrays.stream(numbers).sum();

            if(sum % x != 0){
                length = taille;
            }else{
                int debut = 0;
                while(debut < taille  && numbers[debut] % x == 0 ){
                    debut++;
                }
                int fin = taille - 1;
                while (fin >= 0 && numbers[fin] % x == 0){
                    fin--;
                }
                if(debut == taille){
                    length = NOT_FOUND;
                }else {
                    length = Math.max(taille - 1 - debut, fin);
                }
            }

            if(length != 0){
                System.out.println(length);
            }else {
                System.out.println(NOT_FOUND);
            }

        }
        reader.close();
    }
    public static int[] intArray (String chaine){
        return Arrays.stream(chaine.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
    }
}


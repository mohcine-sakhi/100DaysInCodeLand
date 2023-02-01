/*
    Hossam woke up bored, so he decided to create an interesting array with his friend Hazem.
    Now, they have an array a of n positive integers, Hossam will choose a number ai and Hazem will choose a
    number aj.
    Count the number of interesting pairs (ai,aj) that meet all the following conditions:
    1≤i,j≤n;
    i≠j;
    The absolute difference |ai−aj| must be equal to the maximum absolute difference over all the pairs in the
    array. More formally, |ai−aj|=max1≤p,q≤n|ap−aq|.

    Input
    The input consists of multiple test cases. The first line contains a single integer t (1≤t≤100), which denotes
    the number of test cases. Description of the test cases follows.
    The first line of each test case contains an integer n (2≤n≤105).
    The second line of each test case contains n integers a1,a2,…,an (1≤ai≤105).
    It is guaranteed that the sum of n over all test cases does not exceed 105.

    Output
    For each test case print an integer — the number of interesting pairs (ai,aj).

    Example
    Input
    2
    5
    6 2 3 8 1
    6
    7 2 8 3 2 10

    Output
    2
    4

    Note
    In the first example, the two ways are:
    Hossam chooses the fourth number 8 and Hazem chooses the fifth number 1.
    Hossam chooses the fifth number 1 and Hazem chooses the fourth number 8.

    In the second example, the four ways are:
    Hossam chooses the second number 2  and Hazem chooses the sixth number 10.
    Hossam chooses the sixth number 10 and Hazem chooses the second number 2.
    Hossam chooses the fifth number 2 and Hazem chooses the sixth number 10.
    Hossam chooses the sixth number 10 and Hazem chooses the fifth number 2.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        long cases = Integer.parseInt(reader.readLine().trim());

        while (cases-- > 0){
            int n = Integer.parseInt(reader.readLine().trim());
            long[] a = new long[n];
            String[] inputs = reader.readLine().trim().split(" ");

            for(int i = 0; i < n; ++i){
                a[i] = Integer.parseInt(inputs[i]);
            }

           // on compte les occurrences des max et des min parce qu il represente les bornes de la plus grande
            // valeur absolue
            long max = Arrays.stream(a).max().getAsLong();
            long maxOccurrence = Arrays.stream(a).filter(val -> val == max).count();
            long min = Arrays.stream(a).min().getAsLong();
            long minOccurrence = Arrays.stream(a).filter(val -> val == min).count();

            // on verifie le cas ou le tableau ne contient qu un seul element

            System.out.println((maxOccurrence == minOccurrence && maxOccurrence == n)
                    ? maxOccurrence * (maxOccurrence - 1)
                    : maxOccurrence * minOccurrence * 2);
        }

        reader.close();
    }
}




/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine().trim());

        while (cases-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] a = new int[n];
            String[] inputs = reader.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputs[i]);
            }

            int maxAbsDiff = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    maxAbsDiff = Math.max(maxAbsDiff, Math.abs(a[i] - a[j]));
                }
            }

            int count = 0;
            for (int i = 0; i < n -1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(a[i] - a[j]) == maxAbsDiff) {
                        count++;
                    }
                }
            }
            System.out.println(count * 2);
        }
        reader.close();
    }
}
*/
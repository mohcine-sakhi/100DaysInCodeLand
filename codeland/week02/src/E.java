/*
    In 18,19 March. IEEE ENSIAS student branch is organizing their biggest event : IEEE Moroccan Congress.
    As part of this event , there will be a contest . There are n participants , participant i having a
    potential of Si.
    Every participant wonders how much of an advantage they have over the other best participant. In other
    words, each participant i wants to know the difference between Si and Sj, where j is the strongest
    participant in the competition, not counting i (a difference can be negative).
    So, they ask you for your help! For each i (1≤i≤n) output the difference between Si and the maximum
    strength of any participant other than participant i.

    Input
    The input consists of multiple test cases. The first line contains an integer t (1≤t≤1000) — the number
    of test cases. The descriptions of the test cases follow.
    The first line of each test case contains an integer n (2≤n≤2*10^5) — the length of the array.
    The following line contains n space-separated positive integers S1, S2, ..., Sn (1≤Si≤10^9) — the
    strengths of the participants.
    It is guaranteed that the sum of n over all test cases does not exceed 2*10^5.

    Output
    For each test case, output n space-separated integers. For each i (1≤i≤n) output the difference between
    Si and the maximum strength of any other participant.

    Examples
    Input
    5
    4
    4 7 3 5
    2
    1 2
    5
    1 2 3 4 5
    3
    4 9 4
    4
    4 4 4 4

    Copy
    -3 2 -4 -2
    -1 1
    -4 -3 -2 -1 1
    -5 5 -5
    0 0 0 0

    Note
    For the first test case:
    - The first participant has a strength of 4 and the largest strength of a participant different from
    the first one is 7, so the answer for the first participant is 4−7=−3.
    - The second participant has a strength of 7 and the largest strength of a participant different from
    the second one is 5, so the answer for the second participant is 7−5=2.
    - The third participant has a strength of 3 and the largest strength of a participant different from
    the third one is 7, so the answer for the third participant is 3−7=−4. The fourth participant has a
    strength of 5 and the largest strength of a participant different from the fourth one is 7, so the
    answer for the fourth participant is 5−7=−2.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine().trim());
        int i = 0;
        while (i < cases){
            int taille = Integer.parseInt(reader.readLine().trim());
            int[] participants = intArray(reader.readLine().trim());

            int max =  Arrays.stream(participants).max().getAsInt();
            //on cherche le second max element
            int indexOfMax = IntStream.range(0, taille).filter(val -> participants[val] == max).findFirst().getAsInt();

            participants[indexOfMax] = Integer.MIN_VALUE;

            int max2 =  Arrays.stream(participants).max().getAsInt();
            participants[indexOfMax] = max;

            for(int val : participants){
                if(val != max){
                    System.out.print(val - max + " ");
                }else{
                    System.out.print(max - max2 + " ");
                }
            }
            System.out.println("");
            ++i;
        }
        reader.close();
    }

    public static int[] intArray (String chaine){
        return Arrays.stream(chaine.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
    }
}

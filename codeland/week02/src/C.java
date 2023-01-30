/*
    ENSIAS senior student wants to organize a Bizutage event for their new bizus , they wanted to organize
    an activity with balloons , balloons are distributed as follows:
    Whenever a team solves a problem, that team gets a balloon. The first team to solve a problem gets an
    additional balloon. a contest has 26 problems, labelled A, B , C , ..., Z . You are given the order of
    solved problems in the contest, denoted as a string s , where the i-th character indicates that the
    problem Si has been solved by some team. No team will solve the same problem twice. Determine the total
    number of balloons that the teams received. Note that some problems may be solved by none of the teams.

    Input
    The first line of the input contains an integer t (1≤t≤100 ) — the number of testcases.
    The first line of each test case contains an integer n (1≤n≤50) — the length of the string.
    The second line of each test case contains a string s of length n consisting of uppercase English
    letters, denoting the order of solved problems.

    Output
    For each test case, output a single integer — the total number of balloons that the teams received.

    Examples
    Input
    6
    3
    ABA
    1
    A
    3
    ORZ
    5
    BAAAA
    4
    BKPT
    10
    CODEFORCES

    Output
    5
    2
    6
    7
    8
    17

    Note
    In the first test case, 5 balloons are given out:
    Problem A is solved. That team receives 2 balloons: one because they solved the problem, an additional
    one because they are the first team to solve problem A . Problem B is solved. That team receives 2
    balloons: one because they solved the problem, an additional one because they are the first team to
    solve problem B . Problem A is solved. That team receives only 1 balloon, because they solved the
    problem. Note that they don't get an additional balloon because they are not the first team to solve
    problem A. The total number of balloons given out is 2+2+1=5.
    In the second test case, there is only one problem solved. The team who solved it receives 2 balloons:
    one because they solved the problem, an additional one because they are the first team to solve
    problem A.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine().trim());
        int cas = 0;

        while (cas < cases){
            int balloons = 0;
            int n = Integer.parseInt(reader.readLine().trim());
            String problems = reader.readLine().trim();
            List<Character> problesList = problems.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            while (problesList.size() > 0){
                char first = problesList.get(0);
                int count = (int) problesList.stream().filter(c -> c == first).count();
                //on ajoute la 1 car la 1 equipe qui resout le probleme gagne 2 balloons
                balloons += count + 1;
                // on supprime le probleme traite
                problesList.removeIf(c -> c == first);
            }
            System.out.println(balloons);
            cas++;
        }

        reader.close();
    }
}

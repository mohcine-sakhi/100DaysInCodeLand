
/*
    A student named Ahmed is in the final year of CPGE. One day, Ahmed decided to watch a match of his
    favorite basketball team. And, as the student loves basketball very much, even more than maths, he
    forgot to do his homework. Specifically, he forgot to complete his math assignments. The next day the
    professor got very angry at Ahmed and decided to teach him a lesson. He gave the lazy student a
    seemingly easy task: You are given an object at rest on a frictionless surface and the forces that
    affect it. The object can be considered as a point mass with coordinates (0, 0). Ahmed had only to
    answer whether it is in equilibrium. "Easy peasy" — thought Ahmed, we need only to check if the sum of
    all vectors is equal to 0. So, Ahmed began to solve the problem. But later it turned out that there
    can be lots and lots of these forces, and Ahmed can not cope without your help. Help him. Write a
    program that determines whether the object is at rest or in motion by the given vectors of forces.

    Input
    The first line contains a positive integer n (1≤n≤100), then follow n lines containing three integers
    each: the xi coordinate, the yi coordinate and the zi coordinate of the force vector, applied to the
    body (-100≤xi,yi,zi≤100).

    Output
    Print the word "YES" if the body is in equilibrium, or the word "NO" if it is not.

    Examples

    Input
    3
    4 1 7
    -2 4 -1
    1 -5 -3

    Output
    NO

    Input
    3
    3 -1 7
    -5 2 -4
    2 -1 -3

    Output
    YES
 */
import java.util.Arrays;
import java.util.Scanner;

public class G {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int forces = Integer.parseInt(scanner.nextLine().trim());

        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < forces; ++i){
            x += scanner.nextInt();
            y += scanner.nextInt();
            z += scanner.nextInt();
            //retourner a la ligne
            scanner.nextLine();
        }
        System.out.println((x == 0 && y == 0 && z == 0) ? "YES" : "NO");

     /*
        int sum = 0;
        for (int i = 0; i < forces; i++) {
            sum += Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(val -> Integer.parseInt(val)).sum();
            System.out.println(sum);
        }
        System.out.println((sum == 0) ? "YES" : "NO");

      */
        scanner.close();
    }
}

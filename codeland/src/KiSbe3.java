
/*
    Lioness Lila wants to become the largest lion in the pride, or at least to become larger than her
    sister Lily.
    Right now, Lila and Lily weigh x and y respectively. It's guaranteed that Lila's weight is smaller
    than or equal to her sister's weight.
    Lila eats a lot and her weight is tripled after every year, while Lily's weight is doubled after every
    year.
    After how many full years will Lila become strictly larger (strictly heavier) than Lily?

    Input
    The only line of the input contains two integers a and b (1≤a≤b≤10) — the weight of Lila and the
    weight of Lily respectively.

    Output
    Print one integer, denoting the integer number of years after which Lila will become strictly larger
    than Lily.

    Examples

    Input
    4 7
    Output
    2
    Input
    4 9
    Output
    3
    Input
    1 1
    Output
    1

    Note
    In the first sample, Lila weighs 4 and Lily weighs 7 initially. After one year their weights are
    4·3=12 and 7·2=14 respectively . Lila isn't larger than Lily yet. After the second year weights are 36
    and 28, so the first weight is greater than the second one. Lila became larger than Lily after two
    years so you should print 2.
 */
import java.util.Scanner;

public class KiSbe3 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int lilaWeight = scanner.nextInt();
        int lilyWeight = scanner.nextInt();
        int annee = 0;
        do{
            annee++;
            lilaWeight *= 3;
            lilyWeight *= 2;
        }while (lilaWeight <= lilyWeight);

        System.out.println(annee);
        scanner.close();
    }
}

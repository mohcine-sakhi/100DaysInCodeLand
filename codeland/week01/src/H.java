
/*
    Last Friday, Salma and her friend Amal decided to cook Couscous for lunch and they needed a pumpkin.
    They picked the largest and most ripe one. After it was weighed, the scale showed W kilos. Excited to
    cook this couscous they began to cut this pumpkin until they faced a difficult dilemma.
    Salma and Amal are big fans of even numbers and wanted to divide the pumpkin in such a way that each
    of the two parts weighed an even number of kilos, while it was not necessary for the parts to be equal.
    As they were both famished, they wanted to start their meal as soon as possible, so they asked for your
    help to find out if they can divide the pumpkin in the way they want, ensuring that each of them gets
    a part of positive weight.

    Input
    The first (and the only) input line contains integer number w   (1≤w≤100) — the weight of the pumpkin
    bought by the girls.

    Output
    Print YES, if the girls can divide the pumpkin into two parts, each of them weighing even number of
    kilos; and NO in the opposite case.

    Examples
    Input
    8
    Output
    YES

    Note
    For example, the girls can divide the pumpkin into two parts of 2 and 6 kilos respectively
    (another variant — two parts of 4 and 4 kilos).
 */
import java.util.Scanner;

public class H {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double pumpkin = Integer.parseInt(scanner.nextLine());

        System.out.println((pumpkin == 2 || pumpkin % 2 == 1) ? "NO" : "YES");
        scanner.close();
    }
}

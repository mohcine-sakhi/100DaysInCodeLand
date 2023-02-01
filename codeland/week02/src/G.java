/*
    m chairs are arranged in a circle sequentially. The chairs are numbered from 0 to m−1. n people want to sit in
    these chairs. The i-th of them wants at least a[i] empty chairs both on his right and left side.
    More formally, if the i-th person sits in the j-th chair, then no one else should sit in the following chairs:
    (j−a[i]) mod m, (j−a[i]+1) mod m, ... (j+a[i]−1) mod m , (j+a[i]) mod m.
    Decide if it is possible to sit down for all of them, under the given limitations.

    Input
    The input consists of multiple test cases. The first line contains a single integer t (1≤t≤5⋅10e4) — the number
    of test cases. The description of the test cases follows.
    The first line of each test case contains two integers n and m (2≤n≤10e5, 1≤m≤10e9) — the number of people and the
    number of chairs.
    The next line contains n integers, a1, a2, ... an (1≤ai≤10e9) — the minimum number of empty chairs, on both sides
    of the i-th person.
    It is guaranteed that the sum of n over all test cases will not exceed 105.

    Output
    For each test case print "YES" (without quotes) if it is possible for everyone to sit down and fulfil the
    restrictions, and "NO" (without quotes) otherwise.
    You may print every letter in any case you want (so, for example, the strings "yEs", "yes", "Yes" and "YES" will
    all be recognized as positive answers).

    Example
    Input
    6
    3 2
    1 1 1
    2 4
    1 1
    2 5
    2 1
    3 8
    1 2 1
    4 12
    1 2 1 3
    4 19
    1 2 1 3

    Output
    NO
    YES
    NO
    YES
    NO
    YES

    Note
    Test case 1: n>m, so they can not sit down.

    Test case 2: the first person can sit 2-nd and the second person can sit in the 0-th chair. Both of them want at
    least 1 empty chair on both sides, chairs 1 and 3 are free, so this is a good solution.

    Test case 3: if the second person sits down somewhere, he needs 2 empty chairs, both on his right and on his left
    side, so it is impossible to find a place for the first person, because there are only 5 chairs.

    Test case 4: they can sit in the 1-st, 4-th, 7-th chairs respectively.
 */
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class G {
    public static final int LIBRE = 0;
    public static final int RESERVEE = 1;
    public static final int OCCUPEE = 2;
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int cases = Integer.parseInt(reader.readLine().trim());
            String[] tab;
            int[] emptyChairs;
            int[] chairs;
            while (cases-- > 0){
                tab = reader.readLine().trim().split(" ");
                int people = Integer.parseInt(tab[0]);
                int chairsNumber = Integer.parseInt(tab[1]);
                //on trie le tableau pour traiter en 1 la personne qui demande le plus de places libres
                emptyChairs = Arrays.stream(reader.readLine().trim().split(" "))
                                    .map(Integer::valueOf).sorted(Collections.reverseOrder())
                                    .mapToInt(Integer::intValue).toArray();

                if(chairsNumber < people){
                    System.out.println("NO");
                }else{
                    //on initialise le tableau des chaises avec des places libres
                    //la personne vient s assoir, elle cherche la 1 place libre et verifie si elle peu s assoir
                    chairs = new int[chairsNumber];
                    //System.out.println(Arrays.toString(chairs));
                    boolean isPossible = true;
                    int whereToSit = 0;
                    //on commence par la fin du tableau parce que le tableau est trie dans un ordre croissant
                    for(int i = 0; isPossible && i < people; i++){
                        int free = emptyChairs[i];
                            if(whereToSit != -1 && canSit(chairs, whereToSit, free)){
                                whereToSit = sitAndReservePlaces(chairs, whereToSit, free);
                                //System.out.println(Arrays.toString(chairs));
                            }else {
                                isPossible = false;
                            }
                    }

                    if (isPossible) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }

        }catch (IOException e ){
            e.printStackTrace();
        }
    }

   //verifier si une personne qui doit s'assoir a la place p a free place libre a droite et a gauche
    public static boolean canSit(int[] tab, int place, int free){
        // on verifie si la place courante est deja reservee ou bien les places a reservee sont deja occupee
        //parce qu on peut reserver une place deja reservee
        for(int i = 1; i <= free; ++i){
            if(tab[(place) ] == RESERVEE || tab[(place + i) ] == OCCUPEE){
                return false;
            }
        }
        return true;
    }
    public static int sitAndReservePlaces(int[] tab, int place, int free){
        tab[place] = OCCUPEE;
        // a partir de la 2 personne on reserve des places seulement a droite parce que celles de gauche sont deja
        // reservee puisque le tableau des chaises est deja trie
        int len = tab.length;
        if(place == 0){
            for(int i = 1; i <= free; ++i){
                tab[((place - i) + len) % len] = RESERVEE;
                tab[(place + i) % len] = RESERVEE;
            }
        }else{
            for(int i = 1; i <= free; ++i){
                tab[(place + i) % len] = RESERVEE;
            }
        }
       // on retourne la position disponible apres la reservation
       return (place + free + 1 < len) ? place + free + 1 : -1;
    }

}
*/
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {
    public static final int LIBRE = 0;
    public static final int RESERVEE = 1;
    public static final int OCCUPEE = 2;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int cases = Integer.parseInt(reader.readLine().trim());
            String[] tab;
            int[] emptyChairs;
            int[] chairs;
            while (cases-- > 0) {
                tab = reader.readLine().trim().split(" ");
                int people = Integer.parseInt(tab[0]);
                int chairsNumber = Integer.parseInt(tab[1]);
                emptyChairs = Arrays.stream(reader.readLine().trim().split(" "))
                        .mapToInt(i -> Integer.parseInt(i)).toArray();

                if (chairsNumber < people) {
                    System.out.println("NO");
                } else {
                    // sort the emptyChairs array in descending order
                    Arrays.sort(emptyChairs);
                    chairs = new int[chairsNumber];

                    boolean isPossible = true;
                    int i = emptyChairs.length - 1;
                    while (isPossible && i >= 0) {
                        int free = emptyChairs[i];
                        int whereToSit = whereToSit(chairs, free);
                        if (whereToSit == -1) {
                            i--;
                        } else {
                            sitAndReservePlaces(chairs, whereToSit, free);
                            people--;
                        }
                    }

                    if (people == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int whereToSit(int[] tab, int free) {
        int place = -1;
        int len = tab.length;
        for (int i = 0; i < len; i++) {
            if (canSit(tab, i, free)) {
                place = i;
                break;
            }
        }
        return place;
    }

    public static boolean canSit(int[] tab, int place, int free) {
        int len = tab.length;
        for (int i = 1; i <= free; ++i) {
            if (tab[((place - i) + len) % len] == OCCUPEE ||
                    tab[(place + i) % len] == OCCUPEE) {
                return false;
            }
        }
        return true;
    }

    public static boolean canSit(int[] tab, int place, int free){
        int maxDistance = 0;
        int freeSeats = 0;
        for (int i = 1; i <= free; ++i) {
            int leftSeat = ((place - i) + tab.length) % tab.length;
            int rightSeat = (place + i) % tab.length;
            maxDistance = i;
            if (tab[leftSeat] == OCCUPEE || tab[rightSeat] == OCCUPEE) {
                return false;
            }
            if (tab[leftSeat] == LIBRE) {
                freeSeats++;
            }
            if (tab[rightSeat] == LIBRE) {
                freeSeats++;
            }
            if (freeSeats < maxDistance) {
                return false;
            }
        }
        return true;
    }
    /*
    public static void sitAndReservePlaces(int[] tab, int place, int free) {
        tab[place] = OCCUPEE;
        int len = tab.length;
        for (int i = 1; i <= free; ++i) {
            tab[((place - i) + len) % len] = RESERVEE;
            tab[(place + i) % len] = RESERVEE;
        }
    }

    public static void sitAndReservePlaces(int[] tab, int place, int free) {
        tab[place] = OCCUPEE;
        int bitmap = (1 << (2 * free + 1)) - 1;
        for (int i = 0; i <= free; ++i) {
            tab[(place + i) % tab.length] |= bitmap & (3 << (2 * i));
            tab[((place - i) + tab.length) % tab.length] |= bitmap & (3 << (2 * i));
        }
    }
}
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class G {
    public static final int LIBRE = 0;
    public static final int RESERVEE = 1;
    public static final int OCCUPEE = 2;
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int cases = Integer.parseInt(reader.readLine().trim());
            String[] tab;
            int[] emptyChairs;
            int[] chairs;
            while (cases-- > 0){
                tab = reader.readLine().trim().split(" ");
                int people = Integer.parseInt(tab[0]);
                int chairsNumber = Integer.parseInt(tab[1]);
                //on trie le tableau pour traiter en 1 la personne qui demande le plus de places libres
                emptyChairs = Arrays.stream(reader.readLine().trim().split(" "))
                        .map(Integer::valueOf).sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue).toArray();

                int placeCourante = 0;
                int fin = chairsNumber - emptyChairs[0];
                boolean isPossible = true;
                int i = 0;

                while (isPossible && i < people){
                    // on verifie que la place courante n est pas deja occupee et les places a reserver ne depassent pas la limite
                    if(placeCourante < fin && placeCourante + emptyChairs[i] < chairsNumber){
                        placeCourante += emptyChairs[i] + 1;
                    }else {
                        isPossible = false;
                    }
                    ++i;
                }

                if (isPossible) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}


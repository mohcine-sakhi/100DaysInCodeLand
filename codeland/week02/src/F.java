
/*
    Doubly linked list is one of the fundamental data structures. A doubly linked list is a sequence of elements, each
    containing information about the previous and the next elements of the list. In this problem all lists have linear
    structure. I.e. each element except the first has exactly one previous element, each element except the last has
    exactly one next element. The list is not closed in a cycle.
    In this problem you are given n memory cells forming one or more doubly linked lists. Each cell contains information
    about element from some list. Memory cells are numbered from 1 to n.
    For each cell i you are given two values:
    li — cell containing previous element for the element in the cell i;
    ri — cell containing next element for the element in the cell i.
    If cell i contains information about the element which has no previous element then li=0. Similarly, if cell i
    contains information about the element which has no next element then ri=0.

    6 -> 4 -> 1 -> 7        3           5 -> 2
    Three lists are shown on the picture.
    For example, for the picture above the values of l and r are the following: l1=4, r1=7; l2=5, r2=0; l3=0, r3=0;
    l4=6, r4=1; l5=0, r5=2; l6=0, r6=4; l7=1, r7=0.

    Your task is to unite all given lists in a single list, joining them to each other in any order. In particular, if
    the input data already contains a single list, then there is no need to perform any actions. Print the resulting
    list in the form of values li, ri.
    Any other action, other than joining the beginning of one list to the end of another, can not be performed.

    Input
    The first line contains a single integer n (1≤n≤100) — the number of memory cells where the doubly linked lists are
    located.
    Each of the following n lines contains two integers li, ri (0≤li,ri≤n) — the cells of the previous and the next
    element of list for cell i. Value li=0 if element in cell i has no previous element in its list. Value ri=0 if
    element in cell i has no next element in its list.
    It is guaranteed that the input contains the correct description of a single or more doubly linked lists. All lists
    have linear structure: each element of list except the first has exactly one previous element; each element of list
    except the last has exactly one next element. Each memory cell contains information about one element from some list,
    each element of each list written in one of n given cells.

    Output
    Print n lines, the i-th line must contain two integers li and ri — the cells of the previous and the next element of
    list for cell i after all lists from the input are united in a single list. If there are many solutions print any of
    them.

    Example
    Input
    7
    4 7
    5 0
    0 0
    6 1
    0 2
    0 4
    1 0

    Output
    4 7
    5 6
    0 5
    6 1
    3 2
    2 4
    1 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class F {
    public static void main(String[] args){

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int cases = Integer.parseInt(reader.readLine().trim());
            Cell[] cells = new Cell[cases];
            ArrayList<Integer> indexes = new ArrayList<>();
            int[] infos;
            int i = 0;
            while (i < cases){
                infos = Arrays.stream(reader.readLine().trim().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int value = i + 1;
                int previous = infos[0];
                int next = infos[1];
                //on garde les cells de debut
                if(previous == 0){
                    indexes.add(i);
                }

                Cell cell = new Cell(value, previous, next);
                cells[i] = cell;
                ++i;
            }
            for (int j = 0; j < indexes.size() - 1; ++j){
                Cell cell = cells[indexes.get(j)];
                while(cell.getNext() != 0){
                    cell = cells[cell.getNext() - 1];
                }
                cell.setNext(cells[indexes.get(j + 1)].getValue());
                cells[indexes.get(j + 1)].setPrevious(cell.getValue());
            }

            for (Cell cell : cells){
                System.out.println(cell);
            }
        }catch (IOException e ){
            e.printStackTrace();
        }

    }
}

class Cell{
     private int value;
     private int previous;
     private int next;

     public Cell(int value, int previous, int next){
         this.value = value;
         this.previous = previous;
         this.next = next;
     }

     public void setPrevious(int previous){
         this.previous = previous;
     }
     public int getPrevious(){
         return this.previous;
     }

    public void setNext(int next){
        this.next = next;
    }
    public int getNext(){
        return this.next;
    }

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }

    public String toString(){
         return previous + " " + next;
    }
}
/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cells = new int[n][2];
        Integer[] firstCell = new Integer[n + 1];
        Integer[] lastCell = new Integer[n + 1];
        for (int i = 0; i < n; i++) {
            cells[i][0] = sc.nextInt();
            cells[i][1] = sc.nextInt();
            if (cells[i][0] == 0) {
                firstCell[i + 1] = i + 1;
            }
            if (cells[i][1] == 0) {
                lastCell[i + 1] = i + 1;
            }
        }
        Integer first = null;
        for (int i = 0; i < n; i++) {
            if (firstCell[i + 1] != null) {
                if (first == null) {
                    first = i + 1;
                    continue;
                }
                lastCell[first] = i + 1;
                firstCell[i + 1] = first;
                first = null;
            }
        }
        for (int i = 0; i < n; i++) {
            if (lastCell[i + 1] != null) {
                cells[i][0] = lastCell[i + 1];
            }
            if (firstCell[i + 1] != null) {
                cells[i][1] = firstCell[i + 1];
            }
        }
        for (int[] cell : cells) {
            System.out.println(cell[0] + " " + cell[1]);
        }
        sc.close();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (l[i] == 0) {
                int j = i;
                while (r[j] != 0) {
                    j = r[j];
                }
                r[j] = i;
                l[i] = j;
            }
        }

        int head = 1;
        while (l[head] != 0) {
            head = l[head];
        }

        for (int i = head; i != 0; i = r[i]) {
            System.out.println(l[i] + " " + r[i]);
        }
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        boolean[] processed = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (!processed[i]) {
                int j = i;
                while (r[j] != 0 && !processed[r[j]]) {
                    j = r[j];
                }
                processed[j] = true;
                processed[i] = true;
                r[j] = i;
                l[i] = j;
            }
        }

        int head = 1;
        while (l[head] != 0) {
            head = l[head];
        }

        for (int i = head; i != 0; i = r[i]) {
            System.out.println(l[i] + " " + r[i]);
        }
    }
}

 */



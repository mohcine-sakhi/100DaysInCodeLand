/*
    A new e-mail service "Berlandesk" is going to be opened in Berland in the near future. The site
    administration wants to launch their project as soon as possible, that's why they ask you to help.
    You're suggested to implement the prototype of site registration system. The system should work on
    the following principle.

    Each time a new user wants to register, he sends to the system a request with his name. If such a
    name does not exist in the system database, it is inserted into the database, and the user gets the
    response OK, confirming the successful registration. If the name already exists in the system database,
    the system makes up a new user name, sends it to the user as a prompt and also inserts the prompt into
    the database. The new name is formed by the following rule. Numbers, starting with 1, are appended one
    after another to name (name1, name2, ...), among these numbers the least i is found so that namei does
    not yet exist in the database.

    Input
    The first line contains number n (1≤n≤105). The following n lines contain the requests to the system.
    Each request is a non-empty line, and consists of not more than 32 characters, which are all lowercase
    Latin letters.

    Output
    Print n lines, which are system responses to the requests: OK in case of successful registration, or a
    prompt with a new name, if the requested name is already taken.

    Examples
    Input
    4
    abacaba
    acaba
    abacaba
    acab

    Output
    OK
    OK
    abacaba1
    OK

    Input
    6
    first
    first
    second
    second
    third
    third

    Output
    OK
    first1
    OK
    second1
    OK
    third1
 */
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesNumber = Integer.parseInt(reader.readLine().trim());
        String[] lines = new String[linesNumber];
        //NavigableSet<String> lines = new TreeSet<>();

        int i = 0;
        String name;
        while (i < linesNumber){
            name = reader.readLine().trim();

            if(!exits(lines, i, name)){
                lines[i] = name;
                System.out.println("ok");
            }else{
                int index = findLastIndex(lines, i, name);
                lines[i] = name + (index + 1);
                System.out.println(lines[i]);
            }

            if(lines.add(name)){
                System.out.println("ok");
            }else{

            }

            i++;
        }
        //System.out.println(Arrays.toString(lines)

        reader.close();
    }

    public static boolean exits(String[] words, int end, String word){
        for(int i = 0; i < end; ++i){
            if(word.equals(words[i])){
                return true;
            }
        }
        return false;
    }

    public static int findLastIndex(String[] words, int end, String word){
        int index = 0;
            for(int i = end - 1; i >= 0; --i){
                // on verifie si une chaine du tableau contient le mot cherche + un chiffre
                if(words[i].startsWith(word)){
                    if(words[i].equals(word)){
                        return 0;
                    }
                    try{
                        return Integer.parseInt(words[i].substring(word.length()));
                    }catch (NumberFormatException e){
                        continue;
                    }
                }
            }
        return index;
    }
}
 */
/*
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            if (names.contains(name)) {
                int j = 1;
                while (names.contains(name + j)) {
                    j++;
                }
                names.add(name + j);
                System.out.println(name + j);
            } else {
                names.add(name);
                System.out.println("OK");
            }
        }
    }
}

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        //HashSet<String> names = new HashSet<>();
        HashMap<String, Integer> names = new HashMap<>();
        String name;
        for(int i = 0; i < n; ++i){
            name = reader.readLine().trim();
            if(! names.containsKey(name)){
                System.out.println("OK");
                names.put(name, 1);
            }else {
                System.out.println(name + names.get(name));
                names.put(name, names.get(name) + 1);

            }
        }
    }
}



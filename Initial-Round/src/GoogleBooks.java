import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GoogleBooks {
    public static void main(String[] args) {
        // taking inputs
        int B ; int L; int D;
        String filename = "a_example.txt";
        try {
            File inputFile = new File(filename);
            Scanner reader = new Scanner(inputFile);

            //taking BLD values
            String line1 = reader.nextLine();
            String[] split_line1 = line1.split(" ");
            ArrayList<Integer> int_split_line1 = new ArrayList<Integer>();
            for(String s : split_line1) int_split_line1.add(Integer.valueOf(s));
            B = int_split_line1.get(0); L = int_split_line1.get(1); D = int_split_line1.get(2);

            //taking book scores
            String line2 = reader.nextLine();
            String[] split_line2 = line2.split(" ");
            ArrayList<Integer> book_scores = new ArrayList<Integer>();
            for(String s : split_line2) book_scores.add(Integer.valueOf(s));

            // going through each library
            ArrayList<Library> libraries = new ArrayList<>();
            ArrayList<Integer> library_costs = new ArrayList<>();
            int x = 0;
            for (int l = 0; l < L; l++){
                //library data
                String library = reader.nextLine();
                String[] split_library = library.split(" ");
                ArrayList<Integer> int_library = new ArrayList<Integer>();
                for(String s : split_library) int_library.add(Integer.valueOf(s));
                int b = int_library.get(0); int p = int_library.get(1); int s = int_library.get(2);
                int c = b - ( D - p )*s; // calculates the libraries score
                library_costs.add(c);
                x += p;
                //library's books
                String lib_books = reader.nextLine();
                String[] split_lib_books = lib_books.split(" ");
                ArrayList<Integer> l_books = new ArrayList<Integer>();
                for(String sl : split_lib_books) l_books.add(Integer.valueOf(sl));
                Library new_library = new Library(c, b, p, s ,l_books);
                libraries.add(new_library);
            }

            // books_scores_sorted_indexes
            int[] indexes = new int[book_scores.size()];
            ArrayList<Integer> unsorted_book_scores = new ArrayList<>(book_scores);
            Collections.sort(book_scores);
            int i = 0;
            for (int book: book_scores){
                indexes[i] = unsorted_book_scores.indexOf(book);
                i++;
            }

            //library taking order
            int[] library_indexes = new int[library_costs.size()];
            ArrayList<Integer> unsorted_costs = new ArrayList<>(library_costs);
            Collections.sort(library_costs);
            int j = 0;
            for (int lib_cost: library_costs){
                library_indexes[j] = unsorted_costs.indexOf(lib_cost);
                j++;
            }

            // creating the timetable
            String[][] table = new String[L][D];
            int d = 0;
            int d_before = 0;
            for (int l = 0; l < L; l++) {
                while (d < d_before + libraries.get(L-1-l).getP()){
                    table[l][d] = "#";
                    d ++;
                }
                d_before = d;
            }

            System.out.println(Arrays.toString(indexes));
            System.out.println(Arrays.toString(library_indexes));
            System.out.println(libraries.toString());
            for (String[] row: table){
                System.out.println(Arrays.toString(row));
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Library{
    int c; int b; int p; int s; ArrayList<Integer> l_books;

    Library(int c, int b, int p, int s, ArrayList<Integer> l_books){
        this.b = b; this.c = c; this.p = p; this.l_books = l_books;
    }
    public int getP(){ return p; }
    public int getC(){ return c; }
    public int getS(){ return s; }
    public ArrayList<Integer> getBooks(){ return l_books; }



}

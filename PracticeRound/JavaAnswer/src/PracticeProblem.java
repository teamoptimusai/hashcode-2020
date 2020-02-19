import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PracticeProblem {
    public static void main(String[] args) {
        //taking inputs
        ArrayList<ArrayList<Integer>> inputs = takeInputs();
        int n_people = inputs.get(0).get(0); // no of people to feed
        int n_types_pizza = inputs.get(0).get(1); // different types of pizza
        ArrayList<Integer> pizza_slices = inputs.get(1); // slices of each different type of pizza
        //dynamic programming graph
        print_graph(n_people, n_types_pizza, graph(n_people, n_types_pizza, pizza_slices));


    }
    //Input Function
    public static ArrayList<ArrayList<Integer>> takeInputs(){
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String[] split_line1 = line1.split(" ");
        ArrayList<Integer> int_split_line1 = new ArrayList<Integer>();
        for(String s : split_line1) int_split_line1.add(Integer.valueOf(s));

        String line2 = scanner.nextLine();
        String[] split_line2 = line2.split(" ");
        ArrayList<Integer> int_split_line2 = new ArrayList<Integer>();
        for(String s : split_line2) int_split_line2.add(Integer.valueOf(s));

        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        inputs.add(int_split_line1); inputs.add(int_split_line2);
        return inputs;
    }

    //dynamic programming graph
    public static int[][] graph(int n_people, int n_types_pizza, ArrayList<Integer> pizza_slices){
        int[][] results = new int[n_types_pizza + 1][n_people+1];

        for (int i = 1; i < n_types_pizza + 1; i++){
            results[i][0] = pizza_slices.get(i-1)  ;
        } // row titles
        for (int i = 1; i <= n_people; i++){
            results[0][i] = i ;
        } //col_titles

        for (int i = 1; i < n_types_pizza + 1 ; i++) {
            for (int j = 1; j < n_people + 1; j++) {
                if (i > 1){
                    int upper = results[i-1][j];
                    int next = 0;
                    if (results[i][0] < results[0][j]){
                        next = results[i][0] + results[i-1][results[0][j] - results[i][0]];
                    }
                    int[] max_list = {upper,next};
                    Arrays.sort(max_list);
                    results[i][j] = max_list[max_list.length - 1];


                }else{
                    if (results[i][0] <= results[0][j]){
                        results[i][j] = results[i][0];
                    }
                }
            }

        }

        return results;
    }
    //print the graph
    public static void print_graph(int n_people, int n_types_pizza, int[][] graph){
        for (int i = 0; i < n_types_pizza + 1 ; i++) {
            for (int j = 0; j < n_people + 1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

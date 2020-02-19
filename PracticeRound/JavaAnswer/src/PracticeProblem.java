import java.util.ArrayList;
import java.util.Scanner;


public class PracticeProblem {
    public static void main(String[] args) {
        //taking inputs
        ArrayList<ArrayList<Integer>> inputs = takeInputs();
        int n_people = inputs.get(0).get(0); // no of people to feed
        int n_types_pizza = inputs.get(0).get(1); // different types of pizza
        ArrayList<Integer> pizza_slices = inputs.get(1); // slices of each different type of pizza
        //dynamic programming graph
        



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
}

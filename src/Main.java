import java.util.*;

public class Main {

    public static ArrayList<Integer> randomComboGenerator() {
        //generates random combination
        ArrayList<Integer> combination = new ArrayList<>(4);
        Random randomNum = new Random();
        int limit = 0;
        while (limit < 4) { //4 number combination
            int number = randomNum.nextInt(10);
            if (!combination.contains(number)) { //no duplicates in arraylist (consider using set instead)
                combination.add(number);
                limit++;
            }
        }
        return combination;
    }

    public static void printCorrectPosition(int position, ArrayList<Integer> scans, ArrayList<Integer> combination) {
        if (Objects.equals(scans.get(position), combination.get(position))) {
            System.out.println(scans.get(position) + " is in the correct position");
        }
        else if (combination.contains(scans.get(position))) {
            System.out.println(scans.get(position) + " is located somewhere in the combination");
        }
    }

    public static void positionResult(int position, ArrayList<Integer> scans, ArrayList<Integer> combination) {

        switch (position) {
            case 0, 1, 2, 3 -> printCorrectPosition(position, scans, combination);
        }
    }

    public static void main(String[] args) {
        int attempts = 7;

        ArrayList<Integer> combination = randomComboGenerator();
        Scanner scnr = new Scanner(System.in);

        ArrayList<Integer> scans = new ArrayList<>();
        while (attempts > 0) {
            System.out.println("Attempts remaining: " + attempts);
            System.out.println("Enter a 4 digit combination");
            String input = scnr.next();

            while (input.length() != 4 || !input.matches("[0-9]+")) {
                System.out.print("The number entered was not 4 digits or contains letters. Please enter 4 digits: ");
                input = scnr.next();
            }

            //for each element in string, convert to number and add to array.
            for (int i = 0; i < 4; i++) {
                int replacementNum = Integer.parseInt(String.valueOf(input.charAt(i))); //char to int
                scans.add(i, replacementNum);
            }

            //compare the values in array to random combination. Tell the user what is in the right position or if
            //the number is contained in the array. Only tell the user what's correct
            for (int i = 0; i < 4; i++) {
                positionResult(i, scans, combination);
            }

            attempts--;
        }

        System.out.println("The combination was " + combination);
    }
}
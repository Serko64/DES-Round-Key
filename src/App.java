import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

        final static int[] lPC1 = { 57, 49, 41, 33, 25, 17, 9,
                        1, 58, 50, 42, 34, 26, 18,
                        10, 2, 59, 51, 43, 35, 27,
                        19, 11, 3, 60, 52, 44, 36 };

        final static int[] rPC1 = { 63, 55, 47, 39, 31, 23, 15,
                        7, 62, 54, 46, 38, 30, 22,
                        14, 6, 61, 53, 45, 37, 29,
                        21, 13, 5, 28, 20, 12, 4 };

        final static int[] PC2 = { 14, 17, 11, 24, 1, 5,
                        3, 28, 15, 6, 21, 10,
                        23, 19, 12, 4, 26, 8,
                        16, 7, 27, 20, 13, 2,
                        41, 52, 31, 37, 47, 55,
                        30, 40, 51, 45, 33, 48,
                        44, 49, 39, 56, 34, 53,
                        46, 42, 50, 36, 29, 32 };

        final static int[] iterations = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

        public static void main(String[] args) throws Exception {
                String input = "";
                String inputk = "";

                Scanner sc = new Scanner(System.in);
                while (true) {
                        try {
                                System.out.println("Please write your input: ");
                                input = sc.nextLine();
                                System.out.println("Please write your k: ");
                                inputk = sc.nextLine();

                                Pattern pattern = Pattern.compile("^([0-9A-Fa-f]{2}-)*[0-9A-Fa-f]{2}$");
                                Matcher matcher = pattern.matcher(input);
                                if (matcher.matches()) {
                                        break;
                                } else {
                                        System.out.println("Invalid Input!");
                                        continue;
                                }
                        } catch (NoSuchElementException e) {
                                System.out.println("Invalid Input!");
                                continue;
                        }

                }
                sc.close();

                String[] splitByte = input.split("-");
                int iteration = numberOfIterations(Integer.valueOf(inputk));

                String key = "";
                for (int i = 0; i < splitByte.length; i++) {
                        String binaryString = Integer.toBinaryString(Integer.valueOf(splitByte[i], 16));
                        binaryString = String.format("%8s", binaryString).replace(' ', '0');
                        key += binaryString;
                }

                final String temp = key;

                // Permuatationchoice 1
                // generating left key
                ArrayList<Integer> lKey = Arrays.stream(lPC1)
                                .mapToObj(n -> Integer.valueOf(String.valueOf(temp.charAt(n - 1))))
                                .collect(Collectors.toCollection(ArrayList::new));
                // shifting wishnumber
                Collections.rotate(lKey, -iteration);

                // generating right key
                ArrayList<Integer> rKey = Arrays.stream(rPC1)
                                .mapToObj(n -> Integer.valueOf(String.valueOf(temp.charAt(n - 1))))
                                .collect(Collectors.toCollection(ArrayList::new));
                // shifting wishnumber
                Collections.rotate(rKey, -iteration);

                ArrayList<Integer> sum = new ArrayList<Integer>();
                sum.addAll(lKey);
                sum.addAll(rKey);

                System.out.println();

                // Permutationchoice 2
                ArrayList<Integer> elist = Arrays.stream(PC2)
                                .mapToObj(n -> Integer.valueOf(String.valueOf(sum.get(n - 1))))
                                .collect(Collectors.toCollection(ArrayList::new));
                elist.forEach(System.out::print);
        }

        public static int numberOfIterations(int num) {
                int result = 0;
                for (int index = 0; index < num; index++) {
                        result += iterations[index];
                }
                return result;
        }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
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

    final static int[] iteration = { 1, 1,
            2,
            2,
            2,
            2,
            2,
            2,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            1 };

    public static void main(String[] args) throws Exception {
        System.out.println(lPC1.length);
        Scanner sc = new Scanner(System.in);
        System.out.println("PLease write your input: ");
        String input = sc.nextLine();
        System.out.println("PLease write your k: ");
        String inputK = sc.nextLine();
         sc.close();

        String[] splitByte = input.split("-");

        String key = "";
        for (int i = 0; i < splitByte.length; i++) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(splitByte[i], 16));
            // pad the binary string with leading zeros if necessary
            binaryString = String.format("%8s", binaryString).replace(' ', '0');
            key += binaryString;
        }

        final String temp = key;

        ArrayList<Integer> lKey = Arrays.stream(lPC1).mapToObj(n -> Integer.valueOf(String.valueOf(temp.charAt(n - 1))))
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.rotate(lKey, -4);
        ArrayList<Integer> rKey = Arrays.stream(rPC1).mapToObj(n -> Integer.valueOf(String.valueOf(temp.charAt(n - 1))))
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.rotate(rKey, -4);

        ArrayList<Integer> sum = new ArrayList<>();
        sum.addAll(lKey);
        sum.addAll(rKey);

        ArrayList<Integer> elist = Arrays.stream(PC2)
                .mapToObj(n -> Integer.valueOf(String.valueOf(sum.get(n - 1))))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(elist.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", ""));

    }
    public static () {
        
    }

}

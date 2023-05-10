import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLease write your input: ");
        String input = sc.nextLine();
        System.out.println("Your input is: " + input);
        sc.close();

        String[] splitByte = input.split("-");

        String key = "";
        for (int i = 0; i < splitByte.length; i++) {
            splitByte[i] = Integer.toBinaryString(Integer.parseInt(splitByte[i], 16));
            key += splitByte[i];
        }

        System.out.println("Key: " + key+", Size: "+key.length());


        String lKey= key.substring(0, 28);
        String rKey= key.substring(28);

        //shift lkey by 1 bit

//shift by one

        lKey = lKey.substring(1) + lKey.charAt(0);
        System.out.println(lKey);

        System.out.println("lKey: " + lKey+", Size: "+lKey.length());
        System.out.println("rKey: " + rKey+", Size: "+rKey.length());
        
    }
}

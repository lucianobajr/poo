import java.util.Scanner;

public class Fat{
    private static int nextInt = new Scanner(System.in).nextInt();

    public static void main(String[] args) {
        int value = nextInt;
        int fat = value;

        while(value>1){
            fat = fat*(value-1);
            value--;
        }
        System.out.println(fat);
    }
}
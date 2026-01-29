import java.util.Scanner;

public class L105 {
    public static int CheckNumber(int num){
        if(num < 0){
            return -1;
        } else if (num > 0){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int range = CheckNumber(number);
        System.out.println(range);
    }
}

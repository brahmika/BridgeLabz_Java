import java.util.Scanner;
public class L109 {
    public static void main(String[] args){
        double fee;
        Scanner input = new Scanner(System.in);
        fee = input.nextInt();
        double discount = 0.1;
        double discount_amt = fee * discount;
        double final_amt = fee - discount_amt;
        input.close();

        System.out.println(final_amt);
    }
}

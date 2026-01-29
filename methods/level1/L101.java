import java.util.Scanner;

class L101 {
    public static double SimpleInterest(double principalAmt, double time, double rate){
        return (principalAmt * rate * time) / 100;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Principal:");
        double principal = sc.nextDouble();

        System.out.println("Enter Rate:");
        double rate = sc.nextDouble();

        System.out.println("Enter Time:");
        double time = sc.nextDouble();

        double interest = SimpleInterest(principal, time, rate);

        System.out.println(interest);

        sc.close();
    }
}
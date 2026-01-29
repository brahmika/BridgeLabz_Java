import java.util.Scanner;

class L302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

       
        int count = 0;
        int temp = number; 


        if (temp == 0) {
            count = 1; 
        } else {
            while (temp != 0) {
                temp = temp / 10; 
                count++;           
            }
        }

        System.out.println("The number of digits in " + number + " is " + count);
    }
}

// Calculates discounted amount and final course fee.
public class FeeDiscountCalculator {  
    public static void main(String[] args){
        int fee = 125000;
        double discount = 0.1;
        double discounthere = fee * discount;//calculate the discount rate
        double final_amount = fee - discounthere;//calculate the final price

        System.out.println(final_amount);
    }
}

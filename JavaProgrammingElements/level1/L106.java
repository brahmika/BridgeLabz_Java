public class L106 {  
    public static void main(String[] args){
        int fee = 125000;
        double discount = 0.1;
        double discounthere = fee * discount;
        double final_amount = fee - discounthere;

        System.out.println(final_amount);
    }
}

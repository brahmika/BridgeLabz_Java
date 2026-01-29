public class L104 {
    public static void main(String[] args){
        int costPrice = 129;
        int sellingPrice = 191;

        int Profit = sellingPrice - costPrice;
        double profitpercentage = (Profit * 100) / costPrice;

        System.out.println("Profit: "+ Profit);
        System.out.println("Profit percentage"+ profitpercentage);
    }
}

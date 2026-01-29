// Calculates profit and profit percentage using cost and selling price.

public class ProfitLossCalculator {
    public static void main(String[] args){
        int costPrice = 129;
        int sellingPrice = 191;

        int Profit = sellingPrice - costPrice;//calculating profit
        double profitpercentage = (Profit * 100) / costPrice;//calculating the profit percentage

        System.out.println("Profit: "+ Profit);
        System.out.println("Profit percentage"+ profitpercentage);
    }
}

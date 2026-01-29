/*Calculates the average percentage of Maths, Physics, and Chemistry marks.
*/
public class AverageMarksCalculator{
    public static void main(String[] args){
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        int total_subjects = 3;

        double average = (maths + chemistry + physics) / total_subjects;//formula to calculate the average marks

        System.out.println("Sam's marks in PCM are " + average);
    }     
}

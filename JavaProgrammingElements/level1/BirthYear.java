/*
This program calculates the age of Harry by subtracting his birth year
from the current year. The birth year is fixed as 2000 and the current
year is assumed to be 2024. The program then displays Harry’s age.
*/

class BirthYear {
    public static void main(String[] args){
        //takes in input
        int HarryAge;
        int HarryBirthYear = 2000;
        int currentYear = 2024;

        HarryAge = currentYear - HarryBirthYear; //Calculates the current age of Harry
        System.out.println("Harry's Age is" + HarryAge);//output statement for Harry age
    }
}

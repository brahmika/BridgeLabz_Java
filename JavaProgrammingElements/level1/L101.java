// Write a program to find the age of Harry if the birth year is 2000. Assume the Current Year is 2024
class L101 {
    public static void main(String[] args){
        int HarryAge;
        int HarryBirthYear = 2000;
        int currentYear = 2024;

        HarryAge = currentYear - HarryBirthYear;
        System.out.println("Harry's Age is" + HarryAge);
    }
}

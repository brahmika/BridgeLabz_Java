
// Checks whether the given date falls in the Spring season.



public class SpringSeason {
>>>>>>> b124e46 ([Brahmika]: Level1 assignments done):ControlFlows/level1/SpringSeason.java
    public static void main(String[] args) {

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if ((month == 3 && day >= 20) ||
            (month == 4) ||
            (month == 5) ||
            (month == 6 && day <= 20)) {

            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

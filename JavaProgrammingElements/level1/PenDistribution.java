// Distributes pens equally among students and finds remaining pens.

public class PenDistribution {
    public static void main(String[] args){
        int totalPens = 14;
        int totalStudents = 3;
        int perStudentPen = totalPens / totalStudents;//calculating the number pens one person needs
        int nonDistributed = totalPens % totalStudents; //calculating the number of pens each person gets

        System.out.println(perStudentPen);
        System.out.println(nonDistributed);
    }
}

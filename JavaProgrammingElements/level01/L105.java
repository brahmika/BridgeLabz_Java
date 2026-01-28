public class L105 {
    public static void main(String[] args){
        int totalPens = 14;
        int totalStudents = 3;
        int perStudentPen = totalPens / totalStudents;
        int nonDistributed = totalPens % totalStudents;

        System.out.println(perStudentPen);
        System.out.println(nonDistributed);
    }
}

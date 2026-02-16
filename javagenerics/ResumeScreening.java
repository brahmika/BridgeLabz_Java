/*
 * Different job roles such as Software Engineer,
 * Data Scientist, and Product Manager are handled
 * using a generic Resume<T extends JobRole>.
 * The system processes resumes dynamically while
 * ensuring compile-time type safety.
 */

package javagenerics;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {

    private String roleName;

    // Constructor to initialize job role name
    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    // Returns the job role name
    public String getRoleName() {
        return roleName;
    }

    // Abstract method defining candidate evaluation logic
    public abstract boolean evaluateCandidate(int experience, int skillScore);
}

class SoftwareEngineer extends JobRole {

    // Constructor for Software Engineer role
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    // Evaluates candidate eligibility for Software Engineer
    @Override
    public boolean evaluateCandidate(int experience, int skillScore) {
        return experience >= 2 && skillScore >= 75;
    }
}

class DataScientist extends JobRole {

    // Constructor for Data Scientist role.
    public DataScientist() {
        super("Data Scientist");
    }

    // Evaluates candidate eligibility for Data Scientist
    @Override
    public boolean evaluateCandidate(int experience, int skillScore) {
        return experience >= 3 && skillScore >= 80;
    }
}

class ProductManager extends JobRole {

    // Constructor for Product Manager role
    public ProductManager() {
        super("Product Manager");
    }

    // Evaluates candidate eligibility for Product Manager
    @Override
    public boolean evaluateCandidate(int experience, int skillScore) {
        return experience >= 4 && skillScore >= 70;
    }
}

class Resume<T extends JobRole> {

    private String candidateName;
    private int yearsOfExperience;
    private int skillScore;
    private T jobRole;

    // Constructor to initialize resume details
    public Resume(String candidateName, int yearsOfExperience,
                  int skillScore, T jobRole) {

        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
        this.skillScore = skillScore;
        this.jobRole = jobRole;
    }

    // Returns the associated job role
    public T getJobRole() {
        return jobRole;
    }

    // Screens resume based on role-specific evaluation logic
    public boolean screenResume() {
        return jobRole.evaluateCandidate(yearsOfExperience, skillScore);
    }

    // Displays screening result for the candidate
    public void displayResult() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applied For: " + jobRole.getRoleName());
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Skill Score: " + skillScore);

        if (screenResume()) {
            System.out.println("Result: Selected for next round");
        } else {
            System.out.println("Result: Rejected");
        }

        System.out.println("-----------------------------");
    }
}

class ScreeningPipeline {

    // Processes resume using generic bounded method
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        resume.displayResult();
    }

    // Displays available job roles using wildcard method
    public static void displayAvailableRoles(List<? extends JobRole> roles) {

        System.out.println("Available Job Roles:");
        for (JobRole role : roles) {
            System.out.println("- " + role.getRoleName());
        }
    }
}

public class ResumeScreening {

    // Entry point of the resume screening system
    public static void main(String[] args) {

        // Create Job Roles
        SoftwareEngineer se = new SoftwareEngineer();
        DataScientist ds = new DataScientist();
        ProductManager pm = new ProductManager();

        // Store roles in wildcard list
        List<JobRole> roles = new ArrayList<>();
        roles.add(se);
        roles.add(ds);
        roles.add(pm);

        ScreeningPipeline.displayAvailableRoles(roles);

        // Create Resumes using generics
        Resume<SoftwareEngineer> resume1 =
                new Resume<>("Alice", 3, 85, se);

        Resume<DataScientist> resume2 =
                new Resume<>("Bob", 2, 90, ds);

        Resume<ProductManager> resume3 =
                new Resume<>("Charlie", 5, 72, pm);

        // Process resumes
        ScreeningPipeline.processResume(resume1);
        ScreeningPipeline.processResume(resume2);
        ScreeningPipeline.processResume(resume3);
    }
}

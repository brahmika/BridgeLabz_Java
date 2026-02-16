
/*
 * This program simulates an Insurance Policy Management System.
 * Each policy has a unique policy number, policyholder name, expiry date,
 * coverage type, and premium amount. Policies are stored using different
 * Set implementations to demonstrate uniqueness, insertion order,
 * and automatic sorting by expiry date. The program also provides
 * retrieval methods based on expiry period, coverage type, and
 * detection of duplicate policy numbers. Finally, it compares
 * the performance of HashSet, LinkedHashSet, and TreeSet.
 */

package collections;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy {

    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName,
                  LocalDate expiryDate, String coverageType,
                  double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    // Ensures uniqueness based only on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " +
                expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
    }
}

public class InsurancePolicyManagement {

    // Stores policies using HashSet for fast operations
    private Set<Policy> hashSet = new HashSet<>();

    // Stores policies maintaining insertion order
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();

    // Stores policies sorted by expiry date
    private Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    // Adds a policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Displays all unique policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashSet):");
        hashSet.forEach(System.out::println);
    }

    // Displays policies expiring within next 30 days
    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();

        for (Policy policy : hashSet) {
            long days = ChronoUnit.DAYS.between(today, policy.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(policy);
            }
        }
    }

    // Displays policies with a specific coverage type
    public void displayByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    // Detects duplicate policies based on policy number
    public void detectDuplicates(List<Policy> policies) {
        System.out.println("\nDuplicate Policies:");
        Set<String> seen = new HashSet<>();

        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Compares performance of HashSet, LinkedHashSet, TreeSet
    public void comparePerformance() {
        System.out.println("\nPerformance Comparison:");

        int size = 10000;
        List<Policy> samplePolicies = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            samplePolicies.add(new Policy(
                    "P" + i,
                    "Holder" + i,
                    LocalDate.now().plusDays(i % 365),
                    "Health",
                    1000 + i
            ));
        }

        // HashSet timing
        long start = System.nanoTime();
        Set<Policy> hSet = new HashSet<>(samplePolicies);
        long end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        // LinkedHashSet timing
        start = System.nanoTime();
        Set<Policy> lhSet = new LinkedHashSet<>(samplePolicies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        // TreeSet timing
        start = System.nanoTime();
        Set<Policy> tSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
        tSet.addAll(samplePolicies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");
    }

    // Entry point of the program
    public static void main(String[] args) {

        InsurancePolicyManagement system = new InsurancePolicyManagement();

        Policy p1 = new Policy("P101", "Alice",
                LocalDate.now().plusDays(10), "Health", 5000);

        Policy p2 = new Policy("P102", "Bob",
                LocalDate.now().plusDays(40), "Auto", 3000);

        Policy p3 = new Policy("P103", "Charlie",
                LocalDate.now().plusDays(5), "Home", 4000);

        Policy p4 = new Policy("P101", "David",
                LocalDate.now().plusDays(20), "Health", 6000); // Duplicate number

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");

        List<Policy> duplicateCheckList = Arrays.asList(p1, p2, p3, p4);
        system.detectDuplicates(duplicateCheckList);

        system.comparePerformance();
    }
}

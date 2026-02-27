
/*
 * This program implements an Insurance Policy Management System.
 * Policies are stored using different Map implementations:
 * HashMap for fast lookup by policy number,
 * LinkedHashMap to maintain insertion order,
 * TreeMap to maintain policies sorted by expiry date.
 *
 * The system supports retrieving a policy by number,
 * listing policies expiring within the next 30 days,
 * listing policies by policyholder name,
 * and removing expired policies.
 */
package collections;

import java.time.LocalDate;
import java.util.*;


class PolicyNew {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    // Constructor to initialize policy details
    PolicyNew(String policyNumber, String policyholderName,
           LocalDate expiryDate, String coverageType,
           double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Returns readable representation of policy
    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName +
                " - Expiry: " + expiryDate +
                " - " + coverageType +
                " - $" + premiumAmount;
    }
}

public class InsurancePolicy {

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Adds a policy to all map structures
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        treeMap
                .computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
                .add(policy);
    }

    // Retrieves a policy using its policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Lists policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry :
                treeMap.subMap(today, true, next30Days, true).entrySet()) {
            result.addAll(entry.getValue());
        }

        return result;
    }

    // Lists policies belonging to a specific policyholder
    public List<Policy> getPoliciesByHolder(String name) {
        List<Policy> result = new ArrayList<>();

        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }

        return result;
    }

    // Removes policies that have already expired
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> iterator =
                hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(entry.getKey());
            }
        }

        treeMap.headMap(today).clear();
    }

    // Displays all policies from LinkedHashMap (in insertion order)
    public void displayAllPolicies() {
        for (Policy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }
    }

    // Entry point to test the system
    public static void main(String[] args) {

        InsurancePolicy manager = new InsurancePolicy();

        manager.addPolicy(new Policy("P101", "Alice",
                LocalDate.now().plusDays(10), "Health", 5000));

        manager.addPolicy(new Policy("P102", "Bob",
                LocalDate.now().plusDays(40), "Auto", 3000));

        manager.addPolicy(new Policy("P103", "Alice",
                LocalDate.now().minusDays(5), "Home", 4000));

        System.out.println("All Policies:");
        manager.displayAllPolicies();

        System.out.println("\nPolicy P101:");
        System.out.println(manager.getPolicyByNumber("P101"));

        System.out.println("\nPolicies Expiring Soon:");
        System.out.println(manager.getPoliciesExpiringSoon());

        System.out.println("\nPolicies for Alice:");
        System.out.println(manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();

        System.out.println("\nAfter Removing Expired Policies:");
        manager.displayAllPolicies();
    }
}


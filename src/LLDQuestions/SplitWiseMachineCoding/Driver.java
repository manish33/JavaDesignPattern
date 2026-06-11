package LLDQuestions.SplitWiseMachineCoding;

import LLDQuestions.SplitWiseMachineCoding.service.SplitwiseService;
import LLDQuestions.SplitWiseMachineCoding.split.SplitType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        SplitwiseService splitwise = new SplitwiseService();

        // Register users
        splitwise.addUser("u1", "User1", "gaurav@workat.tech", "9876543210");
        splitwise.addUser("u2", "User2", "sagar@workat.tech", "9876543210");
        splitwise.addUser("u3", "User3", "hi@workat.tech", "9876543210");
        splitwise.addUser("u4", "User4", "mock@workat.tech", "9876543210");

        // Create a group with members
        splitwise.createGroup("g1", "Trip to Goa", "Goa trip expenses", "u1");
        splitwise.addMemberToGroup("g1", "u2");
        splitwise.addMemberToGroup("g1", "u3");
        splitwise.addMemberToGroup("g1", "u4");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");

            try {
                switch (parts[0]) {
                    case "SHOW":
                        handleShow(splitwise, parts);
                        break;
                    case "EXPENSE":
                        handleExpense(splitwise, parts, null);
                        break;
                    case "GROUP_EXPENSE":
                        // GROUP_EXPENSE groupId paidBy amount noOfUsers u1 u2 ... splitType [values]
                        handleGroupExpense(splitwise, parts);
                        break;
                    case "GROUP_SHOW":
                        // GROUP_SHOW groupId
                        splitwise.showGroupBalances(parts[1]);
                        break;
                    case "CREATE_GROUP":
                        // CREATE_GROUP groupId name createdByUserId
                        splitwise.createGroup(parts[1], parts[2], "", parts[3]);
                        System.out.println("Group created: " + parts[2]);
                        break;
                    case "ADD_MEMBER":
                        // ADD_MEMBER groupId userId
                        splitwise.addMemberToGroup(parts[1], parts[2]);
                        System.out.println("Member added to group");
                        break;
                    default:
                        System.out.println("Unknown command: " + parts[0]);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void handleShow(SplitwiseService splitwise, String[] parts) {
        if (parts.length == 1) {
            splitwise.showAllBalances();
        } else {
            splitwise.showBalance(parts[1]);
        }
    }

    private static void handleExpense(SplitwiseService splitwise, String[] parts, String groupId) {
        // EXPENSE paidBy amount noOfUsers u1 u2 ... splitType [values...]
        String paidBy = parts[1];
        double amount = Double.parseDouble(parts[2]);
        int noOfUsers = Integer.parseInt(parts[3]);

        List<String> userIds = new ArrayList<>();
        for (int i = 0; i < noOfUsers; i++) {
            userIds.add(parts[4 + i]);
        }

        String splitTypeStr = parts[4 + noOfUsers];
        SplitType splitType = SplitType.valueOf(splitTypeStr);

        List<Double> values = new ArrayList<>();
        if (splitType != SplitType.EQUAL) {
            for (int i = 0; i < noOfUsers; i++) {
                values.add(Double.parseDouble(parts[5 + noOfUsers + i]));
            }
        }

        splitwise.addExpense(paidBy, amount, "Expense", userIds, values, splitType, groupId);
    }

    private static void handleGroupExpense(SplitwiseService splitwise, String[] parts) {
        // GROUP_EXPENSE groupId paidBy amount noOfUsers u1 u2 ... splitType [values...]
        String groupId = parts[1];
        String paidBy = parts[2];
        double amount = Double.parseDouble(parts[3]);
        int noOfUsers = Integer.parseInt(parts[4]);

        List<String> userIds = new ArrayList<>();
        for (int i = 0; i < noOfUsers; i++) {
            userIds.add(parts[5 + i]);
        }

        String splitTypeStr = parts[5 + noOfUsers];
        SplitType splitType = SplitType.valueOf(splitTypeStr);

        List<Double> values = new ArrayList<>();
        if (splitType != SplitType.EQUAL) {
            for (int i = 0; i < noOfUsers; i++) {
                values.add(Double.parseDouble(parts[6 + noOfUsers + i]));
            }
        }

        splitwise.addExpense(paidBy, amount, "Group Expense", userIds, values, splitType, groupId);
    }
}

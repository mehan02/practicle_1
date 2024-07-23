import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         
        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();

         
        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();
 
        System.out.println("Welcome to the Second Year " + firstName + " " + lastName);

        scanner.close();
    }
}


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Marks {

    // Data structure to store student marks
    private static class Student {
        int id;
        int math;
        int chemistry;
        int physics;

        public Student(int id) {
            this.id = id;
            this.math = 0;
            this.chemistry = 0;
            this.physics = 0;
        }

        public int getTotal() {
            return math + chemistry + physics;
        }

        public double getAverage() {
            return getTotal() / 3.0;
        }
    }

    private static Map<Integer, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Enter your commands:");

        while (true) {
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            processCommand(command);
        }

        scanner.close();
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) return;

        switch (parts[0].toLowerCase()) {
            case "add":
                if (parts.length != 2) {
                    System.out.println("Invalid command. Usage: add [studentID]");
                    return;
                }
                addStudent(Integer.parseInt(parts[1]));
                break;
            case "update":
                if (parts.length != 4) {
                    System.out.println("Invalid command. Usage: update [studentID] [subjectID] [mark]");
                    return;
                }
                updateStudentMark(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                break;
            case "average_s":
                if (parts.length != 2) {
                    System.out.println("Invalid command. Usage: average_s [subjectID]");
                    return;
                }
                averageSubject(Integer.parseInt(parts[1]));
                break;
            case "average":
                if (parts.length != 2) {
                    System.out.println("Invalid command. Usage: average [studentID]");
                    return;
                }
                averageStudent(Integer.parseInt(parts[1]));
                break;
            case "total":
                if (parts.length != 2) {
                    System.out.println("Invalid command. Usage: total [studentID]");
                    return;
                }
                totalStudent(Integer.parseInt(parts[1]));
                break;
            default:
                System.out.println("Invalid command.");
        }
    }

    private static void addStudent(int studentID) {
        if (studentMap.containsKey(studentID)) {
            System.out.println("Student already exists.");
        } else {
            studentMap.put(studentID, new Student(studentID));
            System.out.println("Student " + studentID + " added.");
        }
    }

    private static void updateStudentMark(int studentID, int subjectID, int mark) {
        Student student = studentMap.get(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        switch (subjectID) {
            case 1:
                student.math = mark;
                break;
            case 2:
                student.chemistry = mark;
                break;
            case 3:
                student.physics = mark;
                break;
            default:
                System.out.println("Invalid subject ID. Use 1 for Math, 2 for Chemistry, 3 for Physics.");
                return;
        }

        System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " was updated to " + mark + ".");
    }

    private static void averageSubject(int subjectID) {
        int totalMarks = 0;
        int count = 0;

        for (Student student : studentMap.values()) {
            switch (subjectID) {
                case 1:
                    totalMarks += student.math;
                    break;
                case 2:
                    totalMarks += student.chemistry;
                    break;
                case 3:
                    totalMarks += student.physics;
                    break;
                default:
                    System.out.println("Invalid subject ID. Use 1 for Math, 2 for Chemistry, 3 for Physics.");
                    return;
            }
            count++;
        }

        if (count == 0) {
            System.out.println("No students found.");
        } else {
            double average = totalMarks / (double) count;
            System.out.println("Subject " + subjectID + " has an average of " + average + ".");
        }
    }

    private static void averageStudent(int studentID) {
        Student student = studentMap.get(studentID);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            double average = student.getAverage();
            System.out.println("Student " + studentID + " has an average of " + average + ".");
        }
    }

    private static void totalStudent(int studentID) {
        Student student = studentMap.get(studentID);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            int total = student.getTotal();
            System.out.println("Student " + studentID + " has a total of " + total + " marks.");
        }
    }
}

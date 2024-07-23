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


   import java.util.Scanner;

public class Marks {
    private static class Student {
        int id, math, chemistry, physics;

        public Student(int id) {
            this.id = id;
        }

        public int getTotal() { return math + chemistry + physics; }
        public double getAverage() { return getTotal() / 3.0; }
    }

    private static Student[] students;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        students = new Student[scanner.nextInt()];

        scanner.nextLine(); 

        System.out.println("Enter your commands:");
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) break;
            processCommand(command);
        }
        scanner.close();
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) return;

        int studentID, subjectID, mark;
        switch (parts[0].toLowerCase()) {
            case "add":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] != null) {
                    System.out.println("Invalid or existing student ID.");
                } else {
                    students[studentID - 1] = new Student(studentID);
                    System.out.println("Student " + studentID + " added.");
                }
                break;
            case "update":
                studentID = Integer.parseInt(parts[1]);
                subjectID = Integer.parseInt(parts[2]);
                mark = Integer.parseInt(parts[3]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    Student student = students[studentID - 1];
                    if (subjectID == 1) student.math = mark;
                    else if (subjectID == 2) student.chemistry = mark;
                    else if (subjectID == 3) student.physics = mark;
                    else { System.out.println("Invalid subject ID."); return; }
                    System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " updated to " + mark + ".");
                }
                break;
            case "average_s":
                subjectID = Integer.parseInt(parts[1]);
                int totalMarks = 0, count = 0;
                for (Student student : students) {
                    if (student != null) {
                        if (subjectID == 1) totalMarks += student.math;
                        else if (subjectID == 2) totalMarks += student.chemistry;
                        else if (subjectID == 3) totalMarks += student.physics;
                        else { System.out.println("Invalid subject ID."); return; }
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("No students found.");
                } else {
                    System.out.println("Subject " + subjectID + " has an average of " + (totalMarks / (double) count) + ".");
                }
                break;
            case "average":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student " + studentID + " has an average of " + students[studentID - 1].getAverage() + ".");
                }
                break;
            case "total":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student " + studentID + " has a total of " + students[studentID - 1].getTotal() + " marks.");
                }
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
}


import java.util.Scanner;

public class Marks {
    private static class Student {
        int id, math, chemistry, physics;

        public Student(int id) { this.id = id; }
        public int getTotal() { return math + chemistry + physics; }
        public double getAverage() { return getTotal() / 3.0; }
    }

    private static Student[] students;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        students = new Student[scanner.nextInt()];
        scanner.nextLine(); 

        System.out.println("Enter your commands:");
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) break;
            processCommand(command.split(" "));
        }
        scanner.close();
    }

    private static void processCommand(String[] parts) {
        if (parts.length == 0) return;

        int studentID, subjectID, mark;
        switch (parts[0].toLowerCase()) {
            case "add":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] != null) {
                    System.out.println("Invalid or existing student ID.");
                } else {
                    students[studentID - 1] = new Student(studentID);
                    System.out.println("Student " + studentID + " added.");
                }
                break;
            case "update":
                studentID = Integer.parseInt(parts[1]);
                subjectID = Integer.parseInt(parts[2]);
                mark = Integer.parseInt(parts[3]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    Student student = students[studentID - 1];
                    if (subjectID == 1) student.math = mark;
                    else if (subjectID == 2) student.chemistry = mark;
                    else if (subjectID == 3) student.physics = mark;
                    else { System.out.println("Invalid subject ID."); return; }
                    System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " updated to " + mark + ".");
                }
                break;
            case "average_s":
                subjectID = Integer.parseInt(parts[1]);
                int totalMarks = 0, count = 0;
                for (Student student : students) {
                    if (student != null) {
                        if (subjectID == 1) totalMarks += student.math;
                        else if (subjectID == 2) totalMarks += student.chemistry;
                        else if (subjectID == 3) totalMarks += student.physics;
                        else { System.out.println("Invalid subject ID."); return; }
                        count++;
                    }
                }
                if (count == 0) System.out.println("No students found.");
                else System.out.println("Subject " + subjectID + " has an average of " + (totalMarks / (double) count) + ".");
                break;
            case "average":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student " + studentID + " has an average of " + students[studentID - 1].getAverage() + ".");
                }
                break;
            case "total":
                studentID = Integer.parseInt(parts[1]);
                if (studentID < 1 || studentID > students.length || students[studentID - 1] == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student " + studentID + " has a total of " + students[studentID - 1].getTotal() + " marks.");
                }
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
}

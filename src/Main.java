import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static StudentManagement sm = new StudentManagement();
    static List<Student> studentList = List.of(
            new Student("santhu", new Date("30/1/2009"), "Hyderabad, 501301", 35000),
            new Student("nira", new Date("29/8/2005"), "Bangalore, 501305", 75000),
            new Student("likitha", new Date("19/4/2009"), "Pune, 501302", 95000),
            new Student("Bhavana", new Date("18/9/2000"), "Vijayawada, 500001", 25000),
            new Student("Rohit", new Date("12/2/2005"), "Indonesia, 501521", 1785000)
    );

    public static void main(String[] args) {
        add();
        System.out.println("added successful");
        performOperation();
    }

    private static void showOptions() {
        System.out.println("""
                1. Add new student
                2. Remove Students
                3. Check Student availability
                4. Total Students
                5. Show Registered students
                6. Exit""");
    }

    private static int getChoice() {
        return s.nextInt();
    }

    private static void add() {
        for (Student student : studentList) {
            if (student.fees <= 35000) {
                System.out.println("Sorry " + student.name + " please check fee details before we proceed, for further assistance contact us");
            } else {
                sm.addStudent(student);
            }
        }
    }

    private static void performOperation() {
        while (true) {
            showOptions();
            int choice = getChoice();
            s.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter student details to add:");
                    System.out.print("name:");
                    String name = s.nextLine();
                    System.out.print("dob: ");
                    String date = s.nextLine();
                    System.out.print("address: ");
                    String address = s.nextLine();
                    System.out.print("fees: ");
                    int fees = s.nextInt();
                    s.nextLine();
                    if (fees <= 35000) {
                        System.out.println("Sorry " + name + " please check fee details before we proceed, for further assistance contact us");
                    } else {
                        System.out.println("Student added successfully");
                        sm.addStudent(new Student(name, new Date(date), address, fees));
                    }
                }
                case 2 -> {
                    System.out.println("Enter id or name to remove");
                    String idOrName = s.nextLine();
                    System.out.println(idOrName);
                    sm.removeStudent(idOrName);
                }
                case 3 -> {
                    System.out.println("Enter id or name to check");
                    String idOrName = s.nextLine();
                    sm.checkStudentDetails(idOrName);
                }
                case 4 -> sm.getNoOfStudentsRegistered();
                case 5 -> sm.printTotalRegisteredStudents();
                case 6 -> System.exit(0);
                default -> {
                    System.out.println("Invalid choice");
                    showOptions();
                }
            }
        }
    }
}
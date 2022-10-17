import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManagement {
    Scanner s = new Scanner(System.in);
    public final String MasterPassword = "santhu";
    List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getId().length() == 0) {
            System.out.println("something went wrong , Your admission id not generated please contact our team for further assistance");
        }
        studentList.add(student);
    }

    public void removeStudent(String entry) {
        if (entry.length() == 10 && entry.startsWith("18")) {
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                if (student.getId().equals(entry)) {
                    System.out.println("....student removed....");
                    System.out.println("name: " + student.getId());
                    System.out.println("name: " + student.getName());
                    System.out.println("name: " + student.getDob());
                    System.out.println("name: " + student.getFees());
                    System.out.println("name: " + student.getAddress());
                    studentList.remove(studentList.get(i));
                }
            }
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                if (student.getName().equals(entry)) {
                    System.out.println("....student removed....");
                    System.out.println("Id: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Dob: " + student.getDob());
                    System.out.println("Fees: " + student.getFees());
                    System.out.println("Address: " + student.getAddress());
                    studentList.remove(studentList.get(i));
                }
            }
        }
    }

    public void checkStudentDetails(String entry) {
        List<Student> list;
        if (entry.length() == 10 && entry.startsWith("18")) {
            list = studentList.stream().filter(student -> student.getId().equals(entry)).collect(Collectors.toList());
            System.out.println(
                    list.size() == 0 ? "No students found" : (list.get(0).getName() + " found")
            );
        } else {
            list = studentList.stream().filter(student -> student.getName().equalsIgnoreCase(entry)).collect(Collectors.toList());
            System.out.println(
                    list.size() == 0 ? "No student found" : (list.get(0).getName() + " found")
            );
        }
        if (list.size() != 0) {
            System.out.println("Id: " + list.get(0).getId());
            System.out.println("name: " + list.get(0).getName());
            System.out.println("dob: " + list.get(0).getDob());
            System.out.println("address: " + list.get(0).getAddress());
        }
    }

    public void printTotalRegisteredStudents() {
        boolean passwordCheck = true;
        while (passwordCheck) {
            if (MasterPassword.equalsIgnoreCase(getMasterPassword())) {
                System.out.println("Validation Done");
                passwordCheck = false;
            } else {
                System.out.println("Incorrect master password....");
            }
        }
        studentList.forEach(System.out::println);
    }

    public void getNoOfStudentsRegistered() {
        System.out.println("Total Students Registered: " + studentList.size());
    }

    private String getMasterPassword() {
        System.out.println("Enter master password: ");
        return s.nextLine();
    }
}

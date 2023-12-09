mport java.util.Random;
import java.util.Scanner;

class CredentialService {
    static String generatePassword() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    static String generateEmail(String firstName, String department) {
        return String.format("%s%s@%s.abc.com", firstName.toLowerCase(), department.toLowerCase(), "tech");
    }

    static void showCredentials(Employee employee) {
        String password = generatePassword();
        String email = generateEmail(employee.getFirstName(), employee.getDepartment());

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email --> " + email);
        System.out.println("Password> " + password);
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String department;

    Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    String getFirstName() {
        return firstName;
    }

    String getDepartment() {
        return department;
    }
}

public class CredentialGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the department from the following:");
        System.out.println("1. Technical\n2. Admin\n3. Human Resource\n4. Legal");

        int departmentChoice = scanner.nextInt();
        String department;

        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "Human Resource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid department choice. Exiting...");
                return;
        }

        System.out.println("Enter the first name:");
        String firstName = scanner.next();

        System.out.println("Enter the last name:");
        String lastName = scanner.next();

        Employee newEmployee = new Employee(firstName, lastName, department);
        CredentialService.showCredentials(newEmployee);
    }
}

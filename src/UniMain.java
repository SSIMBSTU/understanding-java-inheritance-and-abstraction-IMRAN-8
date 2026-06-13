import java.util.ArrayList;

// Abstract Class
abstract class UniversityMember {
    int memberId;
    String name;

    UniversityMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    void displayBasicInfo() {
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + name);
    }

    abstract void performDuty();
}

// Level 1
class Employee extends UniversityMember {
    double salary;

    Employee(int memberId, String name, double salary) {
        super(memberId, name);
        this.salary = salary;
    }

    void showSalary() {
        System.out.println("Salary: " + salary);
    }

    @Override
    void performDuty() {
        System.out.println("Employee Duty");
    }
}

// Level 2
class AcademicStaff extends Employee {
    String department;

    AcademicStaff(int memberId, String name,
                  double salary, String department) {

        super(memberId, name, salary);
        this.department = department;
    }

    @Override
    void performDuty() {
        System.out.println("Teaching Students");
    }
}

// Level 3
class Professor extends AcademicStaff {
    String researchArea;

    Professor(int memberId, String name,
              double salary, String department,
              String researchArea) {

        super(memberId, name, salary, department);
        this.researchArea = researchArea;
    }

    void showResearchProfile() {
        System.out.println("Research Area: " + researchArea);
    }

    @Override
    void performDuty() {
        System.out.println("Research and Teaching");
    }
}

// Another subclass of Employee
class AdministrativeOfficer extends Employee {
    String office;

    AdministrativeOfficer(int memberId, String name,
                          double salary, String office) {

        super(memberId, name, salary);
        this.office = office;
    }

    @Override
    void performDuty() {
        System.out.println("Managing Administration");
    }
}

public class UniMain {
    public static void main(String[] args) {

        ArrayList<UniversityMember> members = new ArrayList<>();

        members.add(new Professor(
                101,
                "Dr. Rahman",
                80000,
                "CSE",
                "Artificial Intelligence"
        ));

        members.add(new AdministrativeOfficer(
                201,
                "Mr. Karim",
                40000,
                "Accounts"
        ));

        System.out.println("=== Dynamic Binding ===");

        for (UniversityMember member : members) {
            member.displayBasicInfo();
            member.performDuty();
            System.out.println();
        }

        System.out.println("=== Downcasting ===");

        for (UniversityMember member : members) {

            if (member instanceof Professor) {
                Professor p = (Professor) member; // Downcasting
                p.showResearchProfile();
            }
        }
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while(true){

            System.out.println("\n===== Employee Management System =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int ch=sc.nextInt();

            switch(ch){

            case 1:

                sc.nextLine();

                System.out.print("Enter Name : ");
                String name=sc.nextLine();

                System.out.print("Enter Department : ");
                String dept=sc.nextLine();

                System.out.print("Enter Salary : ");
                double sal=sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Email : ");
                String email=sc.nextLine();

                dao.addEmployee(new Employee(name,dept,sal,email));

                break;

            case 2:

                dao.viewEmployees();

                break;

            case 3:

                System.out.print("Enter Employee ID : ");

                dao.searchEmployee(sc.nextInt());

                break;

            case 4:

                System.out.print("Enter ID : ");
                int id=sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name : ");
                String n=sc.nextLine();

                System.out.print("Enter Department : ");
                String d=sc.nextLine();

                System.out.print("Enter Salary : ");
                double s=sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Email : ");
                String e=sc.nextLine();

                dao.updateEmployee(new Employee(id,n,d,s,e));

                break;

            case 5:

                System.out.print("Enter Employee ID : ");

                dao.deleteEmployee(sc.nextInt());

                break;

            case 6:

                System.out.println("Thank You");

                System.exit(0);

            default:

                System.out.println("Invalid Choice");

            }

        }

    }

}
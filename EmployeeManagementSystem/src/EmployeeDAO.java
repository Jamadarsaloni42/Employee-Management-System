import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    Connection con = DBConnection.getConnection();

    public void addEmployee(Employee e) {

        try {

            String sql = "insert into employees(name,department,salary,email) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.setString(4, e.getEmail());

            ps.executeUpdate();

            System.out.println("Employee Added Successfully.");

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    public void viewEmployees() {

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from employees");

            while(rs.next()){

                System.out.println("-------------------------");

                System.out.println("ID : "+rs.getInt("id"));
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("Department : "+rs.getString("department"));
                System.out.println("Salary : "+rs.getDouble("salary"));
                System.out.println("Email : "+rs.getString("email"));

            }

        } catch(Exception e){

            e.printStackTrace();

        }

    }

    public void searchEmployee(int id){

        try{

            PreparedStatement ps=con.prepareStatement("select * from employees where id=?");

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                System.out.println("ID : "+rs.getInt(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("Department : "+rs.getString(3));
                System.out.println("Salary : "+rs.getDouble(4));
                System.out.println("Email : "+rs.getString(5));

            }
            else{

                System.out.println("Employee Not Found");

            }

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

    public void updateEmployee(Employee e){

        try{

            String sql="update employees set name=?,department=?,salary=?,email=? where id=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,e.getName());
            ps.setString(2,e.getDepartment());
            ps.setDouble(3,e.getSalary());
            ps.setString(4,e.getEmail());
            ps.setInt(5,e.getId());

            ps.executeUpdate();

            System.out.println("Updated Successfully");

        }

        catch(Exception ex){

            ex.printStackTrace();

        }

    }

    public void deleteEmployee(int id){

        try{

            PreparedStatement ps=con.prepareStatement("delete from employees where id=?");

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println("Deleted Successfully");

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

}
package EmployeeOrg.Employee.Repository;

import EmployeeOrg.Employee.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeRepository {

    //return all employeeList
    public List<Employee> getEmployeeList(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Rohit", 91000));
        empList.add(new Employee(2, "Saurabh", 70000));
        empList.add(new Employee(3, "Atul", 81000));
        return empList;
    }

    //get single Emp by Id
    public Employee getEmployeeById(int empId){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Rohit", 91000));
        empList.add(new Employee(2, "Saurabh", 70000));
        empList.add(new Employee(3, "Atul", 81000));
        for(Employee e:empList){
            if(e.getEmpId() == empId){
                return e;
            }else{
                continue;
            }
        }
        return null;
    }

    //create new employee
    public List<Employee> createNewEmployee(Employee emp){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Rohit", 91000));
        empList.add(new Employee(2, "Saurabh", 70000));
        empList.add(new Employee(3, "Atul", 81000));
        empList.add(new Employee(emp.getEmpId(), emp.getEmpName(), emp.getEmpSalary()));
        return empList;
    }

    //Update Employee Details
    public List<Employee> updateEmployeeDetails(int empId, Employee emp){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Rohit", 91000));
        empList.add(new Employee(2, "Saurabh", 70000));
        empList.add(new Employee(3, "Atul", 81000));
        for(Employee e: empList){
            if(e.getEmpId() == empId){
                e.setEmpName(emp.getEmpName());
                e.setEmpSalary(emp.getEmpSalary());
                return empList;
            }
        }
        return empList;
    }

    // delete employee by id
    public boolean deleteEmployeeById(int empId){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Rohit", 91000));
        empList.add(new Employee(2, "Saurabh", 70000));
        empList.add(new Employee(3, "Atul", 81000));
        Iterator<Employee> iterator = empList.iterator();
        while(iterator.hasNext()){
            Employee e = iterator.next();
            if(empId == e.getEmpId()){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

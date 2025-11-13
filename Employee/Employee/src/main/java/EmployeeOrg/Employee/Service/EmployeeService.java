package EmployeeOrg.Employee.Service;

import EmployeeOrg.Employee.Model.Employee;
import EmployeeOrg.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;
    public ResponseEntity<List<Employee>> getAllEmployeeList(){
        List<Employee> l1=new ArrayList<>();
        l1=empRepo.getEmployeeList();
        try{
            if(l1.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }else{
                return ResponseEntity.ok(l1);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // to get single employee by id
    public ResponseEntity<Employee> getEmployeeByHisId(int empId){
        Employee e1 = empRepo.getEmployeeById(empId);
        try{
            if(e1==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }else{
                return ResponseEntity.ok(e1);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    //create a new employee
    public ResponseEntity<List<Employee>> createSingleEmployee(Employee emp){
        List<Employee> l1 = empRepo.createNewEmployee(emp);
        try{
            if(l1.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }else{
                return ResponseEntity.ok(l1);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //to update employee
    public ResponseEntity<List<Employee>> updateEmplyeeById(int empId, Employee emp){
        List<Employee> l1 = empRepo.updateEmployeeDetails(empId, emp);
        try{
            if(l1.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }else{
                return ResponseEntity.ok(l1);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // delete by id
    public ResponseEntity<String> deleteEmpById(int empId){
        boolean result = empRepo.deleteEmployeeById(empId);
        if(result == true){
            return ResponseEntity.ok("Delete Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

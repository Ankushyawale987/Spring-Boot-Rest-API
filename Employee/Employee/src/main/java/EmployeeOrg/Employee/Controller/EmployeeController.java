package EmployeeOrg.Employee.Controller;

import EmployeeOrg.Employee.Model.Employee;
import EmployeeOrg.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empServ;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmpList(){
        return empServ.getAllEmployeeList();
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId){
        return empServ.getEmployeeByHisId(empId);
    }
    @PostMapping("/createEmp")
    public ResponseEntity<List<Employee>> createEmployee(@RequestBody Employee emp){
        return empServ.createSingleEmployee(emp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<List<Employee>> updateEmployee(@PathVariable("id") int empId, @RequestBody Employee emp){
        return empServ.updateEmplyeeById(empId, emp);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId){
        return empServ.deleteEmpById(empId);
    }
}

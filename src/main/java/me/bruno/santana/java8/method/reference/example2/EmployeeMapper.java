package me.bruno.santana.java8.method.reference.example2;

public class EmployeeMapper {

    public EmployeeDO convert(Employee employee) {
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employee.getId());
        employeeDO.setName(employee.getName());
        employeeDO.setSalary(employee.getSalary());
        return employeeDO;
    }

}

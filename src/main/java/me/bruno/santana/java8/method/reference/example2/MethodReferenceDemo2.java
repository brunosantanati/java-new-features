package me.bruno.santana.java8.method.reference.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

//Example based on this tutorial: https://www.youtube.com/watch?v=5rbdwovjbw4

public class MethodReferenceDemo2 {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        //using anonymous class
        service.loadEmployeesFromDB()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        //System.out.println(employee);
                        print(employee);
                    }
                });

        System.out.println("#############################");

        //using Lambda expression
        /*service.loadEmployeesFromDB()
                .forEach(employee -> System.out.println(employee));*/

        service.loadEmployeesFromDB()
                .forEach(employee -> print(employee));

        System.out.println("#############################");

        //using method reference
        /*service.loadEmployeesFromDB()
                .forEach(System.out::println);*/

        service.loadEmployeesFromDB()
                .forEach(MethodReferenceDemo2::print);

        System.out.println("#############################");

        //using anonymous class
        List<EmployeeDO> employeeDOS = service.loadEmployeesFromDB()
                .stream()
                .map(new Function<Employee, EmployeeDO>() {

                    @Override
                    public EmployeeDO apply(Employee employee) {
                        return new EmployeeMapper().convert(employee);
                    }
                }).collect(Collectors.toList());
        System.out.println(employeeDOS);

        System.out.println("#############################");

        //using method reference

        EmployeeMapper mapper = new EmployeeMapper();
        List<EmployeeDO> employeeDOS2 = service.loadEmployeesFromDB()
                .stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
        System.out.println(employeeDOS2);

        List<String> nameList = service.loadEmployeesFromDB()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);

        System.out.println("#############################");

        //using Lambda expression
        EmployeeManager manager = () -> new Employee();
        manager.getEmployee().getEmployeeInfo();

        //using method reference
        EmployeeManager manager1 = Employee::new;
        manager1.getEmployee().getEmployeeInfo();

        //using method reference
        /*service.loadEmployeesFromDB()
                .stream()
                .map(Employee::getId)
                .map(ArrayList::new)
                .forEach(System.out::println);*/
    }

    public static void print(Employee employee) {
        System.out.println(employee);
    }

}

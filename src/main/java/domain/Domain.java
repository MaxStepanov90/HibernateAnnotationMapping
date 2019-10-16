package domain;

import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.*;

public class Domain {
    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham");
        address.setStreet("Arkham street 1");
        address.setPostCode("0987");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstname("John");
        employee.setLastname("Gordon");

        Calendar calendar = new GregorianCalendar();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        HibernateUtil.shutdown();
    }
}

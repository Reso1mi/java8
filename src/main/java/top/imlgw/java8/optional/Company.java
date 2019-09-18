package top.imlgw.java8.optional;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/9/18 17:48
 */
public class Company {
    private String name;

    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

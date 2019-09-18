package top.imlgw.java8.optional;

import java.util.*;

/**
 * @author imlgw.top
 * @date 2019/9/18 17:49
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.setName("imlgw");
        Employee employee1 = new Employee();
        employee1.setName("Resolmi");

        List<Employee> employees= Arrays.asList(employee,employee1);
        Company company = new Company();
        //company.setEmployees(employees);

        List<Employee> reslist = company.getEmployees();

        /*if (reslist != null) {
            return reslist;
        }else{
            return new ArrayList<Employee>();
        }*/

        Optional<Company> optionalCompany=Optional.ofNullable(company);
        System.out.println(optionalCompany.map(theCompany->theCompany.getEmployees()).orElse
                (Collections.emptyList()));
    }

    //不推荐这种做法
    public void test(Optional optional){

    }
}

package top.imlgw.java8.supplier;

/**
 * @author imlgw.top
 * @date 2019/9/17 23:12
 */
public class Student {

    private String name = "Resolmi";

    private Integer age = 20;

    public String getName() {
        return name;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

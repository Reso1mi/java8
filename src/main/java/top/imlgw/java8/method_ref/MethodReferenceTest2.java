package top.imlgw.java8.method_ref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author imlgw.top
 * @date 2019/9/18 22:21
 */
public class MethodReferenceTest2 {

    public String getString(Supplier<String> supplier){
        return supplier.get()+"test";
    }

    public String getString(String s, Function<String,String> function){
        return function.apply(s);
    }

    public static void main(String[] args) {
        Student student1=new Student("imlgw",10);
        Student student2=new Student("Resolmi",90);
        Student student3=new Student("Reeee",100);
        Student student4 = new Student("ABC", 23);
        List<Student> students= Arrays.asList(student1,student2,student3,student4);
        //students.sort((s1,s2)->Student.compareStudentByScore(s2,s1));
        //System.out.println(students);
        System.out.println("=============");
        //等价于上面的那种形式

        //1.类名::静态方法名
        students.sort(Student::compareStudentByScore);
        System.out.println(students);
        System.out.println("=============");

        //2.引用名::实例方法名
        StudentComparator studentComparator=new StudentComparator();
        students.sort(studentComparator::compareStudentByScore);
        System.out.println(students);
        System.out.println("=============");

        //3.类名::实例方法名, 调用者为sort中lambda表达式的第一个参数,其他的作为方法参数
        // 其实也就是compareStudentByScore2的第一个参数this
        students.sort(Student::compareStudentByScore2);
        System.out.println(students);

        List<String> cities=Arrays.asList("qindao","yichang","beijing","wuhan");
        Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
        //this作为方法调用者
        Collections.sort(cities,String::compareToIgnoreCase);
        cities.forEach(System.out::println);

        //4.构造方法引用 类名::new
        System.out.println("=============");
        MethodReferenceTest2 methodReferenceTest2=new MethodReferenceTest2();
        System.out.println(methodReferenceTest2.getString(String::new));

        System.out.println(methodReferenceTest2.getString("abc",String::new));
    }
}

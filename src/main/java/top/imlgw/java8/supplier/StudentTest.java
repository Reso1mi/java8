package top.imlgw.java8.supplier;

import java.util.function.Supplier;

/**
 * @author imlgw.top
 * @date 2019/9/17 23:15
 */
public class StudentTest {

    public static void main(String[] args) {
        /*Student student=new Student();
        student.getAge();*/
        //不接受参数,返回一个对象
        Supplier<Student> studentSupplier=()->new Student();
        System.out.println(studentSupplier.get().getName());
        System.out.println("==============");
        //空构造方法引用,不接受参数,返回一个对象
        studentSupplier=Student::new;
        System.out.println(studentSupplier.get().getName());
    }
}

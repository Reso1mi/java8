package top.imlgw.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author imlgw.top
 * @date 2019/9/21 20:13
 */
public class StreamTest10 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2= new Student("lisi", 90, 20);
        Student student3= new Student("wangwu", 90, 30);
        Student student4= new Student("wangwu", 80, 40);
        List<Student> list= Arrays.asList(student1,student2,student3,student4);

        //根据分数分组
        //实现 select * from students group by name;

        /*
        * 传统方式
        * Map<String,List<Student>> map; 键为名字,值为学生列表
        * 1.循环列表
        * 2.取出学生名字
        * 3.检查map中是否已经存在,不存在就添加到map中,存在就加到list中
        * 4.返回map
        * */
        HashMap<String,List<Student>> map=new HashMap<>();
        for (Student student : list) {
            String name=student.getName();
            if (map.containsKey(name)){
                map.get(name).add(student);
            }else{
                //这里还发现了一个坑hahaha
                //asList返回的是Arrays中的一个私有的内部类也叫ArrayList...
                //所以下面这样写是会报错的
                //map.put(name,Arrays.asList(student));
                ArrayList<Student> students= new ArrayList<>();
                students.add(student);
                map.put(name,students);
            }
        }
        System.out.println(map);

        System.out.println("=======================");
        //Stream的方式
        //Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(stu -> stu.getName()));
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(collect);

        System.out.println("=======================");
        //根据分数分组
        //select * from students group by score
        Map<Integer, List<Student>> collect1 = list.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(collect1);

        System.out.println("=======================");
        //select name , count(*) from student group by name;
        Map<String, Long> collect2 = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(collect2);

        System.out.println("=======================");
        //分区
        Map<Boolean, List<Student>> collect3 = list.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() >= 90));
        System.out.println(collect3);
        System.out.println(collect3.get(false));
    }
}

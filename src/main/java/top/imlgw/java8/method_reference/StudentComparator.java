package top.imlgw.java8.method_reference;

/**
 * @author imlgw.top
 * @date 2019/9/18 23:06
 */
public class StudentComparator {
    public int compareStudentByScore(Student student1,Student student2){
        return student1.getScore()-student2.getScore();
    }

    public int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }
}

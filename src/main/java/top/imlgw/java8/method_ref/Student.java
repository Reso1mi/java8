package top.imlgw.java8.method_ref;

/**
 * @author imlgw.top
 * @date 2019/9/18 22:11
 */
public class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static int compareStudentByScore(Student student1, Student student2){
        return student1.score-student2.score;
    }

    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }

    public  int compareStudentByScore2(Student student){
        return this.score-student.score;
    }
}

package top.imlgw.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author imlgw.top
 * @date 2019/9/16 20:42
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("Resolmi", 20);
        Person person2 = new Person("Jack", 23);
        Person person3 = new Person("Mac", 10);

        List<Person> people = Arrays.asList(person1, person2, person3);
        System.out.println(getPersonsByUsername("Resolmi", people));
        System.out.println("=======================name eq Resolmi");
        //BiFunction
        getPersonsByAge(20, people).forEach(System.out::println);
        //System.out.println(getPersonsByAge(20,(age,list)->));
        System.out.println("=======================大于20");
        getPersonsByAge(20,people,(age,list)->list.stream().filter(person ->
                person.getAge()>age).collect(Collectors.toList())).forEach(System.out::println);
        System.out.println("=======================小于20");
        //使用的时候将具体的行为传递进去
        getPersonsByAge(20,people,(age,list)->list.stream().filter(person -> person.getAge()<age)
                .collect(Collectors.toList())).forEach(System.out::println);
    }

    private static List<Person> getPersonsByUsername(String name, List<Person> personList) {
        return personList.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }

    private static List<Person> getPersonsByAge(int age, List<Person> list) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (peoAge, personList) ->
                personList.stream().filter(person -> person.getAge() > peoAge).collect(Collectors
                        .toList());
        return biFunction.apply(age, list);
    }

    private static List<Person> getPersonsByAge(int age, List<Person> list, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, list);
    }
}

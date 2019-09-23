package top.imlgw.java8.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author imlgw.top
 * @date 2019/9/22 16:02
 */
public class JodaTest {
    public static void main(String[] args) {
        DateTime today=new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        System.out.println("===============");

        //设置天为1
        DateTime d1=today.withDayOfMonth(1);
        System.out.println(d1.toString("yyyy-MM-dd"));
        System.out.println("================");

        //LocalDate 当前日期
        LocalDate localDate=new LocalDate();
        //3个月后的第一天日期
        localDate=localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate);

        //计算2年前的第三个月最后一天的日期
        DateTime dateTime=new DateTime();
        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println(dateTime1.toString("yyyy-MM-dd"));
    }
}

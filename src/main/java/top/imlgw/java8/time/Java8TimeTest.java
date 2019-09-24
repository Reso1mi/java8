package top.imlgw.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author imlgw.top
 * @date 2019/9/22 16:38
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        //获取当前日期
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);//2019-09-23
        System.out.println(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());//2019-9-23

        System.out.println("==============");
        LocalDate localDate1=LocalDate.of(2019,9,21);
        System.out.println(localDate1); //2019-09-21

        System.out.println("==============");
        LocalDate localDate2=LocalDate.of(2010,3,25);
        //只考虑月和日
        MonthDay monthDay = MonthDay.of(localDate2.getMonth(),localDate2.getDayOfMonth());
        System.out.println(localDate2.getMonth()); //MARCH
        MonthDay from = monthDay.from(LocalDate.of(2099, 3, 25));
        //只月日相同就相同,适合生日等场景
        if (from.equals(monthDay)){
            System.out.println("equals"); //equals
        }else{
            System.out.println("not eq");
        }


        System.out.println("=============");
        //时分秒
        LocalTime time=LocalTime.now();
        System.out.println(time); //11:50:58.274
        //三个小时20分钟后
        LocalTime localTime = time.plusHours( 3).plusMinutes(20);
        System.out.println(localTime); //15:10:58.274


        System.out.println("==============");
        LocalDate localDate3=LocalDate.now();//2019-9-23
        LocalDate plus = localDate3.plus(2, ChronoUnit.WEEKS);
        System.out.println(plus); //2019-10-07
        System.out.println(localDate3.minus(2,ChronoUnit.MONTHS));

        System.out.println("==============");
        Clock clock=Clock.systemDefaultZone();
        System.out.println(clock.millis()); //1569214626883

        System.out.println("==============");
        LocalDate l1 = LocalDate.of(2019, 9, 22);
        LocalDate l2 = LocalDate.of(1999, 10, 10);
        LocalDate l3 = LocalDate.of(2019, 10, 10);
        LocalDate l4 = LocalDate.of(2019, 10, 10);
        System.out.println(l1.isAfter(l2)); //true
        System.out.println(l3.isAfter(l4)); //false
        System.out.println(l2.equals(l3)); //false

        System.out.println("==============");
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        TreeSet<String> strings = new TreeSet<String>() {
            {
                addAll(availableZoneIds);
            }
        };
        //strings.stream().forEach(System.out::println);
        System.out.println("===============");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); //2019-09-23T13:06:58.698

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime=ZonedDateTime.of(localDateTime,zoneId);
        System.out.println(zonedDateTime); //2019-09-23T13:06:58.698+08:00[Asia/Shanghai]

        System.out.println("===============");
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);//2019-09
        System.out.println(yearMonth.lengthOfMonth());//30
        System.out.println(yearMonth.isLeapYear()); //false
        System.out.println("=============");
        YearMonth yearMonth1= YearMonth.of(1000, 2);
        System.out.println(yearMonth1);//1000-02
        System.out.println(yearMonth1.lengthOfMonth());//28
        System.out.println(yearMonth1.isLeapYear());//false

        System.out.println("=============");
        LocalDate lo1 = LocalDate.now();
        LocalDate lo2 = LocalDate.of(2018,12,8);
        Period between = Period.between(lo2, lo1);
        System.out.println(between.getYears()); //0 符合人类直觉 ：0年,9个月,15天
        System.out.println(between.getMonths());//9
        System.out.println(between.getDays());  //15

        System.out.println("============");
        //不带时区的UTC
        System.out.println(Instant.now()); //2019-09-24T09:37:31.355Z

        System.out.println("============");
        //format
        LocalDateTime ldt=LocalDateTime.of(2019,9,9,17,40,14);
        System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));//2019-09-09T17:40:14
        System.out.println(ldt.format(DateTimeFormatter.ISO_DATE));//2019-09-09
        System.out.println(ldt.format(DateTimeFormatter.BASIC_ISO_DATE));//20190909
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); //2019-09-09 17:40:14


        //parse
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(formatter.parse("2019-09-09T17:40:14"));//{},ISO resolved to 2019-09-09T17:40:14
        System.out.println(DateTimeFormatter.ISO_DATE.parse("2019-09-09"));//{},ISO resolved to 2019-09-09
        System.out.println(DateTimeFormatter.BASIC_ISO_DATE.parse("20190909"));//{},ISO resolved to 2019-09-09
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2019-09-09 17:40:14"));//{},ISO resolved to 2019-09-09T17:40:14
    }
}


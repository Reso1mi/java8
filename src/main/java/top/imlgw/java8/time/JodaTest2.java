package top.imlgw.java8.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author imlgw.top
 * @date 2019/9/22 16:30
 */
public class JodaTest2 {
    public static void main(String[] args) {
        System.out.println(JodaTest2.UTC2Date("2014-11-04T09:22:54.876Z"));
        System.out.println(JodaTest2.Date2UTC(new Date()));
        System.out.println(JodaTest2.Date2LocalByDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }

    public static Date UTC2Date(String utc){
        DateTime parse = DateTime.parse(utc, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return parse.toDate();
    }

    public static String Date2UTC(Date date){
        DateTime parse = new DateTime(date,DateTimeZone.UTC);
        return parse.toString();
    }

    public static String Date2LocalByDateFormat(Date date,String format){
        DateTime dateTime=new DateTime(date);
        return dateTime.toString(format);
    }

}

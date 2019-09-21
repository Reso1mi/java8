package top.imlgw.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author imlgw.top
 * @date 2019/9/21 16:10
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(5000000);
        for (int i=0;i<5000000;i++){
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("start sort...");
        long startTime=System.currentTimeMillis();
        //sorted不是终止操作,需要在后面加上终止操作
        //并行流(注意并行和并发的区别)
        list.parallelStream().sorted().toArray();
        System.out.println("耗时:"+(System.currentTimeMillis()-startTime));
    }
}

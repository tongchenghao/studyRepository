import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description:策略模式，list排序方式使用的就是策略模式
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class StrategyDemo01 {

    public static void main(String[] args) {
        List<Integer> data1 = new ArrayList<>();
        data1.add(8);
        data1.add(2);
        data1.add(1);
        data1.add(6);
        data1.add(9);
        data1.add(8);
        List<Integer> data2 = new ArrayList<>();
        data2.add(8);
        data2.add(2);
        data2.add(1);
        data2.add(6);
        data2.add(9);
        data2.add(8);
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        /**
         * jdk提供的排序方式为策略模式
         * 结果只返回0,-1,1
         * 但中间比较的逻辑是不确定的
         */
        Collections.sort(data1, comparator);
        System.out.println(data1);
        /**
         * 自己通过策略模式写的sort方法
         */
        TchCollections.sort(data2,comparator);
        System.out.println(data2);
    }
}

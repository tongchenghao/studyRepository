import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @description:自己写策略模式的sort方法
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class TchCollections {

    public static <T> void sort(List<T> data, Comparator<T> comparator){
        for (int i = 0;i<(data.size()-1);i++){
            for (int j = 1;j<data.size()-i;j++){
                int result = comparator.compare(data.get(i),data.get(i+j));
                if(result>0){
                    T item = data.get(i+j);
                    data.set(i+j,data.get(i));
                    data.set(i,item);
                }else if(result<0){

                }else{

                }
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class Deneme {

    Map<Integer, Integer> fibo = new HashMap<>();


    int counter = 0;

    public Integer deneme(Integer i) {
        fibo.put(0,0);
        fibo.put(1,1);
        if (fibo.containsKey(i)){
            return fibo.get(i);
        }
        fibo.put(i,deneme(i - 1) + deneme(i - 2));

        return fibo.get(i);


    }

}

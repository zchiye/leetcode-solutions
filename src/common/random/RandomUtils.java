package common.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static List<Integer> randomIntList(int min, int max, int length) {
        return randomIntList(min, max, length, System.currentTimeMillis());
    }

    public static List<Integer> randomIntList(int min, int max, int length, long seed) {
        Random random = new Random(seed);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            resultList.add(random.nextInt(min, max));
        }
        return resultList;
    }

}

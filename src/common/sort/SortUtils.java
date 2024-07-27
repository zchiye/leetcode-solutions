package common.sort;

import common.random.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class SortUtils {

    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<T>> void quickSort(List<T> list, int start, int end) {
        if (list == null || start < 0 || end >= list.size() || end - start < 1) {
            return;
        }
        T target = list.get(start);
        int i = start;
        int j = end;
        int k = j;
        while (i < j) {
            T o = list.get(k);
            if (o.compareTo(target) <= 0) {
                list.set(i, o);
                i++;
                k = i;
            } else if (o.compareTo(target) > 0) {
                list.set(j, o);
                j--;
                k = j;
            }
        }
        list.set(k, target);
        quickSort(list, start, k - 1);
        quickSort(list, k + 1, end);
    }


    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>(RandomUtils.randomIntList(1, 101, 1_000));
        System.out.println(testList);
        System.out.println(validateSorted(testList));
        quickSort(testList);
        System.out.println(testList);
        System.out.println(validateSorted(testList));
    }

    public static <T extends Comparable<T>> boolean validateSorted(List<T> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

}

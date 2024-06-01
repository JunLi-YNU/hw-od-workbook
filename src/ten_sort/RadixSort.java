package ten_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 12:06:00
 * @version: 1.0
 * @Description: 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        secondMethod(intNumArr);
    }

    private static void secondMethod(int[] intNumArr) {
        if (intNumArr == null || intNumArr.length < 2) {
            return;
        }
        int maxValue = intNumArr[0];
        for (int num : intNumArr
        ) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        //计算最大值是几位数
        int maxValueCharLength = 1;
        while (maxValue / 10 > 0) {
            maxValueCharLength++;
            maxValue /= 10;
        }
        //创建1个桶
        List<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<>());
        }
        //进行每一次排序从个位数开始排
        for (int i = 1; i <= maxValueCharLength; i++) {
            for (int k : intNumArr) {
                int lastCharToNum = (k / (int) Math.pow(10, i - 1)) % 10;
                bucketList.get(lastCharToNum).add(k);
            }
            int currentIndex = 0;
            for (LinkedList<Integer> linkedList : bucketList
            ) {
                for (int num : linkedList
                ) {
                    intNumArr[currentIndex++] = num;
                }
                linkedList.clear();
            }
        }
        for (int num : intNumArr
        ) {
            System.out.print(num + " ");
        }

    }

    private static void firstMethod(int[] intNumArr) {
        int maxValueLength = getMaxValueLength(intNumArr);

        int index = 0;
        for (int i = 1; i < maxValueLength; i++) {
            List<List<Integer>> tempList = new ArrayList<>();
            tempList.add(0, new ArrayList<>());
            tempList.add(1, new ArrayList<>());
            tempList.add(2, new ArrayList<>());
            tempList.add(3, new ArrayList<>());
            tempList.add(4, new ArrayList<>());
            tempList.add(5, new ArrayList<>());
            tempList.add(6, new ArrayList<>());
            tempList.add(7, new ArrayList<>());
            tempList.add(8, new ArrayList<>());
            tempList.add(9, new ArrayList<>());
            for (int k : intNumArr) {
                System.out.println("K:" + k + " _ " + k % (10 * i));
                tempList.get(k / (10 * i) % 10).add(k);
            }
            for (List<Integer> numList : tempList
            ) {
                if (numList != null) {
                    for (Integer num : numList
                    ) {
                        intNumArr[index] = num;
                        index++;
                    }
                }
            }


        }
        for (int a : intNumArr
        ) {
            System.out.println(a + " ");
        }
    }

    private static int getMaxValueLength(int[] intNumArr) {
        int maxValue = Integer.MIN_VALUE;
        for (int j : intNumArr) {
            if (maxValue < j) {
                maxValue = j;
            }
        }
        return String.valueOf(maxValue).length();
    }
}

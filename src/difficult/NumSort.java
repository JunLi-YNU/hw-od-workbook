package difficult;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月10日 21:11:19
 * @version: 1.0
 * @Description: 题目描述
 * 小明今年升学到了小学1年级来到新班级后，发现其他小朋友身高参差不齐，
 * 然后就想基于各小朋友和自己的身高差，对他们进行排序，请帮他实现排序。
 * 输入描述
 * 第一行为正整数 h和n，0<h<200 为小明的身高，0<n<50 为新班级其他小朋友个数。
 * 第二行为n个正整数，h1 ~ hn分别是其他小朋友的身高，取值范围0<hi<200，且n个正整数各不相同。
 * 输出描述
 * 输出排序结果，各正整数以空格分割，
 * 和小明身高差绝对值最小的小朋友排在前面，
 * 和小明身高差绝对值最大的小朋友排在后面，
 * 如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 * 用例
 * 输入
 * <p>
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * <p>
 * 输出
 * <p>
 * 99 101 98 102 97 103 96 104 95 105
 */
public class NumSort {
    public static void main(String[] args) {
        getSortNum();
    }

    private static void getSortNum() {
        Scanner scanner = new Scanner(System.in);
        int targetHeight = scanner.nextInt();
        int count = scanner.nextInt();
        ArrayList<Integer> allClassHeight = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            allClassHeight.add(scanner.nextInt());
        }
        allClassHeight.sort((o1, o2) -> {//95 96 97 98 99 101 102 103 104 105
            System.out.println("o1:" + o1 + " o2:" + o2);
            int i = Math.abs(targetHeight - o1);
            int j = Math.abs(targetHeight - o2);
            if (j == i) {
                return o1 - o2;
            }
            return i - j;
        });
        System.out.println();
        for (Integer height : allClassHeight
        ) {
            System.out.print(height + " ");//区间和
        }
    }
}

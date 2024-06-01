package ten_sort;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 11:24:49
 * @version: 1.0
 * @Description: Shell排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        int exchangeCount = 0;
        for (int gap = (int) Math.floor((double) intNumArr.length / 2); gap > 0; gap = (int) Math.floor((double) gap / 2)) {
            for (int i = gap; i < intNumArr.length; i++) {
                int j = i;
                int current = intNumArr[i];
                while (j - gap >= 0 && intNumArr[j - gap] > current) {
                    intNumArr[j] = intNumArr[j - gap];
                    j = j - gap;
                    exchangeCount++;
                }
                intNumArr[j] = current;
                exchangeCount++;
                System.out.println();
                for (int num : intNumArr
                ) {
                    System.out.println(num + " ");
                }
            }
            System.out.println("exchangeCount: " + exchangeCount);
        }
    }
}

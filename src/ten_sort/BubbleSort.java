package ten_sort;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 10:32:33
 * @version: 1.0
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        int exchangeCount = 0;
        for (int i = 0; i < intNumArr.length - 1; i++) {
            for (int j = 0; j < intNumArr.length - 1; j++) {
                if (intNumArr[j] > intNumArr[j + 1]) {
                    int mTemp = intNumArr[j];
                    intNumArr[j] = intNumArr[j + 1];
                    intNumArr[j + 1] = mTemp;
                    exchangeCount++;
                    System.out.println();
                    for (int num : intNumArr
                    ) {
                        System.out.print(num + " ");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("exchangeCount:" + exchangeCount);
    }
}

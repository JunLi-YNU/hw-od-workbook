package ten_sort;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 10:43:42
 * @version: 1.0
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        int exchangeCount = 0;
        for (int i = 0; i < intNumArr.length; i++) {
            for (int j = i + 1; j < intNumArr.length; j++) {
                if (intNumArr[i] > intNumArr[j]) {
                    int mTemp = intNumArr[j];
                    intNumArr[j] = intNumArr[i];
                    intNumArr[i] = mTemp;
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
        System.out.println("exchangeCount: " + exchangeCount);
    }
}

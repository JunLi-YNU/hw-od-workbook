package ten_sort;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 10:51:34
 * @version:
 * @Description:
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        int exchangeCount = 0;
        int preIndex, currentValue;
        for (int i = 1; i < intNumArr.length; i++) {
            preIndex = i - 1;
            currentValue = intNumArr[i];
            while (preIndex >= 0 && intNumArr[preIndex] > currentValue) {
                intNumArr[preIndex + 1] = intNumArr[preIndex];
                preIndex--;
                exchangeCount++;
            }
            intNumArr[preIndex + 1] = currentValue;
            exchangeCount++;
            System.out.println();
            for (int num : intNumArr
            ) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.println("exchangeCount: " + exchangeCount);
    }
}

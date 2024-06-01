package ten_sort;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 14:54:38
 * @version: 1.0
 * @Description: 快排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] intNumArr = new int[]{1, 10, 23, 13, 123, 123, 456, 76, 32, 234};
        quickSort(intNumArr, 0, intNumArr.length - 1);
        for (int num : intNumArr
        ) {
            System.out.print(num + " ");
        }

    }

    private static void quickSort(int[] intNumArr, int left, int right) {
        if (left < right) {
            int midIndex = partition(intNumArr, left, right);
            System.out.println("------------------------midIndex:" + midIndex);
            for (int num : intNumArr
            ) {
                System.out.print(num + " ");
            }

            quickSort(intNumArr, left, midIndex - 1);
            quickSort(intNumArr, midIndex + 1, right);
        }
    }

    private static int partition(int[] intNumArr, int left, int right) {
        int midValue = intNumArr[left];
        int leftIndex = left + 1;
        int rightIndex = right;
        while (true) {
            while (leftIndex <= rightIndex && intNumArr[leftIndex] < midValue) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && intNumArr[rightIndex] > midValue) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            int temp = intNumArr[rightIndex];
            intNumArr[rightIndex] = intNumArr[leftIndex];
            intNumArr[leftIndex] = temp;
        }
        intNumArr[left] = intNumArr[rightIndex];
        intNumArr[rightIndex] = midValue;
        System.out.println("------------------------rightIndex:" + rightIndex);
        for (int num : intNumArr
        ) {
            System.out.print(num + " ");
        }
        return rightIndex;
    }
}

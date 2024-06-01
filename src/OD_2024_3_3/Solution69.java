package OD_2024_3_3;

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月03日 10:57:26
 * @version: 1.0
 * @Description: 数组连续和
 */
public class Solution69 {
    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in);
        int inputNumCounts = mInputScanner.nextInt();
        int inputTargetMaxSum = mInputScanner.nextInt();
        int[] inputNumArr = new int[inputNumCounts];
        for (int i = 0; i < inputNumCounts; i++) {
            inputNumArr[i] = mInputScanner.nextInt();
        }
        int mTargetTrueTargetCounts = getTargetSumCounts(inputNumArr, inputTargetMaxSum);
        System.out.println(mTargetTrueTargetCounts);
    }

    private static int getTargetSumCounts(int[] inputNumArr, int inputTargetMaxSum) {
        int targetTrueTargetCounts = 0;
        int[] numsSumArr = new int[inputNumArr.length + 1];
        for (int i = 1; i <= inputNumArr.length; i++) {
            numsSumArr[i] = numsSumArr[i - 1] + inputNumArr[i - 1];
        }
        System.out.println();
        for (int sum : numsSumArr
        ) {
            System.out.print(sum + " ");
        }
        int leftIndex = 0;
        int rightIndex = 1;
        while (rightIndex < numsSumArr.length) {
            if ((numsSumArr[rightIndex] - numsSumArr[leftIndex]) >= inputTargetMaxSum) {
                targetTrueTargetCounts += inputNumArr.length - rightIndex + 1;
                leftIndex++;
                rightIndex = leftIndex + 1;
            } else {
                rightIndex++;
            }
        }
        return targetTrueTargetCounts;
    }
}

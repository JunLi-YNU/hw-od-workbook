package OD_2024_2_29;

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月29日 17:46:24
 * @version: 1.0
 * @Description:
 */
public class Solution57 {
    static int currentNetworkCount = 0;

    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in);
        int mRow = mInputScanner.nextInt();
        int mCol = mInputScanner.nextInt();
        int[][] networkArr = new int[mRow][mCol];
        setNetwork(mRow, mCol, networkArr, mInputScanner);
        int maxNetworkCount = 0;

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                if (networkArr[i][j] == 1) {
                    mDFS(networkArr, i, j);
                    System.out.println("c:" + currentNetworkCount);
                    maxNetworkCount = Math.max(maxNetworkCount, currentNetworkCount);
                    currentNetworkCount = 0;
                }
            }
        }
        System.out.println(maxNetworkCount);
    }

    static void mDFS(int[][] networkArr, int row, int col) {
        if (row < 0 || row >= networkArr.length || col < 0 ||
                col >= networkArr[0].length || networkArr[row][col] == 0) {
            return;
        }

        networkArr[row][col] = 0;
        currentNetworkCount++;
        mDFS(networkArr, row + 1, col);
        mDFS(networkArr, row - 1, col);
        mDFS(networkArr, row, col + 1);
        mDFS(networkArr, row, col - 1);
    }

    private static void setNetwork(int mRow, int mCol, int[][] networkArr, Scanner mInputScanner) {
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                networkArr[i][j] = mInputScanner.nextInt();
            }
        }
    }
}

package OD_2024_2_29;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月01日 15:37:44
 * @version: 1.0
 * @Description: 找单词
 * 4
 * A,C,C,F
 * C,D,E,D
 * B,E,S,S
 * F,E,C,A
 * ACCESS
 */
public class Solution55 {
    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in).useDelimiter("[,\n]");
        int inputArrLength = mInputScanner.nextInt();
        String[][] inputCharArr = new String[inputArrLength][inputArrLength];
        for (int i = 0; i < inputCharArr.length; i++) {
            for (int j = 0; j < inputCharArr.length; j++) {
                inputCharArr[i][j] = mInputScanner.next();
            }
        }
        String targetStr = mInputScanner.next();
        for (int i = 0; i < inputCharArr.length; i++) {
            for (int j = 0; j < inputCharArr.length; j++) {
                LinkedList<int[]> targetStrIndex = new LinkedList<>();
                if (secondMethod55(inputCharArr, i, j, targetStr, 0, targetStrIndex)) {
                    for (int[] targetIndex:targetStrIndex
                         ) {
                        System.out.print(targetIndex[0]+","+targetIndex[1]+" ");
                    }
                }
            }
        }
    }

    private static boolean secondMethod55(String[][] inputCharArr, int row, int col, String targetStr
            , int currentIndex, LinkedList<int[]> targetStrIndex) {
        if (row < 0 || row >= inputCharArr.length || col < 0 || col >= inputCharArr.length
                || !targetStr.substring(currentIndex, currentIndex + 1).equals(inputCharArr[row][col])) {
            return false;
        }
        targetStrIndex.add(new int[]{row, col});
        if (targetStrIndex.size() == targetStr.length()) {
            return true;
        }
        String currentStr = inputCharArr[row][col];
        inputCharArr[row][col] = null;
        boolean isFinished = (
                secondMethod55(inputCharArr, row + 1, col, targetStr, currentIndex + 1, targetStrIndex)
                        || secondMethod55(inputCharArr, row - 1, col, targetStr, currentIndex + 1, targetStrIndex)
                        || secondMethod55(inputCharArr, row, col + 1, targetStr, currentIndex + 1, targetStrIndex)
                        || secondMethod55(inputCharArr, row, col - 1, targetStr, currentIndex + 1, targetStrIndex));

        if (!isFinished) {
            inputCharArr[row][col] = currentStr;
            targetStrIndex.removeLast();
        }
        return isFinished;
    }

    private static void firstMethod(String[][] inputCharArr, int i, int j, String targetStr) {
        List<int[]> targetIndex = new ArrayList<>();
        m55DFS(inputCharArr, i, j, targetIndex, targetStr, 0);
        for (int[] arr : targetIndex
        ) {
            System.out.print(arr[0] + "," + arr[1] + " ");
        }
    }


    private static boolean m55DFS(String[][] inputCharArr, int row, int col,
                                  List<int[]> targetIndex, String targetStr, int currentStrIndex) {

        if (row < 0 || row >= inputCharArr.length || col < 0 || col >= inputCharArr.length
                || !inputCharArr[row][col].equals(targetStr.substring(currentStrIndex, currentStrIndex + 1))) {
            return false;
        }

        String tempStr = inputCharArr[row][col];
        inputCharArr[row][col] = null;
        targetIndex.add(new int[]{row, col});
        m55DFS(inputCharArr, row + 1, col, targetIndex, targetStr, currentStrIndex + 1);
        m55DFS(inputCharArr, row - 1, col, targetIndex, targetStr, currentStrIndex + 1);
        m55DFS(inputCharArr, row, col + 1, targetIndex, targetStr, currentStrIndex + 1);
        m55DFS(inputCharArr, row, col - 1, targetIndex, targetStr, currentStrIndex + 1);
        inputCharArr[row][col] = tempStr;
        if (targetIndex.size() < targetStr.length()) {
            targetIndex.clear();
        }
        return false;
    }
}

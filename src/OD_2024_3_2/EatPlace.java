package OD_2024_3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月02日 18:06:36
 * @version: 1.0
 * @Description:
 */
public class EatPlace {
    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in);
        int m = mInputScanner.nextInt();
        int n = mInputScanner.nextInt();
        int[][] mapArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mapArr[i][j] = mInputScanner.nextInt();
            }
//            int[] inputMapLine = Arrays.stream(mInputScanner.nextLine().split(" "))
//                    .mapToInt(Integer::parseInt).toArray();
//            System.arraycopy(inputMapLine, 0, mapArr[i], 0, n);
        }
        UnionFind mUnionFind = new UnionFind(m * n);
        ArrayList<Integer> personPoints = new ArrayList<>();
        ArrayList<Integer> eatingPoint = new ArrayList<>();
        int[][] offsets = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mapArr[i][j] != 1) {
                    //将二维坐标转化为一维坐标
                    int index = i * n + j;

                    if (mapArr[i][j] == 2) {
                        personPoints.add(index);
                    }
                    if (mapArr[i][j] == 3) {
                        eatingPoint.add(index);
                    }
                    for (int[] offset : offsets
                    ) {
                        int row = i + offset[0];
                        int col = j + offset[1];
                        if (row >= 0 && row < m && col >= 0 && col < n && mapArr[row][col] != 1) {
                            mUnionFind.union(index, row * n + col);
                        }
                    }
                }
            }
        }
        int firstPersonPoint = mUnionFind.find(personPoints.get(0));
        int secondPersonPoint = mUnionFind.find(personPoints.get(1));
        int eatPointCount = 0;
        if(firstPersonPoint != secondPersonPoint){

        }else {
            for (int eatPoint:eatingPoint
            ) {
                if(mUnionFind.find(eatPoint) == firstPersonPoint){
                    eatPointCount++;
                }
            }
        }
        System.out.println(eatPointCount);
    }

    static class UnionFind {
        int[] unionFindArr;

        UnionFind(int unionFindLength) {
            unionFindArr = new int[unionFindLength];
            for (int i = 0; i < unionFindLength; i++) {
                unionFindArr[i] = i;
            }
        }

        public int find(int o) {
            if (o != this.unionFindArr[o]) {
                this.unionFindArr[o] = this.find(this.unionFindArr[o]);
                return this.unionFindArr[o];
            }
            return o;
        }

        public void union(int o1, int o2) {
            int num1 = find(o1);
            int num2 = find(o2);
            if (num2 != num1) {
                this.unionFindArr[num2] = num1;
            }
        }
    }
}

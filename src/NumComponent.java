import java.util.*;

import static java.util.Collections.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月28日 14:28:16
 * @version: 1.0
 * @Description:
 */
public class NumComponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputNumArr = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputNumArr);
        int maxNum = inputNumArr[inputNumArr.length - 1];
        System.out.println();
        List<Integer> targetNumArr = new ArrayList<Integer>();
        mDfs(targetNumArr, inputNumArr, 0, "", new boolean[inputNumArr.length]);
        Collections.sort(targetNumArr);
        System.out.println();
        for (int num : targetNumArr
        ) {
            System.out.print(num + ",");
        }
        System.out.println();
        if (targetNumArr.size() >= maxNum - 1) {
            System.out.println(targetNumArr.get(maxNum - 1));
        }
    }

    private static int getIntegers(int num) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(6, 9);
        hashMap.put(9, 6);
        hashMap.put(2, 5);
        hashMap.put(5, 2);
        if (!hashMap.containsKey(num)) {
            return -1;
        }
        return hashMap.get(num);
    }

    private static void mDfs(List<Integer> targetNumArr, int[] relyNum,
                             int currentLength, String currentNumStr, boolean[] isVisit) {
        if (!currentNumStr.isEmpty()) {
            System.out.print(Integer.parseInt(currentNumStr) + ",");
            targetNumArr.add(Integer.parseInt(currentNumStr));
        }
        if (currentLength == relyNum.length) {
            return;
        }
        for (int i = 0; i < relyNum.length; i++) {
            if (isVisit[i]) continue;
            isVisit[i] = true;
            mDfs(targetNumArr, relyNum, currentLength + 1,
                    currentNumStr + relyNum[i], isVisit);
            if (getIntegers(relyNum[i]) != -1) {
                mDfs(targetNumArr, relyNum, currentLength + 1,
                        currentNumStr + getIntegers(relyNum[i]), isVisit);
            }
            isVisit[i] = false;
        }
    }
}

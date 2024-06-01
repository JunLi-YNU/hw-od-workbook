package OD_2024_2_28;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月28日 13:11:29
 * @version: 1.0
 * @Description:
 */
public class OD258 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int inputArrLength = inputArr.length;
        if (inputArrLength == 0) {
            System.out.println();
        }
        if (inputArrLength == 1) {
            System.out.println(inputArr[0]);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : inputArr
        ) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        list.sort(((o1, o2) -> hashMap.get(o2) - hashMap.get(o1)));
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ",");
            } else {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }
}

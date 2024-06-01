import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月12日 22:22:51
 * @version: 1.0
 * @Description: 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 * 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
 * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。
 * <p>
 * 输入描述
 * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * <p>
 * 输出描述
 * 输出众数组成的新数组的中位数
 */
public class MidNum {
    public static void main(String[] args) {
        printMidNum();
    }

    private static void printMidNum() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> manyNum = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            int key = manyNum.getOrDefault(num, 0) + 1;
            manyNum.put(num, manyNum.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, key);
        }

        int finalMaxCount = maxCount;
        List<Integer> targetNum = manyNum.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == finalMaxCount)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
        System.out.println();
        for (int x : targetNum
        ) {
            System.out.print(x + " ");
        }
        System.out.println();
        int median;
        if (targetNum.size() % 2 != 0) {
            int index = (targetNum.size() + 1) / 2 - 1;
            median = targetNum.get(index);
        } else {
            int indexOne = targetNum.size() / 2;
            int indexTwo = targetNum.size() / 2 + 1;
            median = (targetNum.get(indexTwo) + targetNum.get(indexOne)) / 2;
        }
        System.out.println(median);
    }
}

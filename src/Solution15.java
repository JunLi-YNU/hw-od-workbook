import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月18日 11:25:12
 * @version: 1.0
 * @Description:
 */
public class Solution15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> targetList = new HashSet<>();
        int targetSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isLegal(i, j, k, nums) && sum(i, j, k, nums) == targetSum) {
                        ArrayList<Integer> targetEle = new ArrayList<>();
                        targetEle.add(nums[i]);
                        targetEle.add(nums[j]);
                        targetEle.add(nums[k]);
                        targetEle.sort(Comparator.comparingInt(o -> o));
                        targetList.add(targetEle);
                    }
                }
            }
        }
        return targetList.stream().toList();
    }

    private static boolean isLegal(int i, int j, int k, int[] nums) {
        return (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]);
    }

    public static int sum(int i, int j, int k, int[] nums) {
        return nums[i] + nums[j] + nums[k];
    }
}

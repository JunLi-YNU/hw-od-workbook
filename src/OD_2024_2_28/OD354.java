package OD_2024_2_28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月28日 13:42:19
 * @version: 1.0
 * @Description:
 */
public class OD354 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int h = scanner.nextInt();
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int peachCount : inputArr
        ) {
            maxSpeed = Math.max(maxSpeed, peachCount);
        }
        boolean isCanComplete = false;

        int targetSpeed = 0;
        while (minSpeed <= maxSpeed) {
            int needTime = 0;
            int midSpeed = (minSpeed + maxSpeed) / 2;
            for (int peachCount : inputArr
            ) {
                needTime += ((midSpeed - 1 + peachCount) / midSpeed);
            }
            System.out.println("needTime:" + needTime + "midSpeed:" + midSpeed);
            if (needTime <= h) {
                maxSpeed = midSpeed - 1;
                targetSpeed = midSpeed;
            } else {
                minSpeed = midSpeed + 1;
            }
        }
        System.out.println(targetSpeed);
    }
}

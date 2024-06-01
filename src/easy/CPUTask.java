package easy;

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月08日 20:53:29
 * @version: 1.0
 * @Description: 为了充分发挥GPU[算力]，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，
 * 数组元素表示在这1秒内新增的任务个数且每秒都有新增任务。
 * 假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成。
 * 输入描述
 * 第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
 * 第二个参数为任务数组长度，
 * 取值范围[1, 10000]
 * 第三个参数为任务数组，数字范围[1, 10000]
 */
public class CPUTask {
    public static void main(String[] args) {
        cpuTask();
    }

    private static void cpuTask() {
        Scanner scanner = new Scanner(System.in);
        int mastTaskCount = scanner.nextInt();
        int taskArrayLength = scanner.nextInt();
        int[] taskArr = new int[taskArrayLength];
        for (int i = 0; i < taskArrayLength; i++) {
            taskArr[i] = scanner.nextInt();
        }
        int time = 0;
        int concurrentTaskCount = 0;
        int index = 0;
        while (concurrentTaskCount != 0 || index != taskArr.length) {
            if (index < taskArr.length) {
                concurrentTaskCount += taskArr[index];
                index++;
            }
            concurrentTaskCount -= mastTaskCount;
            if (concurrentTaskCount < 0) {
                concurrentTaskCount = 0;
            }
            time++;
        }
        System.out.println(time);
    }
}

package difficult;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月08日 22:54:36
 * @version: 1.0
 * @Description: 题目描述
 * 2020年题：  英雄联盟是一款十分火热的对战类游戏。每一场对战有10位玩家参与，分为两组，每组5人。
 * 每位玩家都有一个战斗力，代表着这位玩家的厉害程度。为了对战尽可能精彩，我们需要把玩家们分为实力尽量相等的两组。
 * 一组的实力可以表示为这一组5位玩家的战斗力和。现在，给你10位玩家的战斗力，请你把他们分为实力尽量相等的两组。
 * 请你输出这两组的实力差。
 * 2023年题：
 * 部门准备举办一场王者荣耀表演赛，有10名游戏爱好者参与，分5为两队，每队5人。每位参与者都有一个评分，
 * 代表着他的游戏水平。为了表演赛尽可能精彩，我们需要把10名参赛者分为实力尽量相近的两队。
 * 一队的实力可以表示为这一队5名队员的评分总和。 现在给你10名参与者的游戏水平评分，
 * 请你根据上述要求分队最后输出这两组的实力差绝对值。
 * 例: 10名参赛者的评分分别为5 1 8 3 4 6 710 9 2，分组为 (135 8 10) (24 679)，
 * 两组实力差最小，差值为1。有多种分法，但实力差的绝对值最小为1。
 * <p>
 * 输入描述
 * 10个整数，表示10名参与者的游戏水平评分。范围在[1,10000]之间
 * 输出描述
 * <p>
 * 1个整数，表示分组后两组实力差绝对值的最小值.
 */
public class LOLTeam {
    static int res = Integer.MAX_VALUE;
    static int totalSum = 0;
    static int targetSum = 0;

    public static void main(String[] args) {
        unitTeam();
    }


    private static void unitTeam() {
        Scanner scanner = new Scanner(System.in);
//        int[] players = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
        int[] players = new int[10];
        System.out.println(players.length);
        for (int i = 0; i < 10; i++) {
            players[i] = scanner.nextInt();
        }
        for (int player : players
        ) {
            totalSum += player;
        }
        targetSum = totalSum / 2;
        dfs(players, 0, 0, 0);
        System.out.println(res);
        scanner.close();
    }

    private static void dfs(int[] players, int idx, int count, int currentTeamSum) {
        if (currentTeamSum > targetSum) return;

        if (count == 5) {
            int otherTeamSum = totalSum - currentTeamSum;
            res = Math.min(res, Math.abs(currentTeamSum - otherTeamSum));
            return;
        }
        if (idx == 10) return;
        dfs(players, idx + 1, count + 1, currentTeamSum + players[idx]);
        dfs(players, idx + 1, count, currentTeamSum);
    }
}

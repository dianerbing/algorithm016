package wb.test;

/**
 * 547.朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class FindCircleNum {
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M[0].length < 1) return 0;
        boolean[] fd = new boolean[M.length];

        int ans = 0;
        for (int i = 0; i < fd.length; i++) {
            if (!fd[i]) {
                findFriend(i, fd, M);
                ans++;
            }
        }

        return ans;
    }

    public static void findFriend(int id, boolean[] fd, int[][] m) {
        fd[id] = true;

        for (int i = 0; i < fd.length; i++) {
            if (id != i && m[id][i] == 1 && !fd[i]) {
                findFriend(i, fd, m);
            }
        }
    }
}

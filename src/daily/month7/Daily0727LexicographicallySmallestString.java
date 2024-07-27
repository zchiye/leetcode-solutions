package daily.month7;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/description/?envType=daily-question&envId=2024-07-27">3106. 满足距离约束且字典序最小的字符串</a>
 */
public class Daily0727LexicographicallySmallestString {

    static class Solution {
        public String getSmallestString(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (k <= 0) {
                    sb.append(s.substring(i));
                    break;
                }
                char c = s.charAt(i);
                int dis = getCharDistance(c, 'a');
                if (dis <= k) {
                    sb.append('a');
                } else {
                    dis = k;
                    char t = (char) (c - dis);
                    if (t < 'a') {
                        t = (char) (t + 2 * dis);
                    }
                    sb.append(t);
                }
                k -= dis;
            }

            return sb.toString();
        }

        int getCharDistance(char c1, char c2) {
            int dis1;
            int dis2;
            if (c2 > c1) {
                dis1 = c2 - c1;
                dis2 = c1 + 26 - c2;
            } else if (c2 < c1) {
                dis1 = c1 - c2;
                dis2 = c2 + 26 - c1;
            } else {
                return 0;
            }
            return Math.min(dis1, dis2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString("zbbz", 3));
        System.out.println(solution.getSmallestString("xaxcd", 4));
        System.out.println(solution.getSmallestString("lol", 0));
    }

}

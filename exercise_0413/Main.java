package exercise.exercise_0413;


/*
数字和为sum的方法数
题目描述
给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
输入描述:
输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。
输出描述:
输出所求的方案数
示例1
输入
5 15 5 5 10 2 3
输出
4
 */
//dp[i,j]//前i个可以凑到j的个数
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        long[][] dp = new long[n+1][m+1];
        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
            // System.out.println(p[i]);
        }
        //用前i个数据组成0的方案只有一种
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        //用前0个数据组成j的方案不存在
        for(int j=1; j<m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                //等于拿了这个数据和没拿这个数据的方案总和，没拿时只需要看前i-1个数据组成j-p[i]的方案数
                if(p[i] <= j){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-p[i]];
                }else{//p[i]>j时只能选择不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
*/

/*
统计字符
题目描述
给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
输入描述:
输入数据一个字符串，包括字母,数字等。
输出描述:
输出首先出现三次的那个英文字符
示例1
输入
Have you ever gone shopping and
输出
e
 */
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char res = solution(str);
        if(res != '0'){
            System.out.println(res);
        }
    }
    private static char solution(String str){
        int len = str.length();
        if(len < 3){
            return '0';
        }
        for(int i=2; i<len; i++){
            char t = str.charAt(i);
            if(('a'<= t && t<='z')||('A'<=t && t<='Z')){
                int count = 0;
                for(int j=0; j<i; j++){
                    if(str.charAt(j) == t){
                        count++;
                        if(count == 2){
                            return t;
                        }
                    }
                }
            }
        }
        return '0';
    }
}*/

/*
丢失的三个数
题目描述
现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
输入描述:
输入数据为一行，包含9997个数字，空格隔开。
输出描述:
输出为一行，包含一个数字。
示例1
输入
同题设例子输入
输出
2
 */
/*
import java.util.*;
import java.math.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10001];
        for(int i=0; i<9997; i++){
            int t = sc.nextInt();
            nums[t] = 1;
        }
        int c = 0;
        String s = "";
        for(int i=1; i<10001; i++){
            if(nums[i] != 1){
                s += String.valueOf(i);
                c++;
            }
            if(c == 3){
                break;
            }
        }
        BigInteger b = new BigInteger(s);
        System.out.println(b.mod(BigInteger.valueOf(7)));
    }
}*/

/*
连续最大和
题目描述
一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
输入描述:
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
输出描述:
所有连续子数组中和最大的值。
示例1
输入
3 -1 2 1
输出
3
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur_num = 0;//当前子序列和
        int max_num = 0;//最大子序列和
        for(int i=0; i<n; i++){
            cur_num += sc.nextInt();
            if(i == 0){
                max_num = cur_num;//初始化
            }
            if(cur_num > max_num){
                max_num = cur_num;
            }
            if(cur_num < 0){
                cur_num = 0;
            }
        }
        System.out.println(max_num);
    }
}
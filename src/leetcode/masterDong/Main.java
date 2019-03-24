package leetcode.masterDong;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    double x, y, r;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
class Pair {
    int u, v;
    double d;
    public Pair(int u, int v, double d) {
        this.u = u;
        this.v = v;
        this.d = d;
    }
}
public class Main {

    static int n;
    static Point[] points;
    static boolean[] vis;
    // 两圆距离
    static double dist(int u, int v) {
        // x轴距离平方
        double a = (points[u].x - points[v].x) * (points[u].x - points[v].x);
        // y轴距离平方
        double b = (points[u].y - points[v].y) * (points[u].y - points[v].y);
        // 总距离 - 两圆半径 = 两圆距离
        return Math.sqrt(a + b) - points[u].r - points[v].r;
    }
    public static void main(String[] args) {
        // 读入点个数n
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 读入各点坐标
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        // 是否停止生长
        boolean[] vis = new boolean[n];

        while (true) {
            // 每一对点都加入Pairs
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (vis[i] && vis[j])
                        continue;
                    list.add(new Pair(i, j, dist(i, j)));
                }
            }
            // 都停止生长则退出while
            if (list.size() == 0)
                break;
            // 初始化d，代表剩余的半径成长空间
            double d = 9999999;
            // 遍历整个list，，则确定所有点中最小距离
            for (int i = 0; i < list.size(); i++) {
                // 若该对点中一个以上停止生长
                if (vis[list.get(i).u] || vis[list.get(i).v])
                    d = Math.min(d, list.get(i).d);
                else
                    d = Math.min(d, list.get(i).d / 2);
            }
            // 每个圆半径先生长到d
            for (int i = 0; i < n; i++) {
                if (!vis[i])
                    points[i].r += d;
            }
            // 生长d后接触的圆使其停止生长
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    if(Math.abs(dist(i, j)) <= 0.00000001)
                        vis[i] = vis[j] = true;
        }
        for (int i = 0; i < n; i++)
            System.out.printf("%.3f%c", points[i].r, i == n - 1 ? '\n' : ' ');
    }
}
/*
3
0 2
0 4
6 3
 */

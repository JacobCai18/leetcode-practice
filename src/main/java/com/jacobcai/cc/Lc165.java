package com.jacobcai.cc;

public class Lc165 {
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++)
                x = x * 10 - '0' + version1.charAt(i);
            i++;
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++)
                y = y * 10 - '0' + version2.charAt(j);
            j++;
            if (x != y)
                return x > y ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Lc165 lc165 = new Lc165();
        String v1 = "1.21", v2 = "1.021";
        int res = lc165.compareVersion(v1, v2);
        System.out.println("res = " + res);
    }
}

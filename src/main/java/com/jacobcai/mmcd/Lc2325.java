package com.jacobcai.mmcd;

public class Lc2325 {
    public String decodeMessage(String key, String message) {
        char[] mp = new char[26];
        char ltr = 'a';
        for (var c : key.toCharArray())
            if (c != ' ' && mp[c - 'a'] == 0)
                mp[c - 'a'] = ltr++;
        char[] mca = message.toCharArray();
        for (int i = 0; i < mca.length; i++)
            if (mca[i] != ' ')
                mca[i] = mp[mca[i] - 'a'];
        return String.valueOf(mca);
    }

    public static void main(String[] args) {
        Lc2325 lc2325 = new Lc2325();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String res = lc2325.decodeMessage(key, message);
        System.out.println("res = " + res);
    }
}

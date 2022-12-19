package com.jacobcai.ccc;

public class Lc208 {
    private final Lc208[] children;
    private boolean isEnd;
    
    public Lc208() {
        children = new Lc208[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Lc208 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Lc208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Lc208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Lc208 node = searchPrefix(prefix);
        return node != null;
    }
    
    private Lc208 searchPrefix(String prefix) {
        Lc208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
    
    public static void main(String[] args) {
        Lc208 trie = new Lc208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

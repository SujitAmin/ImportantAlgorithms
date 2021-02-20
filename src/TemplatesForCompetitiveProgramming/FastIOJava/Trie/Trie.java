package TemplatesForCompetitiveProgramming.FastIOJava.Trie;
import java.util.*;
public class Trie {
    public class TrieNode {
        private Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode(){
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        int length = word.length();
        for (int i=0; i < length; i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            //current.children.put(c, current.children.get(c));
            current = current.children.get(c);
        }
        // Set end to true
        current.isEnd = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i =0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEnd;
    }


    private List<String> getAll(String prefix, TrieNode trieNode) {
        List<String> r = new ArrayList<>();
        if (trieNode.isEnd) {
            r.add(prefix);
        }
        for (Map.Entry<Character, TrieNode> child : trieNode.children.entrySet()) {
            List<String> subSuffix = getAll(prefix + child.getKey(), child.getValue());
            r.addAll(subSuffix);
        }
        return r;
    }

    public List<String> returnAllChildren(String str){
        List<String> r = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            TrieNode trieNode = current.children.get(c);
            if (trieNode == null) {
                // Not found
                return r;
            }
            current = trieNode;
        }
        // If you don't need the prefix, you can just
        // return getAll("", current);
        return getAll(str, current);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcde");
        trie.insert("abcd");
        trie.insert("ab");
        trie.insert("axy");
        List<String> r = trie.returnAllChildren("a");
        for (String s : r) {
            System.out.println(s);
        }
    }
}
class Trie {

    class Node {
        char c;
        boolean end;
        Node[] sub;
        
        public Node(char _c) {
            c = _c;
            sub = new Node[26];
        }
        
        public Node(char _c, boolean _e) {
            c = _c;
            end = _e;
            sub = new Node[26];
        }
        
        public boolean isEnd() {
            return end;
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(char c: word.toCharArray()) {
            if(cur.sub[c-'a'] == null) {
                cur.sub[c-'a'] = new Node(c);
            }
            
            cur = cur.sub[c-'a'];
        }
        
        cur.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean find(String word) {
        Node cur = root;
        for(char c: word.toCharArray()) {
            if(cur.sub[c-'a'] == null)
                return false;
            
            cur = cur.sub[c-'a'];
        }
        
        return cur.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c: prefix.toCharArray()) {
            if(cur.sub[c-'a'] == null)
                return false;
            
            cur = cur.sub[c-'a'];
        }
        
        return true;
    }
}
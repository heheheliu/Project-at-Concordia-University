import java.util.HashMap;

public class Trie {
    HashMap<Character,Trie> next;
    Boolean isEnd;
    public Trie() {
        this.next = new HashMap<>();
        this.isEnd = false;

    }

    public void insert(String word) {
        Trie cur = this;//root开始 root的值为空
        for (char c : word.toCharArray()){
            if(cur.next.get(c) == null)//查无此字符 添加
            {
                cur.next.put(c,new Trie());
            }
            cur = cur.next.get(c);//向下探索
        }
        cur.isEnd = true;

    }

    public boolean search(String word) {
        Trie ans = searchPrefix(word);
        return ans != null && ans.isEnd;

    }

    public boolean startsWith(String prefix) {
        Trie ans = searchPrefix(prefix);
        return ans != null;

    }

    public Trie searchPrefix(String prefix){
        Trie cur = this;//root 开始
        for(char c : prefix.toCharArray()){
            if(cur.next.get(c) == null){//查无此字符 返回null
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur;
    }
}

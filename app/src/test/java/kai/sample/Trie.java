package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 30/8/17.
 */

public class Trie {
    Trie[] tries;
    boolean words;

    public Trie() {
        this.tries = new Trie[26];
    }

    void addWord(String s) {
        if (s.isEmpty()) {
            words = true;
            return;
        }

        char c = s.charAt(0);
        int index = c - 'a';
        if (tries[index] == null) {
            tries[index] = new Trie();
        }

        tries[index].addWord(s.substring(1));
    }

    boolean isWord(String s) {
        if (s.isEmpty()) {
            return words;
        }

        char c = s.charAt(0);
        int index = c - 'a';
        if (tries[index] == null) {
            return false;
        }

        return tries[index].isWord(s.substring(1));
    }

    @Test
    public void test() throws Exception {
        Trie t = new Trie();
        System.out.println(t.isWord("help"));
        t.addWord("help");
        t.addWord("trying");
        t.addWord("try");
        System.out.println(t.isWord("help"));
        System.out.println(t.isWord("try"));
        System.out.println(t.isWord("trying"));
    }
}

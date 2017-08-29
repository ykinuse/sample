package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 18/8/17.
 */

public class Anagram {
    @Test
    public void test() throws Exception {
        System.out.println(isAnagram("abbb","bbab"));
    }

    public boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] cache = new int[1 << 8];
        for(char c : s1.toCharArray()){
            cache[c]++;
        }

        for(char c : s2.toCharArray()){
            cache[c]--;
        }

        for(int i : cache){
            if(i!=0){
                return false;
            }
        }

        return true;
    }
}

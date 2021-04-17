package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationOfParenthesis1 {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder soluPrefix = new StringBuilder();
        helper(n, 0, 0, soluPrefix, res);
        return res;
    }
    private void helper(int n, int l, int r, StringBuilder soluPrefix, List<String> res){
        if(l + r == 2 * n){
            res.add(new String(soluPrefix));
            return;
        }

        if(l < n){
            soluPrefix.append("(");
            helper(n, l + 1, r, soluPrefix, res);
            soluPrefix.deleteCharAt(soluPrefix.length() - 1);
        }
        if(l > r) {
            soluPrefix.append(")");
            helper(n, l, r + 1, soluPrefix, res);
            soluPrefix.deleteCharAt(soluPrefix.length() - 1);
        }
    }
}

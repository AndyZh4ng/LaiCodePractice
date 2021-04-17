package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets1 {
    public List<String> subSets(String set) {
        if(set == null){
            return null;
        }
        List<String> res = new ArrayList<>();
        StringBuilder soluPrefix = new StringBuilder();
        helper(set, soluPrefix, res, 0);
        return res;
    }
    private void helper(String set, StringBuilder soluPrefix, List<String> res, int index){
        if(index == set.length()){
            res.add(new String(soluPrefix));
            return;
        }

        soluPrefix.append(set.charAt(index));
        helper(set, soluPrefix, res, index + 1);
        soluPrefix.deleteCharAt(soluPrefix.length() - 1);
        helper(set, soluPrefix, res, index + 1);
    }
}

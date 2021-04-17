package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation1 {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        char[] arr = input.toCharArray();
        helper(arr, 0, res);
        return res;
    }
    private void helper(char[] input, int index, List<String> res){
        if(index == input.length - 1){
            res.add(new String(input));
            return;
        }
        for(int i = index; i < input.length; i++){
            swap(input, i, index);
            helper(input, index + 1, res);
            swap(input, i, index);
        }
    }

    private void swap(char[] input, int i, int j){
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}

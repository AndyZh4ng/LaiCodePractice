package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0) {
            return res;
        }
        Integer[] soluPrefix = new Integer[coins.length];
        helper(target, coins, res, soluPrefix, 0);
        return res;
    }
    private void helper(int target, int[] coins, List<List<Integer>> res, Integer[] soluPrefix, int index){
        if(index == coins.length - 1){
            if(target % coins[index] == 0) {//Notice that the smallest coin value may not be 1 cent!!!
                soluPrefix[index] = target / coins[index];
                res.add(new ArrayList<>(Arrays.asList(soluPrefix)));
            }
            return;
        }
        for(int i = 0; i <= target / coins[index]; i++){
            soluPrefix[index] = i;
            helper(target - i * coins[index], coins, res, soluPrefix, index +1);
        }
    }
}

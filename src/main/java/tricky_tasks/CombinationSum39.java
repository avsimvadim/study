package tricky_tasks;

import java.util.*;
import java.util.stream.Collectors;

class CombinationSum39 {
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2,3,5}, 8);
        System.out.println(res);
        // [[2,2,2,2],[2,3,3],[3,5]]
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationSum(result, new ArrayList<>(), set, candidates, target, 0);

        List<List<Integer>> res= result.stream().map(list -> list.stream().sorted().collect(Collectors.toList())).distinct().collect(Collectors.toList());
        return res;
    }

    private static void combinationSum(List<List<Integer>> result, List<Integer> temp, Set<List<Integer>> set, int[] candidates, int target, int sum){
        if(target == sum){
            if(set.contains(temp)){
                return;
            }
            result.add(new ArrayList<>(temp));
            set.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i = 0; i < candidates.length; i++){
            temp.add(candidates[i]);
            combinationSum(result, temp, set, candidates, target, sum + candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}

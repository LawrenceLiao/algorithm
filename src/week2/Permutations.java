package week2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private boolean[] used;
    private List<Integer> a = new ArrayList<>();
    private List<List<Integer>> results = new ArrayList<>();
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        recur(nums, 0);
        return results;
    }

    private void recur(int[] nums, int pos) {
        if (pos == n) {
            results.add(new ArrayList<>(a));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                a.add(nums[i]);
                used[i] = true;
                recur(nums, pos + 1);
                used[i] = false;
                a.remove(a.size() - 1);
            }
        }

    }
}

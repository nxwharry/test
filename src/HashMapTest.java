import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    public static void main(String[] args) {
        int[] a = {0,0,0};
        List<List<Integer>> ret = new HashMapTest().threeSum(a);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i+1;
            int R = nums.length - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while( L < R && nums[L] == nums[L+1] )
                        L++;
                    while(L < R && nums[R] == nums[R-1])
                        R--;
                    L++;
                    R--;
                }else if(sum < 0) {
                    L++;
                }else if(sum > 0){
                    R--;
                }
            }

        }
        return  ans;
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no answer!");
    }
}

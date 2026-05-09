
class Solution {

    static ArrayList<Long> ans[];
    
    static long hcf(long a, long b){
        if(b==0) return a;
        else return hcf(b,a%b);
    }

    static long Lcm(long a, long b){
        return (a*b)/hcf(a,b);
    }

    static void helper(int arr[], int idx, long lcm, int size){
        if(idx>=arr.length){
            if(size!=0){
                ans[size].add(lcm);
            }
            return;
        }

        long newLcm = Lcm(lcm,arr[idx]);
        helper(arr,idx+1,newLcm,size+1);
        helper(arr,idx+1,lcm,size);
    }

    public long findKthSmallest(int[] arr, int k) {
        int n = arr.length;
        ans = new ArrayList[16];
        for(int i=0; i<16; i++){
            ans[i] = new ArrayList<>();
        }
        helper(arr,0,(long)1,0);

        long left = 1;
        long right = (long)(1e12);
        long result = 0;

        while(left<=right){
            long mid = left+(right-left)/2;
            long count = 0;
            for(int i=1; i<=n; i++){
                for(int j=0; j<ans[i].size(); j++){
                    if(i%2!=0) count += (mid/ans[i].get(j));
                    else count -= (mid/ans[i].get(j));
                }
            }

            if(count>=k){
                result = mid;
                right = mid-1;
            }else left = mid+1;
        }
        return result;
    }
}
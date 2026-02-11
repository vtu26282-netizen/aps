class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefixSum;
            int right = (totalSum - prefixSum - nums[i]) - nums[i] * (n - i - 1);
            result[i] = left + right;
            prefixSum += nums[i];
        }
        return result;
    }
};

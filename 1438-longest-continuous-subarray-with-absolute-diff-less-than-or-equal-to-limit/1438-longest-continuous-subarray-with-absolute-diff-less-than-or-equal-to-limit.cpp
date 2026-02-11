class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int> maxQ, minQ;
        int left = 0, ans = 0;

        for (int right = 0; right < nums.size(); ++right) {
            while (!maxQ.empty() && maxQ.back() < nums[right])
                maxQ.pop_back();
            maxQ.push_back(nums[right]);

            while (!minQ.empty() && minQ.back() > nums[right])
                minQ.pop_back();
            minQ.push_back(nums[right]);

            while (!maxQ.empty() && !minQ.empty() && maxQ.front() - minQ.front() > limit) {
                if (nums[left] == maxQ.front()) maxQ.pop_front();
                if (nums[left] == minQ.front()) minQ.pop_front();
                ++left;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};

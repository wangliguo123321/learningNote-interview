```C++
class Solution
{
public:

    int firstMissingPositive(vector<int>& nums)
    {
        int n = nums.size();
        nums.push_back(-1);

        for(int i=0; i<=n; i++)
            while(nums[i] >= 0 && nums[i]<=n && nums[nums[i]] != nums[i])
            {
                swap(nums[i], nums[nums[i]]);
                //nums[i] ^= nums[nums[i]];
                //nums[nums[i]] ^= nums[i];
                //nums[i] ^= nums[nums[i]];
            }

        for(int i=1; i<=n; i++)
            if(nums[i] != i)
                return i;
        return n+1;
    }
};
```
![](http://cmhblog.cfzhao.com/2019-02-28%2022-42-21%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE.png)
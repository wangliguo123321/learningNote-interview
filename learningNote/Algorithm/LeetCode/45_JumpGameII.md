### Code 1

$O(M*N)$ 

Use 1568ms. Only beats 29.17%

```c++
class Solution {
public:
    int jump(vector<int>& nums) {
        int len = nums.size();
        int * ans = new int[len];
        
        memset(ans, 0x3f3f3f3f, len*sizeof(int));
        ans[0] = 0;
        int step, dest;
        for(int i=0; i<len; i++)
        {
            step = nums[i];
            dest = i + step;
            for(int j=i+1; j<=dest && j<len; j++)
                ans[j] = min(ans[j], ans[i]+1);
        }
        return ans[len-1];
    }
};
```

### Code 2

$O(N)$

Use 12 ms. Beats 99.65%. (Not use fast read.)

```c++
class Solution {
public:
    int jump(vector<int>& nums) {
        int ans = 0, maxd = 0, end = 0;
        int len = nums.size();
        
        for(int i=0; i<len-1; i++)
        {
            maxd = max(maxd, i+nums[i]);
            if(i == end)
            {
                ans++;
                end = maxd;
            }
        }
        return ans;
    }
};
```


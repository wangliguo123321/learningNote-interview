```c++
class Solution {
public:
    int longestValidParentheses(string s) {
        int len = s.length();
        int ans = 0;
        int *dp = new int[len];
        
        memset(dp, 0, len * sizeof(int));
        
        for(int i=1; i<len; i++)
        {
            if(s[i] == ')')
            {
                if(s[i-1] == '(')
                    dp[i] =(i>=2 ? dp[i-2] : 0) + 2;
                else if(i - dp[i-1] > 0 && s[ i-dp[i-1]-1 ] == '(')
                    dp[i] = dp[i-1] + ( i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0 ) + 2;
                    
            }
            ans = max(ans, dp[i]);
        }
        delete[] dp;
        return ans;
    }
};
```

![](http://cmhblog.cfzhao.com/2019-02-28%2022-48-33%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE.png)
### Code 1

Use 196ms. 88.41%.

离散化+BIT。

```c++
class Solution {
public:
    void update(int x)
    {
        while(x)
        {
            bit[x]++;
            x -= x&-x;
        }
    }
    
    int query(int x)
    {
        int sum = 0;
        
        while(x <= len)
        {
            sum += bit[x];
            x += x&-x;
        }
        return sum;
    }
    
    int reversePairs(vector<int>& nums) {
        len = nums.size();
        if(len == 0 || len == 1)
            return 0;
        int *a = new int[len];
        for(int i=0; i<len; i++)
            a[i] = nums[i];
        sort(a, a+len);
        
        bit = new int[len+1];
        memset(bit, 0, sizeof(int)*(len+1));
        int ans = 0;
        int pos;
        for(int i=0; i<len; i++)
        {
            pos = lower_bound(a, a+len, nums[i] * 2LL + 1) - a + 1;
            ans += query(pos);
            pos = lower_bound(a, a+len,nums[i]) - a + 1;
            update(pos);
        }
        delete[] bit;
        return ans;
    }
    
    int len;
    int *bit;
};
```

### Code 2

Not Fast Read : 180ms, 94.2%

Use Fast Read: 136ms, 100%

```C++
auto _x=[](){
    ios::sync_with_stdio(0);
    cin.tie(0);
    return 0;
}();

class Solution {
public:
    void update(int x)
    {
        while(x<=len)
        {
            bit[x]++;
            x += x&-x;
        }
    }
    
    int query(int x)
    {
        int sum = 0;
        
        while(x)
        {
            sum += bit[x];
            x &= (x-1);
        }
        return sum;
    }
    
    int reversePairs(vector<int>& nums) {
        len = nums.size();
        if(len == 0 || len == 1)
            return 0;
        memset(bit, 0, sizeof(bit));
        
        vector< pair<long long, int> > a(len);
        for(int i=0; i<len; i++)
        {
            a[i].first = nums[i];
            a[i].second = i;
        }
        
        sort(a.begin(), a.end(), greater< pair<long long, int> >() );
        
        int i=0, ans = 0;
        for(int j=0; j<len; j++)
        {
            while(i<len && a[i].first > a[j].first*2)
                update(a[i++].second+1);
            ans += query(a[j].second);
        }
        return ans;
    }
    
    int len;
    int bit[50010];
};
```


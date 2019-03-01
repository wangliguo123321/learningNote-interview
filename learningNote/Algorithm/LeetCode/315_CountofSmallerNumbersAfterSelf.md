### Code 1

Use segment tree.  32ms, beats 86.25%.

```c++
class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        len = nums.size();
        if(len == 0)
            return nums;
        int *a = new int[len];
        
        int *ans = new int[len];
        ans[len-1] = 0;
        
        for(int i=0; i<len; i++)
            a[i] = nums[i];
        
        //离散化
        sort(a, a+len);
        int tot = unique(a, a+len) - a;
        
        for(int i=0; i<len; i++)
            nums[i] = lower_bound(a, a+tot, nums[i]) - a + 1;
        seg = new int[(tot+7)<<2];
        
        build(1, 1, tot);
        update(1, 1, tot, nums[len-1]);
        for(int i=len-2; i>=0; i--)
        {
            ans[i] = query(1, 1, tot, 1, nums[i]-1);
            update(1, 1, tot, nums[i]);
        }
        delete[] a;
        delete[] seg;
        vector<int> ans1;
        for(int i=0; i<len; i++)
            ans1.push_back(ans[i]);
        delete[] ans;
        return ans1;
    }
    void pushup(int root)
    {
        seg[root] = seg[root<<1] + seg[root<<1|1]; 
    }
    
     void build(int root, int l, int r)
    {
        if(l==r)
        {
            seg[root] = 0;
            return;
        }
        int mid = l+r>>1;
        build(root<<1, l, mid);
        build(root<<1|1, mid+1, r);
        pushup(root);
    }
    
    int query(int root, int l, int r, int a, int b)
    {
        if(a > r || b < l)
            return 0;
        if(a <= l && b >= r)
            return seg[root];
        int mid = l+r>>1;
        return query(root<<1, l, mid, a, b) + query(root<<1|1, mid+1, r, a, b);
    }
    
    void update(int root, int l, int r, int ind)
    {
        if(l == r)
        {
            seg[root]++;
            return;
        }
        int mid = l+r>>1;
        if(ind <= mid)
            update(root<<1, l, mid, ind);
        else
            update(root<<1|1, mid+1, r, ind);
        pushup(root);
    }
    int len;
    int *seg;
};
```

### Code 2

Use BIT(Binary Index Tree). 32ms, beats 95.96%. (Not use fast read.)

```c++
class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        len = nums.size();
        
        if(len == 0)
            return nums;
        
        a = new int[len+10];

        for(int i=0; i<len; i++)
            a[i] = nums[i];

        sort(a, a+len);
        tot = unique(a, a+len) - a;

        for(int i=0; i<len; i++)
            nums[i] = lower_bound(a, a+tot, nums[i]) - a + 1;

        memset(a, 0, sizeof(int)*(10+len));
        int lenn = len+10;
        for(int i=0; i<lenn; i++)
            a[i] = 0;
        add(nums[len-1]);
        nums[len-1] = 0;

        int tmp;
        for(int i=len-2; i>=0; i--)
        {
            tmp = nums[i];
            if(tmp-1)
                nums[i] = query(tmp-1);
            else
                nums[i] = 0;
            add(tmp);
        }

        delete[] a;
        return nums;
    }

    inline int lowbit(int x) {return x & -x;}

    void add(int x)
    {
        while(x<=tot)
        {
            a[x]++;
            x += lowbit(x);
        }
    }

    int query(int x)
    {
        int sum = 0;
        while(x)
        {
            sum += a[x];
            x -= lowbit(x);
        }
        return sum;
    }
    int len, tot;
    int *a;
};
```


```C++
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        
        if(n > m)
        {
            swap(nums1, nums2);
            n ^= m ^= n ^= m;
        }  
        
        int l = 0, r = n;
        int halflen = (m+n+1) >> 1;
        
        while(l<=r)
        {
            int i = l+r>>1;
            int j = halflen - i;
            if(i<r && nums2[j-1] > nums1[i])
                l = i+1;
            else if(i>l && nums1[i-1] > nums2[j])
                r = i-1;
            else 
            {
                int maxLeft;
                
                if(!i)
                    maxLeft = nums2[j-1];
                else if(!j)
                    maxLeft = nums1[i-1];
                else 
                    maxLeft = max(nums1[i-1], nums2[j-1]);
                
                if((m+n) & 1)
                    return maxLeft;
                
                int minRight;
                if(i==n)
                    minRight = nums2[j];
                else if(j==m)
                    minRight = nums1[i];
                else
                    minRight = min(nums1[i], nums2[j]);
                
                return (maxLeft + minRight) / 2.0;   
            }
        }
        return 0;
    }
};
```

![](http://cmhblog.cfzhao.com/2019-02-28%2022-43-46%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE.png)
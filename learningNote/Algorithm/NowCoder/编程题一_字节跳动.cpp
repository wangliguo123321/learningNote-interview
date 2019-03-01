//Author: MoonChasing
//Email: moonchasing1999@gmail.com
//Problem Link: https://www.nowcoder.com/practice/ea209d6014c44763a41ee04a11bf2ef1?tpId=90&tqId=30821&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking 

#include<cstdio>
#include<algorithm>
#define MAXN 500007
using namespace std;
 
struct point
{
    int x, y;
}a[MAXN];
 
int n;
 
bool cmp(const point& p1, const point& p2)
{
    return p1.y > p2.y;
}
 
bool cmp2(const point& p1, const point& p2)
{
    return p1.x < p2.x;
}
 
int main()
{
   scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d%d", &a[i].x, &a[i].y);
    sort(a, a+n, cmp);
     
    int maxx = -0x7fffffff;
    point ans[MAXN];
    int cnt = 0;
    for(int i=0; i<n; i++)
    {
        if(a[i].x > maxx)
        {
            ans[cnt++] = a[i];
            //ans[cnt++].y = a[i].y;
            maxx = a[i].x;
        }
    }
    //sort(ans, ans+cnt, cmp2);
    for(int i=0; i<cnt; i++)
        printf("%d %d\n",ans[i].x, ans[i].y);
    return 0;
}
// Author: MoonChasing
// Date: 20190228
#include<cstdio>
#include<cstring>
#include<cmath>
#define MAXN 307
#define MAXM 107

using namespace std;

const double eps = 1e-7;
short c[MAXM];
float dp[MAXN][MAXM][MAXN];		//dp[i][j][k] 表示第 i 个人拿第 j 件礼物时该礼物剩 k 件的概率
								//dp 数组可以用滚动数组优化
float p[MAXN][MAXM];
short n, m;

int main()
{
    scanf("%hd%hd", &n, &m);
    for(int i=1; i<=m; i++)
        scanf("%hd", c+i);
    
    for(int i=1; i<=n; i++)
        for(int j=1; j<=m; j++)
            scanf("%f", &p[i][j]);
    
    memset(dp, 0, sizeof(dp));
    
    for(int j=1; j<=m; j++)
        dp[1][j][c[j]] = 1;
    for(int i=2; i<=n; i++)
    {
        for(int j=1; j<=m; j++)
        {
            if( fabs(dp[i-1][j][0]-1) <= eps)    //dp[i-1][j][0] == 1 -> dp[i][j][0] = 1
                dp[i][j][0] = 1;
            else
                dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1] * p[i-1][j];

            for(int k=1; k<c[j]; k++)
                dp[i][j][k] = dp[i-1][j][k] * (1-p[i-1][j]) + dp[i-1][j][k+1] * p[i-1][j];
            
            if(c[j])
                dp[i][j][c[j]] = dp[i-1][j][c[j]] * (1-p[i-1][j]);
        }
    }
    
    double ans = 0.0;
    
    for(int i=1; i<=n; i++)
        for(int j=1; j<=m; j++)
            ans += p[i][j] * (1-dp[i][j][0]);
    printf("%.1f", ans);
    return 0;
}
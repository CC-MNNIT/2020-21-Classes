#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
#define boost ios_base::sync_with_stdio(false);cin.tie(NULL);
typedef long long int ll;
#define ass 1e18
#define MOD 1000000007
#define mp make_pair
#define pb push_back
#define pf push_front
#define pob pop_back
#define pof pop_front
#define fi first
#define se second
#define sz(x)	(ll)x.size()
#define present(c,x) ((c).find(x) != (c).end())
#define debug(x) cout << #x << ": " << x << endl;
#define debug2(x,y) cout<<#x<<": "<< x<< ", "<< #y<< ": "<< y<< endl;
#define debug3(x,y,z) cout<<#x<<": "<< x<< ", "<< #y<< ": "<< y<<" "<<#z<<" : "<<z<< endl;
#include <ext/pb_ds/assoc_container.hpp> 
#include <ext/pb_ds/tree_policy.hpp> 
using namespace __gnu_pbds;   
#define ordered_set tree<ll, null_type,less<ll>, rb_tree_tag,tree_order_statistics_node_update>
ll dp[105][1005],weight[105],value[105],total;

// n=x..0 , capacity, x= total_item
ll dfs(ll n,ll capacity){
	if(n==-1||capacity==0)
		return 0;
	if(dp[n][capacity]!=-1)
		return dp[n][capacity];
	//capacity is more than weight of item then we have two possibilites pick element or not pick element
	if(capacity>=weight[n])
		dp[n][capacity]=max(value[n]+dfs(n-1,capacity-weight[n]),dfs(n-1,capacity));
	else
		dp[n][capacity]=dfs(n-1,capacity);
	return dp[n][capacity];
}

ll knapsackDP()
{
	ll n,capacity;
	cin>>n>>capacity;
	memset(dp,-1,sizeof(dp));
	for(int i=0;i<n;i++)
		cin>>weight[i];
	for(int i=0;i<n;i++)
		cin>>value[i];
	ll ans=dfs(n-1,capacity);
	// dp[n-1][capacity]=ans //
	// dp[0][capacity] === ans //0th .. n with Capacity max value
	cout<<ans<<"\n";
	return ans;
}

int main()
{
	boost
	ll t=1;
	//cin>>t;
	while(t--)
	{
		knapsackDP();
	}
	return 0;
}

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

ll fracknapsack()
{
	ll n,sum=0,capacity;
	cin>>n>>capacity;
	ll weight[n+5],value[n+5];
	vector< pair<double,ll> >v;
	for(int i=0;i<n;i++)
		cin>>weight[i];
	for(int i=0;i<n;i++)
	{
		cin>>value[i];
		v.push_back( make_pair((value[i]*1.0)/weight[i],i));
	}
	//sort ascending order of value/weight ratio 
	sort(v.rbegin(),v.rend());
	for(int i=0;i<n;i++)
	{
		//pick whole item if its total weight is less than current capacity
		if(weight[v[i].second]<=capacity){
			capacity-=weight[v[i].second];
			sum+=value[v[i].second];
		}
		else
		{
			 sum+=(capacity*1.0/weight[v[i].second])*value[v[i].second];
			 // Break since capacity become 0
			 break;
		}
	}
	cout<<sum<<"\n";
	return sum;
}

int main()
{
	boost
	ll t=1;
	//cin>>t;
	while(t--)
	{
		fracknapsack();
	}
	return 0;
}

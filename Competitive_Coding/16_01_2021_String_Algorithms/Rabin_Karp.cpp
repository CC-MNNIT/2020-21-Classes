#include<bits/stdc++.h>
using namespace std;
#define M 1000000007
#define P 26          //multiplier
long long int modpower(long long int a,long long int b,long long int c)
{
	long long int res=1;
	while(b)
	{
		if(b&1LL)
			res=(res*a)%c;
		a=(a*a)%c;
		b>>=1;
	}
	return res;
}
vector<int> rabin_karp(string const& text, string const& pattern) {
    int n=text.length();
    int m=pattern.length();
    vector<long long int> has(n,0);
    // creating the window
    // text abcdefgh
    for(int i=0;i<m;i++)
    {
        has[0]=(has[0]+((text[i]-'a'+1)*modpower(P,m-i-1,M))%M)%M;
        /*
            abcd -> 1*P^3 + 2*P^2 + 3*P^1 + 4*P^0
        */
    }
    // moving the window
    for(int i=1;i<n-m+1;i++)
    {
        has[i]=(((has[i-1]-((text[i-1]-'a'+1)*modpower(P,m-1,M))%M)*P)%M +(text[i+m-1]-'a'+1) + M)%M;
        /*
            has[i]=(((has[i-1]-((text[i-1]-'a'+1)*modpower(P,m-1,M))%M)*P)%M +(text[i+m-1]-'a'+1) + M)%M;
                     Previous window hash
                                    outgoing char                               new char entry      
            abcd -> 1*P^3 + 2*P^2 + 3*P^1 + 4*P^0
            bcde -> 2*P^3 + 3*P^2 + 4*P^1 + 5*P^0
        */
    }
    long long int p_hash=0;
    for(int i=0;i<m;i++)
    {
        p_hash=(p_hash+((pattern[i]-'a'+1)*modpower(P,m-i-1,M))%M)%M;
        
    }
    vector<int> occur;
    for(int i=0;i<n-m+1;i++)
    {
        if(has[i]==p_hash)
        {
            occur.push_back(i);
        }
    }
    return occur;
}
/*
In case of collisions try:
Use two different hash array if you want to decrease chances of collision. Probability of collision if earlier was
K then decreases to K*K
Try with P (multiplier) = 31.

Incase of some problem with above code msg to vivek.rathi@mnnit.ac.in on teams.
*/
int main()
{
    string text="abcdefgh";
    string pattern = "bcde";
    vector<int> occur = rabin_karp(text,pattern);
    for(int i=0;i<occur.size();i++)
    {
        cout<<occur[i]<<endl;// indexes where pattern matches the text substring
    }
    return 0;
}
/*
Time complexity = O(N+M)
considering that computing power of P is precomputed already
*/
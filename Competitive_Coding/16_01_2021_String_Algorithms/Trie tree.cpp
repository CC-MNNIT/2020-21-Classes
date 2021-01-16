#include<bits/stdc++.h>
#define null NULL
using namespace std;
struct node
{
	bool end;
	struct node *ch[26];
};
struct node *newnode()
{
	node *temp;
	temp=(node*)malloc(sizeof(node));
	temp->end=false;
	for(int i=0;i<26;i++) temp->ch[i]=NULL;
	return temp;
}
void insert(struct node *p,string s)
{
	int len = s.length();
	for(int i=0;i<len;i++)
	{
		int index = s.at(i) - 'a';
		if(p->ch[index]==null) p->ch[index] = newnode();
		p = p->ch[index];
	}
	p->end = true;
}
bool search(struct node *p, string s)
{
	int len = s.length();
	for(int i=0;i<len;i++)
	{
		int index = s.at(i) - 'a';
		if(p->ch[index]==null) return false;
		p = p->ch[index];
	} 
	return true;
}

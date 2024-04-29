#define _CRT_SECURE_NO_WARNINGS 1
#include<stdbool.h>
#include<stdio.h>
#include<stdlib.h>
//205. Í¬¹¹×Ö·û´®
bool isIsomorphic(char * s, char * t)
{
	int i, j;
	int s1 = strlen(s);
	int t1 = strlen(t);
	if (s1 != t1)
		return false;
	for (i = 0; i <= s1; i++)
	{
		for (j = 0; j < i; j++)
		{
			if (s[j] == s[i] && t[j] != t[i])
				return false;
			if (t[j] == t[i] && s[j] != s[i])
				return false;
		}
	}
	return true;
}
int main()
{
	char s[] = "egg";
	char t[] = "add";
	bool a = isIsomorphic(s, t);
	printf("%d", a);
	return 0;
}
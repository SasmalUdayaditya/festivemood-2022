#include <stdio.h>

int main(){
	int i, n; int c = 0;
	scanf("%d", &n);
	for (i = 1; i < n + 1; i++){c += i;}
	printf("%d\n", c);
	return 0;
}

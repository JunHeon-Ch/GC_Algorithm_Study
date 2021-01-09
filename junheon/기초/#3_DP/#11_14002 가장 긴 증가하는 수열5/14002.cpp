#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 1000;
int d[MAX];
int s[MAX];
int ans[MAX];

void print_sequence(int index) {
    if(index == -1) {
        return;
    }
    else {
        print_sequence(ans[index]);
        printf("%d ", s[index]);
    }
}

int main() {
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++) {
        scanf("%d", &s[i]);
    }
    for(int i = 0; i < n; i++) {
        d[i] = 1;
        ans[i] = -1;
        for(int j = 0; j < i; j++) {
            if(s[i] > s[j] && d[i] < d[j] + 1) {
                d[i] = d[j] + 1;
                ans[i] = j;
            }
        }
    }
    printf("%d\n", *max_element(d, d + n));
    int index = max_element(d, d + n) - d;
    print_sequence(index);

    return 0;
}
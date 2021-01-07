#include <cstdio>

void minusTenToTwo(int n) {
    if(n == 0) {
        printf("0");
    }
    else if(n == 1) {
        printf("1");
    }
    else if(n % 2 == 0) {
        minusTenToTwo(-(n / 2));
        printf("0");
    }
    else {
        if(n > 0) {
            minusTenToTwo(-(n / 2));
        }
        else {
            minusTenToTwo((-n + 1) / 2);
        }
        printf("1");
    }
}

int main() {
    int n;
    scanf("%d", &n);
    minusTenToTwo(n);

    return 0;
}
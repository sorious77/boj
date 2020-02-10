#include <iostream>

int main(){
    int n,a,b;
    
    std :: cin >> n;
    
    for(int i=1;i<=n;i++){
        std :: cin >> a >> b;
        printf("Case #%d: %d\n",i,a+b);
    }
}
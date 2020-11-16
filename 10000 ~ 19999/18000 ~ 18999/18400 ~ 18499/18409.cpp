#include <iostream>
#include <string>

using namespace std;

bool check(char c){
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return true;
    
    return false;
}

int main(){
    int n;
    string s;
    cin >> n >> s;
    
    int count = 0;
    
    for(int i=0;i<s.length();i++){
        if(check(s[i]))
            count++;
    }
    
    cout << count;
    
    return 0;
}
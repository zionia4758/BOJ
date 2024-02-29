include <iostream>
using namespace std;

static string str1, str2;
static int dp[1001][1001];
static int n1,n2;
int lcs(int idx1, int idx2){
    if (idx1 == n1 || idx2 == n2){
        return 0;
    }
    if(dp[idx1][idx2] != -1){
        return dp[idx1][idx2];
    }
    int result;
    result = max(lcs(idx1+1,idx2),lcs(idx1,idx2+1));
    if(str1[idx1] == str2[idx2]){
        result = max(result,lcs(idx1+1,idx2+1)+1);
    }
    dp[idx1][idx2] = result;
    return result;

}


int main(){
    cin>>str1>>str2;
    // cout<<str1<<'\n'<<str2<<'\n';
    n1 = str1.length();
    n2 = str2.length();
    for(int i=0; i<n1;i++)
        fill_n(dp[i],n2,-1);

    int answer = lcs(0,0);
    cout<<answer<<'\n';
    return 0;
}   

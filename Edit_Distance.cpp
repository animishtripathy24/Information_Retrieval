#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
        void levenstein(string str1,string str2,vector<vector<int>>&v)
        {
            int n=str1.size();
            int m=str2.size();
            //adding the extra space at the beginning
            str1=" "+str1;
            str2=" "+str2;
            
            for(int i=1;i<n;i++)
            {
                for(int j=1;j<m;j++)
                {
                    if(str1[i]!=str2[j])
                    {
                        v[i][j]=1+min(v[i-1][j],min(v[i-1][j-1],v[i][j-1]));
                    }
                    else
                    {
                        v[i][j]=v[i-1][j-1];
                    }
                }
            }
        }
};

int main()
{
            cout << "Enter the first string " << endl;
            string str1;
            cin >> str1;
            cout << "Enter the second string " << endl;
            string str2;
            cin >> str2;
            int n=str1.size();
            int m=str2.size();
            vector<vector<int>>v(n,vector<int>(m));
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    v[i][j]=0;
                    if(i==0)
                    {
                        v[i][j]=j;
                    }
                    else if(j==0)
                    {
                        v[i][j]=i;
                    }
                }
            }
    Solution *obj=new Solution();
    //calling the levenstein
    obj->levenstein(str1,str2,v);
    cout << "The edit distance table is" << endl;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    cout << v[i][j] << " ";
                }
                cout << endl;
            }
    cout << "The edit distance is:" << v[n-1][m-1] << endl;
    
    return 0;
}
#include <iostream>
using namespace std;

int main(){
    	int M[10][10];
	int num;
	cout<<"Enter Number of nodes : ";
	cin>>num;
	cout<<"Enter Adjecency Matrix : "<<endl;
	for(int i=0;i<num;i++){
		for(int j=0;j<num;j++){
			cin>>M[i][j];
		}
	}
	cout<<endl;
	cout<<"Distance Vector Routing Tables are :"<<endl;
	for(int i=0;i<num;i++){
		cout<<"N"<<i+1<<"--------"<<endl;
		cout<<"Node   Distance    Route"<<endl;
		for(int j=0;j<num;j++){
			cout<<"N"<<j+1<<"     ";
			if(i==j){
				cout<<0<<"         "<<"N"<<j+1<<endl;
			}
			else{
				int minD;
				if(M[i][j]==0){
					minD=100000;
				}
				else{
					minD=M[i][j];
				}
				int min=-1;
				for(int k=0;k<num;k++){
					if(M[i][k]>0 && j!=k){
						if(M[k][j]>0){
							if((M[i][k]+M[k][j])<minD){
								minD=(M[i][k]+M[k][j]);
								min=k;
							}
						}
					}					
				}
				if(min==-1){
					cout<<M[i][j]<<"         "<<"--"<<endl;
				}
				else{
					cout<<minD<<"         "<<"N"<<min+1<<", N"<<j+1<<endl;
				}
			}
		}
	}
}



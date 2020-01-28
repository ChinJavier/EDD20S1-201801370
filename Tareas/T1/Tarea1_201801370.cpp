#include<iostream>
using namespace std;

int main(){
	int colFil = 0;
	cout<<"Ingrese el número de filas y columnas"<<endl;
	cin>>colFil;
	char matriz[colFil][colFil];
	
	
	//Llenando la matriz para no tener valores no deseados
	for(int i = 0; i < colFil; i++){
		for(int j = 0; j <colFil; j++){
			if(i == 0 || j == 0 || i == colFil-1 || j == colFil-1){
				matriz[i][j]= '1';
			}else{
				matriz[i][j]= ' ';
			}
		}
	}
	
  
	//Otra forma de realizarlo
	/*	
	//Llenando el borde superior
	for(int j = 0; j <colFil; j++){
			matriz[0][j]= '1';
	}
	//Llenando el borde izquierdo
	for(int i = 0; i <colFil; i++){
			matriz[i][0]= '1';
	}
	//Llenando el borde derecho
	for(int i = 0; i <colFil; i++){
			matriz[i][colFil-1]= '1';
	}
	//Llenando el borde inferior
	for(int j = 0; j <colFil; j++){
			matriz[colFil-1][j]= '1';
	} */
	
	
	//imprimiendo la matriz
	for(int i = 0; i < colFil; i++){
		for(int j = 0; j <colFil; j++){
			cout<<"[" << matriz[i][j] << "]";
		}
		cout<<endl;
	}
		 
	
	return 0;
}




int X[100];
int N;

void Swap(int a,int b) {
    int t=X[a];
    X[a]=X[b];
    X[b]=t;
}

void Generate(int k) {
    if (k==N) {
        for(int i=0;i<N;i++)
            std::cout<<X[i]<<" ";
        std::cout<<"\n";
    } else { 
        for(int j=k; j<N; j++ ) {
            Swap(k,j);
            Generate(k+1);
            Swap(k,j);
        }
    }
}
 
int main() {
    std::cout<<"N=";
    
    std::cin>>N;

    for(int i=0; i<N; i++)
        X[i]=i+1;

    Generate(0);
}
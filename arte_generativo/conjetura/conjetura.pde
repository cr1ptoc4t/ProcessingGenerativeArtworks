int i = 1;
int iteracion=0;
int n;

void setup(){
    size(800, 800);
    background(100, 100, 255);
}

void draw(){
    while(i<50){
        n = i;
        iteracion=0;
        while (n!=1) {
            if(n%2==0){
                n=n/2;
            }else{
                n=n*3+1;
            }
            iteracion++;
            println("número: "+i+", iteración: "+ iteracion+", resultado: "+ n );
            fill(255);
            text("número: "+i+", iteración: "+ iteracion+", resultado: "+ n, width - 100, 40);
        }
        i++;
    }
}

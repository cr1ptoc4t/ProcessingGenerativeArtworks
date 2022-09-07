int cont=0;
float wSqrt = 200;
void setup() {
    fullScreen();
    background(#A7ADC6);
}

void draw(){
    //square(width/2, height/2, width);
    for(int i=0;i<width;i+=wSqrt){
        for(int j=0; j<height; j+=wSqrt ){
            square(i+wSqrt/2, j+wSqrt/2, wSqrt);
            cont=0;
            square(i, j, wSqrt);
            cont=0;
            //println(cont);
        }
    }
}


void square(float x, float y, float w){
    if(cont%3==0){
        stroke(#CE2D4F);
    }else if(cont%3==1){
        stroke(#56667A);
    } else{
        stroke(#EDAE49);
    }
    noFill();
    
    beginShape();
        vertex(x, y-w/2);
        vertex(x-w/2, y);
        vertex(x, y+w/2);
        vertex(x+w/2, y);
    endShape(CLOSE);
    //rotate(PI/2);
    cont++;
    if(cont<30){
       square(x,y,4*w/5);
    }
    
    // dibuixAR quadrat
    //rotar 90 graus
    //tornar a dibuixar
    //tornar a rotar
}
/* En este programa se describen dos bucles desfasados
a modo de dibujar cuadrados a noventa grados con el eje horizontal

Además, la variable intensity, cambia la intensidad de forma inversa a su valor
durante el frameCount()

Creado la semana del cinco de septiembre de 2022
*/

int cont=0;
int a = 0;
int b=width;
float wSqrt = 100;
int intensity = 0;

void setup() {
    fullScreen();
    background(#A7ADC6);
}

void draw(){
    wSqrt = map(mouseY, 0, height, 100, 500);
    background(240+random(-20,20) - intensity,160+random(-20,20)- intensity, 240+random(-20,20)- intensity);
    if(a==width){
        a=0;
    }

    for(int i=0;i<width;i+=wSqrt){
        for(int j=0; j<height; j+=wSqrt){
            square(i+wSqrt/2 + a, j+wSqrt/2, wSqrt);
            cont=0;
            square(i+ a, j, wSqrt);
            cont=0;
        }
    }
    intensity+=10;
}


void square(float x, float y, float w){
    if(cont%3==0){
        stroke(#56667A);
    }else if(cont%3==1){
        stroke(random(0,255), random(0,255), random(0,255));
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
    cont++;
    if(cont<30){
       square(x,y,7*w/8);
    }
}
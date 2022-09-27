int a =0;
void setup(){
    size(800,800, P3D);
    background(0);
}

void draw(){
    delay(50);
    background(0);
    for(int i=0; i<width;i+=width/5){
        for(int j=0; j<height;j+=height/5){
            esfera(i+ width/5/2,j+height/5/2, 50, i*5);
        }
    }
    
}


void esfera(float x, float y, float r, int i){
    noFill();
    if(i%2==0){
        stroke(120,120,255, 130);
    } else{
        stroke(255,120,120, 130);

    }
    
    pushMatrix();
        
        translate(x, y);
        
        rotateY(a);
        //rotateX(a/2);
        sphere(r);
        stroke(255, 100, 210, 130);
        //rotateY(-2*a);
        //sphere(150);
        //rotateY(a);

    popMatrix();
    a+=mouseY;
    println("valor de a: "+ a+ "\t Mouse Y: "+ mouseY);
}
float i;

void setup(){
    size(1000,1000, P3D);
    
}

void draw(){
    translate(width/2, height/2);
    background(230, 230, 255);
    fill(220, 230,200, 230);

   for(float x=0; x<width; x+=20){
       for(float y=0; y<height; y+=20){ 
            pushMatrix();
                translate(x, y);
                cuadrado();
            popMatrix();
       }
   }
}

void cuadrado(){
        rotateX(i*PI/16);
        rotateY(i*PI/16);
        fill(160,200,120,150);
        //translate(width/2, height/2, 0);
        box(100);
        fill(255);
        rotate(-i*PI/16);
        //box(100);
        delay(100);

    i+=0.3;
}

void recursive(float x, float y, float r){
    translate(x/2, y/2, 0);
    sphere(100);

    if(r<10){
        sphere(100);
    } else{
        recursive(x, y, r- 30);
    }

}
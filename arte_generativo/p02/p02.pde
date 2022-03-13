float i=1;
boolean a =true;
void setup(){
    size(1800,900, P3D);
    fullScreen();
    background(0);
    textAlign(CENTER);
    fill(0,255,0);
}

void draw(){
    rotateX(PI/6);
    background(0);
     camera(mouseX, i, i, 0.0, 0, 0.0, 0, 0.05, 0); 
    for(int i = 5; i<height;i+=39){
        for(int j = 5; j<height;j+=39){
            for(int k = 5; k<height; k+=39){
                //delay(2);
                if((j+i+k)%2==0){
                    fill(0,255,0);
                    text("1", i-500, j-200, k-1000);
                }else{
                    fill(255);
                    text("0", i-500, j-200, k-1000);
                }
            }
        }
    }
    println(i);

    if(a){
        i++;
    }else if(!a){
        i--;
    }



    if(i==70){
        a = false;
    } else if(i==0){
        a =true;

    }
    
   
}
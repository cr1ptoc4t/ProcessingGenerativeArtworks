int i = 1;
int iteracion=0;
int n;
float wGraph;
float hGraph;
float r = 35;
float mx, my;
color back = color(0, 0, 102);


void setup(){
    size(950, 950);
    background(back);
    wGraph = 25;
    hGraph = height - wGraph;
}

void draw(){
    graph();

    while(i<25){
        n = i;
        iteracion=0;
        while (n!=1) {
            graph();
            mx = map(i, wGraph, width - wGraph*2, 0, 20);
            my = map(n, wGraph, hGraph, 0, 180);
            //dibuixar on se situa a tal iteracio
            if(n%2==0){
                n=n/2;
            }else{
                n=n*3+1;
            }
            pushStyle();
                noStroke();
                fill(back);
                rect(width/2, 0, width/2, 70);
                fill(255);
                textAlign(RIGHT);
                text("número: "+i+"   iteración: "+ iteracion+"   resultado: "+ n, width, 40);
            popStyle();
            iteracion++;
            println("número: "+i+"\titeración: "+ iteracion+"\tresultado: "+ n );
            

        }
        i++;
    }
}

void graph(){
    pushStyle();
        stroke(255);
        line(wGraph, hGraph, width- wGraph, hGraph);
        line(wGraph, hGraph, wGraph, wGraph);
        
        for (int i=0; i<130; i++){
            textSize(7); textAlign(LEFT);
            line(wGraph, hGraph - i* ((width-2*wGraph)/130),wGraph-5, hGraph - i* ((width-2*wGraph))/130);
            text(i, wGraph - 10, hGraph - i* ((width-2*wGraph)/130)+2);
            if(i<21){
                textAlign(CENTER); textSize(15);
                line(wGraph + i* ((height-2*wGraph)/20), hGraph ,wGraph + i* ((height-2*wGraph)/20), hGraph + 5);
               
                text(i,wGraph + i* ((height-2*wGraph)/20), hGraph + 15);
            }
        }
        textSize(15);
        textAlign(RIGHT);
        text("Iteración  ", width, height - wGraph/4);
        pushMatrix();
            float angle = radians(270);
            rotate(angle);
            text("Número", -30, 13);
        popMatrix();
    popStyle();
}
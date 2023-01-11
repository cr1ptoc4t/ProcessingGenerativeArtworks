class Node{
    int num;
    Node izq, der;

    
    //constructor
    Node(int num){
        this.num = num;
        this.izq = null; //nodo izquierdo
        this.der= null;  //nodo derecho
    }

    void setIzq(Node nf){
        this.izq = nf;
    }
    
    void setDer(Node nf){
        this.der = nf;
    }

    void inOrdre(){
        if(this.izq != null)  {this.izq.inOrdre();}
        println(this.num);
        if(this.der!= null) {this.der.inOrdre();}

    }
    void preOrdre(){
        println(this.num);      
        if(this.izq != null){this.izq.preOrdre(); }
        if(this.izq != null){this.der.preOrdre();}
    }
    void postOrdre(){
        if(this.izq != null) { this.izq.postOrdre();}
        if(this.der != null){ this.der.postOrdre();}
        println(this.num);
    }

    void display(float x, float y, float r,  int lvl){
        float dx = (width/3)/(lvl+2);

        pushStyle();
            if(this.izq != null){line(x,y, x-dx, y+100);}
            if(this.der != null){line(x,y, x+dx, y+100);}
            ellipse(x, y, r, r);
            fill(0);
            textAlign(CENTER);
            textSize(18);
            text(this.num, x, y);
        popStyle();
    }
}
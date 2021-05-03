import processing.core.PApplet;
import java.util.ArrayList;

public class Universo extends PApplet {
   private Seguidor seguidor;
   private Seguivel seguivel;
   private Planeta planeta;
   private Asteroide asteroide;
   private ArrayList<Asteroide> asteroides;
   private int maxAsteroids = 20;
    float r;

    public void settings() {
        size(1500, 800);

        asteroides = new ArrayList<Asteroide>(10);
    }


    public void draw(){
        //Cor de fundo
        background(0);

        if (seguidor != null) {
            seguidor.desenha();
            seguidor.move();
            seguidor.segue();
        }
        if (seguivel != null) {
            seguivel.desenha();
            seguivel.move();
        }

        int i = 0;
        for (i = 0; i < asteroides.size(); i++) {
            Asteroide asteroide = asteroides.get(i);
            circle(asteroide.pegaX(), asteroide.pegaY(),asteroide.pegaTamanho());
            asteroide.move();
            if (asteroide.pegaX() >= 1000 - asteroide.pegaTamanho()/2) asteroide.setaDX(-asteroide.pegaDX());
            else if (asteroide.pegaX() < asteroide.pegaTamanho()/2) asteroide.setaDX(-asteroide.pegaDX());
            if (asteroide.pegaY() >= 1000 - asteroide.pegaTamanho()/2)  asteroide.setaDY(-asteroide.pegaDY());
            else if (asteroide.pegaY() < asteroide.pegaTamanho()/2) asteroide.setaDY(-asteroide.pegaDY());
        }

        //Posição do SOl na tela
        translate(width/5, height/2);
        //Rotação do planeta
        rotate(radians(r/5));

        //Sol
        Sol sol = new Sol(this);
        sol.desenha();

        //Planeta
        Planeta planeta = new Planeta(300, 0,this);
        planeta.desenha();
        //Satelite
            //Posição
            translate(300, 0);
            //Rotação
            rotate(radians(r/3));
            //Cor
            fill(255);
            //Formato
            ellipse(50,0 , 5, 5);

        //Contador do Raio
        r += 1;
       loop();

       if (asteroides.size() <= maxAsteroids){
           Asteroide asteroide = new Asteroide(20, width - random(1500), height - random(800), this);

           asteroide.setaDX(random(0,5));
           asteroide.setaDY(random(0,5));
           asteroides.add(asteroide);
       }


        if (seguivel != null && seguidor != null)
            seguidor.estabeleceAlvo(seguivel);
    }

    public void mousePressed() {
        Asteroide asteroide = new Asteroide(20, mouseX, mouseY, this);
        asteroide.setaDX(random(-2,2));
        asteroide.setaDY(random(-2,2));
        asteroides.add(asteroide);

//        if (mouseButton == LEFT) {
//            if (random(-1,1) < 0) {
//                seguivel = planeta;
//            } else {
//                seguidor = asteroide;
//            }
//
//        } else if (mouseButton == RIGHT) {
//            seguidor = bola;
//
//        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Universo" };
        PApplet.main(appletArgs);
    }
}

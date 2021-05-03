import processing.core.PApplet;
import java.util.ArrayList;

public class Universo extends PApplet {
   private Seguidor seguidor;
   private Seguivel seguivel;
   private Planeta planeta;
   private Sol sol;
   private Asteroide asteroide;
   private ArrayList<Asteroide> asteroides;
   private int maxAsteroids = 10;
   private float r;

    public void settings() {
        size(1500, 800);

        asteroides = new ArrayList<Asteroide>();
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
            asteroide.setaDX(-asteroide.pegaDY());
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
            fill(121, 123, 125);
            //Formato
            ellipse(50,0 , 5, 5);

        //Contador do Raio
        r += 1;
       loop();

       while (asteroides.size() <= maxAsteroids){
           Asteroide asteroide = new Asteroide(10, width - random(500), height - 800, this);

           asteroide.setaDX(random(2,5));
           asteroide.setaDY(random(2,5));

           asteroides.add(asteroide);
       }


        if (seguivel != null && seguidor != null)
            seguidor.estabeleceAlvo(seguivel);
    }

    public void mousePressed() {
        if (mouseButton == LEFT) {
            Asteroide asteroide = new Asteroide(10, mouseX, mouseY, this);
            asteroide.setaDX(random(5,10));
            asteroide.setaDY(random(5,10));
            asteroides.add(asteroide);
            seguivel = sol ;

            seguidor = asteroide;

        } else if (mouseButton == RIGHT) {
            asteroides.remove(asteroide);

        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Universo" };
        PApplet.main(appletArgs);
    }
}

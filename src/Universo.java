import processing.core.PApplet;

public class Universo extends PApplet {
   private Seguidor seguidor;
   private Seguivel seguivel;


    float x, y;
    float r;

    public void settings() {
        size(1500, 800);
        x = 200;
        y = 0;
    }

    public void draw(){
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
        //pushMatrix();
        translate(width/2, height/2);
        rotate(radians(r));

        //Sol
        Sol sol = new Sol(this);
        sol.desenha();

        //Planeta
        Planeta planeta = new Planeta(x, y,this);
        planeta.desenha();
//        fill(6, 109, 199);
//        ellipse(x, y, 50, 50);
       // pushMatrix();
            //Satelite
            translate(x, y);
            rotate(radians(-r*3));
            fill(255);
            ellipse(50, y, 5, 5);
       // popMatrix();
        r += 1;
       loop();
    }

    public void mousePressed() {
        Asteroide asteroide = new Asteroide( mouseX, mouseY, this);

        asteroide.setaDX(random(-2,2));
        asteroide.setaDY(random(-2,2));


        if (mouseButton == LEFT) {
                seguivel = asteroide;
        }

        if (seguivel != null && seguidor != null)
            seguidor.estabeleceAlvo(seguivel);

    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Universo" };
        PApplet.main(appletArgs);
    }
}

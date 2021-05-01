import processing.core.PApplet;

public class Universo extends PApplet {
    //private Seguidor seguidor;
   // private Seguivel seguivel;

    float x, y;
    float dim = 80.0f;

    public void settings() {
        size(1500, 1000);
    }

    public void draw(){
        background(0);
        fill(245, 192, 20);
        ellipse(500, 500, 200, 200);
        x = x + 30f;

        if (x > width + dim) {
            x = -dim;
        }


        translate(x, dim);
        fill(255);
        ellipse(80, -dim/2, dim, dim);
        loop();
    }



    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Universo" };
        PApplet.main(appletArgs);
    }
}

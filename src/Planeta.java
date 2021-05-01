import processing.core.PApplet;

public class Planeta implements Desenhavel {
    private float posx;
    private float posy;
    private PApplet processing;

    public Planeta( float posx, float posy, PApplet processing) {
        this.posx = posx;
        this.posy = posy;
        this.processing = processing;
    }
    public void desenha() {
        this.processing.fill(6, 109, 199);
        this.processing.ellipse(posx, posy, 50, 50);;
    }
}


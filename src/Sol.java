import processing.core.PApplet;

public class Sol implements Desenhavel {
    private PApplet processing;

    public Sol( PApplet processing) {
        this.processing = processing;
    }
    public void desenha() {
        this.processing.fill(245, 192, 20);
        this.processing.ellipse(0, 0, 200, 200);
    }
}


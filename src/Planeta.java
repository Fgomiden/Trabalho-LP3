import processing.core.PApplet;

public class Planeta implements Desenhavel, Animavel, Seguidor, Seguivel {
    private float posx;
    private float posy;
    //int r;
    private PApplet processing;

    public Planeta( float posx, float posy, PApplet processing) {
        this.posx = posx;
        this.posy = posy;
        this.processing = processing;
    }
    public void desenha() {
        this.processing.fill(6, 109, 199);
        this.processing.ellipse(posx, posy, 25, 25);
//        this.processing.translate(this.processing.width/2, this.processing.height/2);
//        this.processing.rotate(this.processing.radians(r));
//        r += 1;
//        this.processing.loop();
    }

    @Override
    public void move() {

    }

    @Override
    public void segue() {

    }

    @Override
    public void estabeleceAlvo(Seguivel alvo) {

    }

    @Override
    public Posicao pegaPosicao() {
        return null;
    }
}


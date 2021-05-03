import processing.core.PApplet;

public class Sol implements Desenhavel, Animavel, Seguidor, Seguivel {
    private PApplet processing;

    public Sol( PApplet processing) {
        this.processing = processing;
    }
    public void desenha() {
        this.processing.fill(245, 192, 20);
        this.processing.ellipse(0, 0, 100, 100);
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


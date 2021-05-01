import processing.core.PApplet;

public class Planeta implements Animavel, Seguidor, Seguivel {
    private float tamanho;
    private float posx;
    private float posy;
    private float dx = 0;
    private float dy = 0;

    private PApplet lugar;

    private Seguivel alvo = null;

    public Planeta(float tamanho, float posx, float posy, PApplet lugar) {
        this.tamanho = tamanho;
        this.posx = posx;
        this.posy = posy;
        this.lugar = lugar;
    }

    //Interface Seguidor
    public void estabeleceAlvo(Seguivel alvo) {
        this.alvo = alvo;
    }

    //Interface Seguidor
    public void segue() {
        Posicao p_alvo;
        float novodx;
        float novody;
        if (this.alvo != null) {
            p_alvo = alvo.pegaPosicao();
            novodx = (p_alvo.pegaX() - posx)/1000;
            novody = (p_alvo.pegaY() - posy)/1000;
            dx = dx + novodx;
            dy = dy + novody;
        }
    }

    //Interface seguível
    public Posicao pegaPosicao() {
        return new Posicao(this.posx, this.posy);
    }

    public void desenha() {
        this.lugar.circle(posx, posy, tamanho);
    }


    public void setaTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public void setaX(float posx) {
        this.posx = posx;
    }

    public void setaY(float posy) {
        this.posy = posy;
    }

    public float pegaTamanho() {
        return this.tamanho;
    }

    public float pegaX() {
        return this.posx;
    }

    public float pegaY() {
        return this.posy;
    }

    public void setaDX(float dx) {
        this.dx = dx;
    }

    public void setaDY(float dy) {
        this.dy = dy;
    }
    public float pegaDX() {
        return this.dx;
    }

    public float pegaDY() {
        return this.dy;
    }

    public void move() {
        this.posx = this.posx + this.dx;
        this.posy = this.posy + this.dy;
        ajusta();
    }

    public void ajusta() {
        if (posx >= lugar.width - tamanho/2) dx = -dx;
        else if (posx < tamanho/2) dx = -dx;

        if (posy >= lugar.height - tamanho/2) dy = -dy;
        else if (posy < tamanho/2) dy = -dy;
    }


}

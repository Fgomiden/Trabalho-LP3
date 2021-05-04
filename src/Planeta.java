import processing.core.PApplet;
//Classe Planeta com herança simples da interface Desenhavel
public class Planeta implements Desenhavel {
    //Atributos
    private float posx;
    private float posy;
    private float tamX;
    private float tamY;
    public PApplet processing;

    //Construtor
    public Planeta( float posx, float posy, float tamX, float tamY, PApplet processing) {
        this.posx = posx;
        this.posy = posy;
        this.tamX = tamX;
        this.tamY = tamY;
        this.processing = processing;
    }
    //Função exibe a forma geométrica na tela
    public void desenha() {
        this.processing.ellipse(posx, posy, tamX, tamY);
    }

}


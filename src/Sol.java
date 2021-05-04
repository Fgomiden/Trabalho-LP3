import processing.core.PApplet;

//Classe Sol com herança simples da interface Desenhavel
public class Sol implements Desenhavel {
    //Atributo que define o processing
    private PApplet processing;

    //Contrutor da classe Sol
    public Sol( PApplet processing) {
        this.processing = processing;
    }

    //Função exibe a forma geométrica na tela
    public void desenha() {
        this.processing.fill(245, 192, 20);
        this.processing.ellipse(0, 0, 150, 150);
    }
}


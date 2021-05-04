//Classe Asteroide com herança simples da interface Animavel
public class Asteroide  implements Animavel {
   //Atributos
    private float tamanho;
    private float posx;
    private float posy;
    private float dx = 0;
    private float dy = 0;


    //Construtor da classe
    public Asteroide( float tamanho, float posx, float posy) {
        this.tamanho = tamanho;
        this.posx = posx;
        this.posy = posy;
    }

    //Retorna o tamanho da forma geometrica
    public float pegaTamanho() {
        return this.tamanho;
    }

    //Retorna a posição no eixo X da forma geometrica
    public float pegaX() {
        return this.posx;
    }

    //Retorna a posição no eixo Y da forma geometrica
    public float pegaY() {
        return this.posy;
    }

    //Função que define a direção no eixo X
    public void setaDX(float dx) {
        this.dx = dx;
    }

    //Função que define a direção no eixo X
    public void setaDY(float dy) {
        this.dy = dy;
    }

    //Retorna a direção no eixo X
    public float pegaDX() {
        return this.dx;
    }

    //Retorna a direção no eixo Y
    public float pegaDY() {
        return this.dy;
    }

    //Função da Interface Animável que é responsavel por fazer o objeto se movimentar
    public void move() {
        this.posx = this.posx + this.dx;
        this.posy = this.posy + this.dy;
    }

}

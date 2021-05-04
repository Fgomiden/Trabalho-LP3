public class Estrela  {
    //Atributos
    private float tamanho;
    private float posx;
    private float posy;

    //Construtor
    public Estrela( float tamanho, float posx, float posy) {
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

}

import processing.core.PApplet;
import java.util.ArrayList;

//Classe principal que herda os atributos da classe PApplet
public class Universo extends PApplet {
    //Atributos
    private Planeta venus;
    private Planeta terra;
    private Planeta marte;
    private Planeta jupiter;
    private ArrayList<Asteroide> asteroides;
    private ArrayList<Estrela> estrelas;
    private float r;

    public void settings() {
        //Tamanho da tela
        size(1500, 1000);

        //Definindo Planetas
        venus =  new Planeta(200, 100,10, 10,this);
        terra =  new Planeta(300, 0, 25, 25,this);
        marte =  new Planeta(400, 150, 20, 20,this);
        jupiter =  new Planeta(600, 200, 70, 70,this);

        //Lista de Ateroides
        asteroides = new ArrayList<Asteroide>();

        //Lista de Estrelas
        estrelas = new ArrayList<Estrela>();
    }

    public void draw(){
        //Cor de fundo
        background(0);

        //Percorre pela lista de asteroides
        int i = 0;
        for (i = 0; i < asteroides.size(); i++) {
            Asteroide asteroide = asteroides.get(i);

            //Define a forma geometrica do asteroide
            circle(asteroide.pegaX(), asteroide.pegaY(), asteroide.pegaTamanho());

            //Faz o asteroide se movimentar
            asteroide.move();

            //Define a direção do eixo Y com relação ao valor que foi deinido no eixo X
            asteroide.setaDY(-asteroide.pegaDX());

            //Define a direção do eixo X com relação ao valor que foi deinido no eixo X
            asteroide.setaDX(-asteroide.pegaDY());
        }

        //Percorre pela lista de estrelas
        int j = 0;
        for (j = 0; j < estrelas.size(); j++) {
            Estrela estrela = estrelas.get(j);
            circle(estrela.pegaX(), estrela.pegaY(),estrela.pegaTamanho());
        }

        //Posição do SOl na tela
        translate(width/3, height/2);
        //Rotação dos planetas
        rotate(radians(r/4));

        //Sol
        Sol sol = new Sol(this);
        sol.desenha();

        //Colorindo e exibindo os Planetas
        venus.processing.fill(173, 126, 5);
        venus.desenha();
        terra.processing.fill(10, 130, 204);
        terra.desenha();
        marte.processing.fill(158, 56, 44);
        marte.desenha();
        jupiter.processing.fill(163, 138, 54);
        jupiter.desenha();

        //Lua
            //Posição
            translate(300, 0);
            //Rotação
            rotate(radians(r));
            //Cor
            fill(121, 123, 125);
            //Formato
            ellipse(50,0 , 5, 5);

        //Contador do Raio
        r += 1;
        //Reinicia a animação de rotação
        loop();
    }

    //Função ao clicar nos botões do mouse
    public void mousePressed() {
        //Botão esquerdo aciona animação do asteróide
        if (mouseButton == LEFT) {
            //Define uma nova instancia de Asteroide
            Asteroide asteroide = new Asteroide(15, mouseX, mouseY);
            //Define a direção no eixo X
            asteroide.setaDX(random(-10,10));
            //Define a direção no eixo Y
            asteroide.setaDY(random(-10,10));
            //Dá movimento ao asteroide
            asteroide.move();
            //Adiciona asteroide na lista
            asteroides.add(asteroide);
        }
        //Botão direito faz aparecer a estrela na tela
        else if (mouseButton == RIGHT) {
            //Define uma nova instancia de Estrela
            Estrela estrela = new Estrela(5, mouseX, mouseY);
            //Adiciona estrela na lista
            estrelas.add(estrela);
        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Universo" };
        PApplet.main(appletArgs);
    }
}

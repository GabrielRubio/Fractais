
//importes necessarios para mexer com as janelas 
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class CircleFractal extends JFrame{ //classe principal
    
    int tipo = Integer.parseInt(JOptionPane.showInputDialog("Selecione [1] para fractal circular simples e [2] para fractal com quatro circulos: ")); //seleção do tipo de fractal
    int interacoes = Integer.parseInt(JOptionPane.showInputDialog("Numero de interações: ")); //valor para recerber o numero desejado de interações
    
    public CircleFractal() {
        JPanel painel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                if (tipo==1){
                SimpleFractalCircle(interacoes,15, 5, 620, (Graphics2D) g); //chamada para o metodo fractal    
                }
                if (tipo==2){
                fourFractalCircle(interacoes,15, 5, 620, (Graphics2D) g); //chamada para o metodo fractal
                }
            }
        };
         // configurações de janela
        this.add(painel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,660);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Fractal circular");
    }
    
    
    //metodo main da classe
    public static void main(String[] args) {
        CircleFractal main = new CircleFractal();    
    }

    //função para criar o fractal de 4 circulos
    public static void fourFractalCircle(int interacoes, int x, int y, int tamanho, Graphics2D g) {
        if (interacoes == 0) {
        //parada da recursividade
        } else {
            g.drawOval(x, y, tamanho, tamanho); //linha para desenhar o fractal

            fourFractalCircle(interacoes - 1, x+tamanho / 4, y, tamanho / 2, (Graphics2D) g); //chamada recurssiva para desenhar circulos na parte superior
            fourFractalCircle(interacoes - 1, x, y+tamanho / 4, tamanho / 2, (Graphics2D) g);//chamada recurssiva para desenhar circulos na parte esquerda
            fourFractalCircle(interacoes - 1, x + tamanho / 2, y+tamanho / 4, tamanho / 2, (Graphics2D) g);////chamada recurssiva para desenhar circulos na parte direita
            fourFractalCircle(interacoes - 1, x+ tamanho / 4, y + tamanho / 2, tamanho / 2, (Graphics2D) g);//chamada recurssiva para desenhar circulos na parte inferior
        }
    }
    
    //chamada recursiva para criação do fractal
    public static void SimpleFractalCircle(int interacoes, int x, int y, int tamanho, Graphics2D g) {
        if (interacoes == 0) {
         //parada da recursividade
        } else {
            g.drawOval(x, y, tamanho, tamanho); //linha de desenho do fractal

            SimpleFractalCircle(interacoes - 1, x, y+tamanho / 4, tamanho / 2, (Graphics2D) g); //chamada recurssiva para desenhar circulos na parte esquerda
            SimpleFractalCircle(interacoes - 1, x + tamanho / 2, y+tamanho / 4, tamanho / 2, (Graphics2D) g); ////chamada recurssiva para desenhar circulos na parte direita
        }
    }
}

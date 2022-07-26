import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;

/**
     * 1-Leitura da imagem
     * 2-Cria uma nova imagem com transparecencia e tamanho novo
     * 3-Copiar imagem original para a nova
     * 4-Escrever uma frase em uma nova imagem
     * 5-Escrever na nova imagem
     */

public class StickerGenerete {




    public void criaImagem(InputStream inputStream, String nomeArquivo) throws Exception {
        //1
//        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@.jpg").openStream();
//        InputStream inputStream = new FileInputStream(new File("entrada/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg"));
        BufferedImage originalImagem = ImageIO.read(inputStream);

        //2
        int width = originalImagem.getWidth();
        int height = originalImagem.getHeight();
        int novaAltura = height + 200;

        //3
        BufferedImage novaImagem = new BufferedImage(width,novaAltura,BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(originalImagem, 0, 0, null);

        //SET FONT
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 56);
        graphics.setFont(fonte);

        //SET COLOR
        Color color = Color.CYAN;
        graphics.setColor(color);

        //4
        //WRITE MENSAGE
        String mensagem = "Olha essa figurinha";
        graphics.drawString(mensagem, 0, novaAltura - 100);


        //5
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

}

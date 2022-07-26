import java.io.InputStream;
import java.net.URL;
import java.util.List;


/**
 * 1-Fazer conexão HTTP e buscar o top 250 conteudos (URL: https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060) (CLASS CLIENTE HTTP)
 * 2-Pegar dados que nos importam (titulo, poster, classificação) (CLASS EXTRATOR E CONTEUDO)
 * 3-Exibir e manipular os dados
 */

public class Main {
    public static void main(String[] args) {

        ClienteHttp clienteHttp = new ClienteHttp();

        //IMBD
        ExtratorConteudo extratorConteudoImdb = new ExtratorConteudoImdb();
        List<Conteudo> conteudos = extratorConteudoImdb.extrairConteudo("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");


//        //NASA
//        ExtratorConteudo extratorConteudoNasa = new ExtratorConteudoNasa();
//        List<Conteudo> conteudos = extratorConteudoNasa.extrairConteudo("https://api.mocki.io/v2/549a5d8b/NASA-APOD");


        //3
        StickerGenerete stickerGenerete = new StickerGenerete();
        for (int i = 0; i < 3; i++) {
            Conteudo retornoConteudo = conteudos.get(i);

            String nomeConteudo = retornoConteudo.getTitulo();
            String urlImage = retornoConteudo.getUrlImagem();


            //Gera figurinha com base nos conteudos
            try {
                String nomeArquivo = nomeConteudo + ".png";
                InputStream inputStream = new URL(urlImage).openStream();
                stickerGenerete.criaImagem(inputStream, nomeArquivo);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }


            System.out.println("\u001b[1m Nome: \u001b[m" + nomeConteudo);
            System.out.println("\u001b[1m Poster: \u001b[m" + urlImage);
        }

    }
}

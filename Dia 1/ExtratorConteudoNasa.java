import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo{

    public List<Conteudo> extrairConteudo(String json){

        JsonParser jsonParser = new JsonParser();

        ClienteHttp clienteHttp = new ClienteHttp();
        List<Map<String, String>> listaConteudo = jsonParser
                .parse(clienteHttp.buscaDados(json));


        List<Conteudo> conteudos = new ArrayList<>();
        //Popular Lista Conteudos
        for (Map<String, String> novoConteudo: listaConteudo ){

            String conteudoTitulo = novoConteudo.get("title");
            String urlImagem = novoConteudo.get("url");
            conteudos.add(new Conteudo(conteudoTitulo, urlImagem));
        }

        return conteudos;

    }

}

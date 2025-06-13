package servico;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClienteApi {
    public static String obterJson(String urlApi) {
        try {
            URL url = new URL(urlApi);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();

            return resposta.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

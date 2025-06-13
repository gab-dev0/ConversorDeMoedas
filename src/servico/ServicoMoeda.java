package servico;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ServicoMoeda {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/c6a48f249c9ee4e841dcb074/latest/USD";

    public static double obterTaxaDeCambio(String deMoeda, String paraMoeda) {
        String respostaJson = ClienteApi.obterJson(URL_API);

        Gson gson = new Gson();
        JsonObject jsonObjeto = gson.fromJson(respostaJson, JsonObject.class);
        JsonObject taxas = jsonObjeto.getAsJsonObject("conversion_rates");

        double taxaOrigem = taxas.get(deMoeda).getAsDouble();
        double taxaDestino = taxas.get(paraMoeda).getAsDouble();

        return taxaDestino / taxaOrigem;
    }
}

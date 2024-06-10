package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RESTAPIClientTask {

    // Método para fazer a chamada à API e contar os registros por gênero
    public static void countRecordsByGender() throws IOException, JSONException {
        // Definir o URL da API endpoint
        URL url = new URL("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");

        // Abrir conexão HTTP
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Ler a resposta da API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Converter a resposta para JSON
        JSONArray jsonArray = new JSONArray(response.toString());

        // Contar os registros por gênero
        int maleCount = 0;
        int femaleCount = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String gender = jsonObject.getString("gender");
            if ("male".equals(gender)) {
                maleCount++;
            } else if ("female".equals(gender)) {
                femaleCount++;
            }
        }

        // Imprimir o resultado
        System.out.println("Número de registros para o gênero masculino: " + maleCount);
        System.out.println("Número de registros para o gênero feminino: " + femaleCount);
    }

}

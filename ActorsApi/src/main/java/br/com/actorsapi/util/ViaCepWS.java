package br.com.actorsapi.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ViaCepWS {
	
	public static ViaCep searchCep(String cep) {
        String json;
        ViaCep viacep = new ViaCep();
        
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();
            
            Gson gson = new GsonBuilder().create();
            viacep = gson.fromJson(json, ViaCep.class);

        } catch (Exception e) {
           return null;
        }

        return viacep;
    }

}

package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class SugarConnection {

    private static URL url;
    private static final String urls = "https://lftmdev.sugarondemand.com/rest/v11";
    private static HttpURLConnection con;
    private static String username = "";
    private static String password = "";
    private static String accessToken;
    private static int status;

    public SugarConnection() {}

    private static boolean isExpired () {
        try {
            url = new URL(urls+"/Contacts");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestProperty("OAuth-key", accessToken);
            status = con.getResponseCode();
            if (status == 401)
                return true;
        } catch (Exception e) {}
        return false;
    }

    public static boolean isClient (String codClient) {

        String inputLine;

        if(isExpired()) {
        	if(!SugarLogin(username,password)) 
        		return false;
        }

        //setting up connection url
        try {
            url = new URL(urls + "/Contacts" +
                    "?filter[0][lftm_numero_conta_c]="+codClient+"");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestProperty("OAuth-Token", accessToken);

        } catch (java.net.MalformedURLException error) {
            System.out.println("Error on URL");
        } catch (java.io.IOException error) {
            System.out.println("Error on connection setup");
        }
        // executing and getting response
        try {
            status = con.getResponseCode();
            System.out.println(status);
            InputStream is = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer content = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            try {
                JSONObject Response = new JSONObject(content.toString());
                JSONArray Records = Response.getJSONArray("records");
                JSONObject one = Records.getJSONObject(0);
                String id = one.getString("id");
                if (id == "")
                    return false;
                else
                    return true;
            } catch(org.json.JSONException error) {
                System.out.println("Error on Json Object");
            }
            in.close();

        } catch (java.io.IOException error) {
            System.out.println("Error on connection output");
            return false;
        }

        return true;
    }

    public static boolean SugarLogin(String usuario, String senha) {
        String inputLine;
        //setting up connection url
        username = usuario;
        password = senha;
        try {
            url = new URL(urls+"/oauth2/token");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
        } catch (java.net.MalformedURLException error) {
            System.out.println("Error on URL");
        } catch (java.io.IOException error) {
            System.out.println("Error on connection setup");
        }
        //setting parameters
        Map<String,String> parameters = new HashMap<>();
        parameters.put("grant_type", "password");
        parameters.put("client_id", "sugar");
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("platform", "base");
        // set parameters to the connection
        try {
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            DataOutputStream out = new DataOutputStream(os);
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
        } catch (java.net.ProtocolException error) {
            System.out.println("Error on Login");
            return false;
        } catch (java.io.IOException error) {
            System.out.println("Error on connection parameters");
            return false;
        }
        // executing and getting response
        try {
            status = con.getResponseCode();
            InputStream is = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer content = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            try {
                JSONObject Response = new JSONObject(content.toString());
                accessToken = Response.getString("access_token");
            } catch(org.json.JSONException error) {
                System.out.println("Error on Json Object");
            }
            in.close();
            if (status == 200)
                return true;
            else
                return false;

        } catch (java.io.IOException error) {
            System.out.println("Error on connection output");
            return false;
        }
    }

}

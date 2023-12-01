package org.example.httpClient;

import netscape.javascript.JSObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.entity.TableState;
import org.example.entity.User;
import org.example.payload.ForgetPasswordRequest;
import org.example.payload.LoginRequest;
import org.example.payload.TableStates;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HttpClient {
    public HttpClient() {
    }
    public void httpGet(String uri){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(uri);

        ResponseHandler<?> handler = response -> {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString = entity != null ? EntityUtils.toString(entity) : null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            System.out.printf("Execute get to %s, statusCode: %s %nResponse: %s", "stringee.com", status, getResponseString);
            return getResponseString;
        };

        try {
            httpClient.execute(httpGet,handler);
        } catch (Exception ex) {
            System.err.println("Exception " + ex);
        }
    }

    public String login(String uri, LoginRequest loginRequest){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(uri);

        EntityBuilder builder = EntityBuilder
                .create()
                .setText("{\n" +
                        "  \"email\": \"" + loginRequest.getEmail() + "\",\n" +
                        "  \"password\": \"" + loginRequest.getPassword() + "\"\n" +
                        "}");
        httpPost.setEntity(builder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler<String> handler = response -> {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString;
            if (entity != null) getResponseString = EntityUtils.toString(entity);
            else getResponseString = null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            StringTokenizer stringTokenizer = new StringTokenizer(getResponseString, "{:,");
            stringTokenizer.nextToken();
            System.out.printf("StatusCode: %s %nResponse: %s %n", status, getResponseString);
            return stringTokenizer.nextToken();
        };

        try {
            return httpClient.execute(httpPost, handler);
        } catch (Exception ex) {
            return null;
        }
    }

    public Integer signup(String uri, LoginRequest loginRequest){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(uri);

        EntityBuilder builder = EntityBuilder
                .create()
                .setText("{\n" +
                        "  \"email\": \"" + loginRequest.getEmail() + "\",\n" +
                        "  \"password\": \"" + loginRequest.getPassword() + "\"\n" +
                        "}");
        httpPost.setEntity(builder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler<Integer> handler = response -> {
            Integer status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString;
            if (entity != null) getResponseString = EntityUtils.toString(entity);
            else getResponseString = null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            System.out.printf("Execute post to %s, statusCode: %s %nResponse: %s", "stringee.com", status, getResponseString);
            return status;
        };

        try {
            return httpClient.execute(httpPost, handler);
        } catch (Exception ex) {
            return null;
        }
    }

    public Integer forgetPassword(String uri, ForgetPasswordRequest forgetPasswordRequest){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(uri);

        EntityBuilder builder = EntityBuilder
                .create()
                .setText("{\n" +
                        "  \"email\": \"" + forgetPasswordRequest.getEmail() + "\"\n" +
                        "}");
        httpPost.setEntity(builder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler<Integer> handler = response -> {
            Integer status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString;
            if (entity != null) getResponseString = EntityUtils.toString(entity);
            else getResponseString = null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            System.out.printf("Execute post to %s, statusCode: %s %nResponse: %s", "stringee.com", status, getResponseString);
            return status;
        };

        try {
            return httpClient.execute(httpPost, handler);
        } catch (Exception ex) {
            return null;
        }
    }

    public void httpPut(String uri){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPut httpPut = new HttpPut(uri);

        ResponseHandler<String> handler = response -> {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString = entity != null ? EntityUtils.toString(entity) : null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            System.out.printf("Execute put to %s, statusCode: %s %nResponse: %s", "stringee.com", status, getResponseString);
            return getResponseString;
        };

        try {
            httpClient.execute(httpPut, handler);
        } catch (Exception ex) {
            System.err.println("Exception " + ex);
        }
    }

    public void httpDelete(String uri){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpDelete httpDelete = new HttpDelete(uri);

        ResponseHandler<String> handler = response -> {

            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String getResponseString = entity != null ? EntityUtils.toString(entity) : null;
            if (entity != null) {
                EntityUtils.consume(entity);
            }
            System.out.printf("Execute delete to %s, statusCode: %s %nResponse: %s", "stringee.com", status, getResponseString);
            return getResponseString;
        };

        try {
            httpClient.execute(httpDelete, handler);
        } catch (Exception ex) {
            System.err.println("Exception " + ex);
        }
    }

    public List<TableState> getTableStates(Integer type, String token){
        try{
            RestTemplate restTemplate = new RestTemplate();
            List<TableState> tableStates = new ArrayList<>();
            tableStates = restTemplate.getForObject("http://localhost:8080/api/v1/tableState/type/{type}", TableStates.class, type).getTableStates();
            return tableStates;
        }catch(Exception e){
            return null;
        }
    }

    public TableState getTableState(Integer id, String token){
        try{
            RestTemplate restTemplate = new RestTemplate();
            TableState tableState = new TableState();
            tableState = restTemplate.getForObject("http://localhost:8080/api/v1/tableState/{id}", TableState.class, id);
            return tableState;
        }catch(Exception e){
            return null;
        }
    }

    public TableState putTableState(TableState tableState, String token){
        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put("http://localhost:8080/api/v1/tableState", tableState);
            tableState = restTemplate.getForObject("http://localhost:8080/api/v1/tableState/{id}", TableState.class, tableState.getId());
            return tableState;
        }catch(Exception e){
            return null;
        }
    }
}

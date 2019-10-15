package com.dandan.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.*;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 采用连接池来管理HttpClient
 *
 * @author liangfengshan
 */
public class HttpClientUtils02 {

    //private static final Log LOG = LogFactory.getLog(HttpClientUtils.class);

    private static final JSONObject JO404 = new JSONObject();

    static {
        JO404.put("src/main/java/code", 404);
        JO404.put("message", "404 error");
    }

    /**
     * The default timeout for a connected socket.
     */
    public static final int DEFAULT_SOCKET_TIMEOUT_MS = 50 * 1000;

    /**
     * The default timeout for establishing a connection.
     */
    public static final int DEFAULT_CONNECTION_TIMEOUT_MS = 50 * 1000;

    /**
     * max connections a client can have at same time
     */
    private static final int DEFAULT_MAX_CONNECTIONS = 100;

    private static final int DEFAULT_MAX_CONNECTIONS_ROUTE = 100;

    private static final String ENCODE = "utf-8";

    private static PoolingHttpClientConnectionManager connManager = null;
    private static CloseableHttpClient httpclient = null;

    static {
        try {
            SSLContext sslContext = SSLContexts.custom().build();
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }}, null);


            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })).build();

            connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            // 设置超时
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT_MS).setSocketTimeout(DEFAULT_SOCKET_TIMEOUT_MS)
                    .setConnectionRequestTimeout(DEFAULT_CONNECTION_TIMEOUT_MS).build();

            // 设置http cleint参数
            httpclient = HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(requestConfig).setRetryHandler(new DefaultHttpRequestRetryHandler(3, false)).build();
            // Create socket configuration
            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            connManager.setDefaultSocketConfig(socketConfig);
            // Create message constraints
            MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(10000).setMaxLineLength(100000).build();
            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE).setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints).build();
            connManager.setDefaultConnectionConfig(connectionConfig);
            connManager.setMaxTotal(DEFAULT_MAX_CONNECTIONS);
            connManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS_ROUTE);
        } catch (KeyManagementException e) {
            //LOG.error("KeyManagementException", e);
        } catch (NoSuchAlgorithmException e) {
            //LOG.error("NoSuchAlgorithmException", e);
        }
    }

    public static CloseableHttpClient getTimeoutHttpClient() {
        return httpclient;
    }

    public static CloseableHttpClient getHttpClient() {
        return httpclient;
    }

    /**
     * 发送请求获取byte数组结果
     *
     * @param uri
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static byte[] requestByteArray(String uri, Map<String, Object> queryParameters, String method) throws Exception {
        return requestByteArray(uri, null, queryParameters, method);
    }

    /**
     * 发送请求获取response返回
     *
     * @param uri
     * @param headers
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static Map<String, Object> requestResponse(String uri, Map<String, String> headers, Map<String, Object> queryParameters, String method) throws Exception {
        String requestMethod = method == null ? "get" : method.toLowerCase();
        Map<String, Object> map = new HashMap<String, Object>();
        CloseableHttpResponse httpResponse = null;
        switch (requestMethod) {
            case "get":
                HttpGet httpGet = new HttpGet();
                try {
                    httpResponse = get(httpGet, uri, headers, queryParameters);
                    map.put("header", httpResponse.getAllHeaders());
                    map.put("entity", extractByte(uri, method, httpResponse));
                } finally {
                    httpGet.releaseConnection();
                }
                break;
            case "post":
                HttpPost httpPost = new HttpPost(uri);
                try {
                    httpResponse = post(httpPost, uri, headers, queryParameters);
                    map.put("header", httpResponse.getAllHeaders());
                    map.put("entity", extractByte(uri, method, httpResponse));
                } finally {
                    httpPost.releaseConnection();
                }
                break;
            default:
                break;
        }
        return map;
    }

    /**
     * 发送请求获取byte数组结果
     *
     * @param uri
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static byte[] requestByteArray(String uri, Map<String, String> headers, Map<String, Object> queryParameters, String method) throws Exception {
        String requestMethod = method == null ? "get" : method.toLowerCase();
        CloseableHttpResponse httpResponse = null;
        byte[] responseByte = null;
        switch (requestMethod) {
            case "get":
                HttpGet httpGet = new HttpGet();
                try {
                    httpResponse = get(httpGet, uri, headers, queryParameters);
                    responseByte = extractByte(uri, method, httpResponse);
                } finally {
                    httpGet.releaseConnection();
                }
                break;
            case "post":
                HttpPost httpPost = new HttpPost(uri);
                try {
                    httpResponse = post(httpPost, uri, headers, queryParameters);
                    responseByte = extractByte(uri, method, httpResponse);
                } finally {
                    httpPost.releaseConnection();
                }
                break;
            default:
                break;
        }
        return responseByte;
    }

    /**
     * 发送请求获取string结果
     *
     * @param uri
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static String requestString(String uri, Map<String, String> headers, Map<String, Object> queryParameters, String method, boolean isJson) throws Exception {
        String requestMethod = method == null ? "get" : method.toLowerCase();
        CloseableHttpResponse httpResponse = null;
        String responseString = null;
        switch (requestMethod) {
            case "get":
                HttpGet httpGet = new HttpGet();
                try {
                    httpResponse = get(httpGet, uri, headers, queryParameters);
                    responseString = extractStr(uri, httpResponse);
                } finally {
                    httpGet.releaseConnection();
                }
                break;
            case "post":
                HttpPost httpPost = new HttpPost(uri);
                try {
                    httpResponse = post(httpPost, uri, headers, queryParameters, isJson);
                    responseString = extractStr(uri, httpResponse);
                } finally {
                    httpPost.releaseConnection();
                }
                break;
            default:
                break;
        }
        //LOG.debug(String.format("[%s]%s:%s\n[response]%s", requestMethod, uri, queryParameters, responseString));
        return responseString;
    }

    private static byte[] extractByte(String uri, String method, CloseableHttpResponse httpResponse) throws Exception {
        byte[] responseByte = null;
        try {
            if (httpResponse != null) {
                HttpEntity entity = httpResponse.getEntity();
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                try {
                    if (statusCode == HttpStatus.SC_OK) {
                        responseByte = EntityUtils.toByteArray(entity);
                    } else {
                        //LOG.error(String.format("request url: %s return error code: %s", uri, statusCode));
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            }
        } finally {
            closeResponseEntity(httpResponse);
        }
        return responseByte;
    }

    /**
     * 发送请求获取string结果
     *
     * @param uri
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static String requestString(String uri, Map<String, Object> queryParameters, String method) throws Exception {
        return requestString(uri, null, queryParameters, method, false);
    }

    /**
     * 发送请求获取string结果
     *
     * @param uri
     * @param queryParameters
     * @param method
     * @return
     * @throws Exception
     */
    public static String requestString(String uri, Map<String, String> headers, Map<String, Object> queryParameters, String method) throws Exception {
        return requestString(uri, headers, queryParameters, method, false);
    }

    private static String extractStr(String uri, CloseableHttpResponse httpResponse) {
        String responseString = null;
        try {
            if (httpResponse != null) {
                HttpEntity entity = httpResponse.getEntity();
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                try {
                    if (statusCode == HttpStatus.SC_OK) {
                        responseString = EntityUtils.toString(entity, ENCODE);
                    } else {
                        Map<String, Object> rest = new HashMap<String, Object>();
                        rest.put("code", statusCode);
                        responseString = JSON.toJSONString(rest);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            }
        } catch (Exception e) {
            //LOG.error(String.format("[HttpClientsUtils Get] get response error, url:%s", uri), e);
            System.out.println(String.format("[HttpClientsUtils Get] get response error, url:%s", uri) +  e);
            return responseString;
        } finally {
            closeResponseEntity(httpResponse);
        }
        return responseString;
    }

    /**
     * get请求获取数据
     * uri:请求地址
     * queryParameters:参数
     *
     * @param uri
     * @param queryParameters
     * @return
     * @throws Exception
     */
    public static CloseableHttpResponse get(String uri, Map<String, Object> queryParameters) throws Exception {
        HttpGet httpGet = new HttpGet();
        try {
            CloseableHttpResponse response = get(httpGet, uri, null, queryParameters);
            return response;
        } finally {
            httpGet.releaseConnection();
        }
    }

    /**
     * get请求获取数据
     * uri:请求地址
     * queryParameters:参数
     *
     * @param uri
     * @param queryParameters
     * @return
     * @throws Exception
     */
    public static CloseableHttpResponse get(HttpGet httpGet, String uri, Map<String, String> headers, Map<String, Object> queryParameters) throws Exception {
        try {
            StringBuffer buf = new StringBuffer();
            buf.append(uri);
            // 设置头部
            boolean hasHeader = null != headers && !headers.isEmpty();
            if (hasHeader) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            boolean hasParameter = null != queryParameters && !queryParameters.isEmpty();
            if (hasParameter) {
                int i = 0;
                for (Entry<String, Object> entry : queryParameters.entrySet()) {
                    if (i == 0 && !uri.contains("?")) {
                        buf.append("?");
                    } else {
                        buf.append("&");
                    }
                    i++;
                    String value = "";
                    Object obj = entry.getValue();
                    if (!(obj instanceof String)) {
                        value = SimpleJsonUtil.getJsonFromObjNoFormat(obj);
                    } else {
                        value = obj.toString();
                    }
                    buf.append(entry.getKey()).append('=').append(URLEncoder.encode(value, "UTF-8"));
                }
            }
            httpGet.setURI(new URI(buf.toString()));
//            System.out.println(buf.toString());
            CloseableHttpResponse response = getHttpClient().execute(httpGet);
            return response;
        } catch (ClientProtocolException e) {
            //LOG.error(String.format("[HttpClientsUtils Get] get response error, url:%s", uri), e);
            System.out.println(String.format("[HttpClientsUtils Get] get response error, url:%s", uri) + e);
        } catch (IOException e) {
            //LOG.error(String.format("[HttpClientsUtils Get] get response error, url:%s", uri), e);
            System.out.println(String.format("[HttpClientsUtils Get] get response error, url:%s", uri) + e);
        }
        return null;
    }

    /**
     * Post请求获取数据
     * uri:请求地址
     * queryParameters:参数static {
     * JO404.put("code", 404);
     * JO404.put("message", "404 error");
     * }
     *
     * @param uri
     * @param queryParameters
     * @return
     * @throws Exception
     */
    public static CloseableHttpResponse post(HttpPost httpPost, String uri, Map<String, Object> queryParameters) throws Exception {
        return post(httpPost, uri, null, queryParameters);
    }

    public static CloseableHttpResponse post(String uri, Map<String, Object> queryParameters) throws Exception {
        HttpPost httpPost = new HttpPost(uri);
        try {
            CloseableHttpResponse response = post(httpPost, uri, null, queryParameters);
            return response;
        } finally {
            httpPost.releaseConnection();
        }
    }

    /**
     * Post请求获取数据
     * uri:请求地址
     * queryParameters:参数static {
     * JO404.put("code", 404);
     * JO404.put("message", "404 error");
     * }
     *
     * @param uri
     * @param queryParameters
     * @return
     * @throws Exception
     */
    public static CloseableHttpResponse post(HttpPost httpPost, String uri, Map<String, String> headers, Map<String, Object> queryParameters) throws Exception {
        return post(httpPost, uri, headers, queryParameters, false);
    }

    /**
     * Post请求获取数据
     * uri:请求地址
     * queryParameters:参数static {
     * JO404.put("code", 404);
     * JO404.put("message", "404 error");
     * }
     *
     * @param uri
     * @param queryParameters
     * @return
     * @throws Exception
     */
    public static CloseableHttpResponse post(HttpPost httpPost, String uri, Map<String, String> headers, Map<String, Object> queryParameters, boolean isJson) throws Exception {
        try {
            // 设置头部
            boolean hasHeader = null != headers && !headers.isEmpty();
            if (hasHeader) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 设置参数
            boolean hasParameter = null != queryParameters && !queryParameters.isEmpty();
            if (hasParameter) {
                if(headers.get("Content-Type") != null && headers.get("Content-Type").toString().contains("application/json")){
                    isJson = true;
                }
                if (isJson) {
                    String json = SimpleJsonUtil.getJsonFromObjNoFormat(queryParameters);
                    StringEntity entity = new StringEntity(json, Consts.UTF_8);
                    entity.setContentType(headers.get("Content-Type"));
                    entity.setContentEncoding("UTF-8");
                    httpPost.setEntity(entity);
//                    System.out.println(json);
                } else {
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    for (Entry<String, Object> entry : queryParameters.entrySet()) {
                        String value;
                        Object obj = entry.getValue();
                        if (!(obj instanceof String)) {
                            value = SimpleJsonUtil.getJsonFromObjNoFormat(obj);
                        } else {
                            value = obj.toString();
                        }
                        params.add(new BasicNameValuePair(entry.getKey(), value));
//                        System.out.println(entry.getKey() + " --" + value);
                    }
                    httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
                }
            }
//            System.out.println(httpPost.toString());
//            System.out.println(isJson + httpPost.getEntity().toString());
            CloseableHttpResponse response = getHttpClient().execute(httpPost);
            return response;
        } catch (Exception e) {
            //LOG.error(String.format("[HttpClientsUtils Get] get response error, url:%s,params:%s", uri, SimpleJsonUtil.getJsonFromObj(queryParameters)), e);
        }
        return null;
    }

    /**
     * 以json形式发送数据
     */
    public static String postWithJson(String uri, Map<String, String> headers, String json) throws Exception {
        return postWithContent(uri, headers, json, "application/json");
    }

    /**
     * Post请求获取数据
     * uri:请求地址
     * queryParameters:参数static {
     * JO404.put("code", 404);
     * JO404.put("message", "404 error");
     * }
     *
     * @param uri
     * @return
     * @throws Exception
     */
    public static String postWithContent(String uri, Map<String, String> headers, String content, String contType) throws Exception {
        HttpPost httpPost = new HttpPost(uri);
        String responseString = null;
        try {
            // 设置头部
            boolean hasHeader = null != headers && !headers.isEmpty();
            if (hasHeader) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            StringEntity entity = new StringEntity(content, Consts.UTF_8);
            httpPost.setEntity(entity);
            CloseableHttpResponse response = getHttpClient().execute(httpPost);
            responseString = extractStr(uri, response);
            return responseString;
        } catch (Exception e) {
            //LOG.error(String.format("[HttpClientsUtils Post] get response error, url:%s,params:%s", uri, content), e);
        } finally {
            httpPost.releaseConnection();
        }
        return null;
    }

    public static void release() {
        if (connManager != null) {
            connManager.shutdown();
        }
    }


    public static void closeResponseEntity(HttpResponse response) {
        if (response == null) {
            return;
        }
        EntityUtils.consumeQuietly(response.getEntity());
    }

    public static String postFile(String url, Map<String, String> headers, String filekey, String filename, byte[] data) throws Exception {
        String responseString = null;
        HttpPost post = new HttpPost(url);
        try {
            // 设置头部
            boolean hasHeader = null != headers && !headers.isEmpty();
            if (hasHeader) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("file", data, ContentType.APPLICATION_OCTET_STREAM, filename);
            builder.addTextBody("name", filekey);
            builder.addTextBody("filename", filename);
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            CloseableHttpResponse httpResponse = getHttpClient().execute(post);
            if (httpResponse != null) {
                HttpEntity responseEntity = httpResponse.getEntity();
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                try {
                    if (statusCode == HttpStatus.SC_OK) {
                        responseString = EntityUtils.toString(responseEntity, ENCODE);
                    } else {
                        //LOG.error(String.format("request url: %s return error code: %s", url, statusCode));
                    }
                } finally {
                    if (responseEntity != null) {
                        responseEntity.getContent().close();
                    }
                    closeResponseEntity(httpResponse);
                }
            }
        } catch (Exception e) {
            //LOG.error(String.format("[HttpClientsUtils upload file] get response error, url:%s", url), e);
        } finally {
            post.releaseConnection();
        }
        return responseString;
    }

    public static String postFile(String url, Map<String, String> headers, String filename, byte[] data) throws Exception {
        String responseString = null;
        HttpPost post = new HttpPost(url);
        try {
            // 设置头部
            boolean hasHeader = null != headers && !headers.isEmpty();
            if (hasHeader) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("media", data, ContentType.MULTIPART_FORM_DATA, filename);
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            CloseableHttpResponse httpResponse = getHttpClient().execute(post);
            if (httpResponse != null) {
                HttpEntity responseEntity = httpResponse.getEntity();
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                try {
                    if (statusCode >= 200 && statusCode <= 300) {
                        responseString = EntityUtils.toString(responseEntity, ENCODE);
                    } else {
                        //LOG.error(String.format("request url: %s return error code: %s", url, statusCode));
                    }
                } finally {
                    if (responseEntity != null) {
                        responseEntity.getContent().close();
                    }
                    closeResponseEntity(httpResponse);
                }
            }
        } finally {
            post.releaseConnection();
        }
        return responseString;
    }

}
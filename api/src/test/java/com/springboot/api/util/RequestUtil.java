package com.springboot.api.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class RequestUtil {
    /**
     * 请求URL
     */
    private static String urlPrefix = "http://127.0.0.1:9090/";

    /**
     * post 请求 body
     * 
     * @param urlSuffix
     * @param jsonStr
     * @return
     */
    public static String httpPostBody(String urlSuffix, String jsonStr) {
        String body = "";
        try {
            // Configure and open a connection to the site you will send the
            URL url = new URL(urlPrefix + urlSuffix);
            URLConnection urlConnection = url.openConnection();
            // 设置doOutput属性为true表示将使用此urlConnection写入数据
            urlConnection.setDoOutput(true);
            // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
            urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 得到请求的输出流对象
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            // 把数据写入请求的Body
            out.write(jsonStr);
            out.flush();
            out.close();
            // 从服务器读取响应
            InputStream inputStream = urlConnection.getInputStream();
            String encoding = urlConnection.getContentEncoding();
            body = IOUtils.toString(inputStream, encoding);
            System.out.println(body);
        } catch (IOException e) {
            // Logger.getLogger(RequestTest.class.getName()).log(Level.SEVERE,
            // null, e);
        }
        return body;
    }

    /**
     * post 请求 body
     * 
     * @param urlSuffix
     * @param jsonStr
     * @return
     */
    public static String httpPostJsonBody(String urlSuffix, String jsonStr) {
        System.out.println(urlPrefix + urlSuffix);
        String body = "";
        try {
            // Configure and open a connection to the site you will send the
            URL url = new URL(urlPrefix + urlSuffix);
            URLConnection urlConnection = url.openConnection();
            // 设置doOutput属性为true表示将使用此urlConnection写入数据
            urlConnection.setDoOutput(true);
            // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
            // "content-type=application/json","content-type=application/xml"
            urlConnection.setRequestProperty("content-type", "application/json");
            // 得到请求的输出流对象
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            // 把数据写入请求的Body
            out.write(jsonStr);
            out.flush();
            out.close();
            // 从服务器读取响应
            InputStream inputStream = urlConnection.getInputStream();
            String encoding = urlConnection.getContentEncoding();
            body = IOUtils.toString(inputStream, encoding);
            System.out.println(body);
        } catch (IOException e) {
            // Logger.getLogger(RequestTest.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();
        }
        return body;
    }

    public static void main(String[] args) {
        JsonObject json = new JsonObject();
        Gson gson = new Gson();
    }
}

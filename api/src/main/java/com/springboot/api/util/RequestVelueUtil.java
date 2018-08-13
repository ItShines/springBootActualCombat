package com.springboot.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Future
 */
public class RequestVelueUtil {

    private static Logger logger = LoggerFactory.getLogger(RequestVelueUtil.class);

    public static String parseRequestValue(HttpServletRequest request) {
        if (request != null) {
            ServletInputStream is = null;
            InputStreamReader isr = null;
            try {
                is = request.getInputStream();
                StringBuffer buffer = new StringBuffer();
                isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String s = "";
                while ((s = br.readLine()) != null) {
                    buffer.append(s);
                }
                String str = buffer.toString();
                logger.info("requestStr : " + str);
                return str;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (isr != null) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

}

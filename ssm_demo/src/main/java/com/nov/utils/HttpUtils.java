package com.nov.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	
	
	public String sendPost(Map<String,String> params,String uri) throws FileNotFoundException {
		
		HttpClient client = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
		MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
		FileInputStream stream = new FileInputStream("");
		File file = new File("");
		builder.addBinaryBody("file", stream);
		ContentBody contentBody = new FileBody(file);
		builder.addPart("fil1", contentBody);
		builder.addTextBody("param", "test");
		
		//HttpEntityEnclosingRequestBase抽象类中包含了Entity
		HttpPost request = new HttpPost(uri);
		request.setConfig(requestConfig);
		request.setEntity(builder.build());
		// Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    org.apache.http.HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
		String responseBody = null;
		try {
			responseBody = client.execute(request,responseHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(responseBody);
		return responseBody;
	}
}

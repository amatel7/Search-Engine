package com.se.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTTP utility for HTTP request
 * @author amantelkar
 *
 */
public class SEHttp {
	static final Logger LOG = LoggerFactory.getLogger(SEHttp.class);

	public static String post(String url, String data) throws ClientProtocolException, IOException {
		String response = null;
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(url);

			StringEntity requestEntity = new StringEntity(data, ContentType.APPLICATION_JSON);

			httpPost.setEntity(requestEntity);

			try (CloseableHttpResponse resp = client.execute(httpPost);
					BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()))) {
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				response = result.toString();
			}
		}
		return response;
	}

}

package com.ququ.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.gson.Gson;

public class HttpUtil {

	private static Gson GSON = new Gson();

	public static String httpPost(String urlStr, List<String> param, String value) {
		return httpRequest(urlStr, "POST", param, value);
	}

	public static String httpPost(String urlStr, String value) {
		return httpRequest(urlStr, "POST", null, value);
	}

	public static String httpGet(String urlStr, List<String> param) {
		return httpRequest(urlStr, "GET", param, null);
	}

	public static String httpGet(String urlStr) {
		return httpRequest(urlStr, "GET", null, null);
	}

	public static <T> T httpPost(String urlStr, List<String> param, String value, Class<T> T) {
		String response = httpRequest(urlStr, "POST", param, value);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpPost(String urlStr, String value, Class<T> T) {
		String response = httpRequest(urlStr, "POST", null, value);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpGet(String urlStr, List<String> param, Class<T> T) {
		String response = httpRequest(urlStr, "GET", param, null);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpGet(String urlStr, Class<T> T) {
		String response = httpRequest(urlStr, "GET", null, null);
		T obj = GSON.fromJson(response, T);
		return obj;
	}
	
	public static String httpsPost(String urlStr, List<String> param, String value) {
		return httpsRequest(urlStr, "POST", param, value);
	}

	public static String httpsPost(String urlStr, String value) {
		return httpsRequest(urlStr, "POST", null, value);
	}

	public static String httpsGet(String urlStr, List<String> param) {
		return httpsRequest(urlStr, "GET", param, null);
	}

	public static String httpsGet(String urlStr) {
		return httpsRequest(urlStr, "GET", null, null);
	}

	public static <T> T httpsPost(String urlStr, List<String> param, String value, Class<T> T) {
		String response = httpsRequest(urlStr, "POST", param, value);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpsPost(String urlStr, String value, Class<T> T) {
		String response = httpsRequest(urlStr, "POST", null, value);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpsGet(String urlStr, List<String> param, Class<T> T) {
		String response = httpsRequest(urlStr, "GET", param, null);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static <T> T httpsGet(String urlStr, Class<T> T) {
		String response = httpsRequest(urlStr, "GET", null, null);
		T obj = GSON.fromJson(response, T);
		return obj;
	}

	public static String httpRequest(String requestUrl, String method, List<String> param, String outputVal) {
		StringBuffer buffer = new StringBuffer();
		if (param != null && !param.isEmpty()) {
			requestUrl = String.format(requestUrl, param.toArray());
		}

		try {
			URL url = new URL(requestUrl);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod(method);
			http.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");

			http.connect();
			if (outputVal != null) {
				OutputStream os = http.getOutputStream();
				os.write(outputVal.getBytes());
				System.out.println(outputVal);
				os.flush();
				os.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = http.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			http.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static String httpsRequest(String requestUrl, String requestMethod, List<String> param, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		if (param != null && !param.isEmpty()) {
			requestUrl = String.format(requestUrl, param.toArray());
		}
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new JEEWeiXinX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr && !outputStr.trim().isEmpty()) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}
}

class JEEWeiXinX509TrustManager implements X509TrustManager {
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}

package team.serverdata;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {

	
	// GET
	public String sendGet(String url) throws Exception {

		URL locUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) locUrl.openConnection();

		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("GET URL = " + url);
		System.out.println("Response Code = " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"), 8);
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);

		}
		in.close();

		return response.toString();
	}

	// SEND
	public String sendPost(String url, String params) throws Exception {
		URL locUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) locUrl.openConnection();

		conn.setRequestMethod("POST");

		// Post 리퀘스트 보냄.
		conn.setDoOutput(true);

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(params);
		wr.flush();
		wr.close();

		int responseCode = conn.getResponseCode();
		System.out.println("POST URL = " + url);
		System.out.println("POST params =" + params);
		System.out.println("Response Code = " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"), 8);
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);

		}
		in.close();

		return response.toString();
	}

}

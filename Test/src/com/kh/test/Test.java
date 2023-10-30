package com.kh.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class Test {

	public static final String serviceKey = "YKvNpUi%2Bs0sYRHySI9BuHoUUPEngVn1F4zpNMbNIB0T7HGJT815M9I%2B%2F21m0nEAjfcUJvEtQCUanth07KSUMkQ%3D%3D";
	
	
	public static void main(String[] args) throws IOException {
	
	
	String url = "https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
	
	url += "?serviceKey=" + serviceKey;
	url += "&numOfRows=5"; 
	url += "&_type=json";
	URL requestUrl = new URL(url);	
	HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
	
	urlConnection.setRequestMethod("GET");
	
	BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	String line = null;
	
	StringBuffer responseBuffer = new StringBuffer();
	while((line = br.readLine())!=null) {

		responseBuffer.append(line);
		
	}
	br.close();
	urlConnection.disconnect();
	

	}
	
	
	
	}
	
	
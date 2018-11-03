package FinalLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {
	private String url;
	private View view;
	private double longitude;
	private double latitude;
	private String country;
	private String apiKey;
	private JSONObject jsonObject;
	private boolean isSuccess;
	
	public boolean isSuccess() {
		return isSuccess;
	}

	public Request() {
		super();
	}
	
	public Request(String url, View view, String country) {
		super();
		this.url = url;
		this.view = view;
		this.country = country;
	}
	
	public Request(String url, View view, double latitude, double longitude) {
		super();
		this.url = url;
		this.view = view;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public View getView() {
		return view;
	}
	public void setView(View view) {
		this.view = view;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}	
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	
	public void getHttpResponse()
	{
		Loading loadPopup = new Loading();
		loadPopup.frame.setVisible(true);
		InputStream is = null;
		
		DefaultHttpClient client = new DefaultHttpClient();
		List<NameValuePair> parameter = new ArrayList<NameValuePair>();
		parameter.add(new BasicNameValuePair("appid",this.apiKey));
		parameter.add(new BasicNameValuePair("lat",String.valueOf(this.latitude)));
		parameter.add(new BasicNameValuePair("lon",String.valueOf(this.longitude)));
		
		String paramString = URLEncodedUtils.format(parameter,"utf-8");
		url += "?" + paramString;
		System.out.println(url);
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse;
		try {
			httpResponse = client.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is),8);
			
			StringBuilder sb = new StringBuilder();
			
			String line="";
			
			while ((line = reader.readLine())!= null)
			{
				sb.append(line+"\n");
				
			}
			is.close();
			
			//System.out.println(sb.toString());
			jsonObject = new JSONObject(sb.toString());
			if(jsonObject.getInt("cod") == 401)
			{
				this.isSuccess = false;
			}
			else
			{
				this.isSuccess = true;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			this.isSuccess = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.isSuccess = false;
			e.printStackTrace();
		}
		loadPopup.frame.setVisible(false);
		loadPopup.frame.dispose();
		
	}

	

	
		
}
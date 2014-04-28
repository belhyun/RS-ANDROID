package team.serverdata;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONsfromServer {

	private static JSONObject jObj;
	private static JSONArray jArray;
	private final String DEFAULT_URL = "http://14.63.198.222:3000";
	private final String REGION = "/api/v1/regions/list/";
	private final String LINE = "/api/v1/regions/routes/";

	public static class SubWayRegion {
		public static String[] mRegionName;
	}

	public static class SubWayLine {
		// <지역, 노선>
		public static HashMap<String, String[]> mLine;

	}

	public JSONsfromServer() {

		getRegions(DEFAULT_URL+ REGION);
		getLines(DEFAULT_URL + LINE);

	}

	void getRegions(String url) {
		HttpConnector con = new HttpConnector();
		String result = null;
		try {
			result = con.sendGet(url);
			jObj = new JSONObject(result);
			jArray = jObj.getJSONArray("body");
			int jArrayLen = jArray.length();

			SubWayRegion.mRegionName = new String[jArrayLen];

			for (int i = 0; i < jArrayLen; i++) {
				SubWayRegion.mRegionName[i] = jArray.getJSONObject(i)
						.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();

			// final HandlerThread handlerThread = new
			// HandlerThread("HandlerName");
			// handlerThread.start();
			// Handler handler = new Handler( handlerThread.getLooper() );
			//
			// handler.post(new Runnable() {
			//
			// @Override
			// public void run() {
			// Toast.makeText(context, "?", Toast.LENGTH_SHORT).show();
			// }
			// });
			// handler.postDelayed(new Runnable() {
			//
			// @Override
			// public void run() {
			// handlerThread.quit();
			//
			// }
			// }, 1000);
			//
			//
			
			// 핸들러 스레드는 건드는게 아니라고.. 생각해서..;;
		}
	}

	void getLines(String url) {
		HttpConnector con = new HttpConnector();
		String result = null;
		SubWayLine.mLine = new HashMap<String, String[]>();
		try {
			result = con.sendGet(url);
			jObj = new JSONObject(result);

			int bodyLen = jObj.getJSONArray("body").length();

			for (int i = 0; i < bodyLen; i++) {
				int routeLen = jObj.getJSONArray("body").getJSONObject(i)
						.getJSONArray("routes").length();
				String[] str = new String[routeLen];

				for (int j = 0; j < routeLen; j++) {

					str[j] = jObj.getJSONArray("body").getJSONObject(i)
							.getJSONArray("routes").getJSONObject(j)
							.getString("name");

				}
				SubWayLine.mLine.put(jObj.getJSONArray("body").getJSONObject(i)
						.getString("name"), str);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

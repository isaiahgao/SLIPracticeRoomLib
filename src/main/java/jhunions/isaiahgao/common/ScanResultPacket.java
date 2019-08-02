package jhunions.isaiahgao.common;

import com.fasterxml.jackson.databind.JsonNode;

import io.javalin.Context;

public class ScanResultPacket {
	
	public static final ScanResultPacket ERROR = new ScanResultPacket(ScanResult.ERROR, null);
	
	public ScanResultPacket(ScanResult result, String data) {
		this.result = result;
		this.data = data;
	}
	
	public ScanResultPacket(String json) {
		JsonNode body;
		try {
			body = JsonUtils.getJson().readTree(json);
			this.result = ScanResult.valueOf(body.get("scanresult").asText());
			this.data = body.get("data").asText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ScanResult result;
	private String data;
	
	public ScanResult getResult() {
		return this.result;
	}
	
	public String getData() {
		return this.data;
	}
	
	@Override
	public String toString() {
		return "{" + this.result.toJson() + ",\"data\":\"" + (this.getData() == null ? "" : this.getData()) + "\"}";
	}
	
	public enum ScanResult {
		NO_SUCH_USER,
		CHECKED_OUT,
		CHECKED_IN,
		ERROR;
		
		private ScanResult() {
			this.json = "\"scanresult\":\"" + this.toString() + "\"";
		}
		
		private String json;
		
		public static ScanResult fromJson(String json) {
			JsonNode body;
			try {
				body = JsonUtils.getJson().readTree(json);
				return ScanResult.valueOf(body.get("scanresult").asText());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ScanResult.ERROR;
		}
		
		public static ScanResult fromJson(Context ctx) {
			if (ctx.status() != 200) {
				return ScanResult.ERROR;
			}
			
			return fromJson(ctx.body());
		}
		
		public String toJson() {
			return this.json;
		}
	}

}

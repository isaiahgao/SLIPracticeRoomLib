package jhunions.isaiahgao.common;

import com.fasterxml.jackson.databind.JsonNode;

public class IDFormat {
	public IDFormat(int length, int ignorefirst) {
		this.length = length;
		this.ignorefirst = ignorefirst;
	}
	
	public IDFormat(JsonNode node) {
		this.length = node.get("length").asInt();
		this.ignorefirst = node.get("ignore-first").asInt();
	}
	
	private int length;
	private int ignorefirst;
	
	public int getEffectiveLength() {
		return this.length - this.ignorefirst;
	}
	
	public int getTotalLength() {
		return this.length;
	}
	
	public int getIgnoreFirst() {
		return this.ignorefirst;
	}
	
	@Override
	public String toString() {
		return "{\"length\":" + length + ",\"ignore-first\":" + ignorefirst + "}";
	}
}
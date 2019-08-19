package jhunions.isaiahgao.common;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class User {
	
    public User(String hopkinsID, FullName name, String jhed, long phone) {
        this.hopkinsID = hopkinsID;
        this.name = name;
        this.jhed = jhed;
        this.phone = phone;
    }
    
    public User(JsonNode body) {
        this.hopkinsID = body.get("id").asText();
        this.jhed = body.get("jhed").asText();
        this.name = new FullName(body.get("name").asText());
        this.phone = body.get("phone").asLong();
    }
    
    public User(String json) {
        JsonNode body;
        try {
            body = JsonUtils.getJson().readTree(json);
        } catch (IOException e) {
        	return;
        }
        
        this.hopkinsID = body.get("id").asText();
        this.jhed = body.get("jhed").asText();
        this.name = new FullName(body.get("name").asText());
        this.phone = body.get("phone").asLong();
    }
    
    private String hopkinsID;
    private String jhed;
    private FullName name;
    private long phone;
    
    public String checkForErrors() {
    	try {
    		if (!Character.isAlphabetic(this.jhed.charAt(0)))
    			return "Invalid JHED.";
    		
    		if (!Character.isDigit(this.jhed.charAt(this.jhed.length() - 1)))
    			return "Invalid JHED.";
    		
    		if ((this.phone + "").length() != 10)
    			return "Invalid phone number.";
    		
    		String ps = this.phone + "";
    		if (ps.substring(0, 3).equals(ps.substring(3, 6)) && ps.subSequence(0, 3).equals(ps.substring(6, 9)))
    			return "Invalid phone number.";
    	} catch (Exception e) {
    		return "Invalid info.";
    	}
    	return null;
    }
    
    public String getHopkinsID() {
        return hopkinsID;
    }

    public String getJhed() {
        return jhed;
    }

    public FullName getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }
    
    @Override
    public int hashCode() {
    	return this.hopkinsID.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
    	if (!(o instanceof User))
    		return false;
    	
    	User ou = (User) o;
    	return ou.hopkinsID.equals(this.hopkinsID);
    }
    
    @Override
    public String toString() {
    	return "{"
    			+ "\"id\":\"" + this.hopkinsID + "\","
    			+ "\"jhed\":\"" + this.jhed + "\","
    			+ "\"name\":\"" + this.name.toSaveableString() + "\","
    			+ "\"phone\":\"" + this.phone + "\""
    			+ "}";
    }
    
}

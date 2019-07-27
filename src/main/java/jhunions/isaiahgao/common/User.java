package jhunions.isaiahgao.common;

public class User {
	
    public User(String hopkinsID, FullName name, String jhed, long phone) {
        this.hopkinsID = hopkinsID;
        this.name = name;
        this.jhed = jhed;
        this.phone = phone;
    }
    
    public User(String saveable) {
    	String[] arr = saveable.split("\t");
    	this.hopkinsID = arr[0];
    	this.jhed = arr[1];
    	this.name = new FullName(arr[2]);
    	this.phone = Long.parseLong(arr[3]);
    }

    private String hopkinsID;
    private String jhed;
    private FullName name;
    private long phone;
    
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
    	return this.hopkinsID + "\t" + this.jhed + "\t" + this.name.toSaveableString() + "\t" + this.phone;
    }
    
}

package jhunions.isaiahgao.common;

/**
 * Represents a person's full name.
 */
public class FullName {
	
	public FullName(String saveable) {
		String[] arr = saveable.split("§");
		this.first = arr[0];
		this.last = arr[1];
	}

    public FullName(String first, String last) {
        this.first = first;
        this.last = last;
    }

    private String first;
    private String last;

    public String getFirstName() {
        return this.first;
    }

    public String getLastName() {
        return this.last;
    }
    
    public String toSaveableString() {
    	return this.first + "§" + this.last;
    }
    
    @Override
    public String toString() {
        return this.first + " " + this.last;
    }

}

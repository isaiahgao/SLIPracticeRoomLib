package jhunions.isaiahgao.common;

/**
 * Represents a person's full name.
 */
public class FullName {
	
	public FullName(String saveable) {
		System.out.println(saveable);
		String[] arr = saveable.split("§");
		if (arr.length == 1)
			arr = saveable.split("_");
		this.first = arr[0];
		this.last = arr[1];
		this.validateName();
	}

    public FullName(String first, String last) {
        this.first = first;
        this.last = last;
		this.validateName();
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
    	return this.first + "_" + this.last;
    }
    
    @Override
    public String toString() {
        return this.first + " " + this.last;
    }
    
    private void validateName() {
    	this.first = this.first.replaceAll("[^a-zA-Z0-9 -]", "");
    	this.last = this.last.replaceAll("[^a-zA-Z0-9 -]", "");
    }

}

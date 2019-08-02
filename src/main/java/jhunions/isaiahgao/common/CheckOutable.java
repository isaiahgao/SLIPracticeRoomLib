package jhunions.isaiahgao.common;

import org.jetbrains.annotations.Nullable;

public class CheckOutable {

	public CheckOutable(String id) {
		this.id = id;
	}
	
	protected String id;
	protected User occupant;
	protected long checkedOut;
	protected long checkedIn;
	
	public void setTimeCheckedOut(long time) {
		this.checkedOut = time;
	}
	
	public void setTimeCheckedIn(long time) {
		this.checkedIn = time;
	}
	
	public long getTimeCheckedOut() {
		return this.checkedOut;
	}
	
	public long getTimeCheckedIn() {
		return this.checkedIn;
	}
	
	public boolean isOccupied() {
		return this.occupant != null;
	}
	
	public String getId() {
		return this.id;
	}
	
	public @Nullable User getOccupant() {
		return this.occupant;
	}
	
	public void writeToLog() {
		// TODO
	}
	
	/**
	 * Auto updates check in and out times.
	 */
	public CheckOutable setOccupant(@Nullable User user) {
		if (this.occupant == null) {
			this.checkedOut = System.currentTimeMillis();
		}
		this.occupant = user;
		
		if (user == null) {
			this.checkedIn = System.currentTimeMillis();
		}
		return this;
	}

}

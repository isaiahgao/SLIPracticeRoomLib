package jhunions.isaiahgao.common;

public class PracticeRoom extends CheckOutable {
	
	public PracticeRoom(int id) {
		super("" + id);
	}
	
	public PracticeRoom(String id) {
		super(id);
	}
	
	public int getMinutesUntilAvailable() {
		return (int) (this.isOccupied() ?
				Math.max(-1, 90 - (System.currentTimeMillis() - this.getTimeCheckedOut()) / 1000 / 60)
				: -1);
	}

}

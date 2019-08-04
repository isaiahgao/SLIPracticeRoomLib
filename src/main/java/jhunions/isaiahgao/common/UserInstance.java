package jhunions.isaiahgao.common;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Represents a user of the practice room.
 */
public class UserInstance {

    public UserInstance(User who, String room, int timeLimitMinutes) {
        this.who = who;
        this.room = room;
        this.timeIn = new Date();
        this.min90 = new Date(this.timeIn.getTime() + (timeLimitMinutes * 60l * 1000l));
    }

    private User who;
    private String room;
    private Date timeIn, min90;
    private int line;
    
    public int getLine() {
        return this.line;
    }
    
    public void setLine(int line) {
        this.line = line;
    }
    
    public User getUser() {
        return this.who;
    }
    
    public String getRoom() {
        return this.room;
    }
    
    public Date getTimeIn() {
        return this.timeIn;
    }
    
    public String getTimeRemaining() {
        Date date = new Date();
        long diff = this.min90.getTime() - date.getTime();
        
        if (diff < 0) {
            return "<strong>TIME EXPIRED</strong>";
        }
        
        String s = "<strong>Time remaining:</strong> ";
        long mins = diff / 60000;
        if (mins < 1) {
            return s + "Less than a minute";
        }
        
        return s + mins + " minutes";
    }
    
    public String getSheetName() {
        return Utils.capitalizeFirst(Month.of(this.timeIn.getMonth() + 1).toString()) + " " + Calendar.getInstance().get(Calendar.YEAR);
    }

    public List<Object> toObjectList() {
        Date date = new Date();
        String ds = (date.getMonth() + 1) + "/" + date.getDate() + "/" + (date.getYear() + 1900);
        String time = Utils.getTime(date);
        
        List<Object> list = new ArrayList<>();
        list.add(ds + " " + time.substring(0, time.length() - 3));
        list.add(this.who.getName().getFirstName() + " " + this.who.getName().getLastName());
        list.add(this.who.getJhed() + "@jhu.edu");
        list.add(this.who.getPhone());
        list.add("Room " + this.room);
        list.add(time);
        list.add("I agree");
        return list;
    }
}

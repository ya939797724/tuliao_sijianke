package baseview.timer;

public class TimerEntity {
    private String timeyear;
    private String timehours;
    private int imgflag;
    private String activityname;
    private String peoplenum;
    private String timeslot;
    private String loc;

    public TimerEntity(String timeyear, String timehours, int imgflag, String activityname, String peoplenum, String timeslot, String loc) {
        this.timeyear = timeyear;
        this.timehours = timehours;
        this.imgflag = imgflag;
        this.activityname = activityname;
        this.peoplenum = peoplenum;
        this.timeslot = timeslot;
        this.loc = loc;
    }

    public String getTimeyear() {
        return timeyear;
    }

    public void setTimeyear(String timeyear) {
        this.timeyear = timeyear;
    }

    public String getTimehours() {
        return timehours;
    }

    public void setTimehours(String timehours) {
        this.timehours = timehours;
    }

    public int getImgflag() {
        return imgflag;
    }

    public void setImgflag(int imgflag) {
        this.imgflag = imgflag;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "TimerEntity{" +
                "timeyear='" + timeyear + '\'' +
                ", timehours='" + timehours + '\'' +
                ", imgflag=" + imgflag +
                ", activityname='" + activityname + '\'' +
                ", peoplenum='" + peoplenum + '\'' +
                ", timeslot='" + timeslot + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

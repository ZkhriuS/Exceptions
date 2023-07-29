package model;

public class Date {
    private int day;
    private int month;
    private int year;

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(day<10)
            sb.append("0");
        sb.append(day).append(".");
        if(month<10)
            sb.append("0");
        sb.append(month).append(".");
        sb.append(year);
        return sb.toString();
    }
}

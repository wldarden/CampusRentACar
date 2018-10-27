package CampusRentACar.model;

public class CarModel {
	private String car_id;
	private String car_name;
	private int capacity;
	private Float weekday_rate;
	private Float weekend_rate;
	private Float week_rate;
	private Float gps;
	private Float on_star;
	private Float sirius_xm;

	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id =car_id;
	}

	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Float getWeekday_rate() {
		return weekday_rate;
	}
	public void setWeekday_rate(Float weekday_rate) {
		this.weekday_rate = weekday_rate;
	}

	public Float getWeekend_rate() {
		return weekend_rate;
	}
	public void setWeekend_rate(Float weekend_rate) {
		this.weekend_rate = weekend_rate;
	}

	public Float getWeek_rate() {
		return week_rate;
	}
	public void setWeek_rate(Float week_rate) {
		this.week_rate = week_rate;
	}

	public Float getGps() {
		return gps;
	}
	public void setGps(Float gps) {
		this.gps = gps;
	}

	public Float getOn_star() {
		return on_star;
	}
	public void setOn_star(Float on_star) {
		this.on_star = on_star;
	}
	public Float getSirius_xm() {
		return sirius_xm;
	}
	public void setSirius_xm(Float sirius_xm) {
		this.sirius_xm = sirius_xm;
	}
}

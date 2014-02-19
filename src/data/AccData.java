package data;

import java.util.Date;

public class AccData {
	
	
	private String cordX;
	private String cordY;
	private String cordZ;
	private Date timestamp;
	
	public String getCordX() {
		return cordX;
	}
	public void setCordX(String cordX) {
		this.cordX = cordX;
	}
	public String getCordY() {
		return cordY;
	}
	public void setCordY(String cordY) {
		this.cordY = cordY;
	}
	public String getCordZ() {
		return cordZ;
	}
	public void setCordZ(String cordZ) {
		this.cordZ = cordZ;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "AccData [cordX=" + cordX + ", cordY=" + cordY + ", cordZ="
				+ cordZ + ", timestamp=" + timestamp + "]";
	}
	

	
	
}

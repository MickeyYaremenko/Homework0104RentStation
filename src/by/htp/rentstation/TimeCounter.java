package by.htp.rentstation;

public interface TimeCounter {
	final static long HOUR_TO_MILLISECONDS = 3600000L;
	
	void setReturnTime(int hours);
}

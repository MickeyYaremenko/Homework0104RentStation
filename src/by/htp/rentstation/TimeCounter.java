package by.htp.rentstation;

import java.time.LocalDateTime;

public interface TimeCounter {
	final static long HOUR_TO_MILLISECONDS = 3600000L;

	void setReturnTime(LocalDateTime current, int hours);
}

package com.ng.tech.uie.date;

import org.joda.time.DateTime;

public class DateUtils {

	public long getCurrentTimeInMS() {
		DateTime dt = new DateTime();
		return dt.getMillis();
	}
}

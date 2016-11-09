package domain_model;

import sun.util.calendar.BaseCalendar.Date;

public class History {

	int id;
	Date data;
	double amount;
	Operation operation;
	Currency from;
	Currency to;
	double rate;
	
}

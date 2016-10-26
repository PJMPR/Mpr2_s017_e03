package s14094;

import java.math.BigDecimal;
import java.sql.Date;

public class History {
	
	int id;
	Date date;
	Operation operation;
	BigDecimal ammount;
	Person from;
	Person to;
	int rate;
}

package euler.solutions;

import java.util.GregorianCalendar;

/**
 *
 * @author Patrick Bryan
 */
public class Euler019 {
    public String solution() {
        GregorianCalendar date = new GregorianCalendar(1901,1,1);
        GregorianCalendar dateFinal = new GregorianCalendar(2000,12,31);
        int sundaysOnFirst = 0;
        
        while (dateFinal.after(date)) {
            if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY)
                sundaysOnFirst++;
            date.add(GregorianCalendar.MONTH, 1);
        }
        
        return String.valueOf(sundaysOnFirst);
    }
}

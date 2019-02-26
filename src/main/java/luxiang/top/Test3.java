package luxiang.top;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        Date recentDate = null;
        Date curDate = null;
        try {
            recentDate = format.parse("2019-01-18");
            curDate = format.parse("2019-01-18");
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.err.println("sssssssss");
    }
}

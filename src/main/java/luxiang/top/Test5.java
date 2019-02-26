package luxiang.top;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Test5 {
    public static void main(String[] args) {
        Calendar car = Calendar.getInstance();
        car.setTimeInMillis(car.getTimeInMillis()-300000);
        Date date = car.getTime();
        System.out.println(getCurrentQuarterStartTime().toLocaleString());
        System.out.println(getCurrentQuarterEndTime().toLocaleString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
        System.out.println(format.format(strToDate("季","2019（第一季度）").get("startDate")));
        System.out.println(format.format(strToDate("季","2019（第一季度）").get("endDate")));
        System.out.println(format.format(strToDate("季","2019（第二季度）").get("startDate")));
        System.out.println(format.format(strToDate("季","2019（第二季度）").get("endDate")));
        System.out.println(format.format(strToDate("季","2019（第三季度）").get("startDate")));
        System.out.println(format.format(strToDate("季","2019（第三季度）").get("endDate")));
        System.out.println(format.format(strToDate("季","2019（第四季度）").get("startDate")));
        System.out.println(format.format(strToDate("季","2019（第四季度）").get("endDate")));

        System.out.println(format.format(strToDate("月","2019（一月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（一月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（二月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（二月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（三月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（三月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（四月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（四月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（五月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（五月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（六月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（六月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（七月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（七月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（八月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（八月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（九月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（九月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（十月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（十月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（十一月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（十一月）").get("endDate")));
        System.out.println(format.format(strToDate("月","2019（十二月）").get("startDate")));
        System.out.println(format.format(strToDate("月","2019（十二月）").get("endDate")));

        System.out.println(dateToStr("季"));
        System.out.println(dateToStr("月"));
    }


    public static String dateToStr(String type){
        StringBuffer dateStr = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.YEAR);
        dateStr.append(String.valueOf(cal.get(Calendar.YEAR)));
        cal.get(Calendar.MONTH);
        if ("季".equals(type)){
            switch (cal.get(Calendar.MONTH)){
                case 0:
                case 1:
                case 2:
                    dateStr.append("（第一季度）");
                    break;
                case 3:
                case 4:
                case 5:
                    dateStr.append("（第二季度）");
                    break;
                case 6:
                case 7:
                case 8:
                    dateStr.append("（第三季度）");
                    break;
                case 9:
                case 10:
                case 11:
                    dateStr.append("（第四季度）");
                    break;
            }
            return dateStr.toString();
        }else if ("月".equals(type)){
            dateStr.append("（");
            switch (cal.get(Calendar.MONTH)){
                case 0:
                    dateStr.append("一月");
                    break;
                case 1:
                    dateStr.append("二月");
                    break;
                case 2:
                    dateStr.append("三月");
                    break;
                case 3:
                    dateStr.append("四月");
                    break;
                case 4:
                    dateStr.append("五月");
                    break;
                case 5:
                    dateStr.append("六月");
                    break;
                case 6:
                    dateStr.append("七月");
                    break;
                case 7:
                    dateStr.append("八月");
                    break;
                case 8:
                    dateStr.append("九月");
                    break;
                case 9:
                    dateStr.append("十月");
                    break;
                case 10:
                    dateStr.append("十一月");
                    break;
                case 11:
                    dateStr.append("十二月");
                    break;
            }
            dateStr.append("）");
            return dateStr.toString();
        }
        return null;
    }

    public static HashMap<String,Date> strToDate(String type, String dateStr){
        HashMap<String,Date> map = new HashMap<String,Date>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yearStr = dateStr.substring(0,4);
        String value = dateStr.substring(5,dateStr.length()-1);
        StringBuffer startStr = new StringBuffer();
        StringBuffer endStr = new StringBuffer();
        if ("季".equals(type)){
            int index = CommonEnum.Season.valueOf(value).ordinal();
            switch (index){
                case 0:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("01");
                    endStr.append("04");
                    break;
                case 1:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("04");
                    endStr.append("07");
                    break;
                case 2:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("07");
                    endStr.append("10");
                    break;
                case 3:
                    startStr.append(yearStr).append("-");
                    endStr.append(String.valueOf(Integer.valueOf(yearStr)+1)).append("-");
                    startStr.append("10");
                    endStr.append("01");
                    break;
                default:
                    return null;
            }
        }else if ("月".equals(type)){
            int index = CommonEnum.Month.valueOf(value).ordinal();
            switch (index){
                case 0:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("01");
                    endStr.append("02");
                    break;
                case 1:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("02");
                    endStr.append("03");
                    break;
                case 2:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("03");
                    endStr.append("04");
                    break;
                case 3:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("04");
                    endStr.append("05");
                    break;
                case 4:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("05");
                    endStr.append("06");
                    break;
                case 5:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("06");
                    endStr.append("07");
                    break;
                case 6:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("07");
                    endStr.append("08");
                    break;
                case 7:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("08");
                    endStr.append("09");
                    break;
                case 8:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("09");
                    endStr.append("10");
                    break;
                case 9:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("10");
                    endStr.append("11");
                    break;
                case 10:
                    startStr.append(yearStr).append("-");
                    endStr.append(yearStr).append("-");
                    startStr.append("11");
                    endStr.append("12");
                    break;
                case 11:
                    startStr.append(yearStr).append("-");
                    endStr.append(String.valueOf(Integer.valueOf(yearStr)+1)).append("-");
                    startStr.append("12");
                    endStr.append("01");
                    break;
                default:
                    break;
            }
        }
        startStr.append("-01 00:00:00");
        endStr.append("-01 00:00:00");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse(startStr.toString());
            endDate = format.parse(endStr.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return map;
    }

    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(c.getTimeInMillis()-300000);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 6);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentQuarterStartTime());
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }
}

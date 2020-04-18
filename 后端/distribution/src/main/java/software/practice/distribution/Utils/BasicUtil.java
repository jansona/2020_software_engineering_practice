package software.practice.distribution.Utils;

import java.sql.Time;

public class BasicUtil {

    public static Integer covertStrInt(String id_str){
        if(!(id_str == null || id_str.isEmpty())){
            try {
                return Integer.parseInt(id_str);
            }catch (Exception e){
                System.out.println(e);
            }
        }

        return null;
    }

    public static Time covertStrTime(String time_str){
        if(!(time_str == null || time_str.isEmpty())){
            try{
                return Time.valueOf(time_str);
            }catch (Exception e){
                System.out.println(e);
            }
        }

        return null;
    }
}

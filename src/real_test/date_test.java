package real_test;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date_test {
    public static void main(String[] args) {
        String str = "A\\B\\c";
String[] arr = str.split("\\\\");
        for(int i = 0 ; i<arr.length;i++)
        System.out.println(arr[i]);
    }
}

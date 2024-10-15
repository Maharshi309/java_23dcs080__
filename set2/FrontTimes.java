import java.util.*;
class FrontTimes{
public static void main(String[] args) { System.out.println(frontTimes("Chocolate", 2));
System.out.println(frontTimes("Chocolate", 3));
System.out.println(frontTimes("Abc", 3)); 
System.out.println("23DCS080 Maharshi Patel ");

}
public static String frontTimes(String str, int n) {
String front = str.substring(0, Math.min(3, str.length())); 
String result = "";
for (int i = 0; i < n; i++) { 
    result += front;
}
return result;
}
}

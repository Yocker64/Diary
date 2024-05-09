import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date fecha = new Date();
        String datoDeFecha = fecha.toString().substring(0,Math.min(28, 10));        
        System.out.println(datoDeFecha);
    }
}

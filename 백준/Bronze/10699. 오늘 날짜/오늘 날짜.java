import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}

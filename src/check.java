import java.text.SimpleDateFormat;
import java.util.Date;

public class check {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

		String dateReq = dateFormat.format(new Date());
		System.out.println(dateReq);
	}

}

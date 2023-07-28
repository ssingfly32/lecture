import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClassTest {

	public static void main(String[] args) {
		String currentDir = "D:\\lecture\\java";

		File dir = new File(currentDir);

		File[] list = dir.listFiles();

		for (File f : list) {
			Date lastModified = new Date(f.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
			if(!f.isFile()) {
				System.out.println(sdf.format(lastModified) + "\t" + "<DIR>" +"\t" +f.getName());
			} else {
				System.out.println(sdf.format(lastModified) + "\t" +"\t" + f.getName());

			}
		}
	}

}

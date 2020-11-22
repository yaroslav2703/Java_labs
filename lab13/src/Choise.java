package others;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;


public class Choise {
	public String  listxxx[];

	protected class Only implements FilenameFilter {
		String xxx = null;

		public Only(String xxx) {
			this.xxx = "." + xxx;
		}

		public boolean accept(File d, String name) {
			return name.endsWith(xxx);
		}
	}

	public Choise(String d, String xxx) {
		File dir = new File(d);
		if (dir.exists()) {
			listxxx = dir.list(new Only(xxx));
		}
	}
}

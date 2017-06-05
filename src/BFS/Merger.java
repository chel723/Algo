package BFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merger {
	// List<Node> nodes;
	public static void main(String[] args) {
		File[] files = new File[14];

		for (int i = 0; i < 14; i++) {
			String sourceFilePath = "/Users/chelseaw/Documents/workspace/Jackson_Json/Data/stops" + i + ".txt";
			files[i] = new File(sourceFilePath);
		}

		String mergedFilePath = "/Users/chelseaw/Desktop/merged.txt";
		File mergedFile = new File(mergedFilePath);
		mergeFiles(files, mergedFile);
	}
	public static void mergeFiles(File[] files, File mergedFile) {

		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < files.length; i++) {
			int linenum = i + 1;
			System.out.println("merging: " + files[i].getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(files[i]);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));

				String aLine;
				while ((aLine = in.readLine()) != null) {
					if (!aLine.equals(
							"top_id,stop_code,stop_name,stop_desc,stop_lat,stop_lon,location_type,parent_station")) {
						out.write(aLine);
						out.newLine();
					}

				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

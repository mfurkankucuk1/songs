import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int songCount = -1;
		List<List<String>> songList = readValues();
		List<Integer> enterSongIdList = new ArrayList<>();
		HashMap<Integer, Integer> songIdAndTimeList = new HashMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		for (int i = 1; i < songList.size(); i++) {
			songIdAndTimeList.put(Integer.parseInt(songList.get(i).get(0)), Integer.parseInt(songList.get(i).get(5)));
		}

		do {
			System.out.println("How many choice song:");
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a valid value:");
				sc.next();
			}
			songCount = sc.nextInt();
		} while (songCount < 0 || songCount > 49);

		do {
			System.out.println("Please enter the " + (enterSongIdList.size() + 1) + ". song id:");
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a valid " + (enterSongIdList.size() + 1) + ". song id:");
				sc.next();
			}
			enterSongIdList.add(sc.nextInt());
		} while (enterSongIdList.size() < songCount);

		int a = 0;
		for (int i : songIdAndTimeList.keySet()) {
			for (int k = 0; k < enterSongIdList.size(); k++) {
				if (i == enterSongIdList.get(k)) {
					a = a + (songIdAndTimeList.get(i));
				}
			}
		}
		int minute = (a / 1000 / 60);
		if (minute >= 31) {
			System.out.print("Selected " + songCount + " song over 30 minutes: " + minute + " minute");
		} else {
			System.out.print(songCount + " track new album duration: " + minute + " minute");
		}
		enterSongIdList.clear();
		songCount = 0;
		songIdAndTimeList.clear();
		songList.clear();
		sc.close();
	}

	public static List<List<String>> readValues() throws IOException {
		try {
			List<List<String>> data = new ArrayList<>();// list of lists to store data
			String file = "term_project_value_data.csv";// file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Reading until we run out of lines
			String line = br.readLine();
			while (line != null) {
				List<String> lineData = Arrays.asList(line.split(","));// splitting lines
				data.add(lineData);
				line = br.readLine();
			}

			// printing the fetched data
			for (List<String> list : data) {
				for (String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
			return data;
		} catch (Exception e) {
			System.out.print(e);
			List<List<String>> data = new ArrayList<>();// list of lists to store data
			return data;
		}

	}

	public static List<List<String>> readSequential() throws IOException {
		try {
			List<List<String>> data = new ArrayList<>();// list of lists to store data
			String file = "term_project_sequential_data.csv";// file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Reading until we run out of lines
			String line = br.readLine();
			while (line != null) {
				List<String> lineData = Arrays.asList(line.split(","));// splitting lines
				data.add(lineData);
				line = br.readLine();
			}

			// printing the fetched data
			for (List<String> list : data) {
				for (String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
			return data;
		} catch (Exception e) {
			System.out.print(e);
			List<List<String>> data = new ArrayList<>();// list of lists to store data
			return data;
		}

	}
}

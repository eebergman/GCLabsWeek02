import java.util.ArrayList;
import java.util.Scanner;

public class Lab08 {

	public static void main(String[] args) {

		System.out.println("Hello and welcome to the batting average and slugging percentage calculator.");

		Welcome();

	}

	public static void Welcome() {

		Scanner sc = new Scanner(System.in);

		int verifiedNosAtBats = 0;
		int verifiedatBatEntry = 0;
		float sumOne = 0;
		float sumTwo = 0;
		float battingAverge;
		float sluggingPercentage;
		ArrayList<Float> noZeros = new ArrayList<Float>();

		System.out.println("\nPlease enter the number of at-bats for a given player." + "\n(Valid entries (1 - 100)");
		String nosOfBats = sc.nextLine();

		verifiedNosAtBats = VerifyNumber(nosOfBats);

		float[] atBatResults = new float[verifiedNosAtBats];

		for (int i = 0; i < atBatResults.length; i++) {
			int noOfEntries = i + 1;
			System.out.println("\nPlease enter the number of bases taken on at-bat number " + noOfEntries + "."
					+ "\n(Valid entries 0 - 4)");
			String atBatEntry = sc.nextLine();

			try {
				verifiedatBatEntry = Integer.parseInt(atBatEntry);
			} catch (NumberFormatException e) {
				System.out.println("Invalid keystroke. \nRelaunching generator.\n");

				Welcome();
			}

			float convertedAtBatEntry = (float) verifiedatBatEntry;

			if (convertedAtBatEntry < 0 || convertedAtBatEntry > 4) {
				System.out.println("Invalid keystroke. \nRelaunching generator.\n");

				Welcome();
			} else {
				atBatResults[i] = convertedAtBatEntry;
			}
		}

		for (int i = 0; i < atBatResults.length; i++) {
			if (atBatResults[i] > 0) {
				noZeros.add(i + 1.0F);
			}
		}

		for (int i = 0; i < noZeros.size(); i++) {
			sumOne += noZeros.get(i);
		}

		for (int i = 0; i < atBatResults.length; i++) {
			sumTwo += atBatResults[i];
		}

		battingAverge = sumOne / atBatResults.length;
		sluggingPercentage = sumTwo / atBatResults.length;

		System.out.println("Your batter's batting average is " + battingAverge + " and their slugging percentage is "
				+ sluggingPercentage + ".");

		System.out.println("Would you like to calculate for another batter?");
		String goAgain = sc.next();

		if (goAgain.equalsIgnoreCase("y")) {
			Welcome();
		} else if (goAgain.equalsIgnoreCase("n")) {
			System.out.println("Thank you for using the batting average and slugging percentage calculator.");
		} else {
			System.out.println("Invalid keystroke. \nRelaunching generator.\n");

			Welcome();
		}

		sc.close();
	}

	public static int VerifyNumber(String correctNumber) {

		int goodNumber = 0;

		try {
			goodNumber = Integer.parseInt(correctNumber);

			if (goodNumber < 1 || goodNumber > 100) {
				System.out.println("Number is out of bounds, please keep number from 0 - 100");

				Welcome();
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid keystroke. \nRelaunching generator.\n");

			Welcome();
		}
		return goodNumber;
	}
}

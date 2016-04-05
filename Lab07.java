import java.util.Scanner;

public class Lab07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Press 'S' to start the Video Game Information Generator.");
		String startGame = sc.nextLine();
		if (startGame.equalsIgnoreCase("s")) {
			BeginGame(null);
		} else {
			// CleanQuitMethod
		}
		sc.close();
	}

	public static void BeginGame(String startHere) {
		String[] videoGameName = { "Zelda: A Link to the Past", "Fallout 4", "Elder Scrolls V: Skyrim", "Mario 64",
				"Final Fantasy VII", "Mass Effect", "Pokemon Red/Blue", "Portal", "Tetris", "Halo 2" };
		String[] releaseDate = { "11/21/1991", "11/10/2015", "11/11/2011", "06/23/1997", "01/31/1997", "11/16/2007",
				"02/27/1996", "10/09/2007", "06/06/1984", "11/09/2004" };
		String[] publisher = { "Nintendo", "Bethesda", "Bethesda", "Nintendo", "Square Enix", "BioWare", "Nintendo",
				"Valve", "Nintendo", "Microsoft" };

		Scanner sc = new Scanner(System.in);

		System.out.println("Please select a game to learn more about.\n");

		for (int i = 0; i < videoGameName.length; i++) {
			System.out.println("Press " + i + " for " + videoGameName[i]);
		}
		String whichGame = sc.nextLine();

		int verifiedNumber = VerifyNumber(whichGame);

		System.out.println("\nWould you like to learn the release date, the publisher, or both?"
				+ "\n\t1. Release Date (Press 1)" + "\n\t2. Publisher (Press 2)" + "\n\t3. Both! (Press 3)");
		String whatInfo = sc.nextLine();

		int verifiedInfo = VerifyNumber(whatInfo);

		if (verifiedInfo < 4) {
			switch (verifiedInfo) {
			case 1:
				System.out.println("The release date of " + videoGameName[verifiedNumber] + " is "
						+ releaseDate[verifiedNumber] + ".");
				break;
			case 2:
				System.out.println(
						"The publisher of " + videoGameName[verifiedNumber] + " is " + publisher[verifiedNumber] + ".");
				break;
			default:
				System.out.println("The release date of " + videoGameName[verifiedNumber] + " is "
						+ releaseDate[verifiedNumber] + " and the publisher is " + publisher[verifiedNumber] + ".");
			}
		} else {
			System.out.println("Invalid keystroke. \nRelaunching generator.\n");

			BeginGame(null);
		}
		
		sc.close();
	}

	public static int VerifyNumber(String verify) {

		int goodNumber = 0;

		try {
			goodNumber = Integer.parseInt(verify);
			String isItCorrect = Integer.toString(goodNumber);

			goodNumber = CorrectNumber(isItCorrect);

		} catch (NumberFormatException e) {
			System.out.println("Invalid keystroke. \nRelaunching generator.\n");

			BeginGame(null);
		}
		return goodNumber;
	}

	public static int CorrectNumber(String correctNumber) {

		int doubleChecked = Integer.parseInt(correctNumber);

		if (doubleChecked < 0 || doubleChecked > 9) {
		
			System.out.println("Invaild number \nRelaunching generator.\n");

			BeginGame(null);
		} 
		return doubleChecked;
	}

	public static void GoAgain(String again) {
		Scanner sc = new Scanner(System.in);

		if (again.equalsIgnoreCase("y")) {

			BeginGame(null);

		} else if (again.equalsIgnoreCase("n")) {
			System.out.println("Thank you for using the Video Game Information Generator");

		} else {
			System.out.println("Invalid selection. \nPlease press (Y/N)");
			String invalidSelection = sc.nextLine();

			GoAgain(invalidSelection);
		}
		sc.close();
	}
}

package Assignment1;

import java.util.Scanner;

public class UI {
	Scanner scan = new Scanner(System.in);
	private Sets test;

	public void setUniverse(int setCount) {
		test = new Sets(setCount);
		operations(setCount);
	}

	public void operations(int setCount)  {
		System.out.println("-----------------------------------------------------------------\n"
				+"Select an operation:\n" + "1.Intersection.\n" + "2.Union.\n" + "3.Complement.\n"
				+ "---------------------------------------\n" + "Operation Number:");

		while (!scan.hasNextInt()) {
			scan.next();
		}

		int n = scan.nextInt();
		switch (n) {
		case 1:
			intersection(setCount);
			break;
		case 2:
			union(setCount);
			break;
		case 3:
			complement(setCount);
			break;
		default:
			System.out.println("Invalid!");
			// System.clear();
			operations(setCount);
			break;
		}

		operations(setCount);
		return;
	}

	public void intersection(int setCount) {
		char ch = 'A';
		char[] sets = new char[setCount];
		String[] strArr = null;
		int found = 0;
		char ch1 = ' ';
		char ch2 = ' ';

		while (found < 2) {
			System.out.println("choose two sets from :");
			for (int i = 0; i < setCount; i++) {
				System.out.printf("%c ", ch);
				sets[i] = ch;
				ch++;
			}
			ch = 'A';
			found = 0;
			ch1 = scan.next().charAt(0);
			ch2 = scan.next().charAt(0);
			ch2 = Character.toUpperCase(ch2);
			ch1 = Character.toUpperCase(ch1);

			for (int i = 0; i < setCount; i++) {
				if (ch1 == sets[i]) {
					found++;
				}
				if (ch2 == sets[i]) {
					found++;
				}
				if (found == 2) {
					break;
				}

			}
		}
		strArr = test.intersection(ch1, ch2);
		if (strArr.length == 0) {
			System.out.println("There's no intersection between these two sets.");
		} else {
			for (int i = 0; i < strArr.length; i++) {
				System.out.println(strArr[i]);

			}
		}
		operations(setCount);
		return;
	}

	public void union(int setCount) {
		char ch = 'A';
		char[] sets = new char[setCount];
		String[] strArr = null;
		int found = 0;
		char ch1 = ' ';
		char ch2 = ' ';

		while (found < 2) {
			System.out.println("choose two sets from :");
			for (int i = 0; i < setCount; i++) {
				System.out.printf("%c ", ch);
				sets[i] = ch;
				ch++;
			}
			ch = 'A';
			found = 0;
			ch1 = scan.next().charAt(0);
			ch2 = scan.next().charAt(0);
			ch2 = Character.toUpperCase(ch2);
			ch1 = Character.toUpperCase(ch1);
			for (int i = 0; i < setCount; i++) {
				if (ch1 == sets[i]) {
					found++;
				}
				if (ch2 == sets[i]) {
					found++;
				}
				if (found == 2) {
					break;
				}

			}
		}
		strArr = test.Union(ch1, ch2);
		if (strArr.length == 0) {
			System.out.println("There's no union between these two sets.");
		} else {
			for (int i = 0; i < strArr.length; i++) {
				System.out.println(strArr[i]);

			}
		}
		operations(setCount);
		return;

	}

	public void complement(int setCount) {
		char ch = 'A';
		char[] sets = new char[setCount];
		String[] strArr = null;
		boolean found = false;
		char ch1 = ' ';

		while (!found) {
			System.out.println("choose a set from :");

			for (int i = 0; i < setCount; i++) {
				System.out.printf("%c ", ch);
				sets[i] = ch;
				ch++;
			}
			ch = 'A';
			ch1 = scan.next().charAt(0);
			ch1 = Character.toUpperCase(ch1);
			for (int i = 0; i < setCount; i++) {
				if (ch1 == sets[i]) {
					found = true;
					break;
				}
			}
		}
		strArr = test.Complement(ch1);
		if (strArr.length == 0) {
			System.out.println("There's no complement for this set.");
		} else {
			for (int i = 0; i < strArr.length; i++) {
				System.out.println(strArr[i]);

			}
		}
		operations(setCount);
		return;

	}

}

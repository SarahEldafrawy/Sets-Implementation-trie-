package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Sets {

	private Scanner scan = new Scanner(System.in);
	
	private class SetNode {
		boolean included;
		boolean tail;
	}
	
	private ArrayList<String> Ans;
	private SetNode[][] sets;
	private int setCount; // set's variable
	private int nodeNo;
	private TrieNode root;
	private char setChar = 'A'; //added


	
	/**constructor
	 * @param N is the number of sets
	 * @param nodeNo is the number of nodes in Trie
	 */
	public Sets(int N) {
		nodeNo = 0;
		root = new TrieNode(-1, false);
		setCount = 0;
		System.out.println("Enter the strings in the universe, done to finish."); //added
		System.out.println("Whitespaces are ignored"); //added
		input();
		sets = new SetNode[N][nodeNo];
		for (int i = 0; i < N; i++) {
			addSet();
		}
	}
	
	
//	public void addSet(String string) {		
//
//		for (int i = 0; i < nodeNo; i++) {
//			sets[setCount][i] = new SetNode();
//		}
//		
//		String scannedString = "";
//		String[] str = string.split(" ");
//		
//		for (int i = 0; i < str.length; i++) {
//			scannedString = str[i].toLowerCase();
//			searchTrieToAddStringsInSets(setCount, new StringBuffer(scannedString));
//		}
//		
//		setCount++;
//		
//	}
	
	private void addSet() {		

		for (int i = 0; i < nodeNo; i++) {
			sets[setCount][i] = new SetNode();
		}
		
		System.out.printf("Enter the strings in set %c, \"done\" to finish.\n", setChar);  //added
		System.out.println("Whitespaces are ignored in the string.");  //added
		String str = scan.next().toLowerCase();
		StringBuffer temp = new StringBuffer(str.replaceAll(" ", "")); //added
 
		while (!str.equals("done")) {
			if(!searchTrieToAddStringsInSets(setCount, new StringBuffer(temp))) {
				System.out.println("invalid");
			}
			str = scan.next().toLowerCase(); 
			temp = new StringBuffer(str.replaceAll(" ", ""));	//added
		}
		setCount++;
		setChar++;	//added
		
	}
	
	private boolean searchTrieToAddStringsInSets(int setIndex, StringBuffer str) {
		ArrayList<TrieNode> arr = root.getList();
		boolean found = false;
		if (str.length()==0) {
			return false;
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getValue() == str.charAt(0)) {
				int trieNodeIndex = arr.get(i).getNum();
				sets[setIndex][trieNodeIndex].included = true;
				str.deleteCharAt(0);
				if (str.length() != 0) {
				found = addTheRestofTheString(setIndex, str, arr.get(i));
				sets[setIndex][trieNodeIndex].included = found;
				} else {
					sets[setIndex][trieNodeIndex].tail = true;
					found = true;
				}
				break;
			}
		}
		return found;		
	}
	
	private boolean addTheRestofTheString(int setIndex, StringBuffer str, TrieNode trieNodeParent) {
		ArrayList<TrieNode> arr = trieNodeParent.getList();	
		boolean found = false;
		int arrSize = arr.size();
		for (int i = 0; i < arrSize; i++) {
			TrieNode trieNode = arr.get(i);
			
			if (trieNode.getValue() == str.charAt(0)) {
				int strLen = str.length();
				int trieNodeIndex = trieNode.getNum();
				
				if (strLen == 1 && trieNode.checkCondition()) {
					sets[setIndex][trieNodeIndex].tail = true;
					found = true;
					sets[setIndex][trieNodeIndex].included = found;
					break;
				} else if (strLen > 1) {
					str.deleteCharAt(0);
					found = addTheRestofTheString(setIndex, str, trieNode);
					sets[setIndex][trieNodeIndex].included = found;
					break;
				} else {
					found = false;
				}				
			}
		}
		return found;
	}

	public String [] intersection (char ch1, char ch2) {
		Ans = new ArrayList<String>();
		
		int set1 = Character.toUpperCase(ch1)-'A';
		int set2 = Character.toUpperCase(ch2)-'A';
		
		IntersectionLoop(set1, set2, root, new StringBuffer());
		
		String[] results = new String[Ans.size()]; 
	
		Ans.toArray(results);
		return results;
		
	}
	
	public String [] Union (char ch1, char ch2) {
		Ans = new ArrayList<String>();
		
		int set1 = Character.toUpperCase(ch1)-'A';
		int set2 = Character.toUpperCase(ch2)-'A';
		
		UnionLoop(set1, set2, root, new StringBuffer());
		
		String[] results = new String[Ans.size()]; 
	
		Ans.toArray(results);
		return results;
		
	}
		
	public String [] Complement (char ch) {
		Ans = new ArrayList<String>();
		
		int set = Character.toUpperCase(ch)-'A';
		
		ComplementLoop(set, root, new StringBuffer());
		
		String[] results = new String[Ans.size()]; 
	
		Ans.toArray(results);
		return results;
		
	}
		
	private void IntersectionLoop(int set1, int set2, TrieNode trieNodeParent, StringBuffer str) {
		ArrayList<TrieNode> arr = trieNodeParent.getList();	
		int arrSize = arr.size();
		
		for (int i = 0; i < arrSize; i++) {
			TrieNode trieNode = arr.get(i);
			int trieNodeIndex = trieNode.getNum();
			
			if (sets[set1][trieNodeIndex].included && sets[set2][trieNodeIndex].included) {
				boolean append = false;

				if (sets[set1][trieNodeIndex].tail && sets[set2][trieNodeIndex].tail) {
					str.append(trieNode.getValue());
					append = true;
					Ans.add(new String(str));
				}
				if (!append) {
					str.append(trieNode.getValue());
				}
				IntersectionLoop(set1, set2, trieNode, str);
				str.deleteCharAt(str.length()-1);			
			}
		}	
	}
	
	private void ComplementLoop(int set, TrieNode trieNodeParent, StringBuffer str) {
		ArrayList<TrieNode> arr = trieNodeParent.getList();	
		int arrSize = arr.size();
		
		for (int i = 0; i < arrSize; i++) {
			TrieNode trieNode = arr.get(i);
			boolean append = false;

			if (trieNode.checkCondition() && !sets[set][trieNode.getNum()].tail) {
				str.append(trieNode.getValue());
				append = true;
				Ans.add(new String(str));
			}
			if (!append) {
				str.append(trieNode.getValue());
			}
			ComplementLoop(set, trieNode, str);
			str.deleteCharAt(str.length()-1);							
		}	
	}
	
	private void UnionLoop(int set1, int set2, TrieNode trieNodeParent, StringBuffer str) {
		ArrayList<TrieNode> arr = trieNodeParent.getList();	
		int arrSize = arr.size();
		
		for (int i = 0; i < arrSize; i++) {
			TrieNode trieNode = arr.get(i);
			int trieNodeIndex = trieNode.getNum();
			
			if (sets[set1][trieNodeIndex].included || sets[set2][trieNodeIndex].included) {
				boolean append = false;

				if (sets[set1][trieNodeIndex].tail || sets[set2][trieNodeIndex].tail) {
					str.append(trieNode.getValue());
					append = true;
					Ans.add(new String(str));
				}
				if (!append) {
					str.append(trieNode.getValue());
				}
				UnionLoop(set1, set2, trieNode, str);
				str.deleteCharAt(str.length()-1);			
			}
		}
	}
	
	/*
	 * FIRST function call check is an indication on whether the user is done
	 * with entering the strings or not check if the string is repeated or not
	 * by calling second function repeated() if not repeated calls function to
	 * add the string
	 */
	private void input() {

		String scannedString = "";
		boolean check = true;
		while (check) {
			scannedString = scan.next().toLowerCase();
			if (scannedString.equals("done")) {
				check = false;
				continue;
			}
			TrieNode tmp = root;
			
			addString( new StringBuffer(scannedString), tmp);
		}
	}
//private void input(String input) {
//		
//
//		String scannedString = "";
//		String[] str = input.split(" ");
//		for(int i=0; i<str.length; i++){
//		
//			scannedString = str[i].toLowerCase();
//			
//			TrieNode tmp = root;
//			
//			addString(new StringBuffer(scannedString), tmp);
//		
//		}
//	}
	
	/*
	 * Inserts a new Node into a list
	 */

	private void insertNewNode(StringBuffer str, TrieNode node) {
		char ch;
		TrieNode tmp = new TrieNode(-1, false);
		
		int len = str.length();
		
		if (len == 1) {
			ch = str.charAt(0);
			tmp.setValue(ch);
			tmp.setNum(nodeNo);
			tmp.setFinal(true);
			node.addNode(tmp);
			nodeNo++;
			return;
		}
		if (len > 1) {
			ch = str.charAt(0);
			tmp.setValue(ch);
			tmp.setNum(nodeNo);
			node.addNode(tmp);
			str.deleteCharAt(0);
			nodeNo++;
			insertNewNode(str, tmp);
			return;
		}
	}

	/*
	 * SECOND function it takes the string as a param and a TrieNode if the str
	 * is empty it'll return if the node doesn't have any children (list empty)
	 * it'll add the remaining characters of the string if the character is
	 * already listed in the arrayList of the node , we'll use recursion to call
	 * that function again with string-that letter and a node == the child node
	 */
	private void addString(StringBuffer str, TrieNode node) {
		boolean found = false;
		TrieNode tmp = new TrieNode(-1, false);
		if (str.length() == 0) {
			return;
		}

		for (int i = 0; i < node.getList().size(); i++) {

			if (node.getList().get(i).getValue() == str.charAt(0)) {
				if(str.length() == 1){
					node.getList().get(i).setFinal(true);
					found = true;
					break;
				}
				tmp = node.getList().get(i);
				str.deleteCharAt(0);
				addString(str, tmp);
				found = true;
				break;
			}
		}
		if (!found) {
			insertNewNode(str, node);
		}
		return;
	}
	
}
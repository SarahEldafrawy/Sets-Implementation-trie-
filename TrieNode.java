package Assignment1;

import java.util.ArrayList;

public class TrieNode {
	
	private char value;
	private int nodeNum;
	private boolean check;
	private ArrayList<TrieNode> node ;
	
	public TrieNode(int n, boolean b){
		this.nodeNum = n;
		this.check = b;
		this.node = new ArrayList<>();
	}
	
	public void setValue(char c){
		this.value=c;
	}
	
	public void setNum(int n){
		this.nodeNum=n;
	}
	
	public void setFinal(boolean b){
		this.check=b;
	}
	public void addNode(TrieNode nd){
		this.node.add(nd);
	}
	
	public char getValue(){
		return this.value;
	}
	
	public int getNum(){
		return this.nodeNum;
	}
	
	public boolean checkCondition(){
		return this.check;
	}
	
	public ArrayList<TrieNode> getList(){
		return this.node;
	}
	
}

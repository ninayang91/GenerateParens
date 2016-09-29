import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Main {
	
	public static void main(String[] args){
		String s="abc";
		System.out.println(generateParens(3));
		
	}
	public static ArrayList<String> generateParens(int count){
		char[] str=new char[count*2];
		ArrayList<String> al=new ArrayList<String>();
		addParen(al,count,count,str,0);
		return al;
	}
	public static void addParen(ArrayList<String> list, int left, int right, char[] str, int count){
		if(left<0||right<left) return;//invalid
		
		
		if(left==0&&right==0){//no more ( )
			String s=String.copyValueOf(str);
			list.add(s);
		}else{
			if(left>0){//add ( if there are ( remaining
				str[count]='(';
				addParen(list,left-1,right,str,count+1);
			}
			if(right>left){//add ) if there are more ) than (
				str[count]=')';
				addParen(list,left,right-1,str,count+1);
			}
		}
	}
	
	public static Set<String> addparen(int n){
		
		Set<String> set = new HashSet<String>();
		if(n==0)return null;

		if(n==1) {set.add("()");return set;}
		//System.out.println(set);
		Set<String> temp=addparen(n-1);
		for(String s:temp){
			set.add(s+"()");
			set.add("("+s+")");
			set.add("()"+s);
		}
		
		return set;
	}
	


}

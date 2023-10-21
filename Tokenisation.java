import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tokenisation 
{
    public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	FileInputStream f = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\Assign1.txt");
	StringBuffer sb= new StringBuffer("");
	int i=0;
	while((i=f.read())!=-1)
	{
		sb.append((char)i);
	}
	String s= sb.toString();
	String[] st=s.split(" ");
	displayFile(st);
        System.out.println("--------------------------------------------");
	String t[]=remove(st);
	displayFile(t);
        System.out.println("--------------------------------------------");
	ArrayList<String> arr1=new ArrayList<String>();	
	for(String x:st)
	{
		arr1.add(x);
        }
	countFrequency(arr1);
	System.out.println("Enter the value of n:");
	int n=sc.nextInt();
	ArrayList<String> res=ngram(n,t);
	countFrequency(res);
	sc.close();
	f.close();
	}
	
	private static void countFrequency(ArrayList<String> arr1) {
		Map<String,Integer> hm=new HashMap<>();
		for(String i:arr1) {
			Integer j=hm.get(i);
			if(j==null) {
				hm.put(i, 1);
			}
			else
			{
				hm.put(i, j+1);
			}
		}
		
		for(Map.Entry<String, Integer> val : hm.entrySet()) {
			System.out.println(val.getKey()+" ----> "+val.getValue()+" times");
		}
		
        }
		private static ArrayList<String> ngram(int n, String[] str) 
		{
			ArrayList<String> ngrams=new ArrayList<String>();
			for(int i=0;i<str.length - n+1;i++) {
				ngrams.add(concat(str,i,i+n));
			}
			return ngrams;
		}
		
		private static String concat(String[] words, int start, int end) {
			StringBuilder sb=new StringBuilder();
			for(int i=start;i<end;i++)
				sb.append((i>start ? " ": "")+words[i]);
			return sb.toString();
		}
		
		
	
	public static void displayFile(String[] str) {
		for(String x: str) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	public static String[] remove(String[] s)
	{
		for(int j=0;j<s.length;j++) {
			if(s[j].charAt(s[j].length()-1)=='.' || s[j].charAt(s[j].length()-1)==',') {
				String temp=s[j].substring(0,s[j].length()-1);
				s[j]=temp;
			}
		}
		return s;
	}
}


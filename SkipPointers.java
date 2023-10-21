import java.util.*;
import java.io.*;
import java.lang.Math;
public class SkipPointers 
{
    public static String[] remove(String[] s)
	{
		for(int j=0;j<s.length;j++) {
			if(s[j].charAt(s[j].length()-1)=='.' || s[j].charAt(s[j].length()-1)==',' || s[j].charAt(s[j].length()-1)=='/' || s[j].charAt(s[j].length()-1)=='?' || s[j].charAt(s[j].length()-1)==':' || s[j].charAt(s[j].length()-1)=='|') {
				String temp=s[j].substring(0,s[j].length()-1);
				s[j]=temp;
			}
		}
		return s;
	}
    public static void displayFile(Set<String>s)
    {
        for(String x:s)
        {
            System.out.print(x+" ");
        }
    }
    public Set<String> readFile(String str) throws IOException
    {
        FileInputStream f=new FileInputStream(str);
        StringBuffer sb1= new StringBuffer("");
        int i=0;
        while((i=f.read()) != -1)
        {
            sb1.append((char)i);
        }
        String str1=sb1.toString();
        String[] arr1=str1.split(" ");
        String[] newarr1=remove(arr1);
        Set<String>s=new LinkedHashSet<>();
        for(var x:newarr1)
        {
            s.add(x);
        }
        f.close();
        return s;
    }
    public static void checkStopWord(Set<String>s,Set<String>stopWord,Set<String>combinedSet)
    {
        for(String x:s)
        {
            if(!stopWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
    }
    public static void main(String[] args) throws IOException,FileNotFoundException
    {
        Scanner sc=new Scanner(System.in);
        InformationRetrieval ir=new InformationRetrieval();
        Set<String>s1=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc1.txt");
        Set<String>s2=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc2.txt");
        Set<String>s3=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc3.txt");
        Set<String>s4=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc4.txt");
        Set<String>s5=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc5.txt");
        Set<String>s6=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc6.txt");
        Set<String>s7=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc7.txt");
        Set<String>s8=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc8.txt");
        Set<String>s9=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc9.txt");
        Set<String>s10=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc10.txt");
        //creating a combined set
        Set<String>stockWord=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\stop_words.txt");
        System.out.println("\n\n");
        //to preserve order of insertion
        Set<String> combinedSet=new LinkedHashSet<>();
        checkStopWord(s1,stockWord,combinedSet);
        checkStopWord(s2,stockWord,combinedSet);
        checkStopWord(s3,stockWord,combinedSet);
        checkStopWord(s4,stockWord,combinedSet);
        checkStopWord(s5,stockWord,combinedSet);
        checkStopWord(s6,stockWord,combinedSet);
        checkStopWord(s7,stockWord,combinedSet);
        checkStopWord(s8,stockWord,combinedSet);
        checkStopWord(s9,stockWord,combinedSet);
        checkStopWord(s10,stockWord,combinedSet);
        System.out.println("The unique tokens except stop words:");
        displayFile(combinedSet);
        Map<String,Integer>mp=new LinkedHashMap<>();
        int n=0;
        for(var x:combinedSet)
        {
            mp.put(x,n);
            n=n+1;
        }
        System.out.println("\n");
        ArrayList<ArrayList<Integer>>arr = new ArrayList<ArrayList<Integer>>(combinedSet.size());
        for(var x:combinedSet)
        {
            ArrayList<Integer>r=new ArrayList<Integer>();
            if(s1.contains(x))
            {
                r.add(1);
            }
            if(s2.contains(x))
            {
                r.add(2);
            }
            if(s3.contains(x))
            {
                r.add(3);
            }
            if(s4.contains(x))
            {
                r.add(4);
            }
            if(s5.contains(x))
            {
                r.add(5);
            }
            if(s6.contains(x))
            {
                r.add(6);
            }
            if(s7.contains(x))
            {
                r.add(7);
            }
            if(s8.contains(x))
            {
                r.add(8);
            }
            if(s9.contains(x))
            {
                r.add(9);
            }
            if(s10.contains(x))
            {
                r.add(10);
            }
            arr.add(r);
        }
        List<String> cs=new ArrayList<>(combinedSet);
        System.out.println("The inverted index formed is:");
        for (int i = 0; i < arr.size(); i++) 
        {
            System.out.print(cs.get(i));
            for(int k=0;k<20-cs.get(i).length();k++)
                
            System.out.print(" ");
            for (int j = 0; j < arr.get(i).size(); j++) 
            {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the strings(in lowercase) you want to compare :");
        String string1=sc.nextLine();
        String string2=sc.nextLine();
        int r1=mp.get(string1);
        int r2=mp.get(string2);
        //we have to declare two ArrayList
        ArrayList<Integer>a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();
        for(int j=0;j<arr.get(r1).size();j++)
        {
            a1.add(arr.get(r1).get(j));
            
        }
        for(int j=0;j<arr.get(r2).size();j++)
        {
            a2.add(arr.get(r2).get(j));
        }
        double size=a1.size();
        int optimal=(int)Math.sqrt(size);
        double size1=a2.size();
        int optimal1=(int)Math.sqrt(size1);
        ArrayList<Integer>res=new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<a1.size() && j<a2.size())
        {
            if(a1.get(i)==a2.get(j))
            {
                int num=a1.get(i);
                res.add(num);
                i++;
                j++;
            }
            else if(a1.get(i)<a2.get(j))
            {
                if((i+optimal < a1.size())&&(a1.get(i+optimal)< a2.get(j)))
                {
                    i=i+optimal;
                    while((i+optimal < a1.size()) && (a1.get(i+optimal)<a2.get(j)))
                    {
                        i+=optimal;
                    }
                }
                else
                {
                    i+=1;
                }
            }
            else
            {
                if((j+optimal1 < a2.size()) && (a2.get(j+optimal1)< a1.get(i)))
                {
                    j=j+optimal1;
                    while((j+optimal1 < a2.size()) && (a2.get(j+optimal1)< a1.get(i)))
                    {
                        j+=optimal1;
                    }
                }
                else
                {
                    j+=1;
                }
            }
        }
        System.out.println("The Result of the merging is:");
        for(int r=0;r<res.size();r++)
        {
            System.out.print("doc-"+res.get(r)+" ");
        }
        sc.close();
    }
}

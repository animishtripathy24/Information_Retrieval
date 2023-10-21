import java.util.*;
import java.io.*;

public class InvertedIndexing {
    //function to remove the punctuations
    public static String[] remove(String[] s)
	{
		for(int j=0;j<s.length;j++) {
			if(s[j].charAt(s[j].length()-1)=='.' || s[j].charAt(s[j].length()-1)==',' || s[j].charAt(s[j].length()-1)=='/' || s[j].charAt(s[j].length()-1)=='|') {
				String temp=s[j].substring(0,s[j].length()-1);
				s[j]=temp;
			}
		}
		return s;
	}
    //function to read a text file
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
    public static void displayFile(Set<String>s)
    {
        for(String x:s)
        {
            System.out.print(x+" ");
        }
    }
    //Main function
    public static void main(String[] args) throws FileNotFoundException,IOException
    {
        Scanner sc=new Scanner(System.in);
        InvertedIndexing ir=new InvertedIndexing();
        Set<String>s1=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc1.txt");
        System.out.println("\n"+"The individual tokens of document 1 is:");
        displayFile(s1);
        System.out.println("\n\n");
        Set<String>s2=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc2.txt");
        System.out.println("\n"+"The individual tokens of document 2 is:");
        displayFile(s2);
        System.out.println("\n\n");
        Set<String>s3=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc3.txt");
        System.out.println("\n"+"The individual tokens of document 3 is:");
        displayFile(s3);
        System.out.println("\n\n");
        Set<String>s4=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc4.txt");
        System.out.println("\n"+"The individual tokens of document 4 is:");
        displayFile(s4);
        System.out.println("\n\n");
        Set<String>s5=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc5.txt");
        System.out.println("\n"+"The individual tokens of document 5 is:");
        displayFile(s5);
        System.out.println("\n\n");
        //creating a combined set
        Set<String>stockWord=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\stop_words.txt");
        System.out.println("The list of Stock Words are:");
        displayFile(stockWord);
        System.out.println("\n\n");
        //to preserve order of insertion
        Set<String> combinedSet=new LinkedHashSet<>();
        for(var x:s1)
        {
            if(!stockWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
        for(var x:s2)
        {
            if(!stockWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
        for(var x:s3)
        {
            if(!stockWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
        for(var x:s4)
        {
            if(!stockWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
        for(var x:s5)
        {
            if(!stockWord.contains(x))
            {
                combinedSet.add(x);
            }
        }
        System.out.println("The unique tokens except stop words:");
        displayFile(combinedSet);
        //at first we will create a mapping
        Map<String,Integer>mp=new LinkedHashMap<>();
        int n=0;
        for(var x:combinedSet)
        {
            mp.put(x,n);
            n=n+1;
        }
        System.out.println("\n");
        ArrayList<ArrayList<String>>arr = new ArrayList<ArrayList<String>>(combinedSet.size());
        for(var x:combinedSet)
        {
            ArrayList<String>r=new ArrayList<String>();
            if(s1.contains(x))
            {
                r.add("doc1");
            }
            if(s2.contains(x))
            {
                r.add("doc2");
            }
            if(s3.contains(x))
            {
                r.add("doc3");
            }
            if(s4.contains(x))
            {
                r.add("doc4");
            }
            if(s5.contains(x))
            {
                r.add("doc5");
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
        ArrayList<String>a1=new ArrayList<>();
        ArrayList<String>a2=new ArrayList<>();
        for(int j=0;j<arr.get(r1).size();j++)
        {
            a1.add(arr.get(r1).get(j));
            
        }
        for(int j=0;j<arr.get(r2).size();j++)
        {
            a2.add(arr.get(r2).get(j));
        }
        System.out.println("Enter\n 1 for AND operation \n 2 for OR operation \n 3 for NOT");
        int ch=sc.nextInt();
        ArrayList<String> ans=new ArrayList<>();
        if(ch==1)
        {  
            for(int i=0;i<a1.size();i++)
            {
                if(a2.contains(a1.get(i)))
                {
                    ans.add(a1.get(i));
                }
            }
        }
        else if(ch==2)
        {
                for(int i=0;i<a1.size();i++)
                {
                    ans.add(a1.get(i));
                }
                
                for(int i=0;i<a2.size();i++)
                {
                    if(!ans.contains(a2.get(i)))
                    {
                    ans.add(a2.get(i));
                    }
                }
        }
        else if(ch==3)
        {
                System.out.println("Which string has NOT?\n 1st or 2nd?");
                int ci=sc.nextInt();
                if(ci==1)
                {
                        for(int i=0;i<a2.size();i++)
                        {
                            if(!a1.contains(a2.get(i)))
                            {
                                ans.add(a2.get(i));
                            }
                        }
                }
                else if(ci==2)
                {
                        for(int i=0;i<a1.size();i++)
                        {
                            if(!a2.contains(a1.get(i)))
                            {
                                ans.add(a1.get(i));
                            }
                        }  
                }
                else
                {
                        System.out.println("Invalid choice");
                }
            }
        else
        {
                System.out.println("Invalid choice");
        } 
        boolean flag=false;    
        System.out.print("Document found for query are: ");
        for(int i=0;i<ans.size();i++)
        {
            flag=true;
            System.out.print(ans.get(i)+" ");
        }
        if(!flag)
        {
            System.out.println("no such document present");
        }
        sc.close();
    }
}

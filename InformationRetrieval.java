import java.util.*;
import java.io.*;

public class InformationRetrieval {
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
    public static void main(String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        InformationRetrieval ir=new InformationRetrieval();
        Set<String>s1=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc1.txt");
        System.out.println("\n"+"The individual tokens of document 1 is:");
        for(var x:s1)
        {
            System.out.println(x);
        }
        System.out.println("\n\n");
        Set<String>s2=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc2.txt");
        System.out.println("\n"+"The individual tokens of document 2 is:");
        for(var x:s2)
        {
            System.out.println(x);
        }
        System.out.println("\n\n");
        Set<String>s3=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc3.txt");
        System.out.println("\n"+"The individual tokens of document 3 is:");
        for(var x:s3)
        {
            System.out.println(x);
        }
        System.out.println("\n\n");
        Set<String>s4=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc4.txt");
        System.out.println("\n"+"The individual tokens of document 4 is:");
        for(var x:s4)
        {
            System.out.println(x);
        }
        System.out.println("\n\n");
        Set<String>s5=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\doc5.txt");
        System.out.println("\n"+"The individual tokens of document 5 is:");
        for(var x:s5)
        {
            System.out.println(x);
        }
        System.out.println("\n\n");
        //creating a combined set
        Set<String>stockWord=ir.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Document_List_IR\\stop_words.txt");
        System.out.println("The list of Stock Words are:");
        for(var x:stockWord)
        {
            System.out.println(x);
        }
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
        // Iterator it=combinedSet.iterator();
        // while (it.hasNext())
        // {
        //     System.out.println(it.next()+" ");
        // }
        for(String str : combinedSet)
        {
            System.out.println(str);
        }
        Map<String,Integer>mp=new LinkedHashMap<>();
        int n=0;
        for(var x:combinedSet)
        {
            mp.put(x,n);
            n=n+1;
        }
        System.out.println("\n");
        //now we create a two dimensional incidence matrix
        int[][] mat=new int[combinedSet.size()][5];
        //at first we initialize all the rows with zeroes
        for(int row=0;row<combinedSet.size();row++)
        {
            for(int col=0;col<5;col++)
            {
                mat[row][col]=0;
            }
        }
        for(var x:combinedSet)
        {
            if(s1.contains(x))
            {
                mat[mp.get(x)][0]=1;
            }
            if(s2.contains(x))
            {
                mat[mp.get(x)][1]=1;
            }
            if(s3.contains(x))
            {
                mat[mp.get(x)][2]=1;
            }
            if(s4.contains(x))
            {
                mat[mp.get(x)][3]=1;
            }
            if(s5.contains(x))
            {
                mat[mp.get(x)][4]=1;
            }
        }
        List<String> cs=new ArrayList<>(combinedSet);
        System.out.println("\n"+"The term incidence matrix is:");
        System.out.print("\t\t    d1 d2 d3 d4 d5\n");
        for(int row=0;row<combinedSet.size();row++)
        {
            System.out.print(cs.get(row));
            for(int k=0;k<20-cs.get(row).length();k++)
                
            System.out.print(" ");
            for(int col=0;col<5;col++)
            {
                System.out.print(mat[row][col]+"  ");
            }
            System.out.println("\n");
        }
        System.out.println("Enter the strings(in lowercase) you want to compare :");
        String string1=sc.nextLine();
        String string2=sc.nextLine();
        int r1=mp.get(string1);
        int r2=mp.get(string2);
        //we have to declare two ArrayList
        if(r1 <= combinedSet.size() && r2 <= combinedSet.size())
        {
            ArrayList<Integer>a1=new ArrayList<>();
            ArrayList<Integer>a2=new ArrayList<>();
            for(int col=0;col<5;col++)
            {
                a1.add(mat[r1][col]);
                a2.add(mat[r2][col]);
            }
            System.out.println("Which operation you want to perform :");
            System.out.println("Enter 1->AND Operation 2->OR Operation 3->NOT Operation");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                ArrayList<Integer>res=new ArrayList<>();
                for(int loop=0;loop<a1.size();loop++)
                {
                    res.add(a1.get(loop) & a2.get(loop));
                }
                System.out.println("The final list obtained after doing AND Operation->");
                for(int ind=0;ind<res.size();ind++)
                {
                    System.out.print(res.get(ind)+" ");
                }
                System.out.println("\n");
                boolean flag=false;
                for(int l=0;l<res.size();l++)
                {
                    if(res.get(l)==1)
                    {
                        System.out.println("The two are present in document "+(l+1));
                        flag=true;
                    }
                }
                if(!flag)
                {
                    System.out.println("PRESENT IN NEITHER OF THE DOCUMENT");
                }
                System.exit(1);
            }
            else if(choice ==2)
            {
                ArrayList<Integer>res=new ArrayList<>();
                for(int loop=0;loop<a1.size();loop++)
                {
                    res.add(a1.get(loop) | a2.get(loop));
                }
                System.out.println("The final list obtained after doing OR Operation->");
                for(int ind=0;ind<res.size();ind++)
                {
                    System.out.print(res.get(ind)+" ");
                }
                System.out.println("\n");
                boolean flag=false;
                for(int l=0;l<res.size();l++)
                {
                    if(res.get(l)==1)
                    {
                        System.out.println("The two are present in document "+(l+1));
                        flag=true;
                    }
                }
                if(!flag)
                {
                    System.out.println("PRESENT IN NEITHER OF THE DOCUMENT");
                }
                System.exit(1);
            }
            else
            {
                System.out.println("In which row you want NOT Operation 1->row1 and 2->row2");
                int choice1=sc.nextInt();
                if(choice1 == 1)
                {
                    ArrayList<Integer>res=new ArrayList<>();
                    for(int loop=0;loop<a1.size();loop++)
                    {
                        res.add(~a1.get(loop) & a2.get(loop));
                    }
                    System.out.println("The final list obtained after doing NOT Operation->");
                    for(int ind=0;ind<res.size();ind++)
                    {
                        System.out.print(res.get(ind)+" ");
                    }
                    System.out.println("\n");
                    boolean flag=false;
                    for(int l=0;l<res.size();l++)
                    {
                        if(res.get(l)==1)
                        {
                            System.out.println("The two are present in document "+(l+1));
                            flag=true;
                        }
                    }
                    if(!flag)
                    {
                        System.out.println("PRESENT IN NEITHER OF THE DOCUMENT");
                    }
                    System.exit(1);
                }
                else if(choice1 ==2)
                {
                    ArrayList<Integer>res=new ArrayList<>();
                    for(int loop=0;loop<a1.size();loop++)
                    {
                        res.add(a1.get(loop) & ~a2.get(loop));
                    }
                    System.out.println("The final list obtained after doing NOT Operation->");
                    for(int ind=0;ind<res.size();ind++)
                    {
                        System.out.print(res.get(ind)+" ");
                    }
                    System.out.println("\n");
                    boolean flag=false;
                    for(int l=0;l<res.size();l++)
                    {
                        if(res.get(l)==1)
                        {
                            System.out.println("The two are present in document "+(l+1));
                            flag=true;
                        }
                    }
                    if(!flag)
                    {
                        System.out.println("PRESENT IN NEITHER OF THE DOCUMENT");
                    }
                    System.exit(1);
                }
                else
                {
                    System.out.println("INVALID ROW NUMBER ,NOT IN THE RANGE");
                    System.exit(1);
                }

            }
        }
        else
        {
            System.out.println("INVALID ROW NUMBER ,NOT IN THE RANGE");
            System.exit(1);
        }
        sc.close();
    }
}

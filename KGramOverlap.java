import java.util.*;
import java.io.*;
public class KGramOverlap
{
    public boolean check(ArrayList<String> arr,String str2)
    {
        ArrayList<String>res=new ArrayList<>();
        for(int i=0;i<str2.length()-1;i++)
        {
            StringBuffer sb=new StringBuffer();
            sb.append(str2.charAt(i));
            sb.append(str2.charAt(i+1));
            String str=sb.toString();
            res.add(str);
        }
        int count=0;
        for(int i=0;i<res.size();i++)
        {
            if(arr.contains(res.get(i)))
            {
                count++;
            }
        }
        if(count >= 2)
        {
            return true;
        }
        return false;
    }
    public double calculate(ArrayList<String>arr,ArrayList<String>result) throws ArithmeticException
    {
        int count_and=0;
        for(String str:arr)
        {
            if(result.contains(str))
            {
                count_and++;
            }
        }
        int count_or=arr.size()+result.size()-count_and;
        System.out.println(count_or);
        System.out.println(count_and);
        return ((double)count_and/(double)count_or);
    }
    public static void main(String[] args) throws IOException,ConcurrentModificationException
    {
        Scanner sc=new Scanner(System.in);
        KGramOverlap obj= new KGramOverlap();
        System.out.println("The misspelled Word is: bord");
        ArrayList<String> arr=new ArrayList<>();  
        arr.add("bo");
        arr.add("or");
        arr.add("rd");
        ArrayList<ArrayList<String>> posting=new ArrayList<ArrayList<String>>();
        ArrayList<String> a1=new ArrayList<String>();
        a1.add("abord");
        a1.add("about");
        a1.add("boardroom");
        a1.add("border");
        posting.add(a1);
        ArrayList<String> a2=new ArrayList<String>();
        a2.add("border");
        a2.add("lord");
        a2.add("morbid");
        a2.add("sorbid");
        posting.add(a2);
        ArrayList<String> a3=new ArrayList<String>();
        a3.add("abord");
        a3.add("ardent");
        a3.add("boardroom");
        a3.add("border");
        posting.add(a3);
        Map<String,ArrayList<String>>mp=new LinkedHashMap<>();
        for(int i=0;i<3;i++)
        {
            mp.put(arr.get(i),posting.get(i));
        }
        for(var x:mp.entrySet())
        {
            System.out.println(x.getKey()+"-->"+x.getValue());
        }
        Set<String> res =new LinkedHashSet<>();
        for(int i=0;i<posting.size();i++)
        {
            for(int j=0;j<posting.get(i).size();j++)
            {
                if(obj.check(arr,posting.get(i).get(j)))
                {
                    res.add(posting.get(i).get(j));
                }
            }
        }
        System.out.println("The words which has atleast two biagram common to the misspelled word are:");
        for(String s:res)
        {
            System.out.print(s+" ");
        }
        ArrayList<Double> jaccard=new ArrayList<>();
        for(String str:res)
        {
            ArrayList<String>result=new ArrayList<>();
            for(int i=0;i<str.length()-1;i++)
            {
                StringBuffer sb=new StringBuffer();
                sb.append(str.charAt(i));
                sb.append(str.charAt(i+1));
                String str1=sb.toString();
                result.add(str1);
            }
            double n=obj.calculate(arr,result);
            jaccard.add(n);
        }
        System.out.println("The respective jaccard similarity are as follows:");
        for(int i=0;i<jaccard.size();i++)
        {
            System.out.println(jaccard.get(i));
        }
        sc.close();
    }
}
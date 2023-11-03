import java.util.*;
public class MeanAveragePrecision 
{
    public double calculateAveragePrecision(ArrayList<Integer> ans, ArrayList<Integer> reldoc) 
    {
            int num=0;
            int den=0;
            ArrayList<Double> ap= new ArrayList<Double>();
            for(int x:ans)
            {
                den++;
                if(reldoc.contains(x))
                {
                    num++;
                    ap.add((double)num/(double)den);
                }
                else
                {
                    ap.add(0.0);
                } 
                
            }
            
            double res=0.0;
            
            for(int i=0;i<ap.size();i++)
            {
                res=res+ap.get(i);
            }
            
            return res/reldoc.size();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MeanAveragePrecision obj= new MeanAveragePrecision();
        System.out.println("Enter no of Queries:");
        int c=sc.nextInt();
        ArrayList<Double>ans=new ArrayList<>();
        for(int k=0;k<c;k++)
        {
            System.out.println("Query no: "+(k+1));
            ArrayList<Integer> rel=new ArrayList<>();
            System.out.println("Enter the number of relevant document");
            int n=sc.nextInt();
            System.out.println("Enter the relevant documents:");
            while(n-->0)
            {
                int m=sc.nextInt();
                rel.add(m);
            }
            ArrayList<Integer>query=new ArrayList<>();
            System.out.println("Enter the number of queries");
            int q=sc.nextInt();
            System.out.println("Enter the query List:");
            while(q-->0)
            {
                int p=sc.nextInt();
                query.add(p);
            }
            double finalAns=obj.calculateAveragePrecision(query,rel);
            ans.add(finalAns);
        }
        double sum=0.0;
        for(int k=0;k<ans.size();k++)
        {
            sum+=ans.get(k);
        }
        System.out.println("The Mean Average Precision is : "+(sum/c));
        sc.close(); 
    }   
}

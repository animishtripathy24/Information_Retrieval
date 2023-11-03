import java.util.*;
public class NormalisedDiscountedCummulativeGain 
{
    public double Sum(ArrayList<Double> arr)
    {
        double sum=0.0;
        for(double x:arr)
        {
            sum+=x;
        }
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        NormalisedDiscountedCummulativeGain obj=new NormalisedDiscountedCummulativeGain();
        System.out.println("Enter no of cases:");
        int c=sc.nextInt();
        ArrayList<Double>ans=new ArrayList<>();
        for(int k=0;k<c;k++)
        {
            System.out.println("Query no: "+(k+1));     
            System.out.println("Enter number of documents");
            int n=sc.nextInt();
            System.out.println("Enter the query:");
            ArrayList<Integer> query=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int x=sc.nextInt();
                query.add(x);
            }
            System.out.println("Enter the relevant score:");
            ArrayList<Integer> score=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int x=sc.nextInt();
                score.add(x);
            }
            ArrayList<Double> dcg=new ArrayList<>();
            int count=1;
            for(int i=0;i<n;i++)
            {
                int num=score.get(i);
                double denom=Math.log(count + 1)/ Math.log(2);
                count++;
                dcg.add(num/denom);
            }
            double dcgValue=obj.Sum(dcg);
            System.out.println(dcgValue);
            Collections.sort(score);
            Collections.reverse(score);
            ArrayList<Double> idcg=new ArrayList<>();
            int count2=1;
            for(int i=0;i<n;i++)
            {
                int num=score.get(i);
                double denom= Math.log(count2 + 1)/ Math.log(2);
                count2++;
                idcg.add(num/denom);
            }
            double idcgValue=obj.Sum(idcg);
            ans.add(dcgValue/idcgValue);
        }
        System.out.println("NDCG values");
        for(int k=0;k<c;k++)
        {
            System.out.println("Case "+(k+1)+"="+ans.get(k));
        } 
        sc.close();
    }
}

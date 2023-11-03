import java.util.*;
import java.io.*;
public class CosineSimilarity {
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
        public double cosineSimilarity(ArrayList<Double>A, ArrayList<Double>B) 
        {
            double dotProduct = 0.0;
            double normA = 0.0;
            double normB = 0.0;
            for (int i = 0; i < A.size(); i++) {
                dotProduct += A.get(i) * B.get(i);
                normA += Math.pow(A.get(i), 2);
                normB += Math.pow(B.get(i), 2);
            }   
            return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
        }
        public Map<String,Integer> countFrequency(String str) throws IOException
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
            Map<String, Integer> hm = new HashMap<String, Integer>();
            for (String val : newarr1) 
            {
                Integer j = hm.get(val);
                hm.put(val, (j == null) ? 1 : j + 1);
            }
            f.close();
            return hm;
            
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
            for(String x:newarr1)
            {
                s.add(x);
            }
            f.close();
            return s;
        }
        public ArrayList<Double> calVector(double[][] matrix,int col,int size)
        {
            ArrayList<Double>temp=new ArrayList<>();
            for(int j=0;j<size;j++)
            {
                temp.add(matrix[j][col]);
            }
            return temp;
            
        }
        public static void main(String[] args) throws IOException
        {
            Scanner sc=new Scanner(System.in);
            CosineSimilarity obj=new CosineSimilarity();
            Map<String,Integer>c1=obj.countFrequency("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc1.txt");
            Set<String>s1=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc1.txt");
            System.out.println("\n"+"The individual tokens of document 1 is:");
            for(String x:s1)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            Map<String,Integer>c2=obj.countFrequency("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc2.txt");
            Set<String>s2=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc2.txt");
            System.out.println("\n"+"The individual tokens of document 2 is:");
            for(String x:s2)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            Map<String,Integer>c3=obj.countFrequency("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc3.txt");
            Set<String>s3=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc3.txt");
            System.out.println("\n"+"The individual tokens of document 3 is:");
            for(String x:s3)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            Map<String,Integer>c4=obj.countFrequency("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc4.txt");
            Set<String>s4=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc4.txt");
            System.out.println("\n"+"The individual tokens of document 4 is:");
            for(String x:s4)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            Map<String,Integer>c5=obj.countFrequency("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc5.txt");
            Set<String>s5=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\doc5.txt");
            System.out.println("\n"+"The individual tokens of document 5 is:");
            for(String x:s5)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            //creating a combined set
            Set<String>stockWord=obj.readFile("C:\\Users\\hp\\OneDrive\\Desktop\\Information retrieval\\Document_List_IR\\stop_words.txt");
            System.out.println("The list of Stock Words are:");
            for(String x:stockWord)
            {
                System.out.println(x);
            }
            System.out.println("\n\n");
            //to preserve order of insertion
            Set<String> combinedSet=new LinkedHashSet<>();
            for(String x:s1)
            {
                if(!stockWord.contains(x))
                {
                    combinedSet.add(x);
                }
            }
            for(String x:s2)
            {
                if(!stockWord.contains(x))
                {
                    combinedSet.add(x);
                }
            }
            for(String x:s3)
            {
                if(!stockWord.contains(x))
                {
                    combinedSet.add(x);
                }
            }
            for(String x:s4)
            {
                if(!stockWord.contains(x))
                {
                    combinedSet.add(x);
                }
            }
            for(String x:s5)
            {
                if(!stockWord.contains(x))
                {
                    combinedSet.add(x);
                }
            }
            System.out.println("The unique tokens except stop words:");
            for(String str : combinedSet)
            {
                System.out.println(str);
            }
            System.out.print("-------------------------------------------------------------------------------------\n");
            System.out.println("The document frequency is :");
            //now we have to find the document frequency
            Map<String, Integer>docFreq = new HashMap<String, Integer>();
            for(String str:combinedSet)
            {
                int count=0;
                if(s1.contains(str))
                {
                    count++;
                }
                if(s2.contains(str))
                {
                    count++;
                }
                if(s3.contains(str))
                {
                    count++;
                }
                if(s4.contains(str))
                {
                    count++;
                }
                if(s5.contains(str))
                {
                    count++;
                }
                docFreq.put(str,count);
            }
            for (Map.Entry<String,Integer>val : docFreq.entrySet()) 
            {
                System.out.println(val.getKey()+ ": " + val.getValue() + " times");
            }
            int n=5;
            //calculation of idf scores
            Map<String,Double>idf=new HashMap<String,Double>();
            for(String str1 : combinedSet)
            {
                int df=docFreq.get(str1);
                double num=((double)n/(double)df);
                double idfx=Math.log10(num);
                idf.put(str1,idfx);
            }
            System.out.print("-------------------------------------------------------------------------------------\n");
            System.out.println("The Idf scores is :");
            for (Map.Entry<String,Double>val : idf.entrySet()) 
            {
                System.out.println(val.getKey()+ ": " + val.getValue());
            }
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
            
            //now we have to map the contents of the combined set with the row number 
            Map<String,Integer>mp=new LinkedHashMap<>();
            int num=0;
            for(String x:combinedSet)
            {
                mp.put(x,num);
                num=num+1;
            }
            //here we have to define a matrix
            double[][] matrix=new double[combinedSet.size()][5];
            //at first we initialize all the rows with zeroes
            for(int row=0;row<combinedSet.size();row++)
            {
                for(int col=0;col<5;col++)
                {
                    matrix[row][col]=0;
                }
            }
            for(String str: combinedSet)
            {
                if(s1.contains(str))
                {
                    int termFreq = c1.get(str);
                    double idfnum=idf.get(str);
                    double tfidf=((double)termFreq*idfnum);
                    matrix[mp.get(str)][0]=tfidf;
                }
                if(s2.contains(str))
                {
                    int termFreq = c2.get(str);
                    double idfnum=idf.get(str);
                    double tfidf=((double)termFreq*idfnum);
                    matrix[mp.get(str)][1]=tfidf;
                }
                if(s3.contains(str))
                {
                    int termFreq = c3.get(str);
                    double idfnum=idf.get(str);
                    double tfidf=((double)termFreq*idfnum);
                    matrix[mp.get(str)][2]=tfidf;
                }
                if(s4.contains(str))
                {
                    int termFreq = c4.get(str);
                    double idfnum=idf.get(str);
                    double tfidf=((double)termFreq*idfnum);
                    matrix[mp.get(str)][3]=tfidf;
                }
                if(s5.contains(str))
                {
                    int termFreq = c5.get(str);
                    double idfnum=idf.get(str);
                    double tfidf=((double)termFreq*idfnum);
                    matrix[mp.get(str)][4]=tfidf;
                }
            }
            List<String> cs1=new ArrayList<>(combinedSet);
            System.out.println("\n"+"The term incidence matrix is:");
            System.out.print("\t\t    d1 d2 d3 d4 d5\n");
            for(int row=0;row<combinedSet.size();row++)
            {
                System.out.print(cs1.get(row));
                for(int k=0;k<20-cs1.get(row).length();k++)

                System.out.print(" ");
                for(int col=0;col<5;col++)
                {
                    System.out.print(matrix[row][col]+"  ");
                }
                System.out.println("\n");
            }
            //declaring a ArrayList of Integer to store the cosine similarity
            ArrayList<Double>cosSim=new ArrayList<>();
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(i==j) continue;
                    ArrayList<Double>ith=obj.calVector(matrix,i,combinedSet.size());
                    ArrayList<Double>jth=obj.calVector(matrix,j,combinedSet.size());
                    double res=obj.cosineSimilarity(ith,jth);
                    cosSim.add(res);
                    
                    
                }
            }
            Map<String,Integer>result=new LinkedHashMap<>();
            int number=0;
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(i==j) continue;
                    String str1=Integer.toString(i)+Integer.toString(j);
                    result.put(str1,number);
                    number=number+1;
                    
                }
            }
            System.out.println("---------------------------------------------------------------------------");
            for (Map.Entry<String,Integer>val : result.entrySet()) 
            {
                System.out.println(val.getKey()+ ": " + cosSim.get(val.getValue()));
            } 
            System.out.println("Enter the query");
            String QueryString=sc.nextLine();
            String[] query=QueryString.split(" ");
            ArrayList<Double> queryVector=new ArrayList<>();
            for(String str:query)
            {
                if(idf.get(str)==null)
                {
                    queryVector.add(0.0);
                }
                queryVector.add(idf.get(str));
            }
            ArrayList<Double> result2=new ArrayList<>();
            Map<Double,Integer>result1=new LinkedHashMap<>();
            for(int i=0;i<5;i++)
            {
                
                ArrayList<Double>temp1=obj.calVector(matrix, i, combinedSet.size());
                double cosSimqueryDoc=obj.cosineSimilarity(queryVector,temp1);
                result2.add(cosSimqueryDoc);
                result1.put(cosSimqueryDoc,i);
            }
            Collections.sort(result2, Collections.reverseOrder());
            System.out.println("The query is most relevant to doc "+result1.get(result2.get(1)));
            sc.close();
            
            
            
            
        }
}


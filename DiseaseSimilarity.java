import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DiseaseSimilarity {

    public static void main(String... args) throws Exception {

      
		String filePath = "D:\\List2.txt";
        BufferedReader br;
		String line;
		 ArrayList<String> listw = new ArrayList<String>();
		  List<String> list1 = new ArrayList<String>();
	   List<String> list2 = new ArrayList<String>();
		try {   
		br = new BufferedReader(new FileReader(filePath));
	
		

   try {       while((line = br.readLine()) != null)        {            
				
			     listw.add(line);
						
						
			}  

	  //  List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
       // List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));
	   int count=-1;
	   for(String nline : listw)
	   {
		   count++;
		   String[] result=nline.split("\t");
		   for(int i=count+1;i<listw.size();i++)
		   {
			   String sline=listw.get(i);
			   String[] result1=sline.split("\t");
		 System.out.println("sline="+sline);
		 System.out.println("nline="+nline);
	   List<String> list5 = Arrays.asList(result);
       List<String> list6 = Arrays.asList(result1);
	  
	    
		
	   for(int j=1;j<list5.size();j++)
	   {
		  
		  list1.add(list5.get(j));
		  	   }
	   for(int k=1;k<list6.size();k++)
	   {
		
		list2.add(list6.get(k));
		
	   }
	   
	  
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		
		double jaccardindex,oc;
		int lenA,lenB,U,N,min;
		
		list3=new Test().intersection(list1, list2);
		list4=new Test().union(list1, list2);
		lenA=list1.size();
		lenB=list2.size();
		U=list3.size();
		N=list4.size();
		min=(lenA<lenB)? lenA: lenB;
		
		System.out.println("Intersection="+U);
		System.out.println("Union="+N);
		
		jaccardindex=N/U;
		oc=N/min;
		
        System.out.println("Intersection D1 n D2"+new Test().intersection(list1, list2));
        System.out.println("Union D1 u D2"+new Test().union(list1, list2));
		System.out.println("Jaccard Index of  D1  D2 "+jaccardindex);
		System.out.println("Overlap coefficient of  D1  D2 "+oc);
    
		}	
	   }
   }	   
		
		   catch (IOException e) {       // TODO Auto-generated catch block       e.printStackTrace();
								}
		catch(ArrayIndexOutOfBoundsException exception) {
    
}
   
    
    } catch (FileNotFoundException e) {   // TODO Auto-generated catch block   e.printStackTrace();
									  }

}
    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
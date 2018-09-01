package monitoring;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "#sam@100#bhasim@200#shyam@400";
		 String tempA[]= s.split("#");
		 int len=tempA.length;
//		 System.out.println(tempA[0]);
		 String tempB[] = null;
//		 List<String> Name = new ArrayList<String>();
//		 List<String> id = new ArrayList<String>();
		 String Name[] = new String[len];
		 String id[] = new String[len];
		 for(int i=1;i<len;i++){
			 tempB=  tempA[i].split("@");
			 Name[i]=tempB[0];
			 id[i]=tempB[1];
//			 Name.add(tempB[0]);
//			 id.add(tempB[1]);
		 }
		 for (String temp: Name){
	          System.out.print(temp);
	       }
		 System.out.println();
		 for (String temp: id){
	          System.out.print(temp);
	       }
	}

}

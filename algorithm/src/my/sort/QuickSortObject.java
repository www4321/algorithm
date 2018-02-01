package my.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortObject {

//	public void quickSort(List<Student> list, int start, int end) {  
//	    if(start >= end) return;         
//	    int mid = partition(list, start, end);  	      
//	    quickSort(list, start, mid-1); 
//	    quickSort(list, mid+1, end); 
//	    
//	    
//	}
//	public int partition(List<Student> list,int start,int end){
//		Student copy =null;
//		Student midvalue = list.get(start);
//		while(start<end){
//			while(list.get(end).getAge()>midvalue.getAge() && end > start)
//				end--;
//			copy = list.get(end);
//			list.remove(start);
//			list.add(start, copy);
//			while(list.get(start).getAge()<midvalue.getAge() && end > start)
//				start++;
//			copy = list.get(start);
//			list.remove(end);
//			list.add(end,copy);
//			
//		}
//		list.remove(end);
//		list.add(end,midvalue);
//		return end;
//	}
	//½µĞòÅÅÁĞ
	public void quickSort(List<Student> list, int start, int end) {  
	    if(start >= end) return;         
	    int mid = partition(list, start, end);  	      
	    quickSort(list, start, mid-1); 
	    quickSort(list, mid+1, end); 
	    
	    
	}
	public int partition(List<Student> list,int start,int end){
		Student copy =null;
		Student midvalue = list.get(start);
		while(start<end){
			while(list.get(end).getAge()<midvalue.getAge() && end > start)
				end--;
			copy = list.get(end);
			list.remove(start);
			list.add(start, copy);
			while(list.get(start).getAge()>midvalue.getAge() && end > start)
				start++;
			copy = list.get(start);
			list.remove(end);
			list.add(end,copy);
			
		}
		list.remove(end);
		list.add(end,midvalue);
		return end;
	}
	public static void print(List<Student> list){
		for(int i = 0 ; i < list.size() ;i ++)
			System.out.print(list.get(i).name+" "+list.get(i).age+"..");
		System.out.println("\n");
	}
	public static void main(String[] args) {
		QuickSortObject sort =new QuickSortObject();
		Student s1 =new Student(4,"s1");
		Student s2 =new Student(5,"s2");
		Student s3 =new Student(3,"s3");
		Student s4 =new Student(7,"s4");
		Student s5 =new Student(6,"s5");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);
		sort.quickSort(list, 0, list.size()-1);
		//int k = sort.partition(list, 0, list.size()-1);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).name+" "+list.get(i).age);

	}

}

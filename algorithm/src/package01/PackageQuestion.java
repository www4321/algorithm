package package01;

//01±≥∞¸Œ Ã‚

import java.util.ArrayList;
import java.util.List;

public class PackageQuestion {

	public int get01Package(Stuff[] stuffs, int maxWeight){
		int stage = stuffs.length+1;
		int d[][] = new int[stage][maxWeight+1];
		for(int i=0;i<stage;i++)
			for(int j=0;j<maxWeight+1;j++)
				d[i][j]=0;
		for(int i=1;i<stage;i++){
			for(int j=1;j<maxWeight+1;j++){
				if(stuffs[i-1].weight>j){
					d[i][j]=d[i-1][j];
				}else{
					d[i][j]=Math.max(d[i-1][j],d[i-1][j-stuffs[i-1].weight]+stuffs[i-1].value);
				}
			}
		}
		print(d);
		System.out.println(d[stage-1][maxWeight]);
		return d[stage-1][maxWeight];
		
		
	}
  public void answer(int d[][],int maxWeight,Stuff[] stuffs){
	  List<Integer> answers = new ArrayList<Integer>();
	  int weight = maxWeight;
	  for(int i=d.length-1; i>=0; i--){    
		  if(weight==0) {  
			  break;  
		  }  
		  if(i==0 && weight > 0){  
			  answers.add(stuffs[i-1].weight);  
			  break;  
		  }  
		  if(d[i][weight]-d[i-1][weight-stuffs[i-1].weight]==stuffs[i-1].value){  
			  answers.add(stuffs[i-1].weight); 
			  if(d[i-1][weight-stuffs[i-1].weight]==0)
				  break;
			  weight -= stuffs[i-1].weight;  
		  }  
	  }  
	  for(int i=0;i<answers.size();i++)
		  System.out.print(""+answers.get(i)+" ");
  }
	public static void print(int arr[][]){
		for(int i = 1 ; i < arr.length ;i ++){
			for(int j=1; j< arr[0].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println("\n");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PackageQuestion p = new PackageQuestion();
		Stuff stuffs[] = new PackageQuestion.Stuff[3];
		stuffs[0] = p.new Stuff(3,4);
		stuffs[1] = p.new Stuff(4,5);
		stuffs[2] = p.new Stuff(5,6);
//		stuffs[3] = p.new Stuff(5,4);
//		stuffs[4] = p.new Stuff(4,6);
		p.get01Package(stuffs, 10);
	}
    public class Stuff{
    	public int weight;
    	public int value;
    	public Stuff(int weight,int value){
    		this.weight = weight;
    		this.value  = value ;
    	}
    }
}

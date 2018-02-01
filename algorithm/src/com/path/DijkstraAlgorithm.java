package com.path;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



public class DijkstraAlgorithm {

	public static int[] dijkstra(int[][]matrix,int start){
		int n = matrix.length;
		int[]dist = new int[n];
		boolean dijkstr[] = new boolean[n];
		int path[] =new int[n];
		for(int i=0;i<n;i++){
			if(i==start){
				dijkstr[i] = true;
				dist[i] = 0;
			}
			else {
				dijkstr[i] = false;
				dist[i] = matrix[start][i];
			}
			path[i]=start;
		}
		
		for(int i=0;i<n;i++){
			if(i==start)continue;
			int min = Integer.MAX_VALUE;
			int flag = -1;
			for(int j=0;j<n;j++){
				if(!dijkstr[j] && dist[j]<min){
					min = dist[j];
					flag = j;
				}
			}
			
			dijkstr[flag]=true;
			for(int j=0;j<n;j++){
				if(!dijkstr[j]&& (dist[flag]+matrix[flag][j]<dist[j])){
					dist[j] = dist[flag]+matrix[flag][j];
					path[j]=flag;
				}
			}
		}
//		for(int i=0;i<n;i++){
//			//System.out.println(map.get(i));
//			System.out.println(path[i]);
//		}
		showPath(path,5,start);
		return dist;
	}
	
	
	public static void showPath(int path[],int v,int v0)   //打印最短路径上的各个顶点 
	{
	    Stack<Integer> s = new Stack<Integer>();
	    StringBuffer str=new StringBuffer();
	    int u=v;
	    while(v!=v0)
	    {
	        s.push(v);
	        v=path[v];
	    }
	    s.push(v);
	    while(!s.empty())
	    {
	    	str.append(s.pop()+" ");
	    }
	    System.out.println(str);
	}
	public static void main(String[] args) {
		int [][]matrix={{9999,6,3,9999,9999,9999},{6,9999,2,5,9999,9999},{3,2,9999,3,4,9999},{9999,5,3,9999,2,3},{9999,9999,4,2,9999,5},{9999,9999,9999,3,5,9999}};
		int []p=DijkstraAlgorithm.dijkstra(matrix, 0);
		for(int i=0;i<p.length;i++)
			System.out.print(p[i]+" ");

	}

}

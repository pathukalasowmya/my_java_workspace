import java.util.Arrays;

public class ArraysDemo2 {

	public static void main(String[] args) {
		double[] salaries = {35000,45000,55000,66000,77000};
		System.out.println(salaries);
		System.out.println(Arrays.toString(salaries));
		
		//traversing array elements
		System.out.println("traversing array using for each loop");
		for(double salary: salaries){
			System.out.println(salary);
		}
		
		
		int size = salaries.length;
		System.out.println(size);
		
		int[][]multi =new int[2][2];
		multi [0][0]=10;
		multi [0][1]=20;
		multi [1][0]=30;
		multi [1][1]=40;
		
		int[][] arr = {{11,22},{33,44}};
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		
		
		
		
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		
		//jagged Array
		int[][]jaggedArray = {{10,20},{30,40,50,60},{70,80,90}};
		for(int[]eachArray: jaggedArray) {
			for (int element:eachArray) {
				System.out.println(element+"");
				System.out.println();
				
			}
		}
		System.out.println(Arrays.toString(jaggedArray[0]));
		System.out.println(Arrays.toString(jaggedArray[1]));
		System.out.println(Arrays.toString(jaggedArray[2]));
         
		String[]courses= {"Angular","Java","Python","C","React"};
		for(String course : courses){
			System.out.println(course);
		}
	

		
		
		
		}

	}



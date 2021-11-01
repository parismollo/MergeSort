import java.util.Arrays;

public class TriFusion {
	private int arr3[];

	public static void main(String args[]) {

		int arr1[] = {1, 4};
		int arr2[] = {2, 5};

		TriFusion tri_fusion  = new TriFusion();
		tri_fusion.fusion(arr1, arr2);
		tri_fusion.results();
	}

	private void create_arr3(int arr1[], int arr2[]) {
		this.arr3 = new int[arr1.length+arr2.length];
		System.out.println("Array of size: "+this.arr3.length+ " created.");
	}

	public void fusion(int arr1[], int arr2[]) {
		create_arr3(arr1, arr2);
		System.out.println("Merge sort of: "+Arrays.toString(arr1)+" and "+Arrays.toString(arr2));
		int i = 0; // current element arr1
		int j = 0; // current element arr2
		int y = 0; // current element arr3

		while (i<arr1.length && j<arr2.length) {
			int min = min(arr1[i], arr2[j]);
			this.arr3[y] = min;
			y++;
			if(min == arr1[i]) {i++;}
			if(min == arr2[j]) {j++;}
		}

		while (i<arr1.length) {
			this.arr3[y] = arr1[i];
			y++;
			i++;
		}

		while (j<arr2.length) {
			this.arr3[y] = arr2[j];
			y++;
			j++;
		}
	}

	private int min(int a, int b) {
		return (a < b) ? a : b ;
	}

	public void results() {
		System.out.println(Arrays.toString(this.arr3));
	}
}
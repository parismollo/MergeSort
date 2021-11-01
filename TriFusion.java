import java.util.Arrays;

public class TriFusion {

	public static void main(String[] args) {

		int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		// System.out.println("copy_array(input): "+Arrays.toString(copy_array(input, 0, (input.length/2)-1)));
		TriFusion tf  = new TriFusion();
		int[] output = tf.triFusion(input);
		System.out.println("Input: "+Arrays.toString(input));
		System.out.println("Output: "+Arrays.toString(output));

	}

	private int[] create_arr3(int[] arr1, int[] arr2) {
 		return new int[arr1.length+arr2.length];
	}

	private int[] fusion(int[] arr1, int[] arr2) {
		int[] arr3 = create_arr3(arr1, arr2);
		// System.out.println("Merge of: "+Arrays.toString(arr1)+" and "+Arrays.toString(arr2));
		int i = 0; // current element arr1
		int j = 0; // current element arr2
		int y = 0; // current element arr3

		while (i<arr1.length && j<arr2.length) {
			int min = min(arr1[i], arr2[j]);
			arr3[y] = min;
			y++;
			if(min == arr1[i]) {i++;}
			if(min == arr2[j]) {j++;}
		}

		while (i<arr1.length) {
			arr3[y] = arr1[i];
			y++;
			i++;
		}

		while (j<arr2.length) {
			arr3[y] = arr2[j];
			y++;
			j++;
		}
		return arr3;
	}

	public int[] triFusion(int[] arr) {
		int n = arr.length - 1;
		if (arr.length == 1) {return arr;}

		int[] arr1 = copy_array(arr, 0, n/2);
		int[] arr2 = copy_array(arr, (n/2) + 1, n);

		arr1 = triFusion(arr1);
		arr2 = triFusion(arr2);

		return fusion(arr1, arr2);
	}

	private int min(int a, int b) {
		return (a < b) ? a : b ;
	}

	private int[] copy_array(int[] array, int start, int end) {
		// array = [10, 5, 20, 3], start = 0, end = 1
		// copy_array(array, 0, 1) -> [10, 5]
		int[] res = new int[(end-start) + 1];
		int pointer = start;
		for(int i = 0; i < res.length; i++) {
			res[i] = array[pointer];
			pointer++;
		}
		return res;
	}
}
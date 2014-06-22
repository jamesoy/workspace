package amazon;

// start: 2:13pm
// end:   3:12pm

// complexity: worst-case: O(n)
// scan the input array twice
// first time to get all product and check 0 count
// second time to generate output array

// assumptions:
// all product <= 2^32 - 1

/* test results:
[4, 3, 2, 8]
[48, 64, 96, 24]

[8]
[8]

[]
[]

[]
[]

[1, 2, 3, 4, 5, 6, 7, 8]
[40320, 20160, 13440, 10080, 8064, 6720, 5760, 5040]

[1, 2, 3, 0, 5, 6, 7, 8]
[0, 0, 0, 10080, 0, 0, 0, 0]

[1, 2, 3, 0, 5, 6, 0, 8]
[0, 0, 0, 0, 0, 0, 0, 0]
 */

public class ProductsofanArray {

	
	private int[] produce(final int[] in) {
		if (null == in || in.length == 0) {
			return null;
		}

		// init output array
		int[] out = new int[in.length];

		if (in.length == 1) {
			out[0] = in[0];
			return out;
		}
		
		// get 0 count and handle in[]
		int count = 0;
		int firstIndex = 0;
		int productAll = 1;

		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				count++;
				if (count == 1) {
					firstIndex = i;
				}
			} else {
				productAll *= in[i];
			}
		}

		// two 0s
		if (count >= 2) {
			// return all 0s

		// one 0
		} else if (count == 1) {
			out[firstIndex] = productAll;

		// no 0
		} else {
		
			for (int i = 0; i < in.length; i++) {
				out[i] = productAll / in[i];
			}
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		ProductsofanArray poaa = new ProductsofanArray();
		
		// sample input from the question
		int[] in = new int[] {4, 3, 2, 8};
		poaa.print(in);
		int[] out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// 1 number in array
		in = new int[] {8};
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// array is empty
		in = new int[0];
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// array is null
		in = null;
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// another happy path test case
		in = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// one 0 in the input array
		in = new int[] {1, 2, 3, 0, 5, 6, 7, 8};
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();

		// more than one 0s in the input array
		in = new int[] {1, 2, 3, 0, 5, 6, 0, 8};
		poaa.print(in);
		out = poaa.produce(in);
		poaa.print(out);
		System.out.println();
	}

	private void print(int[] arr) {
		if (null == arr || arr.length == 0) {
			System.out.println("[]");
			return;
		}
		
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i]);
			System.out.print(", ");
		}
		System.out.print(arr[arr.length - 1]);
		System.out.println("]");
	}
}

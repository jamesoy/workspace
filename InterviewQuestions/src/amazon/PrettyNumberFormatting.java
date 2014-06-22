package amazon;

// start: 3:10pm
// end:   4:10pm
// during a meeting, not 100% working on this...

// complexity: O(1)

// assumptions:
// input string is in '###B' format
// input has no leading 0
// input is less or equal to 1G

/* results:

341B = 341B
12B = 12B
1B = 1B
B = Invalid input number

34000B = 34K
34200B = 34.2K
342000B = 342K
54123B = 54.1K

5910000B = 5.91M
7200000B = 7.2M

1000000000B = 1G
1100000000B = Input number is greater than 1G
 */

public class PrettyNumberFormatting {

	private String format(final String in) {
		String out = null;
		
		if (null == in) {
			return null;
		}
		
		System.out.print(in + " = ");
		
		int len = in.length();
		int size;
		StringBuffer sb = new StringBuffer();

		if (len > 11) {
			out = "Input number is greater than 1G";
		
		// format G
		} else if (len == 11) {
			if ('0' != in.charAt(1) || '0' != in.charAt(2) || '1' != in.charAt(0)) {
				return "Input number is greater than 1G";
			}
			out = "1G";
		
		// format M
		} else if (len >= 8) {
			size = len - 7;
			build(in, size, sb);
			out = removeTrailing0(sb.toString()) + "M";
			
		// format K
		} else if (len >= 5) {
			size = len - 4;
			build(in, size, sb);
			out = removeTrailing0(sb.toString()) + "K";
			
		// format B
		} else if (len >= 2) {
			out = in;
			
		// input string is too short
		} else {
			out = "Invalid input number";
		}
		
		return out;
	}

	private void build(String in, int size, StringBuffer sb) {
		sb.append(in.substring(0, size));
		sb.append('.');
		sb.append(in.substring(size, 3));
	}
	
	private String removeTrailing0(String in) {

		if (null != in ) {
			if ('0' == in.charAt(in.length() - 1) || '.' == in.charAt(in.length() - 1)) {
				return removeTrailing0(in.substring(0, in.length() - 1));
			}
		}
		
		return in;
	}

	public static void main(String[] args) {
		PrettyNumberFormatting pnf = new PrettyNumberFormatting();
		
		System.out.println(pnf.format("341B"));
		System.out.println(pnf.format("12B"));
		System.out.println(pnf.format("1B"));
		System.out.println(pnf.format("B"));
		System.out.println();
		
		System.out.println(pnf.format("34000B"));
		System.out.println(pnf.format("34200B"));
		System.out.println(pnf.format("342000B"));
		System.out.println(pnf.format("54123B"));
		System.out.println();

		System.out.println(pnf.format("5910000B"));
		System.out.println(pnf.format("7200000B"));
		System.out.println();

		System.out.println(pnf.format("1000000000B"));
		System.out.println(pnf.format("1100000000B"));
	}

}

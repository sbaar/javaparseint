//Submission for Moebius. The only change from Integer.parseInt is that this submission has clearer error messages.
public class Main{
	public static int parseInt(String str) throws NumberFormatException{
		if (str == null)
			throw new NumberFormatException("Cannot parse a null string to Int");
		if (str.length() == 0)
			throw new NumberFormatException("Cannot parse an empty string to Int");
		//str = str.trim(); 	//Useful, but not supported by Integer.parseInt(s)
		//check for negative
		boolean neg = (str.charAt(0) == '-');
		if (neg && (str.length() == 1)) 
			throw new NumberFormatException("Can't parse string " + str+ " to Int");
		String numbers = neg ? str.substring(1) : str;
		int max = neg ? Integer.MIN_VALUE  :Integer.MAX_VALUE * -1;
		int d;
		int sum = 0;
		
		//go through each digit
		for (char c : numbers.toCharArray()){
			d = Character.digit(c, 10);
			if (d < 0)
				throw new NumberFormatException
					("Digit " + c + " in string " +  str + " could not be parsed");
			sum *=10;
			if (sum < max + d)
				throw new NumberFormatException("Int overflow parsing string " + str);
			sum -=d;
		}
		return sum * (neg ? 1 : -1);
		
		
	
	}
	
	public static void main (String args[]) {
		System.out.println("parsing 12312 = " + parseInt("12312") + " actual: " +  Integer.parseInt("12312"));
		System.out.println("parsing -12 = " + parseInt("-12") + " actual: " +  Integer.parseInt("-12"));
		System.out.println("parsing -0023 = " + parseInt("-0023") + " actual: " +  Integer.parseInt("-0023"));
		System.out.println("parsing -2^31 = -2147483648 = " + parseInt("-2147483648") + " actual: " +  Integer.parseInt("-2147483648"));
		System.out.println("parsing 2^31 - 1  =2147483647 = " + parseInt("2147483647") + " actual: " +  Integer.parseInt("2147483647"));
		
		try {System.out.println("parsing -2147483649 = " + parseInt("-2147483649"));}
		catch (Exception e) {System.out.println(e.getMessage());}
		
		try {System.out.println("parsing 2147483648 = " + parseInt("2147483648"));}
		catch (Exception e) {System.out.println(e.getMessage());}
		
		try {System.out.println("parsing -01A23 = " + parseInt("-01A23"));}
			catch (Exception e) {System.out.println(e.getMessage());}
		
		try {System.out.println("parsing - = " + parseInt("-"));}
		catch (Exception e) {System.out.println(e.getMessage());}
		
		try {System.out.println("parsing x213 = " + parseInt("x213"));}
		catch (Exception e) {System.out.println(e.getMessage());}

		
		
	}
}
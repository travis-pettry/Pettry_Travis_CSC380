

public class MathLogic {

	public MathLogic() {
		
	}
	
	public synchronized int add(int num1, int num2){
		return num1 + num2;
	}
	
	public synchronized int subtract(int num1, int num2){
		return num1 - num2;
	}
	
	public synchronized double addDouble(double num1, double num2){
		return num1 + num2;
	}
	
	public synchronized int add(int...is){
		int result = 0;
		for(int d : is){
			result += d;
		}
		return result;
	}
	
	public synchronized float add(float...is){
		float result = 0;
		for(float d : is){
			result += d;
		}
		return result;
	}
	
	public synchronized long add(long...is){
		long result = 0;
		for(long d : is){
			result += d;
		}
		return result;
	}
	
	public synchronized String print(String[] is){
		String result = "";
		for(String d : (String[])is){
			result += d + "\t";
		}
		return result;
	}
	
	public synchronized String print(String is){		
		return is;
	}
		
	public synchronized String print(boolean[] is){
		String result = "";
		for(boolean d : is){
			if(d == true){
				result += "true,";
			}
			else{
				result += "false,";
			}
		}
		return result;
	}
	
	public synchronized String print(char[] is){
		String result = "";
		for(char d : is){
			result += d + ",";
		}
		return result;
	}

}

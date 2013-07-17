
public class Str {
	
	public String r;
	public String t;

	public Str(String r, String t) {
		this.r = r;
		this.t = t;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	@Override
	public String toString(){
		return r +  " " + t;
	}

}

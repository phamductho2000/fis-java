package fis.java;

public class AnTiemFamily {
	private int hp;
	private int d;
	private int s;
	private String t;
	
	
	private int p1;
	private int p2;
	
	public AnTiemFamily() {
		super();
	}

	public AnTiemFamily(int hp, int d, int s, String t) {
		super();
		this.hp = hp;
		this.d = d;
		this.s = s;
		this.t = t;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	
	//Tinh g(s) trong truong hop 2 
	public double caculateGsCase2() {
		if(s % 6 == 0) {
			return s/2;
		}
		else if(s % 6 == 1) {
			return s*2;
		}
		else if(s % 6 == 2) {
			return Math.pow(-(s % 9), 3) / 5;
		}
		else if(s % 6 == 3) {
			return Math.pow(-(s % 30), 2) + 3*s;
		}
		else if(s % 6 == 4) {
			return -s;
		}
		else {
			return -Util.findTriangularNumber((s % 5) + 5);
		}
	}
	
	//Tinh p(t) trong truong hop 2 
	public double caculatePtCase2() {
		if(t.toUpperCase().equals(EnumWeather.FLOOD.toString())) {
			if(s % 6 == 0) {
				return -0.1;
			}
			else if(s % 6 == 1) {
				return -0.15;
			}
			else if(s % 6 == 2) {
				return -0.2;
			}
			else if(s % 6 == 3) {
				return -0.25;
			}
			else if(s % 6 == 4) {
				return -0.5;
			}
			else {
				return 0;
			}
		}
		
		else if(t.toUpperCase().equals(EnumWeather.STORM.toString())) {
			if(s % 6 == 0) {
				return -0.05;
			}
			else if(s % 6 == 1) {
				return -0.1;
			}
			else if(s % 6 == 2) {
				return -0.15;
			}
			else if(s % 6 == 3) {
				return -0.2;
			}
			else if(s % 6 == 4) {
				return 0;
			}
			else {
				return 0.05;
			}
		}
		
		else if(t.toUpperCase().equals(EnumWeather.RAIN.toString())) {
			if(s % 6 == 0) {
				return 0;
			}
			else if(s % 6 == 1) {
				return -0.05;
			}
			else if(s % 6 == 2) {
				return -0.1;
			}
			else if(s % 6 == 3) {
				return -0.15;
			}
			else if(s % 6 == 4) {
				return 0.05;
			}
			else {
				return 0.1;
			}
		}
		
		else if(t.toUpperCase().equals(EnumWeather.SHOWER.toString())) {
			if(s % 6 == 0) {
				return 0.05;
			}
			else if(s % 6 == 1) {
				return 0;
			}
			else if(s % 6 == 2) {
				return -0.05;
			}
			else if(s % 6 == 3) {
				return -0.1;
			}
			else if(s % 6 == 4) {
				return 0.1;
			}
			else {
				return 0.15;
			}
		}
		
		else if(t.toLowerCase().equals(EnumWeather.DRIZZLE.toString())) {
			if(s % 6 == 0) {
				return 0.1;
			}
			else if(s % 6 == 1) {
				return 0.05;
			}
			else if(s % 6 == 2) {
				return 0;
			}
			else if(s % 6 == 3) {
				return -0.05;
			}
			else if(s % 6 == 4) {
				return 0.15;
			}
			else {
				return 0.2;
			}
		}
		
		else {
			if(s % 6 == 0) {
				return 0.15;
			}
			else if(s % 6 == 1) {
				return 0.1;
			}
			else if(s % 6 == 2) {
				return 0.05;
			}
			else if(s % 6 == 3) {
				return 0;
			}
			else if(s % 6 == 4) {
				return 0.2;
			}
			else {
				return 0.25;
			}
		}
	}
	
	//Tinh xac suat bi ran can
	public void caculateProbabilityOfSnakeBite() {
		caculateP1AndP2();
		double pOfSnakeBite = (d + p1 + p2) / 1000d;
		if(pOfSnakeBite > 0.6 && pOfSnakeBite <= 0.8) {
			hp = hp - 50;
		} 
		else if(pOfSnakeBite > 0.4 && pOfSnakeBite <= 0.6) {
			hp = hp - 30;
		}
		else if(pOfSnakeBite > 0.2 && pOfSnakeBite <= 0.4) {
			hp = hp - 30;
		}
	}
	
	//Tinh gia tri p1 va p2
	public void caculateP1AndP2() {
		if(Util.isPrimeNumber(hp)) {
			p1 = 1000;
			p2 = (hp + s) % 1000;
		} else {
			p1 = hp;
			p2 = (hp + d) % 100;
		}
	}
	
	//Tinh gia tri ham f(d,s,t)
	public double caculateF() {
		if(d < 200 ) {
			caculateP1AndP2();
			if(!Util.checkfibonacci(d + s)) {
				return 0;
			}
			return (40 - (Math.abs(d - 500) / 20) + caculateGsCase2()) * (1 + caculatePtCase2());
		}
		
		if(d >= 200 && d <= 300) {
			caculateProbabilityOfSnakeBite();
			caculateP1AndP2();
			return (40 - (Math.abs(d - 500) / 20) + caculateGsCase2()) * (1 + caculatePtCase2());
		}
		
		if(d >= 200 && d <= 800) {
			caculateP1AndP2();
			return (40 - (Math.abs(d - 500) / 20) + caculateGsCase2()) * (1 + caculatePtCase2());
		}
		
		//Truong hop d > 800
		caculateP1AndP2();
		return (-d * s) / 1000d;
	}
	
	// Tinh xac suat sinh ton
	public double caculatePOfSurvival() {
		double f = caculateF();
		return (p1 + p2 * f) / (1000 + Math.abs(p2 * f));
	}
	
	
}

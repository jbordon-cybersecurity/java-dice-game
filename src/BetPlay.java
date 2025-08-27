
public class BetPlay {

	private String user;
	private String betType;
	private String result;
	private int numRounds;
	private int randomNumber;
	private int money;

	public BetPlay() {

	}

	public BetPlay(String user, int money, String betType, String result, int numRounds, int randomNumber) {
		this.user = user;
		this.money = money;
		this.betType = betType;
		this.result = result;
		this.numRounds = numRounds;
		this.randomNumber = randomNumber;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBetType() {
		return this.betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getNumRounds() {
		return this.numRounds;
	}

	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}

	public int getRandomNumber() {
		return this.randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}


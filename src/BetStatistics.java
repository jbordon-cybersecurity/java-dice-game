import java.util.ArrayList;
import java.util.List;

public class BetStatistics {

	private List<BetPlay> betList;

	public BetStatistics() {
		betList = new ArrayList<>();
	}  

	public void addBet(BetPlay betPlay) {
		betList.add(betPlay);
	}

	public List<BetPlay> getBetList() {
		return betList;
	}

	public String fullSummary() {
		StringBuilder text = new StringBuilder();
		text.append(" Player Summary Results \n");

		for (BetPlay bet : betList) {
			text.append(
					String.format("%d Round: %s . You played option: %s | £ %s  Credit / %s / Computer Rolled: %s \n",
							bet.getNumRounds(),
							bet.getUser(),
							bet.getBetType(),
							bet.getMoney(),
							bet.getResult(),
							bet.getRandomNumber()
							)
					);
		}

		return text.toString();
	}

}

package me.shuter.elo;

import java.util.ArrayList;
import java.util.List;

public class ELOGroup {
	private List<ELORank> group = new ArrayList<ELORank>();
	private double avgRank;
	
	public void addELOPlayer(ELORank player) {
		group.add(player);
	}
	
	public void calAvg() {
		double total = 0;
		for(ELORank rank : group) {
			total += rank.getRank();
		}
		
		this.avgRank = total / group.size();
	}

	public double getAvgRank() {
		return avgRank;
	}

	public void setAvgRank(double avgRank) {
		this.avgRank = avgRank;
	}

	public List<ELORank> getGroup() {
		return group;
	}
}

package me.shuter.elo;

import java.util.Random;

public class ELOTest {
	public static void main(String[] args) {
		System.out.println("ELO Test Begin");
		
		Random r = new Random(10);
		ELOGroup blue = new ELOGroup();
		for(int i = 0; i < 5; i++) {
			ELORank rank = new ELORank();
			rank.setRank(r.nextInt(100)+1000);
			
			blue.addELOPlayer(rank);
		}
		blue.calAvg();
		
		ELOGroup red = new ELOGroup();
		for(int i = 0; i < 5; i++) {
			ELORank rank = new ELORank();
			rank.setRank(r.nextInt(120)+1000);
			
			red.addELOPlayer(rank);
		}
		red.calAvg();
		
		//blue win
		for(ELORank rank : blue.getGroup()) {
			int s = ELOWorld.getInstance().normalWinScore(rank.getRank(), red.getAvgRank());
			System.out.println("Blue score = " + rank.getRank() + " winScore = " + s);
		}
		System.out.println("********************");
		//red lose
		for(ELORank rank : red.getGroup()) {
			int s = ELOWorld.getInstance().normalLoseScore(rank.getRank(), blue.getAvgRank());
			System.out.println("Red score = " + rank.getRank() + " loseScore = " + s);
		}
	}
}

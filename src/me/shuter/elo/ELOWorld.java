package me.shuter.elo;

/**
 * ELO system
 * https://en.wikipedia.org/wiki/Elo_rating_system
 */
public class ELOWorld {	
	private final int NORMAL_K = 32;
	private final int DEFAULT_POW_BASE = 10;
	private final double DEFAULT_DIVISOR = 400.0;
	private final double WIN = 1;
	private final double LOSE = 0;
	
	private static final ELOWorld ins = new ELOWorld();
	private ELOWorld() {}
	public static ELOWorld getInstance() {
		return ins;
	}

	/**
	 * 赢得分数
	 * ES为得分, SA 赢为 1 输为 0
	 * ES = K * (SA - EA)
	 * 
	 * @param scoreA
	 * @param scoreB
	 * @return
	 */
    public int normalWinScore(double scoreA, double scoreB) {
    	return (int)(NORMAL_K * (WIN - expect(scoreA, scoreB)));
    }
    
    /**
	 * 输掉分数
	 * ES为得分, SA 赢为 1 输为 0
	 * ES = K * (SA - EA)
	 * 
     * @param scoreA
     * @param scoreB
     * @return
     */
    public int normalLoseScore(double scoreA, double scoreB) {
    	return (int)(NORMAL_K * (LOSE - expect(scoreA, scoreB)));
    }
    
    /**
     * EA = QA / (QA + QB)
     * @param RA
     * @param RB
     * @return
     */
    private double expect(double RA, double RB) {
    	double qa = pow(RA);
    	double qb = pow(RB);
    	
    	return (qa / (qa + qb));
    }
    
    /**
     * Q = 10^(R / 400)
     * @param R
     * @return
     */
    private double pow(double R) {
    	return Math.pow(DEFAULT_POW_BASE, scoreRate(R));
    }
    
    /**
     * R / 400
     * @param R
     * @return
     */
    private double scoreRate(double R) {
    	return R / DEFAULT_DIVISOR;
    }
}

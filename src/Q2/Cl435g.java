package Q2;

// Daniel Szelogowski
// Q2.Prog435g
// 11/10/2022
public class Cl435g {
    private int myScore;
    private int myRank;

    public Cl435g(int score) {
        myScore = score;
        myRank = 0;
    }

    public int getScore() { return myScore; }
    public int getRank() { return myRank; }
    public void setRank(int rank) { myRank = rank; }
    public String toString() { return myScore + "\t\t" + myRank; }
}

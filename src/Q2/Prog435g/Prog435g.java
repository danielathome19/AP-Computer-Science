package Q2.Prog435g;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog435g {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog435g.dat"));
            int[] scores = new int[100];
            int count = 0;

            while (file.hasNext()) {
                int score = file.nextInt();
                scores[count] = score;
                count++;
                // scores[count++] = file.nextInt();
            }

            // Sort the scores (bubble sort)
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count-1; k++) {
                    if (scores[k] > scores[k+1]) {
                        int temp    = scores[k];
                        scores[k]   = scores[k+1];
                        scores[k+1] = temp;
                    }
                }
            }

            Cl435g[] golfers = new Cl435g[count];
            for (int lcv = 0; lcv < count; lcv++) {
                Cl435g cooldude = new Cl435g(scores[lcv]);
                golfers[lcv] = cooldude;
            }

            int rank = 1;
            for (int lcv = 0; lcv < count; lcv++) {
                golfers[lcv].setRank(rank);
                if (lcv < count-1 && scores[lcv] != scores[lcv+1])
                    rank++;
            }

            System.out.println("Score\tRank");
            for (int lcv = 0; lcv < count; lcv++)
                System.out.println(golfers[lcv].toString());

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
Score	Rank
66		1
68		2
68		2
69		3
70		4
70		4
70		4
70		4
71		5
72		6
72		6
72		6
73		7
74		8
75		9
75		9
75		9
76		10
76		10
77		11
77		11
78		12
80		13
81		14
82		15
86		16
87		17
88		18
88		18
88		18
90		19
*/
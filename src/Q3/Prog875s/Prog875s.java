package Q3.Prog875s;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog875s {
    public static void main(String[] args) {
        try {
            Scanner in1 = new Scanner(new File("data/h1-0homosapiens.fna"));
            Scanner in2 = new Scanner(new File("data/h1-0pantroglodytes.fna"));
            Scanner in3 = new Scanner(new File("data/h1-0musmusculus.fna"));

            // Primary assembly
            String humangene1 = in1.nextLine();
            String dna1 = "";
            String line = in1.nextLine();
            while (line.charAt(0) != '>') {
                dna1 += line;
                line = in1.nextLine();
            }

            // Alternate assembly
            String humangene2 = line;
            String dna2 = "";
            line = in1.nextLine();
            while (in1.hasNext()) {
                dna2 += line;
                line = in1.nextLine();
            }

            // Chimp assembly
            String chimpgene = in2.nextLine();
            String dnachimp = "";
            line = in2.nextLine();
            while (in2.hasNext()) {
                dnachimp += line;
                line = in2.nextLine();
            }

            // Mouse assembly
            String mousegene = in3.nextLine();
            String dnamouse = "";
            line = in3.nextLine();
            while (in3.hasNext()) {
                dnamouse += line;
                line = in3.nextLine();
            }

            Gene hprimary = new Gene(humangene1, dna1);
            Gene halternate = new Gene(humangene2, dna2);
            Gene mprimary = new Gene(mousegene, dnamouse);
            Gene cprimary = new Gene(chimpgene, dnachimp);

            int mismatchPenalty = 3;
            int gapPenalty = 2;

            // Align human genes
            System.out.println("Human primary/Human alternate");
            int hhp = hprimary.align(halternate, mismatchPenalty, gapPenalty);

            // Align human genes with chimp
            System.out.println("\nHuman primary/Chimp");
            int hcp = hprimary.align(cprimary, mismatchPenalty, gapPenalty);
            System.out.println("Human alternate/Chimp");
            int hca = halternate.align(cprimary, mismatchPenalty, gapPenalty);

            // Align human genes with mouse
            System.out.println("\nHuman primary/Mouse");
            int hmp = hprimary.align(mprimary, mismatchPenalty, gapPenalty);
            System.out.println("Human alternate/Mouse");
            int hma = halternate.align(mprimary, mismatchPenalty, gapPenalty);

            // Report closest match
            String[] pairings = {"Human-Primary/Chimp", "Human-Alternate/Chimp",
                                 "Human-Primary/Mouse", "Human-Alternate/Mouse"};
            int[] scores = {hcp, hca, hmp, hma};

            int min = 0;
            for (int lcv = 0; lcv < scores.length; lcv++)
                if (scores[lcv] < scores[min]) min = lcv;
            System.out.println("\nThe best pairing is " + pairings[min] +
                               " with a score of " + scores[min]);

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}

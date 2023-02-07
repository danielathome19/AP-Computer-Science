package Q3.Prog875s;

public class Gene extends Fasta {
    private String organism;
    private String geneName;
    private String geneID;
    private String description;

    public Gene(String header, String sequence) {
        super(header, sequence);
        String[] headerParts = header.split(" ");
        geneID = headerParts[0];
        geneName = headerParts[1];
        organism = headerParts[2];
        organism = organism.substring(organism.indexOf("=")+1, organism.length()-1);
        description = headerParts[3];
    }

    public boolean compare(Gene other) { return super.compare(other); }
    public String toString() {
        return geneID + " " + geneName + " " + organism + " " + description;
    }

    public int align(Gene other, int mismatchPenalty, int gapPenalty) {
        // Needleman-Wunsch algorithm
        // Initialize matrix; clamp to shorter sequence
        int len = Math.min(this.getSequence().length(), other.getSequence().length()) + 1;
        int[][] matrix = new int[len][len];

        // Initialize first row and col
        for (int lcv = 0; lcv < matrix.length; lcv++) {
            matrix[lcv][0] = lcv * gapPenalty;
            matrix[0][lcv] = lcv * gapPenalty;
        }

        int match = 0;
        int diag = 0;
        int left = 0;
        int up = 0;

        // Fill in the rest of the matrix
        for (int lcv = 1; lcv < matrix.length; lcv++) {
            for (int lcv2 = 1; lcv2 < matrix[lcv].length; lcv2++) {
                match = 0;
                if (!getSequence().substring(lcv-1,lcv).equals(
                        other.getSequence().substring(lcv2-1,lcv2)))
                    match = mismatchPenalty;
                diag = matrix[lcv-1][lcv2-1] + match;
                left = matrix[lcv][lcv2-1] + gapPenalty;
                up = matrix[lcv-1][lcv2] + gapPenalty;
                matrix[lcv][lcv2] = Math.min(diag, Math.min(left, up));
            }
        }

        // Traceback
        String alignment1 = "";
        String alignment2 = "";
        int i = matrix.length - 1;
        int j = matrix[0].length - 1;

        while (i > 0 && j > 0) {
            match = 0;
            if (!getSequence().substring(i-1,i).equals(other.getSequence().substring(j-1,j)))
                match = mismatchPenalty;
            diag = matrix[i-1][j-1] + match;
            left = matrix[i][j-1] + gapPenalty;
            up = matrix[i-1][j] + gapPenalty;

            if (matrix[i][j] == diag) {
                alignment1 = this.getSequence().substring(i-1,i) + alignment1;
                alignment2 = other.getSequence().substring(j-1,j) + alignment2;
                i--;
                j--;
            } else if (matrix[i][j] == left) {
                alignment1 = "_" + alignment1;
                alignment2 = other.getSequence().substring(j-1,j) + alignment2;
                j--;
            } else if (matrix[i][j] == up) {
                alignment1 = this.getSequence().substring(i-1,i) + alignment1;
                alignment2 = "_" + alignment2;
                i--;
            }
        }

        // Print alignment
        int score = matrix[matrix.length-1][matrix[0].length-1];
        System.out.println(this.organism + " gene " + this.geneID + ": \n\t" + alignment1);
        System.out.println(other.organism + " gene " + other.geneID + ": \n\t" + alignment2);
        System.out.println("Alignment score: " + score);
        return score;
    }
}

package Q3.Prog875s;

public class Fasta implements Sequence {
    private String header;
    private String sequence;

    public Fasta(String header, String sequence) {
        this.header = header;
        this.sequence = sequence;
    }

    public boolean compare(Fasta other) {
        return this.header.equals(other.getHeader()) &&
               this.sequence.equals(other.getSequence());
    }

    public String getHeader() { return header; }
    public String getSequence() { return sequence; }
}

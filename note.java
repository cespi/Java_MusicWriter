public class note {

    private int length;
    private char tone;

    public note(){
        length = 4;
        tone = 'r';
    }

    public note(int length, char tone){
        this.length = length;
        this.tone = tone;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTone(char tone) {
        this.tone = tone;
    }

    public int getLength() {
        return length;
    }

    public char getTone() {
        return tone;
    }
}

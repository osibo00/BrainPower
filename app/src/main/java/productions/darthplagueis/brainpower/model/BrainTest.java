package productions.darthplagueis.brainpower.model;

public class BrainTest {

    private int question;
    private boolean isSelected = false;

    public BrainTest(int question) {
        this.question = question;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

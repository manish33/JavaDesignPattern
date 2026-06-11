package LLDQuestions.SplitWiseMachineCoding.model;

public class ExpenseMetadata {
    private final String name;
    private final String imgUrl;
    private final String notes;

    public ExpenseMetadata(String name, String imgUrl, String notes) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.notes = notes;
    }

    public String getName() { return name; }
    public String getImgUrl() { return imgUrl; }
    public String getNotes() { return notes; }
}

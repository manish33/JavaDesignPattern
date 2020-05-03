package Behavioral.Momento;

public class Originator {
    private long id;
    private String title;
    private String content;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Originator(long id, String title,String content) {
        super();
        this.id = id;
        this.title = title;
        this.content=content;
    }

    //Setters and getters

    public Memento createMemento()
    {
        Memento m = new Memento(id, title, content);
        return m;
    }

    public void restore(Memento m) {
        this.id = m.getId();
        this.title = m.getTitle();
        this.content = m.getContent();
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}

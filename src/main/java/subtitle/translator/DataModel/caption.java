package subtitle.translator.DataModel;

public class caption {
    private final long id;
    private final String content;

    public caption(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

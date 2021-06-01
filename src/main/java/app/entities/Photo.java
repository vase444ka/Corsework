package app.entities;

public class Photo {
    public Photo(Yearbook yearbook, String filePath) {
        this.yearbook = yearbook;
        this.filePath = filePath;
    }

    public Photo(Yearbook yearbook, String filePath, boolean edited, boolean selected) {
        this.yearbook = yearbook;
        this.filePath = filePath;
        this.edited = edited;
        this.selected = selected;
    }

    public Yearbook getYearbook() {
        return yearbook;
    }

    public void setYearbook(Yearbook yearbook) {
        this.yearbook = yearbook;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    Yearbook yearbook;
    private String filePath;
    private boolean edited;
    private boolean selected;
}

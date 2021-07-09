package ImmutableObjects;

import java.util.Objects;

public class Faculty implements Cloneable {
    private final String title;
    private int studentsCount;

    public Faculty(String title, int studentsCount) {
        this.title = title;
        this.studentsCount = studentsCount;
    }

    public String getTitle() {
        return title;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void incrementStudentsCount(){
        studentsCount++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.hashCode() == obj.hashCode()) return true;
        if (obj instanceof Faculty){
            Faculty f = (Faculty) obj;
            if (this.hashCode() == f.hashCode()) {
                return f.studentsCount == this.studentsCount && f.title.equals(this.title);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return title.hashCode() / studentsCount;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Class isn`t implements interface Cloneable");
        }
    }
}

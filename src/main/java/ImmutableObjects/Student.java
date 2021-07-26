package ImmutableObjects;

public final class Student {
    private final String name;
    private final String group;
    private final int age;
    private final Faculty faculty;

    public Student(String name, String group, int age, Faculty faculty) {
        this.name = name;
        this.group = group;
        this.age = age;
        this.faculty = (Faculty) faculty.clone();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getAge() {
        return age;
    }

    public Faculty getFaculty() {
        return (Faculty) faculty.clone();
    }

    @Override
    public int hashCode() {
        return (name.hashCode() + group.hashCode() + faculty.hashCode()) / age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Student){
            Student s = (Student) obj;
            if (this.hashCode() == s.hashCode()) {
                return this.age == s.age && this.name.equals(s.name) && this.group.equals(s.group)
                        && this.faculty.equals(s.faculty);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

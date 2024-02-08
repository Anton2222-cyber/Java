package edu.itstep.hibernate.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "children_sections",
            joinColumns = @JoinColumn(name = "id_sections"),
            inverseJoinColumns = @JoinColumn(name = "id_children")
    )
    private List<Child> children = new ArrayList<>();

    public Section() {
    }

    public Section(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id && price == section.price && Objects.equals(name, section.name) && Objects.equals(children, section.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, children);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", children=" + children +
                '}';
    }

    public void addChild(Child child) {
        children.add(child);
    }
}

package dictionarySpring.model;

import javax.persistence.*;

@Entity
@Table(name = "dictline")
public class DictionaryLine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public DictionaryLine() {
    }

    public DictionaryLine(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

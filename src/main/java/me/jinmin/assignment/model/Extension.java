package me.jinmin.assignment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "extension_name")
    private String name;

    @Column(name = "custom")
    private Boolean custom;

    @Column(name = "checked")
    private Boolean checked;

    public Extension(String name, boolean custom) {
        this.name = name;
        this.custom = custom;
    }

    public Extension(String name, boolean custom, boolean checked) {
        this.name = name;
        this.custom = custom;
        this.checked = checked;
    }

    public static Extension makeCustomExtension(String name, boolean custom) {
        return new Extension(name, custom);
    }

    public static Extension saveFixedExtension(String name, boolean custom, boolean checked) {
        return new Extension(name, custom, checked);
    }

    public void convertCheckStatus() {
        if (checked) {
            checked = false;
        } else {
            checked = true;
        }
    }
}

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
    private boolean custom;

    @Column(name = "checked")
    private boolean checked;

    public Extension(String name, boolean custom, boolean checked) {
        this.name = name;
        this.custom = custom;
        this.checked = checked;
    }

    public Extension(String name, boolean custom) {
        this.name = name;
        this.custom = custom;
    }

    public static Extension makeCustomExtension(String name, boolean custom) {
        return new Extension(name, custom);
    }
}

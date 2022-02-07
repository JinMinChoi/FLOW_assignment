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

    @Column(name = "isCustom")
    private boolean is_custom;

    @Column(name = "isChecked")
    private boolean is_checked;

    public Extension(String name, boolean is_custom, boolean is_checked) {
        this.name = name;
        this.is_custom = is_custom;
        this.is_checked = is_checked;
    }

    public static Extension makeExtension(String name, boolean is_custom, boolean is_checked) {
        return new Extension(name, is_custom, is_checked);
    }
}

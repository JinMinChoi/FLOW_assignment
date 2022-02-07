package me.jinmin.assignment.repository;

import me.jinmin.assignment.model.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {

    Optional<Extension> findByName(String name);

    List<Extension> findByIsCustom(boolean isCustom);

    void deleteByNameAndIs_custom(String name, boolean isCustom);

}

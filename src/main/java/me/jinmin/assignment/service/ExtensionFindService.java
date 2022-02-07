package me.jinmin.assignment.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.exception.NotFoundFixedExtension;
import me.jinmin.assignment.model.Extension;
import me.jinmin.assignment.repository.ExtensionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionFindService {

    private final ExtensionRepository extensionRepository;

    @Transactional(readOnly = true)
    public Extension findById(Long id) {
        return extensionRepository.findById(id)
                .orElseThrow(() -> new NotFoundFixedExtension(String.format("FixedExtension is not found")));
    }

    @Transactional(readOnly = true)
    public Extension findByName(String name) {
        return extensionRepository.findByName(name)
                .orElseThrow(() -> new NotFoundFixedExtension(String.format("%s is not found", name)));
    }

    @Transactional(readOnly = true)
    public List<Extension> findByIsCustom() {
        return extensionRepository.findAllByCustom(true);
    }

    @Transactional
    public long countCustom(){
        return extensionRepository.countAllByCustom(true);
    }
}

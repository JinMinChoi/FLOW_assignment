package me.jinmin.assignment.service.fixedExtension;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.model.Extension;
import me.jinmin.assignment.repository.ExtensionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FixedExtensionStatusSaveService {

    private final ExtensionRepository extensionRepository;

    @Transactional
    public void saveStatus(List<String> fixedExtensions) {
        for (String fixedExtensionName : fixedExtensions) {
            if (extensionRepository.findByName(fixedExtensionName).isPresent()) {
                Extension extension = extensionRepository.findByName(fixedExtensionName).get();
                extension.convertCheckStatus();
            } else {
                Extension extension = Extension.saveFixedExtension(fixedExtensionName, false, true);
                extensionRepository.save(extension);
            }
        }
    }

}

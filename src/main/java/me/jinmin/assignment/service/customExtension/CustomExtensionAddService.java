package me.jinmin.assignment.service.customExtension;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.controller.dto.CustomExtensionAddRequest;
import me.jinmin.assignment.exception.AlreadyExistFixedExtensionException;
import me.jinmin.assignment.model.Extension;
import me.jinmin.assignment.repository.ExtensionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomExtensionAddService {

    private final ExtensionRepository extensionRepository;

    @Transactional
    public void addCustomExtension(CustomExtensionAddRequest customExtensionAddRequest) {
        checkAlreadyExistFixedExtension(customExtensionAddRequest.getName());
        Extension extension = Extension.makeExtension(
                customExtensionAddRequest.getName(),
                true,
                true);
        extensionRepository.save(extension);
    }

    private void checkAlreadyExistFixedExtension(String name) {
        if (extensionRepository.findByName(name).isPresent()) {
            throw new AlreadyExistFixedExtensionException(String.format("%s is already saved custom extension", name));
        }
    }
}

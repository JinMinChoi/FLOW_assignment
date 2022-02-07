package me.jinmin.assignment.service.customExtension;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.repository.ExtensionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomExtensionDeleteService {

    private final ExtensionRepository extensionRepository;

    @Transactional
    public void deleteCustomExtension(Long extensionId) {
        extensionRepository.deleteById(extensionId);
    }
}

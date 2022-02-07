package me.jinmin.assignment.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.controller.dto.CustomExtensionAddRequest;
import me.jinmin.assignment.model.Extension;
import me.jinmin.assignment.service.ExtensionFindService;
import me.jinmin.assignment.service.customExtension.CustomExtensionAddService;
import me.jinmin.assignment.service.customExtension.CustomExtensionDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CustomExtensionController {

    private final ExtensionFindService extensionFindService;
    private final CustomExtensionAddService customExtensionAddService;
    private final CustomExtensionDeleteService customExtensionDeleteService;

    @GetMapping("/list/custom")
    public String findCustomExtension(Model model) {
        List<Extension> customExtensions = extensionFindService.findByIsCustom();
        model.addAttribute("customExtensions", customExtensions);
        return "mainView";
    }

    @PostMapping("/write/custom")
    public String addCustomExtension(@ModelAttribute("extensionAddRequest") CustomExtensionAddRequest customExtensionAddRequest) {
        customExtensionAddService.addCustomExtension(customExtensionAddRequest);
        return "mainView";
    }

    @DeleteMapping("/cancel/custom/{id}")
    public String deleteCustomExtension(@PathVariable("id") Long id) {
        customExtensionDeleteService.deleteCustomExtension(id);
        return "mainView";
    }
}

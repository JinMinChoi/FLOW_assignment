package me.jinmin.assignment.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.controller.dto.CustomExtensionAddRequest;
import me.jinmin.assignment.service.customExtension.CustomExtensionAddService;
import me.jinmin.assignment.service.customExtension.CustomExtensionDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CustomExtensionController {

    private final CustomExtensionAddService customExtensionAddService;
    private final CustomExtensionDeleteService customExtensionDeleteService;

    @PostMapping("/write/custom")
    public String addCustomExtension(@ModelAttribute("customExtensionAddRequest") CustomExtensionAddRequest customExtensionAddRequest) {
        customExtensionAddService.addCustomExtension(customExtensionAddRequest);
        return "redirect:/list/custom";
    }

    @GetMapping("/cancel/custom/{id}")
    public String deleteCustomExtension(@PathVariable("id") Long id) {
        customExtensionDeleteService.deleteCustomExtension(id);
        return "redirect:/list/custom";
    }

}

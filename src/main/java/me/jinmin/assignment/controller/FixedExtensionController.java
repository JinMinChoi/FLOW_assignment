package me.jinmin.assignment.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.service.fixedExtension.FixedExtensionStatusSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class FixedExtensionController {

    private final FixedExtensionStatusSaveService fixedExtensionStatusSaveService;

    @PostMapping("/check/fixed")
    public String checkFixedExtension(@RequestParam List<String> fixedExtensions) {
        fixedExtensionStatusSaveService.saveStatus(fixedExtensions);
        return "redirect:/list";
    }


}

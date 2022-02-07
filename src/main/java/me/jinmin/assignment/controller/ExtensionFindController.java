package me.jinmin.assignment.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.assignment.controller.dto.CustomExtensionAddRequest;
import me.jinmin.assignment.exception.OverCustomExtensionCountException;
import me.jinmin.assignment.model.Extension;
import me.jinmin.assignment.service.ExtensionFindService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ExtensionFindController {

    private final ExtensionFindService extensionFindService;

    @GetMapping("/list")
    public String findAllExtension(Model model) {
        //fixed
        List<Extension> customAndCheckedExtensions = extensionFindService.findAllByCustomAndChecked(false, true);

        //custom
        List<Extension> customExtensions = extensionFindService.findAllByIsCustom(true);
        CustomExtensionAddRequest customExtensionAddRequest = new CustomExtensionAddRequest();

        long customExtensionCurCount = extensionFindService.countCustom();
        checkOverCustomExtensionCount(customExtensionCurCount);

        model.addAttribute("customExtensions", customExtensions);
        model.addAttribute("customExtensionAddRequest", customExtensionAddRequest);
        model.addAttribute("customExtensionCurCount", customExtensionCurCount);
        model.addAttribute("customAndCheckedExtensions", customAndCheckedExtensions);

        return "mainView";
    }

    private void checkOverCustomExtensionCount(long customExtensionCurCount) {
        if (customExtensionCurCount > 200) {
            throw new OverCustomExtensionCountException("custom extensions count is over 200");
        }
    }
}

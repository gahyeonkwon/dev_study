package medicine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.Material;
import medicine.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("/material/list")
    public String materialList(Model model) {

        List<Material> materials =  new ArrayList<>();
        materials = (List<Material>) materialService.findMaterials();
        model.addAttribute("materials", materials);

        return "material/materialList";
    }
}

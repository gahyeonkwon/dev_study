package medicine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.Material;
import medicine.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MaterialService {

    private final MaterialRepository materialRepository;

    public List<Material> findMaterials() {
        return materialRepository.findAll();
    }
}

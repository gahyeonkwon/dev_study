package medicine.repository;

import lombok.RequiredArgsConstructor;
import medicine.db.item.Material;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MaterialRepository {

    private final EntityManager em;

    public List<Material> findAll() {
        return em.createQuery("select i from Material i", Material.class).getResultList();
    }

}

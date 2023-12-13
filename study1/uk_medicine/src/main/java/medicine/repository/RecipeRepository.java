package medicine.repository;

import lombok.RequiredArgsConstructor;
import medicine.db.item.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.awt.*;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {
    private final EntityManager em;

}


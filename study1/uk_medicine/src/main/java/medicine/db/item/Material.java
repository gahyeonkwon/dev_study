package medicine.db.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "medi_material")
public class Material {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(name = "material_nm")
    private String name;

    private String comment;

}

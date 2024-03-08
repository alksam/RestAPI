package Exercise2;

import lombok.*;

@Getter
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@ToString

public class ProductDTO {
    int id;
     String name;
     double price;
     String category;



        public ProductDTO(int id, String name, double price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }
}

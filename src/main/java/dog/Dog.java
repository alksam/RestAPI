package dog;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Dog {
    int id;
    String name;
    int age;


    public Dog(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

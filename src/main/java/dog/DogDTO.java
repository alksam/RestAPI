package dog;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DogDTO {
    private int id;
    private String name;
    private String breed;
    private String gender;
    private int age;

    public DogDTO(int id, String name, String breed, String gender, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
    }
}
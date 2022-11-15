import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;  //Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
    protected final String surname;  //Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
    protected OptionalInt age; //возраст
    protected Optional<String> address;  //Текущий город жительства

    {
        age = OptionalInt.empty();
        address = Optional.empty();
    }
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = Optional.ofNullable(city);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return getAge();
    }

    public String getAddress() {
        return address.orElse("Неизвестен");
    }
    public boolean hasAge() {  //Возраст человека может быть неизвестен, в этом случае метод boolean hasAge()
        // должен вернуть false, иначе - true.
        return age.isPresent();  //если значение присутствует - вернет true
    }

    public void happyBirthday() { //Если возраст человека известен, то с момента создания объекта он может
        // быть изменён только увеличением на единицу
        if (hasAge() == true) {
//    age.getAsInt();//вернет значение
//            age.ifPresent(age -> age++);
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public boolean hasAddress() { //метод boolean hasAddress() должен вернуть true если адрес известен, иначе - false
        return address.isPresent();  //если значение присутствует - вернет true
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isEmpty() ? "Unknown" : age.getAsInt()) +
                ", address=" + getAddress() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAddress(getAddress())
                .setAge(1);
    }  //метод для получения полузаполненного билдера для ребёнка в класс Person
    // а именно: с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).
}
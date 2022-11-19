import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {

    private Optional<String> name;
    private Optional<String> surname;
    private OptionalInt age;
    private Optional<String> address;
//Каждый метод добавления данных в билдер должен возвращать самого себя чтобы можно было сделать

    public PersonBuilder() {
        name = Optional.empty();
        surname = Optional.empty();
        age = OptionalInt.empty();
        address = Optional.empty();
    }

    public PersonBuilder setName(String name) {
        this.name = Optional.ofNullable(name);
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = Optional.ofNullable(surname);
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст некорректен"); //выкидываем ошибку
//            System.out.println("IllegalArgumentException - Возраст некорректен");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = Optional.ofNullable(address);
        return this;
    }

    public Person build() {  // возвращающий объект класса Person с указанными билдеру данными
//        if (name.isEmpty() || surname.isEmpty()) {
//            throw new IllegalStateException("Ошибка! Необходимо ввести имя и фамилию"); //ловим ошибку
//        }
//        Person person;
//        if (age.isEmpty()) {
//            person = new Person(name.get(), surname.get());
//        } else {
//            person = new Person(name.get(), surname.get(), age.getAsInt());
//        }
//        return person;

        Person person = null;
        try {
            if (age.isEmpty()) {
                person = new Person(name.get(), surname.get());
            } else {
                person = new Person(name.get(), surname.get(), age.getAsInt());
            }
        } catch (IllegalStateException e){
            if (name.isEmpty() || surname.isEmpty()) {
                System.out.println("Ошибка! Необходимо ввести имя и фамилию!");//выкидываем ошибку
            }
        }
        return person;
    }
}

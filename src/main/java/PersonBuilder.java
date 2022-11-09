import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;
//Каждый метод добавления данных в билдер должен возвращать самого себя чтобы можно было сделать
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(OptionalInt age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {  // возвращающий объект класса Person с указанными билдеру данными
        try {
            if (name != null && surname != null && age != null) {
                return new Person(name, surname, age.getAsInt()); //getAsInt-Если в этом присутствует значение OptionalInt, возвращает значение
            }
        } catch (IllegalStateException e) { //сли мы билдеру не указали достаточное количество данных (например, не указали фамилию), то метод build() должен выкинуть IllegalStateException с осмысленным сообщением.
            if (surname == null) {
                System.out.println("Ошибка - не указана фамилия");
            }
        } catch (IllegalArgumentException e) {  //Если же мы передали неподходящие данные билдеру (например, некорректный возрст builder.setAge(-100)), то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением.
            if (age.equals(-100)) {  //Указывает, является ли какой-либо другой объект "равным" этому OptionalInt .
                System.out.println("Ошибка - не верно указан возраст");
            }
        }
        return new Person(name, surname, age.getAsInt());
    }
}

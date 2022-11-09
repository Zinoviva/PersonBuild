import java.util.OptionalInt;

public class Person {
    protected final String name;  //Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
    protected final String surname;  //Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
    protected int age; //возраст
    protected String address;  //Текущий город жительства

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {  //Возраст человека может быть неизвестен, в этом случае метод boolean hasAge()
        // должен вернуть false, иначе - true.
//        return age.isPresent();  //если значение присутствует - вернет true
        return age != 0;
    }

    public void happyBirthday() { //Если возраст человека известен, то с момента создания объекта он может
        // быть изменён только увеличением на единицу
        if (hasAge() == true) {
//    age.getAsInt();//вернет значение
//            age.ifPresent(age -> age++);
            age++;
        }
    }

    public boolean hasAddress() { //метод boolean hasAddress() должен вернуть true если адрес известен, иначе - false
        return address != null;
    }

    public void setAddress(String address) {  //выставлен в любой адрес через setAddress
        if (hasAddress() == false) {
            this.address = address;
        }
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
        return address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public int hashCode() {
        return age;
    }

    public PersonBuilder newChildBuilder() {
return null;
    }  //метод для получения полузаполненного билдера для ребёнка в класс Person
    // а именно: с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).
}
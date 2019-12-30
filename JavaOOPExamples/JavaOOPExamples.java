abstract class Animal {

    private String speciesName = "Dog";

    public Animal(String name) {
        if (name.equals("")) {
            System.out.println("The species name cannot be empty. The name was not set.");
        } else {
            speciesName = name;
        }
    }

    public Animal() {
        System.out.println("Called the parameter-less constructor from Animal class. ");
    }

    public String getSpeciesName() {
        return speciesName;
    }

    abstract String speak();
}

class Person extends Animal {

    private String name = "Johnny Appleseed";
    private int age = 20;

    public Person(String nameInput, int ageInput) {
        super("Human");
        setName(nameInput);
        setAge(ageInput);
    }

    public Person() {
        System.out.println("Called the parameter-less constructor from Person class. ");
    }

    public void setName(String nameInput) {
        if (nameInput.equals("")) {
            System.out.println("The name cannot be empty. The name was not set.");
        } else {
            name = nameInput;
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int ageInput) {
        if (ageInput >= 0 && ageInput <= 125) {
            age = ageInput;
        } else {
            System.out.println("The age given is not a reasonable age for a person. The age was not set.");
        }
    }

    public void setAge() {
        age++;
        if (age > 125) {
            System.out.println("The age was incremented and is no longer a valid age for a person.");
            age = 125;
        }
    }

    public int getAge() {
        return age;
    }

    public String speak() {
        return "Hello! My name is " + getName() + " and I am " + getAge() + " years old. ";
    }
}

class Teenager extends Person {

    /* This constructor demonstrates run-time polymorphism. Since the method setAge
     * was overridden in this class, when the parent constructor is called and the
     * setAge method is called from there, it calls the Teenager setAge method
     * (since it was overridden in this class), which only allows ages 13 to 19. */
    public Teenager(String name, int age) {
        super(name, age);

        /*We know that if the age is not reasonable, then it was not set,
        * and it will default to 20 years old, which is still not reasonable for a teen.
        * Therefore, we can check if the age is reasonable, and if it is not,
        * then we can set it to a default age of 15, which is reasonable. */
        if (!isReasonableAge(age)) {
            setAge(15);
        }
    }

    public Teenager() {
        System.out.println("Called the parameter-less constructor from Teenager class. ");

        //Must set the age to something reasonable (see description from above constructor)
        setAge(15);
    }

    private static boolean isReasonableAge(int age) {
        return age >= 13 && age <= 19;
    }

    public void setAge(int ageInput) {
        if (isReasonableAge(ageInput)) {
            super.setAge(ageInput);
        } else {
            System.out.println("The age given is not reasonable for a teenager. The age was not set.");
        }
    }

    public void setAge() {
        super.setAge();
        if (getAge() > 19) {
            System.out.println("The age was incremented and is no longer a valid age for a person.");
            setAge(19);
        }
    }

    public String speak() {
        return super.speak() + "I am a teenager. ";
    }
}

class Child extends Person {
    // This constructor automatically calls super()
    Child() {}

    //You must use super here
    Child(String name, int age) {
        super(name, age);
    }

    public void setAge(int ageInput) {
        if (ageInput >= 0 && ageInput <= 12) {
            super.setAge(ageInput);
        } else {
            System.out.println("The given age is not valid for a child. The age was not set. ");
        }
    }
}

public class JavaOOPExamples {
    public static void main(String[] args) {
        /* This demonstrates the use of encapsulation - it doesn't allow a blank name.
         * In addition, this prints the speak method from the Person class,
         * which had to be implemented because of abstraction rules. */
        Person person = new Person("James Smith", 30);
        System.out.println("Successful constructor at line 149. ");
        System.out.print("setName output from line 152: ");
        person.setName("");
        System.out.println("person's name (line 153): " + person.getName());
        System.out.println("person speaking (line 154): " + person.speak());
        System.out.println();

        /* This shows that all superclass constructors are called (by default) */
        System.out.println("Constructor output from line 159 (next 2 lines): ");
        Person otherPerson = new Person();
        System.out.println("Constructor output from line 161 (next 3 lines): ");
        otherPerson = new Teenager();
        System.out.println("Constructor output from line 163 (next 3 lines): ");
        otherPerson = new Child();
        System.out.println();

        /* This shows that the constructor saw that the input values were invalid
         * and did set the variables to these values. It also shows that default
         * values were used so that name and age would have some value. */
        System.out.println("Constructor output from line 170 (next 2 lines of output): ");
        Person badPerson = new Person("", -30);
        System.out.println("badPerson's age (line 171): " + badPerson.getAge());
        System.out.println("badPerson's name (line 172): " + badPerson.getName());
        System.out.println();

        /* This shows that the Teenager class does not allow the age to be set to 20,
         * since that is not a valid age for a teenager. It would have been allowed
         * in the Person class, but not for the Teenager class. This demonstrates
         * encapsulation and inheritance (because of the use of methods from the
         * superclass). */
        Teenager teen = new Teenager("Some Body", 17);
        System.out.println("Successful constructor at line 180. ");
        System.out.print("setAge output from line 183: ");
        teen.setAge(20);
        System.out.println("teen's age (line 184): " + teen.getAge());
        System.out.println();

        /* This shows that there are default values for the Teenager class that are
         * different from the person class. Since 20 cannot be a default value for
         * a teenager, it provides a different value (see the constructor). The name
         * default is the same as the one in the Person class. This also is an example
         * of run-time polymorphism. */
        System.out.println("Constructor output from line 193 (next 2 lines of output): ");
        Teenager badTeen = new Teenager("", 10);
        System.out.println("badTeen's age (line 194): " + badTeen.getAge());
        System.out.println("badTeen's name (line 195): " + badTeen.getName());
        System.out.println();

        /* This shows the use of overloaded methods (compile-time polymorphism).
         * They do different things because of different parameter lists (and
         * different implementations of the method being done). */
        Teenager otherTeen = new Teenager("Some One", 13);
        System.out.println("Successful constructor at line 201. ");
        otherTeen.setAge(16);
        System.out.println("otherTeen's age (line 204): " + otherTeen.getAge());
        otherTeen.setAge();
        System.out.println("otherTeen's new age (line 206): " + otherTeen.getAge());
        System.out.println();

        /* This shows the use of run-time polymorphism (overridden methods).
         * The methods do different things based on the reference. When
         * anotherPerson refers to a new Person, setAge allows the age to be set to
         * 30 years old. However, the setAge method from the Teenager and Child classes
         * do now allow the age to be set to 30 years old, as they only allow ages
         * within their ranges to be set. Also, the speak method does different
         * things for Teenagers and Persons. */
        Person anotherPerson = new Person("A Person", 40);
        System.out.println("Successful constructor at line 216.");
        System.out.println("Age of anotherPerson (line 218):" + anotherPerson.getAge());
        System.out.print("setAge output from Teenager constructor at line 220: ");
        anotherPerson = new Teenager("A Teenager", 40);
        anotherPerson.setAge(15);
        System.out.println("Successful setAge at line 221. ");
        System.out.print("setAge output from Child constructor at line 224: ");
        anotherPerson = new Child("A Child", 40);
        System.out.print("setAge output at line 226: ");
        anotherPerson.setAge(15);
        anotherPerson.setAge(10);
        System.out.println("Successful setAge at line 227. ");
        anotherPerson = new Person("New Person", 40);
        System.out.println("anotherPerson speaks (line 230): " + anotherPerson.speak());
        anotherPerson = new Teenager("New Teenager", 15);
        System.out.println("anotherPerson speaks again (line 232): " + anotherPerson.speak());
        System.out.println();

        /* This combines several concepts into one block. It demonstrates run-time
         * polymorphism (see the appropriate constructor and the description).
         * In addition to this, it highlights that one can do:
         * Superclass name = new Subclass(parameters);. This is useful if one
         * wants to make it a new Superclass later on (one would not have to
         * make a new reference). The downside is shown in the next block... */
        System.out.print("Constructor output from line 242: ");
        Person interestingPerson = new Teenager("Average Joe",  10);
        System.out.print("setAge output from line 244: ");
        interestingPerson.setAge(20);
        System.out.println("interestingPerson's age (line 245): " + interestingPerson.getAge());
        interestingPerson.setAge(13);
        System.out.println("interestingPerson's new age (line 247): " + interestingPerson.getAge());
        interestingPerson = new Person("Other Joe", 30);
        System.out.println("Successful constructor at line 248. ");
        System.out.println("interestingPerson's newer age (line 250): " + interestingPerson.getAge());
        System.out.println();

        /* A downside to using that syntax is that all methods used by that reference
         * must be in the superclass. Since the setAge method is not in the Animal class,
         * the reference must be casted (as shown) to the type Person before using the
         * method (Java will not compile the code otherwise because it won't be able to
         * find the method). However, for the getSpeciesName method, one does not have
         * to cast because the method is in the superclass and is inherited by the
         * subclass. One does not have to cast for the speak method because it is present
         * in both classes (despite the fact that it is abstract in Animal). */
        Animal interestingThing = new Person("First Last", 40);
        System.out.println("Successful constructor at line 261. ");
        ((Person)interestingThing).setAge(20);
        System.out.println("interestingThing's age (line 264): " + ((Person)interestingThing).getAge());
        System.out.println("interestingThing's species (line 265): " + interestingThing.getSpeciesName());
        System.out.println("interestingThing speaks (line 266): " + interestingThing.speak());
        System.out.println();
    }
}

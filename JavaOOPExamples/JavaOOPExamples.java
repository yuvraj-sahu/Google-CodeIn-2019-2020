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

public class JavaOOPExamples {
    public static void main(String[] args) {

        /* This demonstrates the use of encapsulation - it doesn't allow a blank name.
         * In addition, this prints the speak method from the Person class,
         * which had to be implemented because of abstraction rules. */
        Person person = new Person("James Smith", 30);
        System.out.println("Successful constructor at line 128. ");
        System.out.print("setName output from line 131: ");
        person.setName("");
        System.out.println("person's name (line 132): " + person.getName());
        System.out.println("person speaking (line 133): " + person.speak());
        System.out.println();

        /* This shows that all superclass constructors are called (by default) */
        System.out.println("Constructor output from line 138 (next 2 lines): ");
        Person otherPerson = new Person();
        System.out.println("Constructor output from line 140 (next 3 lines): ");
        otherPerson = new Teenager();
        System.out.println();

        /* This shows that the constructor saw that the input values were invalid
         * and did set the variables to these values. It also shows that default
         * values were used so that name and age would have some value. */
        System.out.println("Constructor output from line 147 (next 2 lines of output): ");
        Person badPerson = new Person("", -30);
        System.out.println("badPerson's age (line 148): " + badPerson.getAge());
        System.out.println("badPerson's name (line 149): " + badPerson.getName());
        System.out.println();

        /* This shows that the Teenager class does not allow the age to be set to 20,
         * since that is not a valid age for a teenager. It would have been allowed
         * in the Person class, but not for the Teenager class. This demonstrates
         * encapsulation and inheritance (because of the use of methods from the
         * superclass). */
        Teenager teen = new Teenager("Some Body", 17);
        System.out.println("Successful constructor at line 157. ");
        System.out.print("setAge output from line 160: ");
        teen.setAge(20);
        System.out.println("teen's age (line 161): " + teen.getAge());
        System.out.println();

        /* This shows that there are default values for the Teenager class that are
         * different from the person class. Since 20 cannot be a default value for
         * a teenager, it provides a different value (see the constructor). The name
         * default is the same as the one in the Person class. This also is an example
         * of run-time polymorphism. */
        System.out.println("Constructor output from line 170 (next 2 lines of output): ");
        Teenager badTeen = new Teenager("", 10);
        System.out.println("badTeen's age (line 171): " + badTeen.getAge());
        System.out.println("badTeen's name (line 172): " + badTeen.getName());
        System.out.println();

        /* This shows the use of overloaded methods (compile-time polymorphism).
         * They do different things because of different parameter lists (and
         * different implementations of the method being done). */
        Teenager otherTeen = new Teenager("Some One", 13);
        System.out.println("Successful constructor at line 178. ");
        otherTeen.setAge(16);
        System.out.println("otherTeen's age (line 181): " + otherTeen.getAge());
        otherTeen.setAge();
        System.out.println("otherTeen's new age (line 183): " + otherTeen.getAge());
        System.out.println();

        /* This combines several concepts into one block. It also highlights that
         * one can do: Superclass name = new Subclass(parameters);. This is useful
         * if one wants to make it a new Superclass later on (one would not have to
         * make a new reference). The downside is shown in the next block... */
        System.out.print("Constructor output from line 191: ");
        Person interestingPerson = new Teenager("Average Joe",  10);
        System.out.print("setAge output from line 193: ");
        interestingPerson.setAge(20);
        System.out.println("interestingPerson's age (line 194): " + interestingPerson.getAge());
        interestingPerson.setAge(13);
        System.out.println("interestingPerson's new age (line 196): " + interestingPerson.getAge());
        interestingPerson = new Person("Other Joe", 30);
        System.out.println("Successful constructor at line 197. ");
        System.out.println("interestingPerson's newer age (line 199): " + interestingPerson.getAge());
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
        System.out.println("Successful constructor at line 210. ");
        ((Person)interestingThing).setAge(20);
        System.out.println("interestingThing's age (line 213): " + ((Person)interestingThing).getAge());
        System.out.println("interestingThing's species (line 214): " + interestingThing.getSpeciesName());
        System.out.println("interestingThing speaks (line 215): " + interestingThing.speak());
    }
}

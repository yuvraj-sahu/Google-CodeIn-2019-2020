abstract class LivingThing {

    private String speciesName;

    LivingThing(String name) {
        if (name.equals("")) {
            System.out.println("The species name cannot be empty. The name was not set.");
        } else {
            speciesName = name;
        }
    }

    public String getSpeciesName() {
        return speciesName;
    }

    abstract String speak();
}

class Person extends LivingThing {

    private String name = "Johnny Appleseed";
    private int age = 20;

    public Person(String nameInput, int ageInput) {
        super("Human");
        setName(nameInput);
        setAge(ageInput);
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

    public String speak() {
        return super.speak() + "I am a teenager. ";
    }
}

public class JavaOOPExamples {
    public static void main(String[] args) {
        Person person = new Person("James Smith", 30);
        System.out.println("Successful constructor at line 93. ");
        System.out.print("setName output from line 96: ");
        person.setName("");
        System.out.println("person's name (line 97): " + person.getName());
        System.out.println("person speaking (line 98): " + person.speak());
        System.out.println();

        System.out.println("Constructor output from line 102 (next 2 lines of output): ");
        Person badPerson = new Person("", -30);
        System.out.println("badPerson's age (line 103): " + badPerson.getAge());
        System.out.println("badPerson's name (line 104): " + badPerson.getName());
        System.out.println();

        Teenager teen = new Teenager("Some Body", 17);
        System.out.println("Successful constructor at line 107. ");
        System.out.print("setAge output from line 110: ");
        teen.setAge(20);
        System.out.println("teen's age: " + teen.getAge());
        System.out.println();

        System.out.println("Constructor output from line 115 (next 2 lines of output): ");
        Teenager badTeen = new Teenager("", 10);
        System.out.println("badTeen's age: " + badTeen.getAge());
        System.out.println("badTeen's name: " + badTeen.getName());
        System.out.println();

        System.out.print("Constructor output from line 121: ");
        Person interestingPerson = new Teenager("Average Joe",  10);
        System.out.print("setAge output from line 123: ");
        interestingPerson.setAge(20);
        System.out.println("interestingPerson's age (line 124): " + interestingPerson.getAge());
        interestingPerson.setAge(13);
        System.out.println("interestingPerson's new age (line 126): " + interestingPerson.getAge());
        interestingPerson = new Person("Other Joe", 30);
        System.out.println("interestingPerson's newer age (line 128): " + interestingPerson.getAge());
        System.out.println();

        LivingThing interestingThing = new Person("First Last", 40);
        System.out.println("Successful constructor. ");
        ((Person)interestingThing).setAge(20);
        System.out.println("interestingThing's age: " + ((Person)interestingThing).getAge());
        System.out.println("interestingThing's species: " + interestingThing.getSpeciesName());
    }
}

# Java OOP

In the JavaOOPExamples.java file, you will find sample classes, named Animal, Person, and Teenager. The JavaOOPExamples uses these classes to demonstrate Object-Oriented Programming, or OOP, concepts, such as abstraction, inheritance, polymorphism, and encapsulation.

Below is a brief description of each of those terms.

## Encapsulation

Encapsulation describes the restriction of data, allowing only certain modifications to be made. In simpler terms, it is where data is made private and can only be accessed and changed by specific methods. This is used to make sure that data cannot have extreme or unreasonable values.

In the code, you can see that several variables are encapsulated. This concept is demonstrated in the following places:
* In the Animal class, the speciesName variable can only be retrieved and not changed to prevent an animal from changing its species. 
* In the Person class, the name and age variables can be retrieved, but can only be changed in certain ways. The age variable must be within a specific reasonable range (0 to 125 years old) in order to be set to the new value. The name variable must not be blank in order to be changed.
* In the Teenager class, the age variable is restricted like the Person class, but must have an age range between 13 and 19 years old.

In order for someone who uses the class to change a variable, they would have to use methods, as they cannot directly edit the variable because it is private.

One must be careful when using this practice because if someone gives invalid input for the parameters, there must be a default value so that the value is not initialized to null or some extreme default value. This is shown when the variables are initialized to default values (shown above the constructors) in the Animal and Person classes.

Note that encapsulation is a practice, not a feature that requires special keywords. It is simply the practice of forcing users to use getter and setter methods to edit and retrieve data instead of allowing them to directly get and set the variable.

## Inheritance

Inheritance is the use of methods from another class - the idea is that a class is 'inheriting' methods from another class. The class that inherits the methods is called the subclass, and the class that is being inherited is known as the superclass. 

A subclass will usually inherit methods from a superclass that it is a subgroup of. For example, since a person is a subgroup of a animal (a person is a type of animal), it would make sense for the Person class to inherit from the Animal class.

In Java, one would use the <b>extends</b> keyword. All classes inherit from the Object class by default (you do not have to write it in the code), and therefore inherit certain methods, such as the equals() method, the toString() method, and the clone() method.

In the example code, you see that:
* The Person class inherits from the Animal class
* The Teenager class inherits from the Person class
* Although not written in the code, the Animal class automatically extends the Object class

In Java, a class can only inherit from one other class. However, it is possible for a class to inherit from a class that is inheriting from a class, as shown in the example code.

In order to get public methods/data from a superclass in Java, one must use the keyword <b>super</b>. To get methods or data, one would do super.<i>method_name</i> or super.<i>variable_name</i>, as shown in the setAge method of the Teenager class. This calls the setAge from the Person class. In order to call the constructor of the superclass, do super(<i>parameter_list</i>). This can only be in the first line of a Java subclass constructor. Java will automatically pass no parameters to the superclass constructor (which is like doing super()) if you do not specify any super constructor, and Java will automatically provide a parameter-less constructor if you do not write any constructors. 

## Abstraction

An abstract class is a class where not all methods are defined. This can be used when a class is too vague to specify how something would be done. 

For example, the Animal class is abstract and does not provide an implementation for the method speak(). This is because different animals have different ways of speaking and there is no general way that animals speak.

When a class inherits from an abstract class, it has two options - it can either declare itself as abstract, or it can provide an implementation for the abstract method(s).

In Java, abstract classes are marked by the keyword <b>abstract</b>, and all abstract methods also have the keyword abstract in their declaration and end in a semicolon instead of curly braces with a code block in between them.

## Polymorphism

In general, polymorphism is the practice of a method having multiple different forms. There are two types of polymorphism - compile-time polymorphism and run-time polymorphism. Below is a description of the two.

### Compile-Time Polymorphism

This is the use of overloaded methods. Overloaded methods are methods with the same name but a different parameter list. The method typically does different things depending on the parameter list. One must make two seperate declarations. 

For example, the setAge method of the Person class is an overloaded method. If you pass it an integer representing the age, it will check if it is reasonable and set the variable to that age. However, if you do not pass it any parameters, it will simply increment the age.

While Java is compiling the program, it must check which version of the method you used based on the parameter list given.

### Run-Time Polymorphism

This is the use of overriding methods. Overridden methods are superclass methods that are redefined in a subclass. For example, the setAge method is an overriden method because the Teenager class redefines this method to fit the age requirements to be a teenager.

Using this method, let's take a look at the badTeen example in the code. The Teenager constructor calls the superclass constructor, which in turn calls the setName() and setAge() methods. The setAge method will actually refer to the one in the Teenager class because it was overridden in this class and a new Teenager was being created, not a new Person. Because of this, it realizes that someone 10 years old is not a teenager, and prints that this is an invalid age instead of setting the age to 10 (this is what the Person constructor would have done since that is a reasonable age for a person). However, since the setName() method was not overridden in the Teenager class, the parent implementation was used.

In addition, one can see how the Child class and Teenager class setAge methods have different age requirements. They were both overridden from the Parent class, and they work differently from each other. You can see a demonstration in the example code, along with an example of the speak method being overridden by the Teenager class from the one in the Person class. 

## The Example Code

You can use the example code, compile and run it, and observe the output. There are comments in the code to show what each section does.  

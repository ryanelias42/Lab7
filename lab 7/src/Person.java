/**
 * Class representing a Person who will be admitted to a Hospital.
 *
 * @author Stephen
 * @version 2019-03-07
 */
public abstract class Person implements Comparable<Person>
{
	// Note: private variables should be documented, but don't require Javadoc.
	private String name;

	private int age;
	
	/**
	 * Stores the name and age of the Person.
	 *
	 * @param name The Person's name.
	 * @param age The Person's age, in years.
	 */
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	/**
	 * Get Person's name.
	 *
	 * @return Person's name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Get Person's age.
	 *
	 * @return Person's age.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Subclass implementation of Person comparison.
	 *
	 * @param p The other person to compare to.
	 * @return Standard Comparable values:
	 * 	(1) self comes "before" p: negative number
	 *  (2) self comes "after" p: positive number
	 *  (3) self and p are equivalent in ordering: 0
	 */
	protected abstract int compareToImpl(Person p);

	/**
	 * Comparable implementation. Compares self to another person to define the natural ordering of Persons.
	 *
	 * Relies on compareToImpl to offload the ordering to subclasses of person. Allows Person to implement
	 * the Comparable interface and ensure that all children also can compare to another Person.
	 *
	 * @param p The person to compare to.
	 */
	@Override
	public int compareTo(Person p)
	{
		return compareToImpl(p);
	}

	/**
	 * Gives some information about the Person.
	 *
	 * @return The string "%s, a %d-year old." with replacements of the Person's name and age.
	 */
	@Override
	public String toString()
	{
		return String.format("%s, a %d-year old.", name, age);
	}
}
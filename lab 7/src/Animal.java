/**
 * Class representing an Animal to be admitted to a Hospital.
 *
 * @author Stephen
 * @version 2019-03-06
 */
public class Animal implements Comparable<Animal>
{
	private String breed;

	private int age;

	/**
	 * Stores information about the animal.
	 *
	 * @param breed The Animal's breed (e.g. cat, dog).
	 * @param age The Animal's age, in years.
	 */
	public Animal(String breed, int age)
	{
		this.breed = breed;
		this.age = age;
	}

	/**
	 * Gets the Animal's breed.
	 *
	 * @return The Animal's breed.
	 */
	public String getBreed()
	{
		return breed;
	}

	/**
	 * Gets the Animal's age.
	 *
	 * @return The Animal's age.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Gives information about the Animal.
	 *
	 * @return The string "A %d-year old %s." with replacements of the animal's age and breed.
	 */
	@Override
	public String toString()
	{
		return String.format("A %d-year old %s.", age, breed);
	}

	/**
	 * Defines the natural ordering of animals.
	 *
	 * @param o The other animal to be compared to.
	 * @return The following values:
	 * 	(1) self's age is lower than o's age: positive value
	 * 	(2) self's age is greater than o's age: negative value
	 * 	(3) ages are equal: 0
	 */
	@Override
	public int compareTo(Animal o)
	{
		return o.age - age;
	}
}
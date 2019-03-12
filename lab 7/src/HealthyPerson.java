
public class HealthyPerson extends Person{
	
	private String reason;

	public HealthyPerson(String name, int age, String reason) {
		super(name, age);
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
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
	@Override
	protected int compareToImpl(Person p) {
		if (p instanceof HealthyPerson) {
			return this.getName().compareTo(p.getName());
		}
		//if this is being compared to SickPerson, return 1 putting self afterwords in order or precedence to remain consistent. 
		else {
			return 1;
		}
	}
	
	public String toString() {
		return String.format("%s, a %d-year old. Reason for visit: %s.", this.getName(), this.getAge(), this.getReason());
	}

}

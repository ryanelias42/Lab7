
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
			if (this.getName().compareTo(p.getName()) < 0) {
				//if self name is lower value it is alphabetically first and is therefor returning a -1
				return -1;
			}
			else if(this.getName().compareTo(p.getName()) > 0) {
				return 1;
			}
			else {
				return 0;
			}
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

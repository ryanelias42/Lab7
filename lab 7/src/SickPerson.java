
public class SickPerson extends Person {
	
	public int severity;

	public SickPerson(String name, int age, int severe) {
		super(name, age);
		this.severity = severe;
	}
	
	
	
	public int getSeverity() {
		return this.severity;
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
		if (p instanceof SickPerson) {
			//severity of self is less than severity of p
			//return (1)
			if(this.getSeverity() < ((SickPerson) p).getSeverity()) {
					return 1;
				}
			//severity of self is greater than severity of p
			//return (-1)
			else if(this.getSeverity() > ((SickPerson) p).getSeverity()) {
					return -1;
				}
			//severity of self and p are equal
			//return 0
			else {
					return 0;
				}
		}
		//if SickPerson is being compared to HealthyPerson (the only other subclass of person),
		// SickPerson will take precedence by default. 
		else {
			return -1;
		}
		
	}
	
	public String toString() {
		return String.format("%s, a %d-year old with severity %d.", this.getName(),this.getAge(),this.getSeverity());
	}

}

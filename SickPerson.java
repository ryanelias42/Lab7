
public class SickPerson extends Person {
	
	private int severity;

	public SickPerson(String name, int age, int severity) {
		super(name, age);
		this.severity = severity;
	}
	
	
	
	private int getSeverity() {
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
	 *  
	 * return -(this.getSeverity() - ((SickPerson)(p)).getSeverity());
	 */
	
	@Override
	protected int compareToImpl(Person p) {
		if (p instanceof SickPerson) {
			return -(this.getSeverity() - ((SickPerson)(p)).getSeverity());
			
		}
		//if SickPerson is being compared to HealthyPerson (the only other subclass of person),
		// SickPerson will take precedence by default. 
		// strike the above apparently i was supposed to return 0 if it is not a SickPerson
		else {
			return 0;	}
	}
	
	public String toString() {
		return String.format("%s Severity level %d", super.toString(),this.severity);

	}
	
	/**
	 * 
	 * 
	 * 
	 */

}

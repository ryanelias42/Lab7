
public class HealthyPerson extends Person{
	
	public String reason;

	public HealthyPerson(String name, int age, String reason) {
		super(name, age);
		this.reason = reason;
	}

	@Override
	protected int compareToImpl(Person p) {
		
	}
	
	public String toString() {
		
	}

}

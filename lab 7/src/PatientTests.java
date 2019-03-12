import org.junit.Test;
import org.junit.Assert;

public class PatientTests {
	
	
	//SickPerson tests
	SickPerson sp1 = new SickPerson("Alex",20,10);
	SickPerson sp2 = new SickPerson("Blake",20,5);
	SickPerson sp3 = new SickPerson("Charlie",20,10);
	HealthyPerson hp = new HealthyPerson("Daniel",20,"because");
	Person person = new HealthyPerson("abc", 25, "yes");
	
	
	@Test
	public void SickPersonConstTest() {
	//test constructor & getSeverity, getName, getAge tests.
	// Person compareTo test
	Assert.assertEquals("SP getSeverity incorrect", 10,sp1.getSeverity(),0.00001);
	Assert.assertEquals("SP getName incorrect", "Alex", sp1.getName());
	Assert.assertEquals("SP getAge incorrect",20, sp1.getAge(), 0.00001);
	Assert.assertEquals("Person compareTo incorrect", -5, sp1.compareTo(sp2), 0.00001);
	}
	
	
	@Test
	public void SickPersonCompTest () {
	//test compareToImpl methods
	//(1) this severity > p (expect negative number)
		Assert.assertEquals("compareToImpl incorrect, this.severity() > p.severity() issue", -5, sp1.compareToImpl(sp2), 0.000001);
	//(2) this severity < p (expect positive number)
		Assert.assertEquals("compareToImpl incorrect, this.severity() < p.severity issue", 5, sp2.compareToImpl(sp1),0.000001);
	//(3) this severity = p (expect 0)
		Assert.assertEquals("compareToImpl incorrect, Severity equal issue",0, sp1.compareToImpl(sp3));
	//(4) p is HealthyPerson (expect -1)
		Assert.assertEquals("compareToImpl incorrect, p = HealthyPerson issue", -1, sp1.compareToImpl(hp));
	}
	
	
	@Test
	public void SickPersontoStringTest() {
		//test toString
		Assert.assertEquals("toString incorrect", "Alex, a 20-year old with severity 10.",sp1.toString());
	}
	
	
	//HealthyPerson test
	HealthyPerson hp1 = new HealthyPerson("Alex",20,"allergies");
	HealthyPerson hp2 = new HealthyPerson("Blake",20,"because");
	HealthyPerson hp3 = new HealthyPerson("Alex",20,"check-up");
	SickPerson sp = new SickPerson("Daniel", 20, 10);
	
	
	@Test
	public void HealthyPersonConstTest() {
	//test constructor & getReason, getName, getAge
		Assert.assertEquals("HP getReason incorrect", "allergies", hp1.getReason());
		Assert.assertEquals("HP getName incorrect", "Alex", hp1.getName());
		Assert.assertEquals("HP getAge incorrect", 20, hp1.getAge(),0.0001);
	}
	@Test
	public void HealthyPersonCompareToImplTest() {
	//test compareToImpl method
	//(1) this name has precedence (expect negative number) 
		Assert.assertEquals("HP compare incorrect this precedence", -1, hp1.compareToImpl(hp2),0.00001);
	//(2) p name has precedence (expect positive number)
		Assert.assertEquals("HP compare incorrect p precedence", 1, hp2.compareToImpl(hp1),0.00001);
	//(3) this and p have same name (expect 0)
		Assert.assertEquals("HP compare incorrect =.", 0, hp1.compareToImpl(hp3),0.000001);
	//(4) p is SickPerson (expect 1)
		Assert.assertEquals("HP compare incorrect, p = SickPerson.", 1,hp1.compareToImpl(sp),0.000001);
	}
	
	//test toString
	@Test
	public void HealthyPersontoStringTest() {
		Assert.assertEquals("HP toString incorrect.", "Alex, a 20-year old. Reason for visit: allergies.",hp1.toString());	
	}
	
	
	
	//Animal tests
	
	Animal a = new Animal("Dog", 5);
	Animal b = new Animal("Cat", 10);
	Animal c = new Animal("Dog",5);
	
	@Test
	public void AnimalConstMethodTest() {
		//test constructor & getBreed & getAge methods
		Assert.assertEquals("A getBreed incorrect","Dog",a.getBreed());
		Assert.assertEquals("A getAge incorrect", 5, a.getAge(), 0.000001);
	}
	
	@Test
	//return o.age - this.age;
	public void AnimalCompareToTest() {
		//test compareTo
	//(1) this.age is less than o.age (expect positive number)
		Assert.assertEquals("A compareTo incorrect this < o.", 5, a.compareTo(b),0.00001);
	//(2) this.age is greater than o.age (expect negative number)
		Assert.assertEquals("A compareTo incorrect this > o.", -5, b.compareTo(a), 0.00001);
	//(3) this.age is equal to o.age (expect 0)
		Assert.assertEquals("A compareTo incorrect this = o.", 0, a.compareTo(c),0.0000001);
	}
	@Test
	public void AnimalToStringTest() {
		//test toString
		Assert.assertEquals("A toString incorrect.","A 5-year old Dog.", a.toString());
	}
	//HOSPITAL TESTS BELOW
	
	//StackHospital
	StackHospital<Person> stack = new StackHospital<>();
	//addPatient and numPatient test and allPatientInfo
	@Test
	public void addPatientStackTest() {
		stack.addPatient(sp1);
		Assert.assertEquals("failed to add patient to StackHospital", 1, stack.numPatients(),0.0000001);
		
		stack.addPatient(sp2);
		Assert.assertEquals("allPatientInfo incorrect for Stack Hospital",sp1.toString() + sp2.toString(), stack.allPatientInfo());
	}
	
	@Test
	public void StackHospitalTreatNextTypeTest() {
		stack.addPatient(sp1);
		stack.addPatient(hp1);
		Assert.assertEquals("nextPatient incorrect for Stack Hospital.",hp1, stack.nextPatient());
		Assert.assertEquals("nextPatient incorrect for Stack Hospital.",hp1, stack.treatNextPatient());
		Assert.assertEquals("hospitalType incorrect for Stack Hospital.", "StackHospital", stack.hospitalType());
	}
	
	//QueueHospital
	QueueHospital<Person> queue = new QueueHospital<>();
	
	@Test
	public void QueueNumTypeInfoAddTest() {
		queue.addPatient(hp);
		queue.addPatient(sp1);
		Assert.assertEquals("failed to add patient to QueueHospital.", 2,queue.numPatients(), 0.00001);
		Assert.assertEquals("allPatientInfo incorrect for QueueHospital.", hp.toString() + sp1.toString(),queue.allPatientInfo());
		Assert.assertEquals("hospitalType incorrect for QueueHospital.","QueueHospital", queue.hospitalType());
	}
	
	@Test
	public void QueueNextPatientTreatNextPatientTest() {
		queue.addPatient(hp);
		queue.addPatient(sp);
		queue.addPatient(hp1);
		
		Assert.assertEquals("nextPatient incorrect for QueueHospital.", hp, queue.nextPatient());
		Assert.assertEquals("treatNextPatient incorrect for QueueHospital.", hp, queue.treatNextPatient());
	}
	
	//PriorityQueueHospital
	PriorityQueueHospital<Person> priority = new PriorityQueueHospital<>();
	
	@Test
	public void PriorityNumTypeAddInfoTest() {
		priority.addPatient(hp);
		priority.addPatient(sp);
		Assert.assertEquals("Failed to add Patient to PriorityQueueHospital.",2, priority.numPatients(), 0.0001);
		Assert.assertEquals("allPatientInfo incorrect for PriorityQueueHospital.", sp.toString() + hp.toString(), priority.allPatientInfo());
		Assert.assertEquals("hospitalType incorrect for PriorityQueueHospital.","PriorityQueueHospital", priority.hospitalType());
	}
	@Test
	public void PriorityNextPatientTreatNextPatient() {
		priority.addPatient(hp2);
		priority.addPatient(sp1);
		priority.addPatient(hp1);
		Person x = priority.nextPatient();
		Assert.assertEquals("nextPatient incorrect for PriorityQueueHospital.", sp1, x);
		Assert.assertEquals("treatNextPatient incorrect for PriorityQueueHospital.", sp1, priority.treatNextPatient());
	}
	
	@Test
	public void HospitalToStringTest() {
		Assert.assertEquals("Hospital ToString incorrect.", "A StackHospital-type hospital with 0 patients.",stack.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

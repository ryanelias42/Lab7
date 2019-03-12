import java.util.ArrayList;

public class StackHospital extends Hospital {
	
	public ArrayList<Object> patients = new ArrayList<>();

	@Override
	// adds new patient at the end of the list
	public void addPatient(Object patient) {
		patients.add(patient);
	}

	@Override
	//returns patient that is at the end of the ArrayList
	public Object nextPatient() {
		return patients.get(patients.size()-1);
	}

	@Override
	//stores last patient into Object answer, removes last object from list, returns answer
	public Object treatNextPatient() {
		Object answer = patients.get(patients.size()-1);
		patients.remove(patients.size()-1);
		return answer;
	}

	@Override
	public int numPatients() {
		return patients.size();
	}

	@Override
	public String hospitalType() {
		return "StackHospital";
	}

	@Override
	//runs for each loop that adds the toString of each object to the string answer and then returns answer
	public String allPatientInfo() {
		String answer = "";
		for (Object x: patients) {
			answer+=x.toString();
		}
		return answer;
	}

}

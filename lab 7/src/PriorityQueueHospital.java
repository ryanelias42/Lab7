import java.util.ArrayList;

public class PriorityQueueHospital<PatientType extends Comparable<PatientType>> extends Hospital<PatientType> {
	
	private ArrayList<PatientType> patients = new ArrayList<PatientType>();

	@Override
	public void addPatient(PatientType patient) {
		patients.add(patient);
	}

	@Override
	public PatientType nextPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientType treatNextPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numPatients() {
		return patients.size();
	}

	@Override
	public String hospitalType() {
	return "PriorityQueueHospital";
	}

	@Override
	public String allPatientInfo() {
		String answer = "";
		for (PatientType x: patients) {
			answer+=x.toString();
		}
		return answer;
	}
	
	

}

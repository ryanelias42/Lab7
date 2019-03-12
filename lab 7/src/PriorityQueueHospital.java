import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueHospital<PatientType extends Comparable<PatientType>> extends Hospital<PatientType> {
	
	private ArrayList<PatientType> patients;
	
	public PriorityQueueHospital() {
		patients = new ArrayList<>();
	}

	@Override
	public void addPatient(PatientType patient) {
		patients.add(patient);
		Collections.sort(patients);
		}

	@Override
	public PatientType nextPatient() {
		Collections.sort(patients);
		return patients.get(0);
	}

	@Override
	public PatientType treatNextPatient() {
		Collections.sort(patients);
		PatientType x = patients.get(0);
		patients.remove(0);
		return x;
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

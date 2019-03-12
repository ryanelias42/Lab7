import java.util.ArrayList;

public class QueueHospital<PatientType> extends Hospital<PatientType> {
	
	private ArrayList<PatientType> patients = new ArrayList<>();

	@Override
	public void addPatient(PatientType patient) {
		patients.add(patient);
	}

	@Override
	public PatientType nextPatient() {
		return patients.get(0);
	}

	@Override
	public PatientType treatNextPatient() {
		PatientType answer = patients.get(0);
		patients.remove(0);
		return answer;
	}

	@Override
	public int numPatients() {
		return patients.size();
	}

	@Override
	public String hospitalType() {
		return "QueueHospital";
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

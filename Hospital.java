/**
 * Class representing a Hospital. Hospitals store a collection of patients who are waiting to receive
 * medical treatment. Patients are treated one at a time by some defined ordering. How to determine
 * which patient to treat next is the responsibility of the Hospital subclasses. Once a patient is treated,
 * it is removed from the Hospital.
 *
 * Hospitals may have different types of patients. In the case of this lab, the two general patient types
 * used are Person and Animal.
 *
 * @author Stephen
 * @version 2019-03-07
 * @param <PatientType> The generic type for the type of patient that the Hospital accepts.
 */
public abstract class Hospital<PatientType>
{
	/**
	 * Add a patient to the Hospital.
	 *
	 * @param patient The patient to be added.
	 */
	public abstract void addPatient(PatientType patient);

	/**
	 * Find and return the patient who will next be treated. Does not treat the patient (i.e. it is not
	 * removed from the collection of patients that the hospital still must treat).
	 *
	 * @return The patient who would be next treated.
	 */
	public abstract PatientType nextPatient();

	/**
	 * Treats the next patient and removes them from the Hospital. Once someone is healed they
	 * no longer need to stay in the Hospital.
	 *
	 * @return The patient receiving treatment.
	 */
	public abstract PatientType treatNextPatient();

	/**
	 * Calculate and return the number of patients still in the hospital (untreated).
	 *
	 * @return The number of patients in the Hospital.
	 */
	public abstract int numPatients();

	/**
	 * Gives a String for the hospital type.
	 *
	 * @return A string exactly matching the class name.
	 */
	public abstract String hospitalType();

	/**
	 * Prints all patient information.
	 *
	 * @return The toString of all patients, concatenated (don't add spaces, newlines, etc...).
	 */
	public abstract String allPatientInfo();

	/**
	 * Returns some information about the Hospital and its occupancy.
	 *
	 * @return The string "A %s-type hospital with %d patients.", with replacements of the hospitalType
	 * and the number of patients.
	 */
	@Override
	public String toString()
	{
		return String.format("A %s-type hospital with %d patients.", hospitalType(), numPatients());
	}
}
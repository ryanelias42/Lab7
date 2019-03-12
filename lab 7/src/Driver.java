import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * THIS CLASS IS GIVEN TO YOU. DO NOT CHANGE. YOU SHOULD GENERALLY UNDERSTAND HOW IT WORKS, BUT UNDERSTANDING
 * SPECIFICS IS NOT REQUIRED.
 *
 * Lab 7
 *
 * Class to compare the behavior of different hospitals (stack, queue, priority queue) treating different types
 * of patients (animal, person).
 *
 * @author Stephen
 * @version 2019-03-06
 */
public class Driver
{
    /**
     * Main method for the Hospital Comparison system. Takes repeated inputs from the user to interact with
     * the hospitals. Three hospitals are created for treating animals and people each. When a person or animal
     * is added, it is added to all three associated hospitals (stack, queue, and priority queue). This allows
     * the user to compare how the hospitals determine the order of treating the patients.
     *
     * @param args command-line arguments [not used]
     */
    public static void main(String[] args)
    {
        // Set up the hospitals to compare:
    	StackHospital<Animal> animalStack = new StackHospital<Animal>();
    	QueueHospital<Animal> animalQueue = new QueueHospital<Animal>();
    	PriorityQueueHospital<Animal> animalPQueue = new PriorityQueueHospital<Animal>();

    	StackHospital<Person> personStack = new StackHospital<Person>();
    	QueueHospital<Person> personQueue = new QueueHospital<Person>();
    	PriorityQueueHospital<Person> personPQueue = new PriorityQueueHospital<Person>();

    	// Aggregate structures:
    	ArrayList<Hospital<Animal>> animalHospitals = new ArrayList<Hospital<Animal>>();
    	ArrayList<Hospital<Person>> personHospitals = new ArrayList<Hospital<Person>>();

    	animalHospitals.add(animalStack);
    	animalHospitals.add(animalQueue);
    	animalHospitals.add(animalPQueue);
    	String[] ahNames = {"AStack", "AQueue", "APQueue"};

    	personHospitals.add(personStack);
    	personHospitals.add(personQueue);
    	personHospitals.add(personPQueue);
    	String[] phNames = {"PStack", "PQueue", "PPQueue"};

        // Set up the user input loop:
        boolean done = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!done)
        {
            System.out.println("Please choose a hospital option:");
            System.out.println("\t1. [add] a patient.");
            System.out.println("\t2. [treat] a patient.");
            System.out.println("\t3. [check] the next patient to be treated.");
            System.out.println("\t4. [summary] Prints the toString of each hospital.");
            System.out.println("\t5. [patientlist] For each hospital, prints ");
            System.out.println("\t6. [quit]");

            try
            {
                String input = reader.readLine();
                String[] tokens = input.split(" ");
                switch(tokens[0])
                {
                case "add":
                	System.out.println("Add an [animal] or [person].");
                	String choice = reader.readLine();
                	if (choice.equalsIgnoreCase("animal"))
                	{
                		System.out.println("Please enter data in the following format:");
                		System.out.println("(breed) (age)");
                		String[] info = reader.readLine().split(" ");
                		if (info.length != 2)
                		{
                			System.out.println("Bad information length. Please try again...");
                		}
                		for (Hospital<Animal> hos : animalHospitals)
                		{
                			hos.addPatient(new Animal(info[0], Integer.parseInt(info[1])));
                		}
                	}
                	else if (choice.equalsIgnoreCase("person"))
                	{
                		System.out.println("[sick] or [healthy].");
                		String choice2 = reader.readLine();
                		if (choice2.equalsIgnoreCase("sick"))
                		{
                			System.out.println("Please enter data in the following format:");
                    		System.out.println("(name) (age) (severity)");
                    		String[] info = reader.readLine().split(" ");
                    		if (info.length != 3)
                    		{
                    			System.out.println("Bad information length. Please try again...");
                    		}
                    		for (Hospital<Person> hos : personHospitals)
                    		{
                    			hos.addPatient(new SickPerson(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2])));
                    		}
                		}
                		else if (choice2.equalsIgnoreCase("healthy"))
                		{
                			System.out.println("Please enter data in the following format:");
                    		System.out.println("(name) (age) (reason)");
                    		String[] info = reader.readLine().split(" ");
                    		if (info.length != 3)
                    		{
                    			System.out.println("Bad information length. Please try again...");
                    		}
                    		for (Hospital<Person> hos : personHospitals)
                    		{
                    			hos.addPatient(new HealthyPerson(info[0], Integer.parseInt(info[1]), info[2]));
                    		}
                		}
                		else
                		{
                			System.out.println("Bad choice. Please try again...");
                		}
                	}
                	else
                	{
                		System.out.println("Bad choice. Please try again...");
                	}
                	break;
                case "treat":
                	System.out.println("Treat an [animal] or [person].");
                	choice = reader.readLine();
                	if (choice.equalsIgnoreCase("animal"))
                	{
                		for (int i = 0; i < animalHospitals.size(); i++)
                		{
                			Animal treated = animalHospitals.get(i).treatNextPatient();
                			System.out.println(String.format("%s: treated - %s", ahNames[i], treated));
                		}
                	}
                	else if (choice.equalsIgnoreCase("person"))
                	{
                		for (int i = 0; i < personHospitals.size(); i++)
                		{
                			Person treated = personHospitals.get(i).treatNextPatient();
                			System.out.println(String.format("%s: treated - %s", phNames[i], treated));
                		}

                	}
                	else
                	{
                		System.out.println("Bad choice. Please try again...");
                	}
                	break;
                case "check":
                	System.out.println("Check an [animal] or [person].");
                	choice = reader.readLine();
                	if (choice.equalsIgnoreCase("animal"))
                	{
                		for (int i = 0; i < animalHospitals.size(); i++)
                		{
                			Animal next = animalHospitals.get(i).nextPatient();
                			System.out.println(String.format("%s: next - %s", ahNames[i], next));
                		}
                	}
                	else if (choice.equalsIgnoreCase("person"))
                	{
                		for (int i = 0; i < personHospitals.size(); i++)
                		{
                			Person next = personHospitals.get(i).nextPatient();
                			System.out.println(String.format("%s: next - %s", phNames[i], next));
                		}

                	}
                	else
                	{
                		System.out.println("Bad choice. Please try again...");
                	}
                	break;
                case "summary":
                	for (Hospital hos : animalHospitals)
                	{
                		System.out.println(hos);
                	}
                	for (Hospital hos : personHospitals)
                	{
                		System.out.println(hos);
                	}
                	break;
                case "patientlist":
                	for (Hospital hos : animalHospitals)
                	{
                		System.out.println(hos.allPatientInfo());
                	}
                	for (Hospital hos : personHospitals)
                	{
                		System.out.println(hos.allPatientInfo());
                	}
                	break;
                case "quit":
                	done = true;
                	break;
                default:
                	System.out.println("Please input a valid (case-sensitive) command...");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Input integer not formatted correctly.");
            }
            catch (IOException e)
            {
            	System.out.println("Bad issue with the console input!!!");
                e.printStackTrace();
            }
        }
    }
}

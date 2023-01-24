package constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommonTexts {

    //On-Boarding
    SECOND_SCREEN_TEXT("Our TeleHealth team is ready to connect any time you have questions."),
    THIRD_SCREEN_TEXT ("*Labs, Diagnostics, and Medications not included."),
    VIRTUAL_ACCESS("24/7 Virtual Access"),
    NO_EXAMS("No Exam Fees*"),
    LOCATION_INSTRUCTIONS("To find the location nearest to you, please enter your zip code or enable location services on your device."),
    ZIP_TEXT("Enter Zip to display available locations"),

    //Log In Texts
    PASSWORD_REQUIRED("password is required"),
    INVALID_EMAIL("Invalid email address"),
    //Travel Texts
    TRAVEL_TITLE("Travel certificate"),
    TRAVEL_SUBTITLE("Travel documents and services"),
    TRAVEL_QUESTION("Where are you traveling?"),
    FIRST_TRAVEL_OPTION_TEXT("Domestic"),
    SECOND_TRAVEL_OPTION_TEXT("International"),
    THIRD_TRAVEL_OPTION_TEXT("Hawaii"),
    TRAVEL_FIRST_SUBTEXT("Travel within the Continental United States"),
    TRAVEL_SECOND_SUBTEXT("International destinations"),
    TRAVEL_THIRD_SUBTEXT("Hawaiian Islands"),

    //Anual Wellness Text

    WELLNESS_TITLE("Wellness"),
    WELLNESS_SUBTEXT("Pet wellness exams and services."),
    WELLNESS_QUESTION("How can we help?"),
    WELLNESS_OPTION_ONE("Annual wellness visit"),
    WELLNESS_OPTION_TWO("Travel anxiety"),
    WELLNESS_OPTION_THREE("Vaccinations"),
    WELLNESS_OPTION_FOUR("Motion sickness"),
    WELLNESS_OPTION_FIVE("Weight management"),
    WELLNESS_OPTION_SIX("Behavioral issues"),
    WELLNESS_OPTION_SEVEN("Separation anxiety"),
    WELLNESS_OPTION_EIGHT("Other Onsite services"),
    WELLNESS_SUBTEXT_ONE("Schedule your pet's annual wellness visit"),
    WELLNESS_SUBTEXT_TWO("Consultation for a nervous pet"),
    WELLNESS_SUBTEXT_THREE("Schedule a vaccination"),
    WELLNESS_SUBTEXT_FOUR("Remedies for motion sickness"),
    WELLNESS_SUBTEXT_FIVE("Weight management options and plans"),
    WELLNESS_SUBTEXT_SIX("Training options and advice"),
    WELLNESS_SUBTEXT_SEVEN("Advice for a stressful animal"),
    WELLNESS_SUBTEXT_EIGHT("Services available at our practice"),

    //Dental text
    DENTAL_TITLE("Dental"),
    DENTAL_SUBTITLE("Pet dental care"),
    DENTAL_QUESTION("How can we help?"),
    DENTAL_FIRST_OPTION("Dental consultation"),
    DENTAL_SECOND_OPTION("Dental cleaning"),
    DENTAL_THIRD_OPTION("Extractions"),
    DENTAL_FOURTH_OPTION("Other dental concerns"),
    DENTAL_FIRST_SUBTEXT("Estimate consultation"),
    DENTAL_SECOND_SUBTEXT("Annual cleaning"),
    DENTAL_THIRD_SUBTEXT("Removing teeth"),
    DENTAL_FOURTH_SUBTEXT("Other concerns");

    @Getter
    private final String CommonTexts;
}

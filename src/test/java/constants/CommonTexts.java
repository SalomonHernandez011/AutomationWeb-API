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

    //Annual Wellness Text

    WELLNESS_TITLE("Wellness"),
    WELLNESS_SUBTEXT("Pet wellness exams and services."),
    WELLNESS_QUESTION("How can we help?"),
    WELLNESS_OPTION_ONE("Wellness visit"),
    WELLNESS_OPTION_TWO("Vaccinations"),
    WELLNESS_OPTION_THREE("Tech appointments & other services"),
    WELLNESS_OPTION_FOUR("Motion sickness"),
    WELLNESS_OPTION_FIVE("Weight management"),
    WELLNESS_OPTION_SIX("Behavioral issues"),
    WELLNESS_OPTION_SEVEN("Separation anxiety"),
    WELLNESS_SUBTEXT_ONE("Schedule your pet’s wellness visit"),
    WELLNESS_SUBTEXT_TWO("Schedule a vaccination"),
    WELLNESS_SUBTEXT_THREE("Nail trim, ear cleaning, blood draw, etc."),
    WELLNESS_SUBTEXT_FOUR("Remedies for motion sickness"),
    WELLNESS_SUBTEXT_FIVE("Weight management options and plans"),
    WELLNESS_SUBTEXT_SIX("Training options and advice"),
    WELLNESS_SUBTEXT_SEVEN("Advice for a stressful animal"),

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
    DENTAL_FOURTH_SUBTEXT("Other concerns"),
    //BookVisitOptions
    BOOKVISIT_WELLNESS("Wellness"),
    BOOKVISIT_SICK("Sick"),
    BOOKVISIT_TRAVEL("Travel"),
    BOOKVISIT_SPAYNEUTER("Spay / Neuter"),
    BOOKVISIT_DENTAL("Dental"),
    BOOKVISIT_OTHER("Other"),
    BOOKVISIT_WELLNESS_SUBTEXT("Healthy pet wellness exams and services"),
    BOOKVISIT_SICK_SUBTEXT("If your pet is unwell"),
    BOOKVISIT_TRAVEL_SUBTEXT("Health certificates, anxiety, and motion..."),
    BOOKVISIT_SPAYNEUTER_SUBTEXT("Reproductive health"),
    BOOKVISIT_DENTAL_SUBTEXT("Exams, cleaning, extractions"),
    BOOKVISIT_OTHER_SUBTEXT("Tell us what you need");

    @Getter
    private final String CommonTexts;
}

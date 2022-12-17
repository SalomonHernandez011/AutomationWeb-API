package constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommonTexts {
    SECOND_SCREEN_TEXT("Our TeleHealth team is ready to connect any time you have questions."),
    THIRD_SCREEN_TEXT ("*Labs, Diagnostics, and Medications not included."),
    VIRTUAL_ACCESS("24/7 Virtual Access"),
    NO_EXAMS("No Exam Fees"),
    LOCATION_INSTRUCTIONS("To find the location nearest to you, please enter your zip code or enable location services on your device."),
    ZIP_TEXT("Enter Zip to display available locations");

    @Getter
    private final String CommonTexts;
}

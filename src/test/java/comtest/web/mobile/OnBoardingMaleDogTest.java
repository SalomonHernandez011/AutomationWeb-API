package comtest.web.mobile;

import comtest.OnBoardingMobileTest;
import org.testng.annotations.Test;

public class OnBoardingMaleDogTest extends OnBoardingMobileTest {
    @Test
    public void maleCatTest() {
        callLandingPage();
        thirdPageView();
        getStartedPage();
    }
}

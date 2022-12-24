package Util;

import Util.helper.AllureHelpers;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

/**
 * The class Allure screen shooter.
 */
public class AllureScreenShooter extends ExitCodeListener {
    /**
     * The class Allure screen shooter.
     *
     * @param result this is ITestResult.
     */
    public void onTestFailure(final ITestResult result) {
        super.onTestFailure(result);
        AllureHelpers.takeScreenshot();

    }
}

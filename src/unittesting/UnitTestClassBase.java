package unittesting;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestWatcher;

import com.hp.lft.report.CaptureLevel;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.unittesting.UnitTestBase;
import com.tools.Constants;


public class UnitTestClassBase extends UnitTestBase {
	
	protected Browser browser;
    protected static UnitTestClassBase instance;

    public static void globalSetup(Class<? extends UnitTestClassBase> testClass) throws Exception {
        if (instance == null)
            instance = testClass.newInstance();
        instance.classSetup();
    }

    @Before
    public void beforeTest() throws Exception {
        testSetup();
        Reporter.setSnapshotCaptureLevel(CaptureLevel.All);
        //browser initialization
        browser = BrowserFactory.launch(Constants.BROWSER_TYPE);
    }

    @After
    public void afterTest() throws Exception {
        testTearDown();
    }

    public static void globalTearDown() throws Exception {
        instance.classTearDown();
        getReporter().generateReport();
    }

    @ClassRule
    public static TestWatcher classWatcher = new TestWatcher() {
        @Override
        protected void starting(org.junit.runner.Description description) {
            className = description.getClassName();
        }
    };

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void starting(org.junit.runner.Description description) {
            testName = description.getMethodName();
        }
        @Override
        protected void failed(Throwable e, org.junit.runner.Description description) {
            setStatus(Status.Failed);
        }
        
        @Override
        protected void succeeded(org.junit.runner.Description description) {
            setStatus(Status.Passed);
        }
    };

    @Override
    protected String getTestName() {
        return testName;
    }
    
    @Override
    protected String getClassName() {
        return className;
    }

    protected static String className;
    protected String testName;
    
}
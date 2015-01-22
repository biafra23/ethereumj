package test.ethereum.jsontestsuite;

import org.ethereum.jsontestsuite.StateTestCase;
import org.ethereum.jsontestsuite.StateTestSuite;
import org.ethereum.jsontestsuite.TestCase;
import org.ethereum.jsontestsuite.TestRunner;
import org.ethereum.jsontestsuite.TestSuite;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Test file specific for tests maintained in the GitHub repository
 * by the Ethereum DEV team. <br/>
 *
 * @see <a href="https://github.com/ethereum/tests/">https://github.com/ethereum/tests/</a>
 */
@RunWith(Suite.class)
@SuiteClasses({
        GitHubVMTest.class,
})
public class GitHubJSONTestSuite {

    private static Logger logger = LoggerFactory.getLogger("TCK-Test");


    protected static void runGitHubJsonTest(String json) throws ParseException {
        Assume.assumeFalse("Online test is not available", json.equals(""));

        JSONParser parser = new JSONParser();
        JSONObject testSuiteObj = (JSONObject) parser.parse(json);

        TestSuite testSuite = new TestSuite(testSuiteObj);
        Iterator<TestCase> testIterator = testSuite.iterator();

        while (testIterator.hasNext()) {

            TestCase testCase = testIterator.next();

            TestRunner runner = new TestRunner();
            List<String> result = runner.runTestCase(testCase);
            Assert.assertTrue(result.isEmpty());
        }
    }

    protected static void runGitHubJsonStateTest(String json, String testName) throws ParseException {
        Assume.assumeFalse("Online test is not available", json.equals(""));

        JSONParser parser = new JSONParser();
        JSONObject testSuiteObj = (JSONObject) parser.parse(json);

        StateTestSuite testSuite = new StateTestSuite(testSuiteObj);

        for (StateTestCase testCase : testSuite.getAllTests()) {
            if (testCase.getName().equals(testName))
                logger.info(" => " + testCase.getName());
            else
                logger.info("    " + testCase.getName());
        }

        StateTestCase testCase = testSuite.getTestCase(testName);
        TestRunner runner = new TestRunner();
        List<String> result = runner.runTestCase(testCase);

        if (!result.isEmpty())
            for (String single : result)
                logger.info(single);

        Assert.assertTrue(result.isEmpty());
    }

    protected static void runGitHubJsonStateTest(String json, Set<String> exclude) throws ParseException {
        Assume.assumeFalse("Online test is not available", json.equals(""));

        JSONParser parser = new JSONParser();
        JSONObject testSuiteObj = (JSONObject) parser.parse(json);

        StateTestSuite testSuite = new StateTestSuite(testSuiteObj);
        Collection<StateTestCase> testCollection = testSuite.getAllTests();

        for (StateTestCase testCase : testSuite.getAllTests()) {

            String prefix = "    ";
            if (exclude.contains(testCase.getName())) prefix = "[X] ";

            logger.info(prefix + testCase.getName());
        }

        for (StateTestCase testCase : testCollection) {

            if (exclude.contains(testCase.getName())) continue;
            TestRunner runner = new TestRunner();
            List<String> result = runner.runTestCase(testCase);

            if (!result.isEmpty())
                for (String single : result)
                    logger.info(single);

            Assert.assertTrue(result.isEmpty());
        }
    }


    protected static void runGitHubJsonStateTest(String json) throws ParseException {
        Assume.assumeFalse("Online test is not available", json.equals(""));

        JSONParser parser = new JSONParser();
        JSONObject testSuiteObj = (JSONObject) parser.parse(json);

        StateTestSuite testSuite = new StateTestSuite(testSuiteObj);
        Collection<StateTestCase> testCollection = testSuite.getAllTests();


        for (StateTestCase testCase : testCollection) {

            TestRunner runner = new TestRunner();
            List<String> result = runner.runTestCase(testCase);

            if (!result.isEmpty())
                for (String single : result)
                    logger.info(single);

            Assert.assertTrue(result.isEmpty());
            logger.info(" *** Passed: " + testCase.getName());
        }
    }


}

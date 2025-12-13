package com.education.ztu;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import Classes.Operations;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(JUnitParamsRunner.class)
@Suite.SuiteClasses({OperationTestJunit.class})
public class OperationTestJunit {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public TestName testName = new TestName();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public Verifier verifier = new Verifier() {
        @Override
        public void verify() {
        }
    };

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddition() {
        assertEquals(10.0, Operations.addition(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(0.0, Operations.subtraction(10, 5, 5), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(24.0, Operations.multiplication(2, 3, 4), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, Operations.division(8, 2, 2), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("Division by zero is not allowed.");
        Operations.division(1, 0);
    }

    @Test
    public void testAverage() {
        assertEquals(2.5, Operations.average(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testMaximum() {
        assertEquals(4.0, Operations.maximum(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testMaximumNoNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No numbers provided.");
        Operations.maximum();
    }

    @Test
    public void testMinimum() {
        assertEquals(1.0, Operations.minimum(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testMinimumNoNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No numbers provided.");
        Operations.minimum();
    }

    @Test
    @Parameters({"1, 2, 3, 6", "2, 3, 4, 9"})
    public void testAdditionWithParams(double a, double b, double c, double expected) {
        assertThat(Operations.addition(a, b, c)).isEqualTo(expected);
    }

    @Test
    public void testFail() {
        org.junit.Assert.fail("Цей тест навмисно провалений");
    }

    @Test
    @Ignore("Тест ігнорується")
    public void testIgnored() {
    }

    @Test
    public void testRules() throws IOException {
        File file = folder.newFile("test.txt");
        assertTrue(file.exists());

        thrown.expect(IOException.class);
        throw new IOException("Test IOException");

    }

    @Test
    public void testAssertions() {
        assertNull(null);
        assertNotNull(new Object());

        Object obj = new Object();
        assertSame(obj, obj);
        assertNotSame(obj, new Object());
    }
}
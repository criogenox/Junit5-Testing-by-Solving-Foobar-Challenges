package mvn.foobartest;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;
import org.apache.commons.lang3.math.NumberUtils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.condition.EnabledIf;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
/**
 * @author Criogenox
 */
@DisplayName("Junit5 Usage applied to Solved Foobar Functions")
class AllSolutionsTest {

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
               testReporter.publishEntry("Checking " + testInfo.getDisplayName() +
                                               " | challenge: " + testInfo.getTags());
    }

    @Nested
    @Tag("Re-ID")
    @DisplayName("Test for Re-ID challenge")
    class Solution1Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @CsvSource({"    0, 23571",
            "            3, 71113",
            "        10000, 63109"})
        void checkSolutionAgainstExpect(String num, String expected) {
            // checking integer input 
            checkIntegerInput(num);
            // getting method output
            String res = Solution.solution1(Integer.parseInt(num));
            // checking against expected result
            assertEquals(expected, res); // utility methods
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @ValueSource(strings = {"0", "3", "10000"})
        @DisplayName("Checking execution times")
        void checkSolutionNotExceedTime(String num) {
            // checking integer input 
            checkIntegerInput(num);
            // checking timeout errors
            assertTimeout(ofMillis(50), () -> {
                Solution.solution1(Integer.parseInt(num));
            }, "The solution1 method take more than 50 milliseconds");
        }

        void checkIntegerInput(String num) {
            // rejecting null & strings (including empty values)
            assertTrue(NumberUtils.isCreatable(num),
                    () -> "There is not an integer input");
        }
    }

    @Nested
    @Tag("Palindrome")
    @DisplayName("Test for Palindrome challenge")
    class Solution2Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @CsvSource({"    0, 2",
            "           24, 3",
            "         1000, 9"})
        void checkSolutionAgainstExpect(String num, int expected) {
            // checking integer input 
            checkIntegerInput(num);
            // getting method output
            int res = Solution.solution2(Integer.parseInt(num));
            //numchar checking against expected result
            assertEquals(expected, res); // utility methods
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @ValueSource(strings = {"0", "24", "1000"})
        @DisplayName("Checking execution times")
        void checkSolutionNotExceedTime(String num) {
            // checking integer input 
            checkIntegerInput(num);
            // checking timeout errors
            assertTimeout(ofMillis(50), () -> {
                Solution.solution2(Integer.parseInt(num));
            }, "The solution2 method take more than 50 milliseconds");
        }

        void checkIntegerInput(String num) {
            // rejecting null & strings (including empty values)
            assertTrue(NumberUtils.isCreatable(num),
                    () -> "There is not an integer input");
        }
    }

    @Nested
    @Tag("Square-Supplies")
    @DisplayName("Test for Square Supplies challenge")
    class Solution3Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @CsvSource({"   24, 3",
            "          160, 2",
            "        10000, 1"})
        void checkSolutionAgainstExpect( int num, int expected) {
            // getting method output
            int res = Solution.solution3(num);
            //numchar checking against expected result
            assertEquals(expected, res); // utility methods
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @ValueSource(ints = {24, 160, 10000})
        @DisplayName("Checking execution times")
        void checkSolutionNotExceedTime(int num) {
            // checking timeout errors
            assertTimeout(ofMillis(50), () -> {
                Solution.solution3(num);
            }, "The solution3 method take more than 50 milliseconds");
        }
    }

    @Nested
    @Tag("Zombit-Monitoring")
    @DisplayName("Test for Zombit Monitoring challenge")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Solution4Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @MethodSource("input")
        void checkSolutionAgainstExpect(int[][] input, int expected) {
            // getting method output
            int res = Solution.solution4(input);
            // checking against expected result
            assertEquals(expected, res);
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @DisplayName("Checking execution times")
        @MethodSource("input")
        void checkSolutionNotExceedTime(int[][] input, int expected) {
            // checking timeout errors
            assertTimeout(ofMillis(50), () -> {
                Solution.solution4(input);
            }, "The solution4 method take more than 50 milliseconds");
        }

        Stream<Arguments> input() {
            return Stream.of(
                    Arguments.of((Object) new int[][]{{1, 3}, {3, 6}}, 5),
                    Arguments.of((Object) new int[][]{{10, 14}, {4, 18}, {19, 20},
            {19, 20}, {13, 20}}, 16),
                    Arguments.of((Object) new int[][]{{19, 20}, {13, 20}, {19, 20},
            {4, 18}, {10, 14}}, 16),
                    Arguments.of((Object) new int[][]{{13, 20}, {19, 20}, {10, 14},
            {4, 18}, {19, 20}}, 16),
                    Arguments.of((Object) new int[][]{{4, 18}, {19, 20}, {13, 20},
            {19, 20}, {10, 14}}, 16),
                    Arguments.of((Object) new int[][]{{4, 18}, {19, 20}, {13, 20},
            {19, 20}, {10, 14}, {12, 19}, {22, 26}, {45, 52}, {15, 42}, {27, 35}}, 45)
            );
        }
    }

    @Nested
    @Tag("Zombit-Antidote")
    @DisplayName("Test for Zombit Antidote challenge")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class Solution5Test {
        static boolean ifcon = true;
        @Order(1)
        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @MethodSource("input")
        void checkSolutionAgainstExpect(int[][] input, int expected) {
            // getting method output
            int res = Solution.solution5(input);
            // checking against expected result
            try {
                assertEquals(expected, res); // utility methods
            } catch (AssertionError e) {
                // at least one test has failed
                // set EnabledIf condition to false
                ifcon = false;
                throw e;
            }
        }
        @Order(2)
        @ParameterizedTest(name = "timeout errors | case {index}")
        @DisplayName("Checking execution times")
        @EnabledIf("passCondition")
        @MethodSource("input")
        void checkSolutionNotExceedTime(int[][] input, int expected) {
            // checking timeout errors
            assertTimeout(ofMillis(50), () -> {
                Solution.solution5(input);
            }, "The solution5" +
                    " method take more than 50 milliseconds");
        }
        static boolean passCondition() {
            return ifcon;
        }
        Stream<Arguments> input() {
            return Stream.of(
                    Arguments.of((Object) new int[][]{{0, 1}, {1, 2}, {2, 3},
            {3, 5}, {4, 5}}, 4),
                    Arguments.of((Object) new int[][]{{0, 1000000}, {42, 43},
            {0, 1000000}, {42, 43}}, 1),
                    Arguments.of((Object) new int[][]{{0, 7}, {1, 5}, {5, 6},
            {1, 5}, {9, 10}}, 3),
                    Arguments.of((Object) new int[][]{{4, 10}, {1, 5}, {4, 6},
            {3, 15}, {4, 10}, {0, 2}, {2, 8}}, 2),
                    Arguments.of((Object) new int[][]{{5, 12}, {2, 3}, {40, 43},
            {3, 15}, {0, 1000000}, {0, 2}, {2, 8}}, 4),
                    Arguments.of((Object) new int[][]{{0, 100}, {2, 3}, {40, 43},
            {3, 15}, {5, 12}, {0, 2}, {2, 8}}, 4)
            );
        }
    }

    @Nested
    @Tag("Zombit-Infection")
    @DisplayName("Test for Zombit Infection challenge")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Solution6Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @MethodSource("input")
        void checkSolutionAgainstExpect(int[][] input, int c, int r, int s, int[][] expected) {
            // getting method output
            int[][] res = Solution.solution6(input, c, r, s);
//             System.out.println(Arrays.deepToString(res));
            // checking against expected result
            assertArrayEquals(expected, res);
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @DisplayName("Checking execution times")
        @MethodSource("input")
        void checkSolutionNotExceedTime(int[][] input, int c, int r, int s, int[][] expected) {
            // checking timeout errors
            assertTimeout(ofMillis(200), () -> {
                Solution.solution6(input, c, r, s);
            }, "The solution6 method take more than 200 milliseconds");
        }

        Stream<Arguments> input() {
            return Stream.of(
                    Arguments.of((Object) new int[][]{{1, 2, 3}, {2, 3, 4},
            {3, 2, 1}}, 0, 0, 2, new int[][]{{-1, -1, 3},
            {-1, 3, 4}, {3, 2, 1}}),
                    Arguments.of((Object) new int[][]{{1, 2, 3}, {2, 3, 4},
            {2, 2, 1}, {2, 2, 5}}, 0, 0, 2,
                    new int[][]{{-1, -1, 3}, {-1, 3, 4}, {-1, -1, -1}, {-1, -1, 5}}),
                    Arguments.of((Object) new int[][]{{6, 7, 2, 7, 6},
            {6, 3, 1, 4, 7}, {0, 2, 4, 1, 10}, {8, 1, 1, 4, 9}, {8, 7, 4, 9, 9}},
                    2, 1, 5, new int[][]{{6, 7, -1, 7, 6},
                    {6, -1, -1, -1, 7}, {-1, -1, -1, -1, 10}, {8, -1, -1, -1, 9},
                    {8, 7, -1, 9, 9}})
            );
        }
    }

    @Nested
    @Tag("Please-Pass-The-Coded-Messages")
    @DisplayName("Test for Please Pass The Coded Messages challenge")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Solution7Test {

        @ParameterizedTest(name = "expected result | case {index}")
        @DisplayName("Checking function output")
        @MethodSource("input")
        void checkSolutionAgainstExpect(int[] input, String expected) {
            // getting method output
            String numchar = Solution.solution7(input);
            // checking against expected result
            assertEquals(expected, numchar);
        }

        @ParameterizedTest(name = "timeout errors | case {index}")
        @DisplayName("Checking execution times")
        @MethodSource("input")
        void checkSolutionNotExceedTime(int[] input, int expected) {
            // checking timeout errors
            assertTimeout(ofMillis(250), () -> {
                Solution.solution7(input);
            }, "The solution8 method take more than 250 milliseconds");
        }

        Stream<Arguments> input() {
            return Stream.of(
                    Arguments.of((Object) new int[]{2, 2, 6}, "6"),
                    Arguments.of((Object) new int[]{3, 1, 4, 1}, "4311"),
                    Arguments.of((Object) new int[]{3, 1, 4, 1, 5, 9}, "94311"),
                    Arguments.of((Object) new int[]{1, 1, 1, 1, 1, 1, 1, 1}, "111111"),
                    Arguments.of((Object) new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1}, "0")
            );
        }
    }
}

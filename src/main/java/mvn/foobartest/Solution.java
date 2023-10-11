package mvn.foobartest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Criogenox
 */
class Solution {

    /*--------------------------------------------------------------------------
                                ===> Re-ID <===  
                                ===============     
There's some unrest in the minion ranks: minions with ID numbers like "1", "42", 
and other "good" numbers have been lording it over the poor minions who 
are stuck with more boring IDs. To quell the unrest, Commander Lambda has 
tasked you with reassigning everyone new, random IDs based on her Completely 
Foolproof Scheme.

She's concatenated the prime numbers in a single long string: "2357111317192329...". 
Now every minion must draw a number from a hat. That number is the starting index 
in that string of primes, and the minion's new ID number will be the next five 
digits in the string. So if a minion draws "3", their ID number will be "71113".

Help the Commander assign these IDs by writing a function solution(n) which takes
in the starting index n of Lambda's string of all primes, and returns the next 
five digits in the string. Commander Lambda has a lot of minions, so the value 
of n will always be between 0 and 10000.        
//-------------------------
Test Cases
        
Input:
    solution.solution(0)
Output:
    "23571"

Input:
    solution.solution(3)
Output:
    "71113" 

Input:
    solution.solution(10000)
Output:
    "63109"
    
//-------------------------
     */
    static String solution1(int n) {
        // elemental prime numbers 2/3/5/7
        String str = "2357";
        int np = 11;
        // get string at least n+5 long (It can be a little longer)
        while (str.length() < n + 5) {
            //
            if (np % 2 != 0 && np % 3 != 0
                    && np % 5 != 0 && np % 7 != 0) {
                //
                str = str + np;
            }
            np++;
        }
        return str.substring(n, n + 5);
    }

    /*---------------------------------------------------------------------------
                              ===> Palindrome <===  
                              ====================
To help Beta Rabbit crack the lock, write a function solution(n) which returns 
the smallest positive integer base b, at least 2, in which the integer n is a 
palindrome. The input n will satisfy "0 <= n <= 1000".
//-------------------------
Test Cases
   
Input:
    solution.solution(0)
Output:
    2

Input:
    solution.solution(42)
Output:
    4
    
Input:
    solution.solution(1000)
Output:
    9
//-------------------------
     */
    static int solution2(int n) {
        //
        double res, fnum, num;
        int b = 2, p = 0, fn, numi, l, lh, pal;
        char a, c;
        //
        while (true) {
            // highest power for b base (included into n at least once)
            String conv = "";
            while (n >= Math.pow(b, p)) {
                p++;
            }
            // conversion n to b base
            fnum = n / (Math.pow(b, (p - 1)));
            fn = (int) Math.floor(fnum);
            conv = conv + fn;
            res = fnum - fn;
            //
            while (p > 1) {
                num = b * res;
                numi = (int) Math.floor(num);
                conv = conv + numi;
                res = num - numi;
                p--;
            }
            // palindrome check
            l = conv.length();
            lh = (int) Math.floor(l / 2);
            pal = 0;
            for (int j = 0; j < lh; j++) {
                //
                a = conv.charAt(j);
                c = conv.charAt(l - (j + 1));
                //
                if (a != c) {
                    pal = 1;
                    break;
                }
            }
            if (pal == 0) {
                return b;
            }
            b++;
        }
    }

    /*--------------------------------------------------------------------------
                           ===> Square Supplies <===  
                           =========================
With the zombie cure injections ready to go, it's time to start treating our 
zombified rabbit friends (known as zombits) at our makeshift zombit treatment 
center. You need to run out really fast to buy some gauze pads but you only have 
30 seconds before you need to be back.

Luckily, the corner store has unlimited gauze pads in squares of all sizes. 
Jackpot! The pricing is simple - a square gauze pad of size K x K costs exactly 
K * K coins. For example, a gauze pad of size 3x3 costs 9 coins.

You're in a hurry and the cashier takes a long time to process each transaction. 
You decide the fastest way to get what you need is to buy as few gauze pads as 
possible, while spending all of your coins (you can always cut up the gauze later 
if you need to). Given that you have n coins, what's the fewest number of gauze 
pads you can buy?

Write a method solution(n), which returns the smallest number of square gauze
pads that can be bought with exactly n coins.

n will be an integer, satisfying 1 <= n <= 10000.
//-------------------------
Test Cases
   
Input:
    solution.solution(24)
Output:
    3

Input:
    solution.solution(160)
Output:
    2
    
Input:
    solution.solution(10000)
Output:
    1
//-------------------------
     */
    static int solution3(int n) {
        //
        int cost, res = 1, count = 0;
        while (res != 0) {
            count++;
            // get the bigger gauze
            int b = 1, gt = 0;
            while (gt <= n) {
                gt = (int) Math.pow(b, (2));
                b++;
            }
            cost = (int) Math.pow((b - 2), (2));
            // remaining coins
            res = n - cost;
            n = res;
        }
        return count;
    }

    /*---------------------------------------------------------------------------
                          ===> Zombit Monitoring <===  
                          ===========================
The first successfully created zombit specimen, Dolly the Zombit, needs constant
monitoring, and Professor Boolean has tasked the minions with it. Any minion who 
monitors the zombit records the start and end times of their shifts. However, 
those minions, they are a bit disorganized: there may be times when multiple 
minions are monitoring the zombit, and times when there are none!

That's fine, Professor Boolean thinks, one can always hire more minions... 
Besides, Professor Boolean can at least figure out the total amount of time that 
Dolly the Zombit was monitored. He has entrusted you, another one of his trusty 
minions, to do just that. Are you up to the task?

Write a function solution(intervals) that takes a list of pairs [start, end] and 
returns the total amount of time that Dolly the Zombit was monitored by at least 
one minion. Each [start, end] pair represents the times when a minion started and 
finished monitoring the zombit. All values will be positive integers no greater 
than 2^30 - 1. You will always have end > start for each interval.
//-------------------------
Test Cases
   
Input:
    solution.solution([[1, 3], [3, 6]])
Output:
    5

Input:
    solution.solution([[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]])
Output:
    16
    
Input:
    solution.solution([[19, 20], [13, 20], [19, 20], [4, 18], [10, 14]])
Output:
    16
    
Input:
    solution.solution([[13, 20], [4, 18], [10, 14], [19, 20], [19, 20]])
Output:
    16
    
Input:
    solution.solution([[4, 18], [19, 20], [13, 20], [19, 20], [10, 14]])
Output:
    16

Input:
    solution.solution([[4, 18], [19, 20], [13, 20], [19, 20], [10, 14], 
                       [12, 19], [22, 26], [45, 52], [15, 42], [27, 35]])
Output:
    45  
//-------------------------
     */
    static int solution4(int[][] arr) {
        // 
        for (int j = 0; j < arr.length - 1; j++) {
            // overlapping check-up
            for (int i = j + 1; i < arr.length; i++) {
                // 
                if (arr[i][0] <= arr[j][0] && arr[i][1] >= arr[j][1]) { //   |---|    j
                                                                        // |-------|  i
                    arr[j][0] = -1;
                    break; // set -1 to dropped j row
                }
                //
                if (arr[i][0] >= arr[j][0] && arr[i][1] <= arr[j][1]) { // |-------|  j
                                                                        //   |---|    i
                    arr[i][0] = arr[j][0];
                    arr[i][1] = arr[j][1]; // keeping i row
                    arr[j][0] = -1;
                    break; // set -1 to dropped j row
                }
                //
                if (arr[i][0] >= arr[j][0] && arr[i][0] <= arr[j][1]
                        && arr[i][1] > arr[j][1]) { // |---|      j
                                                    //   |------| i    
                    arr[i][0] = arr[j][0];  // keeping i row                                                                               
                    arr[j][0] = -1;
                    break; // set -1 to dropped j row
                }
                //
                if (arr[i][0] < arr[j][0] && arr[i][1] >= arr[j][0]
                        && arr[i][1] < arr[j][1]) { //      |---| j
                                                    // |------|   i      
                    arr[i][1] = arr[j][1];  // keeping i row                                                                               
                    arr[j][0] = -1;
                    break; // set -1 to dropped j row   
                }
            }
        }
        int count = 0;
        for (int[] arri : arr) {
            if (arri[0] != -1) {
                count = count + (arri[1] - arri[0]); // counting total time
            }
        }
        return count;
    }

    /*--------------------------------------------------------------------------
                          ===> Zombit Antidote <===  
                          =========================
Forget flu season. Zombie rabbits have broken loose and are terrorizing Silicon 
Valley residents! Luckily, you've managed to steal a zombie antidote and set up 
a makeshift rabbit rescue station. Anyone who catches a zombie rabbit can schedule 
a meeting at your station to have it injected with the antidote, turning it back 
from a zombit to a fluffy bunny. Unfortunately, you have a limited amount of time 
each day, so you need to maximize these meetings. Every morning, you get a list 
of requested injection meetings, and you have to decide which to attend fully. 
If you go to an injection meeting, you will join it exactly at the start of the 
meeting, and only leave exactly at the end.

Can you optimize your meeting schedule? The world needs your help!

Write a method called solution(meetings) which, given a list of meeting requests, 
returns the maximum number of non-overlapping meetings that can be scheduled. If 
the start time of one meeting is the same as the end time of another, they are 
not considered overlapping.

meetings will be a list of lists. Each element of the meetings list will be a two
element list denoting a meeting request. The first element of that list will be 
the start time and the second element will be the end time of that meeting request.

All the start and end times will be non-negative integers, no larger than 1000000. 
The start time of a meeting will always be less than the end time.

The number of meetings will be at least 1 and will be no larger than 100. The list 
of meetings will not necessarily be ordered in any particular fashion.
//-------------------------
Test Cases

Input:
    solution.solution([[0, 1], [1, 2], [2, 3], [3, 5], [4, 5]])
Output:
    4

Input:
    solution.solution([[0, 1000000], [42, 43], [0, 1000000], [42, 43]])
Output:
    1
    
Input:
    solution.solution([[0, 7], [1, 5], [5, 6], [1, 5], [9, 10]])
Output:
    3

Input:
    solution.solution([[4, 10], [1, 5], [4, 6], [3, 15], [4, 10], [0, 2], [2, 8]])
Output:
    2
    
Input:
    solution.solution([[5, 12], [2, 3], [40, 43], [3, 15], [0, 1000000], [0, 2], [2, 8]])
Output:
    4

Input:
    solution.solution([[0, 100], [2, 3], [40, 43], [3, 15], [5, 12], [0, 2], [2, 8]])
Output:
    4 
//-------------------------
     */
    static int solution5(int[][] arr) {
        // meeting length calculation
        int[] dif = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            dif[k] = arr[k][1] - arr[k][0];
        }
        sort(dif, arr, dif.length); // sorting by increasing length 
        //
        int count = 1;
        ArrayList<Integer> idx = new ArrayList<>();
        idx.add(0, -1); // first meeting
        for (int j = 0; j < arr.length - 1; j++) {
            //
            for (int i = j + 1; i < arr.length; i++) {
                // initial overlapping check-up
                while (j == 0) {
                    if ((arr[i][0] >= arr[j][1] || arr[i][1] <= arr[j][0])) {
                        idx.add(i, -1);   //     |---|     j
                        count++;          // |---|   |---| i
                        break;
                    }
                    idx.add(i, 0);
                    break; // no counted meeting 
                }
                //
                if (count > 1) {
                    // duplicate meeting deletion
                    if ((arr[i][0] == arr[j][0] && arr[i][1] == arr[j][1])
                            && idx.get(j) == -1) {  //     |---|     j
                                                    //     |---|     i                                                     
                        count--;
                        break;
                    }
                    // overlapped counted-twice meetings deletion
                    if (!(arr[i][0] >= arr[j][1] || arr[i][1] <= arr[j][0])) {
                        //
                        if (idx.get(i) == -1 && idx.get(j) == -1) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }

    static void sort(int dif[], int[][] arr, int n) {
        // recursive sort algorithm
        if (n <= 1) {                 
            return;
        }
        //
        sort(dif, arr, n - 1);        
        //
        int last = dif[n - 1];           
        int[] arrlast = arr[n - 1];
        int j = n - 2;                  

        while (j >= 0 && dif[j] > last) { // < last ==> highest to lowest
                                          // > last ==> lowest to highest
            arr[j + 1] = arr[j];
            dif[j + 1] = dif[j];         
            j--;                       
        }
        dif[j + 1] = last;              
        arr[j + 1] = arrlast;
    }

    /*--------------------------------------------------------------------------
                          ===> Zombit Infection <===  
                          ==========================
Dr. Boolean continues to perform diabolical studies on your fellow rabbit kin, 
and not all of it is taking place in the lab. Reports say the mad doctor has his 
eye on infecting a rabbit in a local village with a virus that transforms rabbits 
into zombits (zombie-rabbits)!

Professor Boolean is confident in the virus's ability to spread, and he will only 
infect a single rabbit. Unfortunately, you and your fellow resistance agents have 
no idea which rabbit will be targeted. You've been asked to predict how the 
infection would spread if uncontained, so you decide to create a simulation 
experiment. In this simulation, the rabbit that Dr. Boolean will initially infect 
will be called "Patient Z".

So far, the lab experts have discovered that all rabbits contain a property they 
call "Resistance", which is capable of fighting against the infection. The virus 
has a particular "Strength" which Dr. Boolean needs to make at least as large as 
the rabbits' Resistance for it to infect them.

You will be provided with the following information: population = A 2D non-empty 
array of positive integers. (The dimensions of the array are not necessarily equal.) 
Each cell represents one rabbit, and the value of the cell represents that rabbit's 
Resistance. All cells contain a rabbit. x = The X-Coordinate (column) of "Patient Z" 
in the population array. y = The Y-Coordinate (row) of "Patient Z" in the population 
array. strength = A constant integer value representing the Strength of the virus.

Here are the rules of the simulation: First, the virus will attempt to infect 
Patient Z. Patient Z will only be infected if the infection's Strength equals or 
exceeds Patient Z's Resistance. From then on, any infected rabbits will attempt 
to infect any uninfected neighbors (cells that are directly - not diagonally - 
adjacent in the array). They will succeed in infecting any neighbors with a 
Resistance lower than or equal to the infection's Strength. This will continue 
until no further infections are possible (i.e., every uninfected rabbit adjacent 
to an infected rabbit has a Resistance greater than the infection's Strength.)

You will write a function solution(population, x, y, strength), which outputs a 
copy of the input array representing the state of the population at the end of 
the simulation, in which any infected cells value has been replaced with -1. The 
Strength and Resistance values will be between 0 and 10000. The population grid 
will be at least 2x2 and no larger than 50x50. The x and y values will be valid 
indices in the population arrays, with numbering beginning from 0.
//-------------------------
Test Cases

Input:
    solution.solution([[ 1, 2, 3], 
                       [ 2, 3, 4], 
                       [ 3, 2, 1]], 0, 0, 2)
Output:
    [[-1, -1, 3], 
     [-1,  3, 4], 
     [ 3,  2, 1]]

Input:
    solution.solution([[ 1, 2, 3], 
                       [ 2, 3, 4], 
                       [ 2, 2, 1]
                       [ 2, 5, 5]], 0, 0, 2)
Output:
    [[-1, -1,  3], 
     [-1,  3,  4], 
     [-1, -1, -1],
     [-1, -1,  5]]
  
Input:
    solution.solution([[ 6,  7, -1,  7,  6],
                       [ 6, -1, -1, -1,  7], 
                       [-1, -1, -1, -1, 10], 
                       [ 8, -1, -1, -1,  9], 
                       [ 8,  7, -1,  9,  9]], 2, 1, 5)
Output:
     [[ 6,  7, -1,  7,  6], 
      [ 6, -1, -1, -1,  7], 
      [-1, -1, -1, -1, 10], 
      [ 8, -1, -1, -1,  9], 
      [ 8,  7, -1,  9,  9]]
//-------------------------
     */
    static int[][] solution6(int[][] arr, int c, int r, int s) {
        //
        int xl = arr[0].length;
        int yl = arr.length; // 3
        if (arr[r][c] <= s) {
            arr[r][c] = -1;
        }
        //
        if (arr[r][c] == -1) { // patient z's row/column scanning
            for (int i = c - 1; i > -1; i--) {
                if (arr[r][i] <= s && arr[r][i + 1] == -1) {
                    arr[r][i] = -1;
                }
            }
            for (int i = c + 1; i < xl; i++) {
                if (arr[r][i] <= s && arr[r][i - 1] == -1) {
                    arr[r][i] = -1;
                }
            }
            for (int i = r - 1; i > -1; i--) {
                if (arr[i][c] <= s && arr[i + 1][c] == -1) {
                    arr[i][c] = -1;
                }
            }
            for (int i = r + 1; i < yl; i++) {
                if (arr[i][c] <= s && arr[i - 1][c] == -1) {
                    arr[i][c] = -1;
                }
            }
            // 
            int nc = c - 1, pc = c + 1;
            while (nc > -1) {  // patient z's left columns
                for (int i = r - 1; i > -1; i--) { // patient z's upper rows
                    if (arr[i][nc] <= s && (arr[i][nc + 1] == -1 || arr[i + 1][nc] == -1)) {
                        arr[i][nc] = -1;
                    }
                }
                for (int i = r + 1; i < yl; i++) { // patient z's lower rows
                    if (arr[i][nc] <= s && (arr[i][nc + 1] == -1 || arr[i - 1][nc] == -1)) {
                        arr[i][nc] = -1;
                    }
                }
                nc--;
            }
            while (pc < xl) {  // patient z's right columns
                for (int i = r - 1; i > -1; i--) { // patient z's upper rows
                    if (arr[i][pc] <= s && (arr[i][pc - 1] == -1 || arr[i + 1][pc] == -1)) {
                        arr[i][pc] = -1;
                    }
                }
                for (int i = r + 1; i < yl; i++) { // patient z's lower rows
                    if (arr[i][pc] <= s && (arr[i][pc - 1] == -1 || arr[i - 1][pc] == -1)) {
                        arr[i][pc] = -1;
                    }
                }
                pc++;
            }
        }
        return arr;
    }

    /*---------------------------------------------------------------------------
                    ===> Please Pass The Coded Messages <===  
                    ========================================

You need to pass a message to the bunny prisoners, but to avoid detection, the 
code you agreed to use is... obscure, to say the least. The bunnies are given 
food on standard-issue prison plates that are stamped with the numbers 0-9 for 
easier sorting, and you need to combine sets of plates to create the numbers in 
the code. The signal that a number is part of the code is that it is divisible 
by 3. You can do smaller numbers like 15 and 45 easily, but bigger numbers like 
144 and 414 are a little trickier. Write a program to help yourself quickly 
create large numbers for use in the code, given a limited number of plates to 
work with.

You have L, a list containing some digits (0 to 9). Write a function solution(L) 
which finds the largest number that can be made from some or all of these digits 
and is divisible by 3. If it is not possible to make such a number, return 0 as 
the solution. L will contain anywhere from 1 to 9 digits.  The same digit may 
appear multiple times in the list, but each element in the list may only be used 
once.
//-------------------------
Test Cases

Input:
    solution.solution([3, 1, 4, 1])
Output:
    4311

Input:
    solution.solution([3, 1, 4, 1, 5, 9])
Output:
    94311
    
Input:
    solution.solution([2, 2, 6])
Output:
    6

Input:
    solution.solution([1, 1, 1, 1, 1, 1, 1, 1])
Output: 
    111111
    
Input:
    solution.solution([1, 0, 0, 0, 0, 0, 0, 0, 1])
Output:
    0
//-------------------------
     */
    static String solution7(int[] arr) {
        //
        sort(arr, arr.length); // sorting by increasing length 
        int k = arr.length;
        boolean done = false;
        String numcharf = "";
        //
        while (k > 0) {
            List<int[]> perm = new ArrayList<>();
            boolean[] dig = new boolean[arr.length];
            int[] iPerm = new int[k];
            // k permutations with no repetitions
            calc(arr, k, perm, iPerm, dig, 0);
            //
            for (int[] permutation : perm) {
                int numero = 0;
                String numchar = "";
                for (int num : permutation) {
                    numero = numero + num;
                    numchar = numchar + Integer.toString(num);
                } // test divisibility by 3
                if (numero % 3 == 0) {
                    if (numero == 0) {
                        numcharf = "0";
                    } else {
                        numcharf = numchar;
                    }
                    done = true;
                    break;
                }
            }
            k--;
            if (done) {
                break;
            }
        }
        return numcharf;
    }

    static void sort(int arr[], int n) {
        // recursive sort algorithm
        if (n <= 1) {
            return;
        }
        //
        sort(arr, n - 1);
        //
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] < last) { // < last ==> highest to lowest
                                          // > last ==> lowest to highest
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    static void calc(int[] arr, int k, List<int[]> perm,
            int[] iPerm, boolean[] dig, int idx) {
        if (idx == k) {
            perm.add(iPerm.clone());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!dig[i]) {
                dig[i] = true;
                iPerm[idx] = arr[i];
                calc(arr, k, perm, iPerm, dig, idx + 1);
                dig[i] = false;
            }
        }
    }

}

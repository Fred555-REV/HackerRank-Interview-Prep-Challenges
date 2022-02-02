package organizingcontainersofballs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        //                         types
        //containers

        //Keep track of amount of balls in each container
        //If there is more of one type than the max amount in a container impossible Done

        /*
    1 3 1  5                 0 2 1      TESTCASE     0 2    2
    2 1 2  5                 1 1 1                   1 1    2
    3 3 3  9                 2 0 0                  1  3
    6 7 7


10
2
999336263 998799923
998799923 999763019
4
997612619 934920795 998879231 999926463
960369681 997828120 999792735 979622676
999013654 998634077 997988323 958769423
997409523 999301350 940952923 993020546
9
993263231 806455183 972467746 761846174 226680660 667393859 815298761 790313908 997845516
873142072 579210472 996344520 999601755 904458846 663577990 980240637 713052540 963408591
551159221 873763794 752756532 798803609 670921889 995259612 981339960 763904498 499472207
975980611 999974039 729219884 834636710 973988213 969888254 846967495 687204298 511348404
993232608 998103218 857820670 995587240 817798750 773950980 824882180 797565274 887424441
847857578 768853671 916073200 982234748 986511977 733420232 997714976 819799716 891570083
733197334 985682497 612123868 971798655 999905357 710092446 997494889 683312998 850074746
799093993 543648222 944524289 814951921 981087922 997222915 506561779 997697933 652807674
989362549 973516812 891706714 786904549 982329176 376575034 993535504 984745483 777613376
8
46243313 92616295 67710591 64815435 54972858 72243452 43981963 98839842
92051933 89794374 13448199 23493279 82268795 11069706 82550576 19654929
81743395 56456242 80407875 99464396 95594850 44919631 12483256 54576390
31379865 35550507 13850344 82310457 35039216 11977132 44906966 58819635
10544893 81324309 69520528 81983330 45347555 78383273 77715274 86346533
78482611 37125744 47756688 70062813 86629089 81735741 38208033 80479682
59164275 5441347 85517562 78736923 59124243 51404960 24474089 27179427
48097170 61680833 13467922 1371525 59776803 85694885 96662368 52983154
4
990446736 997114107 981378365 996304832
998069384 997117556 999915673 983059005
977726971 997275340 996964137 999686661
999000949 999267170 999903443 992602611
8
95191218 87409555 42950393 42038751 84631134 48464787 59894151 72209295
10208942 40165003 24468583 74313769 78553469 12298347 92465316 98013853
11962063 97319173 32772008 57537234 47515651 96327283 13026475 6272697
15196842 74022651 40230895 29947691 22917615 13671399 53857449 59913669
12346213 63160025 19794975 11420503 11101182 7020704 99262506 99345314
63048552 59405595 80841813 57114539 698590 30758610 35361024 19021664
48021465 59401215 33812089 32481698 38580652 37607783 66478344 64808679
21875586 87926772 98872000 19211740 76777430 661772 86446637 49124189
5
979032185 977330496 624547097 994815517 999577525
539128031 998016416 976111699 872522746 999964658
997364357 998086547 951266271 999938891 821877010
988421608 997815396 999690278 997717508 566289150
999245153 797284221 998318595 710308158 998035207
3
997427147 999234285 998319806
993127006 999257405 999972351
999251470 996489548 994064605
2
999789250 999886349
999654053 999789250
5
793248296 992239720 805150460 911286487 830355332
994381728 671232291 999428047 887238380 999950552
994157957 987220978 763871658 995769647 999904596
999500311 735194138 984736325 992803407 967745073
998302692 946393168 999044508 892881333 942969283

         */
        //key = type  v = amount

        HashMap<Integer, BigInteger> typeAmounts = new HashMap<>();
        HashMap<Integer, BigInteger> containerAmounts = new HashMap<>();
        for (int i = 0; i < container.size(); i++) {
            List<Integer> singleContainer = container.get(i);
            BigInteger containerAmount = BigInteger.valueOf(0);
            for (int j = 0; j < singleContainer.size(); j++) {
                BigInteger ballAmount = BigInteger.valueOf(singleContainer.get(j));
                //Adding a ball to typeAmounts map
                if (!typeAmounts.containsKey(j)) {
                    typeAmounts.put(j, ballAmount);
                } else {
                    BigInteger c = typeAmounts.get(j).add(ballAmount);
                    typeAmounts.put(j, c);
                }

                containerAmount = containerAmount.add(ballAmount);
            }
            containerAmounts.put(i, containerAmount);
        }
        System.out.println();
        System.out.println(containerAmounts);
        System.out.println(typeAmounts);
        for (int type : typeAmounts.keySet()) {
            boolean isValid = false;
            for (int key : containerAmounts.keySet()) {
                if (typeAmounts.get(type).equals(containerAmounts.get(key))) {
                    containerAmounts.remove(key);
                    isValid = true;
                    break;
                }
            }
            if(!isValid){
                return "Impossible";
            }
        }
        return "Possible";
    }
    /*
TestCase
2
3
1 3 1
2 1 2
3 3 3
3
0 2 1
1 1 1
2 0 0

Outcome
Impossible
Possible
     */

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int q = Integer.parseInt(scan.nextLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            int n = Integer.parseInt(scan.nextLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                container.add(
                        Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            });

            String result = Result.organizingContainers(container);

            System.out.println(result);
        });
        scan.close();

    }
}

package com.ringohub.pcc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem001 {
  public static void main(String[] args) {
    System.out.println(existCertainSum(4, 15, Arrays.asList(1, 20, 12)));
    System.out.println(existCertainSum(4, 15, Arrays.asList(-1, (int) Math.pow(10, 8) + 1, -12)));
  }

  public static boolean compute(int m, List<Integer> l) {
    return existCertainSum(4, m, l);
  }

  /**
   * 与えられた数字のリストから，d回数字を選び，その総和がmと等しくなるような組み合わせは存在するか調べる関数（部分和問題）．
   * @param d
   * @param m
   * @param list
   * @return
   */
  public static boolean existCertainSum(int d, int m, List<Integer> list) throws IllegalArgumentException {
    int n = list.size();
    // Argument inspection
    List<String> errorMessages = new ArrayList<String>();
    if (n < 1 || n > 50) errorMessages.add("n: Domain error. Must be (1 <= n <= 50).");
    if (m < 1 || m > Math.pow(10, 8)) errorMessages.add("m: Domain error. Must be (1 <= m <= 10^8).");
    list.stream().filter(k -> (k < 1 || k > Math.pow(10, 8))).forEach(
        k -> errorMessages.add("k: Domain error. Must be (1 <= k <= 10^8). " + k + " has been detected."));
    if (!errorMessages.isEmpty()) {
      throw new IllegalArgumentException(
          "\n" + errorMessages.stream().collect(Collectors.joining("\n")));
    }

    return existCertainSum(d, m, list, 0);
  }

  private static boolean existCertainSum(int d, int m, List<Integer> list, int sum) {
    if (sum > m) return false;
    if (d == 0 && sum == m) return true;
    if (d == 0) return false;

    for (int k : list) if (existCertainSum(d - 1, m, list, sum + k)) return true;
    return false;
  }
}

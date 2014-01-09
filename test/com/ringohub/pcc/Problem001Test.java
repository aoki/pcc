package com.ringohub.pcc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Problem001Test {

  @Test
  public void 答えサンプルtrue() throws Exception {
    assertThat(Problem001.compute(10, Arrays.asList(1, 3, 5)), is(true));
  }

  @Test
  public void 答えサンプルfalse() throws Exception {
    assertThat(Problem001.compute(9, Arrays.asList(1, 3, 5)), is(false));
  }


  // n に関するテスト
  @Test(expected = IllegalArgumentException.class)
  public void nが0である時に例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(4, 1, new ArrayList<Integer>()), is(true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nが50を超える値である時に例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(4, 1, range(1, 52).boxed().collect(Collectors.toList())), is(false));
  }


  // m に関するテスト
  @Test(expected = IllegalArgumentException.class)
  public void mが負の値である時に例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, -1, Arrays.asList(1, 2, 3)), is(true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void mが0である時に例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, 0, Arrays.asList(1, 2, 3)), is(true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void mが10の8乗を超える値である時に例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, (int) Math.pow(10, 8) + 1, Arrays.asList(1, 2, 3)), is(true));
  }


  // k に関するテスト
  @Test(expected = IllegalArgumentException.class)
  public void 与えられたリストに負の数が入っていると例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, 1, Arrays.asList(-1, 2, 3)), is(true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void 与えられたリストに0が入っていると例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, 1, Arrays.asList(0, 2, 3)), is(true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void 与えられたリストに10の8乗を超える値が入っていると例外が投げられる() throws Exception {
    assertThat(Problem001.existCertainSum(1, 1, Arrays.asList((int) Math.pow(10, 8) + 1, 2, 3)), is(true));
  }
}

/*
 * =====================================
 *  Copyright (c) 2020 NextMove Software
 * =====================================
 */

package org.openscience.cdk.stereo;

import java.util.Arrays;

public class TableGen {

  protected static final int A = 1, B = A + 1, C = B + 1, D = C + 1, E = D + 1, F = E + 1;

  private static final int[][] OH_TABLE = new int[][]{
// @OH1
      {A, B, C, D, E, F, A, C, D, E, B, F, A, D, E, B, C, F, A, E, B, C, D, F,
          B, A, E, F, C, D, B, C, A, E, F, D, B, E, F, C, A, D, B, F, C, A, E, D,
          C, A, B, F, D, E, C, B, F, D, A, E, C, D, A, B, F, E, C, F, D, A, B, E,
          D, A, C, F, E, B, D, C, F, E, A, B, D, E, A, C, F, B, D, F, E, A, C, B,
          E, A, D, F, B, C, E, B, A, D, F, C, E, D, F, B, A, C, E, F, B, A, D, C,
          F, B, E, D, C, A, F, C, B, E, D, A, F, D, C, B, E, A, F, E, D, C, B, A},
// @OH2
      {A, B, E, D, C, F, A, C, B, E, D, F, A, D, C, B, E, F, A, E, D, C, B, F,
          B, A, C, F, E, D, B, C, F, E, A, D, B, E, A, C, F, D, B, F, E, A, C, D,
          C, A, D, F, B, E, C, B, A, D, F, E, C, D, F, B, A, E, C, F, B, A, D, E,
          D, A, E, F, C, B, D, C, A, E, F, B, D, E, F, C, A, B, D, F, C, A, E, B,
          E, A, B, F, D, C, E, B, F, D, A, C, E, D, A, B, F, C, E, F, D, A, B, C,
          F, B, C, D, E, A, F, C, D, E, B, A, F, D, E, B, C, A, F, E, B, C, D, A},
// @OH3
      {A, B, C, D, F, E, A, C, D, F, B, E, A, D, F, B, C, E, A, F, B, C, D, E,
          B, A, F, E, C, D, B, C, A, F, E, D, B, E, C, A, F, D, B, F, E, C, A, D,
          C, A, B, E, D, F, C, B, E, D, A, F, C, D, A, B, E, F, C, E, D, A, B, F,
          D, A, C, E, F, B, D, C, E, F, A, B, D, E, F, A, C, B, D, F, A, C, E, B,
          E, B, F, D, C, A, E, C, B, F, D, A, E, D, C, B, F, A, E, F, D, C, B, A,
          F, A, D, E, B, C, F, B, A, D, E, C, F, D, E, B, A, C, F, E, B, A, D, C},
// @OH4
      {A, B, C, E, D, F, A, C, E, D, B, F, A, D, B, C, E, F, A, E, D, B, C, F,
          B, A, D, F, C, E, B, C, A, D, F, E, B, D, F, C, A, E, B, F, C, A, D, E,
          C, A, B, F, E, D, C, B, F, E, A, D, C, E, A, B, F, D, C, F, E, A, B, D,
          D, A, E, F, B, C, D, B, A, E, F, C, D, E, F, B, A, C, D, F, B, A, E, C,
          E, A, C, F, D, B, E, C, F, D, A, B, E, D, A, C, F, B, E, F, D, A, C, B,
          F, B, D, E, C, A, F, C, B, D, E, A, F, D, E, C, B, A, F, E, C, B, D, A},
// @OH5
      {A, B, C, F, D, E, A, C, F, D, B, E, A, D, B, C, F, E, A, F, D, B, C, E,
          B, A, D, E, C, F, B, C, A, D, E, F, B, D, E, C, A, F, B, E, C, A, D, F,
          C, A, B, E, F, D, C, B, E, F, A, D, C, E, F, A, B, D, C, F, A, B, E, D,
          D, A, F, E, B, C, D, B, A, F, E, C, D, E, B, A, F, C, D, F, E, B, A, C,
          E, B, D, F, C, A, E, C, B, D, F, A, E, D, F, C, B, A, E, F, C, B, D, A,
          F, A, C, E, D, B, F, C, E, D, A, B, F, D, A, C, E, B, F, E, D, A, C, B},
// @OH6
      {A, B, C, E, F, D, A, C, E, F, B, D, A, E, F, B, C, D, A, F, B, C, E, D,
          B, A, F, D, C, E, B, C, A, F, D, E, B, D, C, A, F, E, B, F, D, C, A, E,
          C, A, B, D, E, F, C, B, D, E, A, F, C, D, E, A, B, F, C, E, A, B, D, F,
          D, B, F, E, C, A, D, C, B, F, E, A, D, E, C, B, F, A, D, F, E, C, B, A,
          E, A, C, D, F, B, E, C, D, F, A, B, E, D, F, A, C, B, E, F, A, C, D, B,
          F, A, E, D, B, C, F, B, A, E, D, C, F, D, B, A, E, C, F, E, D, B, A, C},
// @OH7
      {A, B, C, F, E, D, A, C, F, E, B, D, A, E, B, C, F, D, A, F, E, B, C, D,
          B, A, E, D, C, F, B, C, A, E, D, F, B, D, C, A, E, F, B, E, D, C, A, F,
          C, A, B, D, F, E, C, B, D, F, A, E, C, D, F, A, B, E, C, F, A, B, D, E,
          D, B, E, F, C, A, D, C, B, E, F, A, D, E, F, C, B, A, D, F, C, B, E, A,
          E, A, F, D, B, C, E, B, A, F, D, C, E, D, B, A, F, C, E, F, D, B, A, C,
          F, A, C, D, E, B, F, C, D, E, A, B, F, D, E, A, C, B, F, E, A, C, D, B},
// @OH8
      {A, B, D, C, E, F, A, C, E, B, D, F, A, D, C, E, B, F, A, E, B, D, C, F,
          B, A, E, F, D, C, B, D, A, E, F, C, B, E, F, D, A, C, B, F, D, A, E, C,
          C, A, D, F, E, B, C, D, F, E, A, B, C, E, A, D, F, B, C, F, E, A, D, B,
          D, A, B, F, C, E, D, B, F, C, A, E, D, C, A, B, F, E, D, F, C, A, B, E,
          E, A, C, F, B, D, E, B, A, C, F, D, E, C, F, B, A, D, E, F, B, A, C, D,
          F, B, E, C, D, A, F, C, D, B, E, A, F, D, B, E, C, A, F, E, C, D, B, A},
// @OH9
      {A, B, D, C, F, E, A, C, F, B, D, E, A, D, C, F, B, E, A, F, B, D, C, E,
          B, A, F, E, D, C, B, D, A, F, E, C, B, E, D, A, F, C, B, F, E, D, A, C,
          C, A, D, E, F, B, C, D, E, F, A, B, C, E, F, A, D, B, C, F, A, D, E, B,
          D, A, B, E, C, F, D, B, E, C, A, F, D, C, A, B, E, F, D, E, C, A, B, F,
          E, B, F, C, D, A, E, C, D, B, F, A, E, D, B, F, C, A, E, F, C, D, B, A,
          F, A, C, E, B, D, F, B, A, C, E, D, F, C, E, B, A, D, F, E, B, A, C, D},
// @OH10
      {A, B, E, C, D, F, A, C, D, B, E, F, A, D, B, E, C, F, A, E, C, D, B, F,
          B, A, D, F, E, C, B, D, F, E, A, C, B, E, A, D, F, C, B, F, E, A, D, C,
          C, A, E, F, D, B, C, D, A, E, F, B, C, E, F, D, A, B, C, F, D, A, E, B,
          D, A, C, F, B, E, D, B, A, C, F, E, D, C, F, B, A, E, D, F, B, A, C, E,
          E, A, B, F, C, D, E, B, F, C, A, D, E, C, A, B, F, D, E, F, C, A, B, D,
          F, B, D, C, E, A, F, C, E, B, D, A, F, D, C, E, B, A, F, E, B, D, C, A},
// @OH11
      {A, B, F, C, D, E, A, C, D, B, F, E, A, D, B, F, C, E, A, F, C, D, B, E,
          B, A, D, E, F, C, B, D, E, F, A, C, B, E, F, A, D, C, B, F, A, D, E, C,
          C, A, F, E, D, B, C, D, A, F, E, B, C, E, D, A, F, B, C, F, E, D, A, B,
          D, A, C, E, B, F, D, B, A, C, E, F, D, C, E, B, A, F, D, E, B, A, C, F,
          E, B, D, C, F, A, E, C, F, B, D, A, E, D, C, F, B, A, E, F, B, D, C, A,
          F, A, B, E, C, D, F, B, E, C, A, D, F, C, A, B, E, D, F, E, C, A, B, D},
// @OH12
      {A, B, E, C, F, D, A, C, F, B, E, D, A, E, C, F, B, D, A, F, B, E, C, D,
          B, A, F, D, E, C, B, D, E, A, F, C, B, E, A, F, D, C, B, F, D, E, A, C,
          C, A, E, D, F, B, C, D, F, A, E, B, C, E, D, F, A, B, C, F, A, E, D, B,
          D, B, F, C, E, A, D, C, E, B, F, A, D, E, B, F, C, A, D, F, C, E, B, A,
          E, A, B, D, C, F, E, B, D, C, A, F, E, C, A, B, D, F, E, D, C, A, B, F,
          F, A, C, D, B, E, F, B, A, C, D, E, F, C, D, B, A, E, F, D, B, A, C, E},
// @OH13
      {A, B, F, C, E, D, A, C, E, B, F, D, A, E, B, F, C, D, A, F, C, E, B, D,
          B, A, E, D, F, C, B, D, F, A, E, C, B, E, D, F, A, C, B, F, A, E, D, C,
          C, A, F, D, E, B, C, D, E, A, F, B, C, E, A, F, D, B, C, F, D, E, A, B,
          D, B, E, C, F, A, D, C, F, B, E, A, D, E, C, F, B, A, D, F, B, E, C, A,
          E, A, C, D, B, F, E, B, A, C, D, F, E, C, D, B, A, F, E, D, B, A, C, F,
          F, A, B, D, C, E, F, B, D, C, A, E, F, C, A, B, D, E, F, D, C, A, B, E},
// @OH14
      {A, B, D, E, C, F, A, C, B, D, E, F, A, D, E, C, B, F, A, E, C, B, D, F,
          B, A, C, F, D, E, B, C, F, D, A, E, B, D, A, C, F, E, B, F, D, A, C, E,
          C, A, E, F, B, D, C, B, A, E, F, D, C, E, F, B, A, D, C, F, B, A, E, D,
          D, A, B, F, E, C, D, B, F, E, A, C, D, E, A, B, F, C, D, F, E, A, B, C,
          E, A, D, F, C, B, E, C, A, D, F, B, E, D, F, C, A, B, E, F, C, A, D, B,
          F, B, C, E, D, A, F, C, E, D, B, A, F, D, B, C, E, A, F, E, D, B, C, A},
// @OH15
      {A, B, D, F, C, E, A, C, B, D, F, E, A, D, F, C, B, E, A, F, C, B, D, E,
          B, A, C, E, D, F, B, C, E, D, A, F, B, D, A, C, E, F, B, E, D, A, C, F,
          C, A, F, E, B, D, C, B, A, F, E, D, C, E, B, A, F, D, C, F, E, B, A, D,
          D, A, B, E, F, C, D, B, E, F, A, C, D, E, F, A, B, C, D, F, A, B, E, C,
          E, B, C, F, D, A, E, C, F, D, B, A, E, D, B, C, F, A, E, F, D, B, C, A,
          F, A, D, E, C, B, F, C, A, D, E, B, F, D, E, C, A, B, F, E, C, A, D, B},
// @OH16
      {A, B, F, D, C, E, A, C, B, F, D, E, A, D, C, B, F, E, A, F, D, C, B, E,
          B, A, C, E, F, D, B, C, E, F, A, D, B, E, F, A, C, D, B, F, A, C, E, D,
          C, A, D, E, B, F, C, B, A, D, E, F, C, D, E, B, A, F, C, E, B, A, D, F,
          D, A, F, E, C, B, D, C, A, F, E, B, D, E, C, A, F, B, D, F, E, C, A, B,
          E, B, C, D, F, A, E, C, D, F, B, A, E, D, F, B, C, A, E, F, B, C, D, A,
          F, A, B, E, D, C, F, B, E, D, A, C, F, D, A, B, E, C, F, E, D, A, B, C},
// @OH17
      {A, B, E, F, C, D, A, C, B, E, F, D, A, E, F, C, B, D, A, F, C, B, E, D,
          B, A, C, D, E, F, B, C, D, E, A, F, B, D, E, A, C, F, B, E, A, C, D, F,
          C, A, F, D, B, E, C, B, A, F, D, E, C, D, B, A, F, E, C, F, D, B, A, E,
          D, B, C, F, E, A, D, C, F, E, B, A, D, E, B, C, F, A, D, F, E, B, C, A,
          E, A, B, D, F, C, E, B, D, F, A, C, E, D, F, A, B, C, E, F, A, B, D, C,
          F, A, E, D, C, B, F, C, A, E, D, B, F, D, C, A, E, B, F, E, D, C, A, B},
// @OH18
      {A, B, F, E, C, D, A, C, B, F, E, D, A, E, C, B, F, D, A, F, E, C, B, D,
          B, A, C, D, F, E, B, C, D, F, A, E, B, D, F, A, C, E, B, F, A, C, D, E,
          C, A, E, D, B, F, C, B, A, E, D, F, C, D, B, A, E, F, C, E, D, B, A, F,
          D, B, C, E, F, A, D, C, E, F, B, A, D, E, F, B, C, A, D, F, B, C, E, A,
          E, A, F, D, C, B, E, C, A, F, D, B, E, D, C, A, F, B, E, F, D, C, A, B,
          F, A, B, D, E, C, F, B, D, E, A, C, F, D, E, A, B, C, F, E, A, B, D, C},
// @OH19
      {A, B, D, E, F, C, A, D, E, F, B, C, A, E, F, B, D, C, A, F, B, D, E, C,
          B, A, F, C, D, E, B, C, D, A, F, E, B, D, A, F, C, E, B, F, C, D, A, E,
          C, B, F, E, D, A, C, D, B, F, E, A, C, E, D, B, F, A, C, F, E, D, B, A,
          D, A, B, C, E, F, D, B, C, E, A, F, D, C, E, A, B, F, D, E, A, B, C, F,
          E, A, D, C, F, B, E, C, F, A, D, B, E, D, C, F, A, B, E, F, A, D, C, B,
          F, A, E, C, B, D, F, B, A, E, C, D, F, C, B, A, E, D, F, E, C, B, A, D},
// @OH20
      {A, B, D, F, E, C, A, D, F, E, B, C, A, E, B, D, F, C, A, F, E, B, D, C,
          B, A, E, C, D, F, B, C, D, A, E, F, B, D, A, E, C, F, B, E, C, D, A, F,
          C, B, E, F, D, A, C, D, B, E, F, A, C, E, F, D, B, A, C, F, D, B, E, A,
          D, A, B, C, F, E, D, B, C, F, A, E, D, C, F, A, B, E, D, F, A, B, C, E,
          E, A, F, C, B, D, E, B, A, F, C, D, E, C, B, A, F, D, E, F, C, B, A, D,
          F, A, D, C, E, B, F, C, E, A, D, B, F, D, C, E, A, B, F, E, A, D, C, B},
// @OH21
      {A, B, E, D, F, C, A, D, F, B, E, C, A, E, D, F, B, C, A, F, B, E, D, C,
          B, A, F, C, E, D, B, C, E, A, F, D, B, E, A, F, C, D, B, F, C, E, A, D,
          C, B, F, D, E, A, C, D, E, B, F, A, C, E, B, F, D, A, C, F, D, E, B, A,
          D, A, E, C, F, B, D, C, F, A, E, B, D, E, C, F, A, B, D, F, A, E, C, B,
          E, A, B, C, D, F, E, B, C, D, A, F, E, C, D, A, B, F, E, D, A, B, C, F,
          F, A, D, C, B, E, F, B, A, D, C, E, F, C, B, A, D, E, F, D, C, B, A, E},
// @OH22
      {A, B, F, D, E, C, A, D, E, B, F, C, A, E, B, F, D, C, A, F, D, E, B, C,
          B, A, E, C, F, D, B, C, F, A, E, D, B, E, C, F, A, D, B, F, A, E, C, D,
          C, B, E, D, F, A, C, D, F, B, E, A, C, E, D, F, B, A, C, F, B, E, D, A,
          D, A, F, C, E, B, D, C, E, A, F, B, D, E, A, F, C, B, D, F, C, E, A, B,
          E, A, D, C, B, F, E, B, A, D, C, F, E, C, B, A, D, F, E, D, C, B, A, F,
          F, A, B, C, D, E, F, B, C, D, A, E, F, C, D, A, B, E, F, D, A, B, C, E},
// @OH23
      {A, B, E, F, D, C, A, D, B, E, F, C, A, E, F, D, B, C, A, F, D, B, E, C,
          B, A, D, C, E, F, B, C, E, A, D, F, B, D, C, E, A, F, B, E, A, D, C, F,
          C, B, D, F, E, A, C, D, F, E, B, A, C, E, B, D, F, A, C, F, E, B, D, A,
          D, A, F, C, B, E, D, B, A, F, C, E, D, C, B, A, F, E, D, F, C, B, A, E,
          E, A, B, C, F, D, E, B, C, F, A, D, E, C, F, A, B, D, E, F, A, B, C, D,
          F, A, E, C, D, B, F, C, D, A, E, B, F, D, A, E, C, B, F, E, C, D, A, B},
// @OH24
      {A, B, F, E, D, C, A, D, B, F, E, C, A, E, D, B, F, C, A, F, E, D, B, C,
          B, A, D, C, F, E, B, C, F, A, D, E, B, D, C, F, A, E, B, F, A, D, C, E,
          C, B, D, E, F, A, C, D, E, F, B, A, C, E, F, B, D, A, C, F, B, D, E, A,
          D, A, E, C, B, F, D, B, A, E, C, F, D, C, B, A, E, F, D, E, C, B, A, F,
          E, A, F, C, D, B, E, C, D, A, F, B, E, D, A, F, C, B, E, F, C, D, A, B,
          F, A, B, C, E, D, F, B, C, E, A, D, F, C, E, A, B, D, F, E, A, B, C, D},
// @OH25
      {A, C, D, E, F, B, A, D, E, F, C, B, A, E, F, C, D, B, A, F, C, D, E, B,
          B, C, F, E, D, A, B, D, C, F, E, A, B, E, D, C, F, A, B, F, E, D, C, A,
          C, A, F, B, D, E, C, B, D, A, F, E, C, D, A, F, B, E, C, F, B, D, A, E,
          D, A, C, B, E, F, D, B, E, A, C, F, D, C, B, E, A, F, D, E, A, C, B, F,
          E, A, D, B, F, C, E, B, F, A, D, C, E, D, B, F, A, C, E, F, A, D, B, C,
          F, A, E, B, C, D, F, B, C, A, E, D, F, C, A, E, B, D, F, E, B, C, A, D},
// @OH26
      {A, C, D, F, E, B, A, D, F, E, C, B, A, E, C, D, F, B, A, F, E, C, D, B,
          B, C, E, F, D, A, B, D, C, E, F, A, B, E, F, D, C, A, B, F, D, C, E, A,
          C, A, E, B, D, F, C, B, D, A, E, F, C, D, A, E, B, F, C, E, B, D, A, F,
          D, A, C, B, F, E, D, B, F, A, C, E, D, C, B, F, A, E, D, F, A, C, B, E,
          E, A, F, B, C, D, E, B, C, A, F, D, E, C, A, F, B, D, E, F, B, C, A, D,
          F, A, D, B, E, C, F, B, E, A, D, C, F, D, B, E, A, C, F, E, A, D, B, C},
// @OH27
      {A, C, E, D, F, B, A, D, F, C, E, B, A, E, D, F, C, B, A, F, C, E, D, B,
          B, C, F, D, E, A, B, D, E, C, F, A, B, E, C, F, D, A, B, F, D, E, C, A,
          C, A, F, B, E, D, C, B, E, A, F, D, C, E, A, F, B, D, C, F, B, E, A, D,
          D, A, E, B, F, C, D, B, F, A, E, C, D, E, B, F, A, C, D, F, A, E, B, C,
          E, A, C, B, D, F, E, B, D, A, C, F, E, C, B, D, A, F, E, D, A, C, B, F,
          F, A, D, B, C, E, F, B, C, A, D, E, F, C, A, D, B, E, F, D, B, C, A, E},
// @OH28
      {A, C, F, D, E, B, A, D, E, C, F, B, A, E, C, F, D, B, A, F, D, E, C, B,
          B, C, E, D, F, A, B, D, F, C, E, A, B, E, D, F, C, A, B, F, C, E, D, A,
          C, A, E, B, F, D, C, B, F, A, E, D, C, E, B, F, A, D, C, F, A, E, B, D,
          D, A, F, B, E, C, D, B, E, A, F, C, D, E, A, F, B, C, D, F, B, E, A, C,
          E, A, D, B, C, F, E, B, C, A, D, F, E, C, A, D, B, F, E, D, B, C, A, F,
          F, A, C, B, D, E, F, B, D, A, C, E, F, C, B, D, A, E, F, D, A, C, B, E},
// @OH29
      {A, C, E, F, D, B, A, D, C, E, F, B, A, E, F, D, C, B, A, F, D, C, E, B,
          B, C, D, F, E, A, B, D, F, E, C, A, B, E, C, D, F, A, B, F, E, C, D, A,
          C, A, D, B, E, F, C, B, E, A, D, F, C, D, B, E, A, F, C, E, A, D, B, F,
          D, A, F, B, C, E, D, B, C, A, F, E, D, C, A, F, B, E, D, F, B, C, A, E,
          E, A, C, B, F, D, E, B, F, A, C, D, E, C, B, F, A, D, E, F, A, C, B, D,
          F, A, E, B, D, C, F, B, D, A, E, C, F, D, A, E, B, C, F, E, B, D, A, C},
// @OH30
      {A, C, F, E, D, B, A, D, C, F, E, B, A, E, D, C, F, B, A, F, E, D, C, B,
          B, C, D, E, F, A, B, D, E, F, C, A, B, E, F, C, D, A, B, F, C, D, E, A,
          C, A, D, B, F, E, C, B, F, A, D, E, C, D, B, F, A, E, C, F, A, D, B, E,
          D, A, E, B, C, F, D, B, C, A, E, F, D, C, A, E, B, F, D, E, B, C, A, F,
          E, A, F, B, D, C, E, B, D, A, F, C, E, D, A, F, B, C, E, F, B, D, A, C,
          F, A, C, B, E, D, F, B, E, A, C, D, F, C, B, E, A, D, F, E, A, C, B, D}
  };

  // https://oeis.org/A180632
  private static String OH_SUPERPERM =
      "1234561234516234512634512364513264513624513642513645" +
      "2136451234651234156234152634152364152346152341652341" +
      "2563412536412534612534162534126534123564123546123541" +
      "6235412635412365413265431264531624351624315624316524" +
      "3162543162453164253146253142653142563142536142531645" +
      "2314652314562314526314523614523164532164531264351264" +
      "3152643125643215642315462315426315423615423165423156" +
      "4213564215362415362145362154362153462135462134562134" +
      "6521346251346215364215634216534216354216345216342516" +
      "3421564325164325614325641325643126543216543261534261" +
      "3542613452613425613426513426153246513246531246351246" +
      "3152463125463215463251463254163254613254631245632145" +
      "6324156324516324561324563124653214653241653246153264" +
      "1532614532615432651436251436521435621435261435216435" +
      "2146352143651243615243612543612453612435612436514235" +
      "6142351642351462351426351423651432654136254136524135" +
      "6241352641352461352416352413654213654123";


  private static void findPermInSuperperm(byte[] superperm, int[] perm, byte[] ids, byte id) {
    for (int i = 0; i < (superperm.length - 5); i++) {
      boolean found = true;
      for (int j = 0; j < perm.length; j++) {
        if (perm[j] != superperm[i + j]) {
          found = false;
          break;
        }
      }
      if (found) {
        ids[i] = id;
      }
    }
  }


  public static void main(String[] args) {
    System.out.println(generateOhSuperpermLookup());
  }


  private static String generateOhSuperpermLookup() {

    // OH1 = 1, OH2 = 2, OH3 = 3, ... OH30=u
    char[] code_dict = "123456789abcdefghijklmnopqrstu".toCharArray();

    StringBuilder code     = new StringBuilder();
    byte[]        sup_perm = new byte[OH_SUPERPERM.length()];
    for (int i = 0; i < sup_perm.length; i++) {
      sup_perm[i] = (byte) (OH_SUPERPERM.charAt(i) - '0');
    }
    byte[] id = new byte[OH_SUPERPERM.length() - 5];
    Arrays.fill(id, (byte) -1);
    for (int i = 0; i < OH_TABLE.length; i++) {
      for (int j = 0; j < OH_TABLE[i].length; j += 6) {
        int[] perm = Arrays.copyOfRange(OH_TABLE[i], j, j + 6);
        findPermInSuperperm(sup_perm, perm, id, (byte) i);
        // break;
      }
     // debug
     // code.append("public static int OH").append(i + 1).append(" = '").append(code_dict[i]).append("';\n");
    }
    code.append("private static String superperm = \n    \"");
    for (int i = 0; i < sup_perm.length; i++) {
      if (i != 0 && i % 60 == 0)
        code.append("\" + \n    \"");
      code.append((char)('0'+sup_perm[i]));
    }
    code.append("\";\n");
    code.append("// OH1 = 1, OH2 = 2, OH3 = 3, ..., OH10=a, OH11=b, ...,  OH30=u\n");
    code.append("private static String config_ids = \"123456789abcdefghijklmnopqrstu\";\n");
    code.append("private static String config = \n    \"");
    for (int i = 0; i < id.length; i++) {
      if (i != 0 && i % 60 == 0)
        code.append("\" + \n    \"");
      if (id[i] < 0) {
        code.append(' ');
      } else {
        code.append(code_dict[id[i]]);
      }
    }
    code.append("\";\n");
    return code.toString();
  }

}

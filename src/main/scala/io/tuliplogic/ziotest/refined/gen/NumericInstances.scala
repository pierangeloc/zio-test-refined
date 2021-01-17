package io.tuliplogic.ziotest.refined.gen

import eu.timepit.refined.api.Refined
import eu.timepit.refined.internal.WitnessAs
import eu.timepit.refined.numeric.Greater
import zio.random.Random
import zio.test.Gen
/**
 * Generators for numeric types, following the lines of https://github.com/fthomas/refined/tree/master/modules/scalacheck/shared/src/main/scala/eu/timepit/refined/scalacheck
 */
trait NumericInstances {

  def intGreaterThan[N](implicit
    wn: WitnessAs[N, Int]
  ): Gen[Random, Int Refined Greater[N]] =
    Gen.int(wn.snd, Int.MaxValue).map(Refined.unsafeApply)

  def longGreaterThan[N](implicit
                         wn: WitnessAs[N, Long]
                        ): Gen[Random, Long Refined Greater[N]] =
    Gen.long(wn.snd, Long.MaxValue).map(Refined.unsafeApply)

  def shortGreaterThan[N](implicit
                          wn: WitnessAs[N, Short]
                         ): Gen[Random, Short Refined Greater[N]] =
    Gen.short(wn.snd, Short.MaxValue).map(Refined.unsafeApply)

  def byteGreaterThan[N](implicit
  wn: WitnessAs[N, Byte]
  ): Gen[Random, Byte Refined Greater[N]] =
  Gen.byte(wn.snd, Byte.MaxValue).map(Refined.unsafeApply)

  def doubleGreaterThan[N](implicit
  wn: WitnessAs[N, Double]
  ): Gen[Random, Double Refined Greater[N]] =
  Gen.double(wn.snd, Double.MaxValue).map(Refined.unsafeApply)

}

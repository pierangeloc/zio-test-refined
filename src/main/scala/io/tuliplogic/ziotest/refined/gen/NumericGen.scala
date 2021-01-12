package io.tuliplogic.ziotest.refined.gen

import eu.timepit.refined.api.{RefType, Refined, Validate}
import eu.timepit.refined.numeric.Positive
import zio.random.Random
import zio.test.Gen

/**
 * Generators for numeric types, following the lines of https://github.com/fthomas/refined/tree/master/modules/scalacheck/shared/src/main/scala/eu/timepit/refined/scalacheck
 */
trait NumericGen {

  val x: Int Refined Positive = ???

  //shameless copy from
  def genRefinedInt[F[_, _], T: Numeric, P](min: F[T, P], max: F[T, P])(
                                               implicit rt: RefType[F],
                                               v: Validate[T, P]): Gen[Random, F[T, P]] =
    ???

}

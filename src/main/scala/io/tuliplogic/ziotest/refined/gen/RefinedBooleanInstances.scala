package io.tuliplogic.ziotest.refined.gen

import eu.timepit.refined.api.Refined
import zio.test.BoolAlgebra.Or
import zio.test.Gen
import zio.test.magnolia.DeriveGen

object boolean extends RefinedCharInstances

trait RefinedBooleanInstances {
  implicit def orDeriveGen[T, A, B](implicit
    arbA: DeriveGen[Refined[T, A]],
    arbB: DeriveGen[Refined[T, B]]
  ): DeriveGen[Refined[T, A Or B]] = {
    val genA = arbA.derive.map(Refined.unsafeApply)
    val genB = arbA.derive.map(Refined.unsafeApply)
    DeriveGen.instance(Gen.oneOf(genA, genB))
  }
}

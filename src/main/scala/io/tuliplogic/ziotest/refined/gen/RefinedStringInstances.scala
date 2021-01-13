package io.tuliplogic.ziotest.refined.gen

import eu.timepit.refined.api.Refined
import eu.timepit.refined.string.{EndsWith, StartsWith, Uuid}
import shapeless.Witness
import zio.test.Gen
import zio.test.magnolia.DeriveGen

trait RefinedStringInstances {
  implicit def endsWithArbitrary[S <: String](
    implicit
    ws: Witness.Aux[S]
  ): DeriveGen[Refined[String, EndsWith[S]]] =
    DeriveGen.instance(
      Gen.anyString.map(value => Refined.unsafeApply(value + ws.value))
    )

  implicit def startsWithArbitrary[S <: String](
    implicit
    ws: Witness.Aux[S]
  ): DeriveGen[Refined[String, StartsWith[S]]] =
    DeriveGen.instance(
      Gen.anyString.map(value => Refined.unsafeApply(ws.value + value))
    )

  implicit val uuidStringArbitrary: DeriveGen[Refined[String, Uuid]] =
    DeriveGen.instance(
      Gen.anyUUID.map(value => Refined.unsafeApply(value.toString))
    )
}

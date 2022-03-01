package com.vj.leet.advantageshuffle


object Solution extends App{

  advantageCount(Array(2,0,4,1,2),Array(1,3,0,0,2)).foreach(println)

  def remove(some: List[Int], e: Int) : List[Int] = {
    some.foldLeft((List[Int](),false))((b,a) => b._2 match {
      case true => (a :: b._1,true)
      case false if (a == e) =>  (b._1,true)
      case false => ( a :: b._1,true)
    })._1
  }

  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    var some = A.sortWith(_ < _).toList

    B.map( elem => {
      val e  = some.find(_ > elem) match {
        case Some(e) => e
        case None => some(0)
      }
      some = remove(some,e)
      e
    })

  }

  advantageCount(Array(5,1,2,3),Array(4,1,2,3))
}
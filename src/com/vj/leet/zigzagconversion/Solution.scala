package com.vj.leet.zigzagconversion

object Some extends App{

  val tupls = Solution.convert("A",2);
  println(tupls)
}

object Solution {


  def getTuples(numRows: Int):List[(Int,Int)] = {
     getTuples((numRows-1) * 2,(numRows-1) * 2)
  }

  private def getTuples(number:Int, total: Int):List[(Int,Int)] = number match {
    case some if some <= 0 => (total,0)::Nil
    case others =>  (total - others ,others) :: getTuples(number-2,total)

  }
  def convert(s: String, numRows: Int): String = numRows match{
    case 1 => s
    case _ =>
      convert_(s, numRows);
  }

  private def convert_(s: String, numRows: Int): String = {
    val rowIndex = getTuples(numRows);
    rowIndex.zipWithIndex.map(getStr(s)).flatten.mkString("")
  }

  private def getStr(s:String)(data:((Int, Int),Int)) :String = {
    val(a,index  )= data
    val (low,high)  = a;
    val res:List[Char] = index match {
      case some if index >= s.length =>Nil
      case other => s(index) :: getStr(s,index,a,true);
    }
    res.mkString("")
  }
  private def getStr(s:String,currentIndex:Int, a:(Int, Int), high:Boolean) :List[Char] = {
    val index =   a match {
      case some if a._1 == 0 => currentIndex + a._2
      case some if a._2 == 0 => currentIndex + a._1
      case other if high => currentIndex + a._2
      case other => currentIndex + a._1
    }

    index match {
      case 0 =>Nil
      case index if index >= s.length => Nil
      case others => s(index) :: getStr(s,index,a,!high);
    }

  }
}
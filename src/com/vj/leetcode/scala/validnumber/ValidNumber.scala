package com.vj.leetcode.scala.validnumber

object ValidNumber extends App{
  println(Solution.isNumber("44e016912630333") == true)

  List("44e016912630333","0e1","2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789") foreach {
    num => if( Solution.isNumber(num) == false) println( s" The number $num is a  Valid Numer but returned false"  )
  }
List(".","abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53")foreach {
  num => if( Solution.isNumber(num) == true) println( s" The number $num is a Not Valid Numer but returned true"  )
}
}

object Solution {
  def isNumber(s: String): Boolean = s.length match {
    case a if a < 1 || a > 20 => false
    case _ =>splitNumber(s.toList) match {
      case Right(false) => false
      case Right(true) => true
      case Left((Nil, other,true)) => false
      case Left((main, Nil,true)) =>  false
      case  Left((main, other ,_)) => isNumber(main,true)  && isNumber(other)
    }

  }

  def splitNumber(chars:List[Char], afterE:Boolean = false, mantisa:List[Char] = Nil,other:List[Char]=Nil, signMan:Option[Boolean]=None, signOth:Option[Boolean] =None ) : Either[(List[Char],List[Char],Boolean),Boolean] = chars match {

    case '+' :: list if !afterE  => if (!signMan.isEmpty) Right(false) else splitNumber( list,afterE,'+' :: mantisa,other,Some(true),signOth)
    case '+' :: list if afterE  => if (!signOth.isEmpty) Right(false) else splitNumber( list,afterE, mantisa,'+' ::other,signMan,Some(true))
    case '-' :: list if !afterE  => if (!signMan.isEmpty) Right(false) else splitNumber( list,afterE,'-' :: mantisa,other,Some(false),signOth)
    case '-' :: list if afterE  => if (!signOth.isEmpty) Right(false) else splitNumber( list,afterE, mantisa,'-' ::other,signMan,Some(false))

   case ch :: list if !afterE && ch.isDigit => splitNumber( list,afterE,ch :: mantisa,other,signMan,signOth)
   case ch :: list if afterE && ch.isDigit => splitNumber( list,afterE, mantisa,ch ::other,signMan,signOth)
   case '.' :: list if afterE => Right(false)
   case '.' :: list  => splitNumber( list,afterE,'.' :: mantisa,other,signMan,signOth)
   case 'e' :: list => if(afterE) Right(false) else splitNumber( list,true, mantisa,other,signMan,signOth)
   case 'E' :: list => if(afterE) Right(false) else splitNumber( list,true, mantisa,other,signMan,signOth)
   case _ :: list => Right(false)
   case Nil => Left((trim(mantisa.reverse),trim(other.reverse),afterE))
 }

private def trim(chars:List[Char]):List[Char] = chars match {
//  case '0' :: list => trim(list)
  case  _ :: list => chars
  case  Nil => chars
}
  private def isNumber( chars:List[Char],isDeci : Boolean = false) : Boolean = (isDeci,chars) match {
    case (_,Nil) => true
    case (true,'.' :: Nil) => false
    case (true,_) => scala.util.Try(java.lang.Double.parseDouble( chars.mkString)).isSuccess
    case (false,_) => scala.util.Try(java.lang.Double.parseDouble( chars.mkString)).isSuccess
  }

}
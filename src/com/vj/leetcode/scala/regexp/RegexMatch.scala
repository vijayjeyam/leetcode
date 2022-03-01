package com.vj.leetcode.scala.regexp

object RegexMatch extends App{

  List(("vijay",".*ijay"),("aab","c*a*b"),("ab",".*"),("aa","a*")).foreach{
    case(str,pat) => if(!Solution.isMatch(str,pat)) println(s"$str is not matching $pat")
  }
  List(("abcd","d*")).foreach{
    case(str,pat) => if(Solution.isMatch(str,pat)) println(s"$str is  matching $pat")
  }


}

object Solution {
  def isMatch(s: String, p: String): Boolean = {
    isMatch(s.toList,p.toList)
  }

  def isMatch( char:List[Char] , pat:List[Char], prevPat:Char = 0 ): Boolean ={
    println(s" ${char.mkString} compared with ${pat.mkString}  prev $prevPat ")
    (char, pat) match {
      case (Nil,'*'::Nil)  => true
      case (_,'*'::Nil) if prevPat == '.' => true
      case( c :: chars, '.' :: pattern ) => isMatch(chars,pattern,'.')
      case (c :: chars, '*' :: pattern) if(prevPat == '.' || c == prevPat) =>  isMatch(chars,pat,prevPat)
      case (c :: chars, '*' :: _ ::pattern)  =>  isMatch(chars,pattern,'*')
      case (c :: chars, p::pattern) if c == p => isMatch(chars,pattern,p)
     case (c :: chars, p::pattern) if pattern.head == '*' && (prevPat == '.' || p == c )=> isMatch(chars,pat,p)
      case ( Nil , Nil) => true
      case (_,Nil) => false
      case (_, _)  => false
    }
  }
}
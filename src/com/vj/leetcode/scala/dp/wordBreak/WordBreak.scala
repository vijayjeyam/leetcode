package com.vj.leetcode.scala.dp.wordBreak

import com.vj.leetcode.scala.TestMixin

object WordBreak extends TestMixin{
  println(Solution.wordBreak("hello"
    ,  List("h","el","lo")))

  println(Solution.wordBreak("aaab"
,  List("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")))
}

object Solution {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    if(s.length==0)return true
    if(wordDict.length == 0) return false
    val mem = Array.fill[Integer](s.length+1)(Integer.MAX_VALUE)
    def dp(index:Int):Boolean ={
      if(mem(index) != Integer.MAX_VALUE) return mem(index) == 1
      mem(index) = 1
      if(index == s.length) return true
      val tocheck = s.substring(index)
      val listTocheck = for(word <- wordDict
                            if tocheck.startsWith(word)
                            if index+tocheck.length <= s.length
                            )yield word
      val res = listTocheck.map(w => dp(index+w.length)).foldLeft(false)((a,b)=> a || b)
      mem(index) == 1
    }
    dp(0)
    mem(s.length) ==1
  }
}